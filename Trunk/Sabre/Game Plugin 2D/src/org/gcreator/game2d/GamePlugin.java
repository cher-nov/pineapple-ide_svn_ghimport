/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 BobSerge<serge_1994@hotmail.com>

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
package org.gcreator.game2d;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.gcreator.editors.ActorEditor;
import org.gcreator.editors.TextEditor;
import org.gcreator.gui.DocumentPane;
import org.gcreator.gui.PineappleGUI;
import org.gcreator.gui.TestActionRenderer;
import org.gcreator.managers.EventManager;
import org.gcreator.pineapple.PineappleCore;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.Event;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.Plugin;
import org.gcreator.project.io.BasicFile;
import org.gcreator.project.io.FormatSupporter;
import org.noos.xing.mydoggy.ToolWindow;
import org.noos.xing.mydoggy.ToolWindowAnchor;

/**
 * The Game 2D plugin
 * 
 * @author Luís Reis
 */
public class GamePlugin extends Plugin implements FormatSupporter{

    /**
     * Called when the palette is created
     */
    public static final String PALETTE_CREATED = "game-palette-created";
    
    public static ToolWindow palette = null;
    public static JPanel palettePanel = null;
    
    @Override
    public String getName() {
        return "Game Plugin 2D";
    }
    
    @Override
    public String getDescription(String format){
        if(format==null){
            return "";
        }
        
        if(format.equals("actor")){
            return "Edits actors, that is, game entities with behavior.";
        }
        
        return "";
    }
    
    public DocumentPane load(BasicFile f){
        String n = f.getName();
        int index = n.indexOf(".");
        if(index==-1){
            return new TextEditor(f);
        }
        //x. length=2 index=1
        if(index==n.length()-1){
            return new TextEditor(f);
        }
        
        //x.txt index=1 n.substring(index=".txt")
        String format = n.substring(index+1);
        if(format.equals("actor")){
            return new ActorEditor(f);
        }
        
        return new TextEditor(f);
    }

    public static String[] formats = new String[]{
        "actor"
    };
    
    public String[] getFormats(){
        return formats;
    }
    
    @Override
    public String getDescription() {
        return "Adds 2D game support to Pineapple";
    }

    @Override
    public void handleEvent(Event e) {
        if (e.getEventType().equals(DefaultEventTypes.WINDOW_CREATED)) {
            palettePanel = new JPanel();
            palette = PineappleGUI.manager.registerToolWindow("Palette", "Palette", null, palettePanel,
                ToolWindowAnchor.RIGHT);
            palette.setAvailable(false);
            EventManager.fireEvent(this, PALETTE_CREATED, palette, palettePanel);
            
            JFrame f = new JFrame();
            f.setLayout(new BorderLayout());
            TestActionRenderer act = new TestActionRenderer();
            act.setVisible(true);
            act.updateUI();
            f.add(act, BorderLayout.CENTER);
            f.setSize(300, 300);
            f.setVisible(true);
        }
        else if (e.getEventType().equals(PineappleGUI.FILE_CHANGED)) {
            DocumentPane p = PineappleGUI.dip.getSelectedDocument();
            if(p!=null&&p instanceof PaletteUser){
                palette.setAvailable(((PaletteUser) p).doPalette(palette, palettePanel));
            }
            else{
                palette.setAvailable(false);
            }
        } else if (e.getEventType().equals(PineappleCore.REGISTER_PROJECT_TYPES)) {
            PineappleCore.addProjectType(new GameProjectType());
        } else if (e.getEventType().equals(PineappleCore.REGISTER_FORMATS)) {
            PineappleCore.addFormatSupporter(this);
        }
    }

    /**
     * 
     * Initializes the plugin(Registers the event handlers)
     */
    @Override
    public void initialize() {
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_CREATED, EventPriority.LOW);
        EventManager.addEventHandler(this, PineappleGUI.FILE_CHANGED);
        EventManager.addEventHandler(this, PineappleCore.REGISTER_PROJECT_TYPES);
        EventManager.addEventHandler(this, PineappleCore.REGISTER_FORMATS);
        PineappleCore.fileTypeNames.put("actor", "Game Actor");
        PineappleCore.fileTypeDescriptions.put("actor",
                "Game entities associated with a position and a behavior.");
        
        EventManager.addEventHandler(this, PineappleCore.REGISTER_FORMATS);
    }

    @Override
    public String getAuthor() {
        return "Luís Reis";
    }
}
