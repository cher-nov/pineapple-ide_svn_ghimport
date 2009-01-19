/*
Copyright (C) 2008-2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008-2009 Serge Humphrey<bob@bobtheblueberry.com>

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 */
package org.gcreator.pinedl.cpp;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.gcreator.events.Event;
import org.gcreator.formats.Actor;
import org.gcreator.formats.Scene;
import org.gcreator.game2d.GameProjectType;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;

/**
 * This class is used to compile the game.
 * 
 * @author Luís Reis
 */
public class GameCompiler {

    Project p;
    File outputFolder;
    File binFolder;
    File resFolder;
    CompilerFrame compFrame;
    Vector<File> pineScripts = new Vector<File>();
    Vector<File> imageFiles = new Vector<File>();
    Vector<File> compFiles = new Vector<File>();
    Vector<String> context = new Vector<String>();
    String gamePackage = "Game";
    boolean worked = true;
    OutputStream headerH = null;

    public GameCompiler(final Project p) {
        this.p = p;
        if (p.getProjectType() instanceof GameProjectType) {
            try {
                prepare();
                //Let's compile it!
                Thread t = new Thread() {

                    @Override
                    public void run() {
                        try {
                            for (ProjectElement e : p.getFiles()) {
                                String name = e.getFile().getName();
                                String format = name.substring(name.lastIndexOf('.') + 1);
                                if (format.equals("actor")) {
                                    createActorScript(e);
                                } else if (format.equals("scene")) {
                                    createSceneScript(e);
                                } else if (format.equals("pdl")) {
                                    copyScript(e);
                                } else if (format.equals("png")) {
                                    copyImage(e);
                                }
                            }
                            buildContext();
                            compFrame.writeLine("Generating C++ and header files");
                            for (File script : pineScripts) {
                                if (!worked) {
                                    return;
                                }
                                generateHeader(script);
                                generateCppFile(script);
                            }
                            copyLib();
                            compFrame.writeLine("Compiling C++ code");
                            compile();
                        } catch (Exception ex) {
                            compFrame.writeLine("<font color='red'>COMPILE EXCEPTION: " + ex.getMessage() + "</font>");
                            worked = false;
                        }
                    }
                };

                t.start();
            } catch (Exception e) {
                compFrame.writeLine("<font color='red'>COMPILE EXCEPTION: " + e.getMessage() + "</font>");
                worked = false;
            }
        }
    }

    private void copyLib() throws IOException {
        compFrame.writeLine("Copying static library");
        File f = new File(outputFolder, "libPineapple.a");
        FileOutputStream fos = new FileOutputStream(f);
        InputStream is = getClass().getResourceAsStream("/org/gcreator/pinedl/cpp/res/linux/libPineapple.a");
        int c = 0;
        while ((c = is.read()) != -1) {
            fos.write(c);
        }
        fos.close();
        compFrame.writeLine("Copying precompiled header");
        f = new File(outputFolder, "pineapple.h.gch");
        fos = new FileOutputStream(f);
        is = getClass().getResourceAsStream("/org/gcreator/pinedl/cpp/res/linux/pineapple.h.gch");
        while ((c = is.read()) != -1) {
            fos.write(c);
        }
    }

    private void compile() throws Exception {
        headerH.write("#endif\n".getBytes());
        headerH.close();
        //TODO: MAKE THIS WINDOWS-COMPATIBLE
        //TODO: TEST THIS AGAINST LARGE PROJECTS
        File outputFile = new File(outputFolder, "game");
        String command = "g++ -o \"";
        command += outputFile.getAbsolutePath();
        command += "\" \"";
        File pine1 = new File(outputFolder, "libPineapple.a");
        command += pine1.getAbsolutePath();
        command += "\"";
        for (File script : pineScripts) {
            command += " \"";
            String path = script.getAbsolutePath();
            command += path.substring(0, path.lastIndexOf('.'));
            command += ".cpp\"";
        }
        command += " `sdl-config --cflags --libs` -lSDL_image -lGL -lGLU";
        Process proc = Runtime.getRuntime().exec(command);
        compFrame.writeLine("Calling GCC C++ for executable generation:");
        compFrame.writeLine(command);
        int c;
        String res = "";
        InputStream is = new BufferedInputStream(proc.getInputStream());
        int x = proc.waitFor();
        while ((c = is.read()) != -1) {
            if (c != '\n') {
                res += (char) c;
            } else {
                compFrame.writeLine(res);
                res = "";
            }
        }
        compFrame.writeLine("Finished!");
        if(x!=0){
            compFrame.writeLine("There seems to have been some errors with the compiler");
            compFrame.writeLine("Please report them to the G-Creator team");
        }
    }

    private void buildContext() {
        for (File script : pineScripts) {
            String fname = script.getName();
            fname = fname.substring(0, fname.lastIndexOf('.'));
            context.add(fname);
        }
    }

    private void generateHeader(File script) throws IOException {
        InputStream is = new FileInputStream(script);
        String fname = script.getName();
        System.out.println("fname=" + fname);
        fname = fname.substring(0, fname.lastIndexOf('.'));
        System.out.println("new fname=" + fname);
        File output = new File(outputFolder, fname + ".h");
        headerH.write("#include \"".getBytes());
        headerH.write(fname.getBytes());
        headerH.write(".h\"\n".getBytes());
        FileOutputStream fos = new FileOutputStream(output);
        HGenerator gen = new HGenerator(is, fos, this, fname, context);
        if (!gen.wasSuccessful()) {
            worked = false;
        }
        fos.close();
    }

