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

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import org.gcreator.gui.NewProjectDialog;
import org.gcreator.gui.PineappleGUI;
import org.gcreator.managers.EventManager;
import org.gcreator.plugins.Event;
import org.gcreator.plugins.Plugin;
import org.gcreator.project.DefaultProject;
import org.gcreator.project.Project;

/**
 * The Game 2D plugin
 * @author Luís Reis
 */
public class GamePlugin extends Plugin{
    @Override
    public String getName(){
        return "Game Plugin 2D";
    }
    
    @Override
    public String getDescription(){
        return "Adds 2D game support to Pineapple";
    }
    
    @Override
    public void handleEvent(Event e){
        if(e.getEventType().equals(NewProjectDialog.GENERATE_PROJECTS)){
            JList projects = (JList) e.getArguments()[0];
            DefaultListModel model = (DefaultListModel) e.getArguments()[1];
            model.addElement("2D Game Project");
        }
        if (e.getEventType().equals(NewProjectDialog.BUTTON_OK)) {
            Object[] args = e.getArguments();
            if (args[0] == null) {
                return;
            }
            String s = args[0].toString();
            if (s.equals("2D Game Project")) {
                //Will have to change later
                Project p = new GameProject();
                PineappleGUI.project = p;
                PineappleGUI.projectNode.setProject(p);
                PineappleGUI.tree.updateUI();
                ((JDialog) e.getSender()).dispose();
            }
        }
    }
    
    /**
     * 
     * Initializes the plugin(Registers the event handlers)
     */
    @Override
    public void initialize() {
        EventManager.addEventHandler(this, NewProjectDialog.GENERATE_PROJECTS);
        EventManager.addEventHandler(this, NewProjectDialog.BUTTON_OK);
    }
}
