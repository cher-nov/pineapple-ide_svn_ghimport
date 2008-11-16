/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey <bob@bobtheblueberry.com>
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
package org.gcreator.managers;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gcreator.core.Core;
import org.gcreator.plugins.Plugin;

/**
 * This class handles the importing of plugins, usually at startup.
 * 
 * @author Luís Reis
 */
public final class PluginManager {
    
    private static Vector<File> modules = new Vector<File>();
    
    /** Don't allow instantation
     */
    private PluginManager() {
    }

    /**
     * Loads the plugins.
     * This function should only be called once
     */
    public static void loadPlugins() {
        importAppDataPlugins();
        importAppExePlugins();
        URL[] urls = new URL[modules.size()];
        int i = 0;
        for(File file : modules){
            try{
                urls[i++] = file.toURI().toURL();
            }
            catch(Exception e){}
        }
        URLClassLoader clsloader = new URLClassLoader(urls);
        for(File file : modules){
            importPlugin(file, clsloader);
        }
    }

    /**
     * Imports the Application Data Plug-ins.
     */
    public static void importAppDataPlugins() {
        File f = new File(Core.getApplicationDataFolder().toString() + "/Plugins/");
        System.out.println(f.toString());
        if (!f.exists()) {
            System.out.println("Creating...");
            f.mkdir();
        }
        if (!f.isDirectory()) {
            System.out.println("Not a directory");
            return;
        }
        File[] fs = f.listFiles();
        System.out.println("Checking " + fs.length + " files.");
        for (File file : fs) {
            if (file.isFile() && file.getName().matches(".*\\.jar")) {
                modules.add(file);
            }
        }
    }

    /**
     * Imports the Application Executable Plug-ins.
     */
    public static void importAppExePlugins() {
        File f = new File(Core.getApplicationExecutableFolder().toString() + "/Plugins/");
        System.out.println(f.toString());
        if (!f.exists()) {
            System.out.println("Creating...");
            f.mkdir();
            return;
        }
        if (!f.isDirectory()) {
            System.out.println("Not a directory");
            return;
        }
        File[] fs = f.listFiles();
        System.out.println("Checking " + fs.length + " files.");
        for (File file : fs) {
            if (file.isFile() && file.getName().matches(".*\\.jar")) {
                modules.add(file);
            }
        }
    }

    /**
     * Imports a plug-in from a {@link File}.
     * 
     * @param f The File to import the plug-in from.
     */
    public static void importPlugin(File f, URLClassLoader loader) {
        try {
            System.out.println("Loading plugin: " + f.toString());
            JarInputStream jaris = new JarInputStream(new FileInputStream(f));
            Manifest m = jaris.getManifest();
            jaris.close();
            Attributes a = m.getMainAttributes();
            load(f, a.getValue("Pineapple-EntryPoint"), loader);
        } catch (Exception e) {
            Thread.getDefaultUncaughtExceptionHandler().uncaughtException(Thread.currentThread(), e);
        }
    }

    /**
     * Loads a class from a JAR {@link java.io.File}, and attempts to initilize a given class from the JAR.
     * 
     * @param f The Jar {@link java.io.File}.
     * @param className The {@link java.lang.Class} to load and initilize from the JAR.
     * 
     * @throws java.lang.ClassNotFoundException  If the given class was not found in the JAR.
     * @throws java.lang.InstantiationException If the class failed to initilize
     * @throws java.lang.reflect.InvocationTargetException If an error occurs while initilizing the class.
     */
    @SuppressWarnings("unchecked")
    public static void load(File f, String className, URLClassLoader loader) throws 
            ClassNotFoundException, InstantiationException, InvocationTargetException {
        
        if (className == null) {
            return;
        }
        try {
            System.out.println("Loading " + f.toString());
            
            Class c = loader.loadClass(className);
            Object o = c.getConstructor().newInstance();
            Core.addPlugin((Plugin)o);
            c.getMethod("initialize").invoke(o);
        } catch (IllegalAccessException ex) {
            /* Should not happen */
            Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            /* Should not happen */
            Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            /* Should not happen */
            Logger.getLogger(PluginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