    private void generateCppFile(File script) throws IOException {
        InputStream is = new FileInputStream(script);
        String fname = script.getName();
        fname = fname.substring(0, fname.lastIndexOf('.'));
        File output = new File(outputFolder, fname + ".cpp");
        FileOutputStream fos = new FileOutputStream(output);
        CppGenerator gen = new CppGenerator(is, fos, this, fname, context);
        if (!gen.wasSuccessful()) {
            worked = false;
        }
        fos.close();
    }

    private void copyImage(ProjectElement e) throws Exception {
        File f = new File(resFolder, e.getName());
        FileOutputStream fos = new FileOutputStream(f);
        InputStream is = e.getFile().getInputStream();
        int c = 0;
        while ((c = is.read()) != -1) {
            fos.write(c);
        }
        imageFiles.add(f);
        fos.close();
    }

    private void copyScript(ProjectElement e) throws Exception {
        compFrame.writeLine("Copying PineDL script " + e.getName());
        File f = new File(outputFolder, e.getName());
        FileOutputStream fos = new FileOutputStream(f);
        InputStream is = e.getFile().getInputStream();
        int c = 0;
        while ((c = is.read()) != -1) {
            fos.write(c);
        }
        pineScripts.add(f);
        fos.close();
    }

    private void createActorScript(ProjectElement e) throws Exception {
        Actor a = new Actor(e.getFile());
        String fname = e.getName();
        fname = fname.substring(0, fname.lastIndexOf('.'));
        fname = fname.replaceAll("\\s", "_");
        compFrame.writeLine("Creating PineDL Script for actor " + fname);
        File f = new File(outputFolder, fname + ".pdl");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write("package ".getBytes());
        fos.write(gamePackage.getBytes());
        fos.write(';');
        fos.write('\n');
        fos.write('\n');
        fos.write("class ".getBytes());
        fos.write(fname.getBytes());
        fos.write(" extends Actor{\n".getBytes());

        for (Event evt : a.events) {
            if (evt.getType().equals(Event.TYPE_CREATE)) {
                fos.write("\tpublic this(float x, float y){\n".getBytes());

                fos.write("\t\tsetX(x);\n\t\tsetY(y);\n".getBytes());
                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.getType().equals(Event.TYPE_UPDATE)) {
                fos.write("\tpublic void update(){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.getType().equals(Event.TYPE_DRAW)) {
                fos.write("\tpublic void draw(){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.getType().equals(Event.TYPE_KEYPRESS)) {
                fos.write("\tpublic void onKeyUp(Key key){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }

            if (evt.getType().equals(Event.TYPE_KEYRELEASE)) {
                fos.write("\tpublic void onKeyDown(Key key){\n".getBytes());

                fos.write(outputEvent(a, evt).getBytes());

                fos.write("\t}\n".getBytes());
            }
        }

        fos.write('}');
        fos.write('\n');
        pineScripts.add(f);
        fos.close();
    }

    private void createSceneScript(ProjectElement e) throws Exception {
        Scene scene = new Scene(e.getFile());
        String fname = e.getName();
        fname = fname.substring(0, fname.lastIndexOf('.'));
        fname = fname.replaceAll("\\s", "_");
        compFrame.writeLine("Creating PineDL Script for scene " + fname);
        File f = new File(outputFolder, fname + ".pdl");
        FileOutputStream fos = new FileOutputStream(f);
        fos.write("package ".getBytes());
        fos.write(gamePackage.getBytes());
        fos.write(';');
        fos.write('\n');
        fos.write('\n');
        fos.write("class ".getBytes());
        fos.write(fname.getBytes());
        fos.write(" extends Scene{\n".getBytes());

        fos.write("\tpublic this() : super".getBytes());

        fos.write(("(" + scene.width + ", " + scene.height).getBytes());

        fos.write("){\n".getBytes());

        for (Scene.ActorInScene a : scene.actors) {
            String aname = a.bf.getName();
            aname = aname.substring(0, aname.lastIndexOf('.'));
            fos.write(("\t\taddActor(new " + aname + "(" + a.x + ", " + a.y + "));\n").getBytes());
        }

        fos.write("\t}\n".getBytes());

        fos.write('}');
        fos.write('\n');
        pineScripts.add(f);
        fos.close();
    }

    private String outputEvent(Actor a, Event evt) {
        return evt.getPineDL();
    }

    private void prepare() throws Exception {
        compFrame = new CompilerFrame();
        compFrame.writeLine("<b>Preparing game compilation</b>");
        compFrame.setVisible(true);
        outputFolder = new File(p.getProjectFolder(), "output/cpp-opengl/");
        if (outputFolder.exists()) {
            outputFolder.delete();
        }
        outputFolder.mkdirs();
        binFolder = new File(outputFolder, "bin/"); // OUTPUT/bin
        if (binFolder.exists()) {
            binFolder.delete();
        }
        binFolder.mkdir();
        resFolder = new File(binFolder, "res/"); // OUTPUT/bin/res
        if (resFolder.exists()) {
            resFolder.delete();
        }
        resFolder.mkdir();
        headerH = new FileOutputStream(new File(outputFolder, "header.h"));
        headerH.write("#ifndef _PINEAPPLE_HEADER_H_\n".getBytes());
        headerH.write("#define _PINEAPPLE_HEADER_H_\n".getBytes());
        headerH.write("#include \"pineapple.h\"\n".getBytes());
    }
}
