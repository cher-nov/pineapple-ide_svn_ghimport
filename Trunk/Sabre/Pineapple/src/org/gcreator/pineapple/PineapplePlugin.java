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
package org.gcreator.pineapple;

import java.util.Vector;
import org.gcreator.gui.PineappleGUI;
import org.gcreator.plugins.EventManager;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.NotifyEvent;
import org.gcreator.plugins.PluginCore;
import org.gcreator.project.DefaultProjectType;
import org.gcreator.project.ProjectType;
import org.gcreator.project.io.FormatSupporter;
import org.gcreator.project.io.ImageSupporter;
import org.gcreator.project.io.PlainTextSupporter;

/**
 * The Plugin class for Pineapple.
 * 
 * @author Luís Reis
 */
public class PineapplePlugin extends PluginCore {

    /**
     * The {@link PineappleGUI} object.
     */
    public static PineappleGUI gui;
    
    /**
     * The format supporters.
     */
    public static Vector<FormatSupporter> formats;
    
    /**
     * The project types.
     */
    public static Vector<ProjectType> projectTypes;
    
    /**
     * Event called to add format supporters to
     * the PineapplePlugin's list.
     * 
     * @see #addFormatSupporter(FormatSupporter) 
     */
    public static final String REGISTER_FORMATS = "register-formats";
    
    /**
     * Event called to add project types to
     * the PineapplePlugin's list.
     * 
     * @see #addProjectType(ProjectType) 
     */
    public static final String REGISTER_PROJECT_TYPES = "register-managers";
    
    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "Pineapple Default Plug-In";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "Provides essential Pineapple interface behaviors " +
                "including menus, docking and file handling.";
    }

    /**
     * Initializes the plugin and registers the event handlers.
     */
    @Override
    public void initialize() {
        
        EventManager.addEventHandler(this, REGISTER_FORMATS, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, REGISTER_PROJECT_TYPES, EventPriority.MEDIUM);
        
        gui = new PineappleGUI();
        
        formats = new Vector<FormatSupporter>(4);
        EventManager.fireEvent(this, REGISTER_FORMATS);
        
        projectTypes = new Vector<ProjectType>(2);
        EventManager.fireEvent(this, REGISTER_PROJECT_TYPES);
    }
    
    /**
     * Adds a {@link FormatSupporter} to the list of available
     * format supporters.
     * 
     * @param s The {@link FormatSupporter} to add.
     */
    public static void addFormatSupporter(FormatSupporter s) {
        formats.add(s);
    }
    
    /**
     * Adds a {@link ProjectType} to the list of available
     * project types.
     * 
     * @param t The {@link ProjectType} to add.
     */
    public static void addProjectType(ProjectType t) {
        projectTypes.add(t);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEvent(NotifyEvent event) {
        if (event.getEventType().equals(REGISTER_FORMATS)) {
            PineapplePlugin.addFormatSupporter(new PlainTextSupporter());
            PineapplePlugin.addFormatSupporter(new ImageSupporter());
        } else if (event.getEventType().equals(REGISTER_PROJECT_TYPES)) {
            PineapplePlugin.addProjectType(new DefaultProjectType());
        }
    }
}