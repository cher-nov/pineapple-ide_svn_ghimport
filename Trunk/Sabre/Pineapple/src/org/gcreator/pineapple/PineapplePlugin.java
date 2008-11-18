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
import org.gcreator.managers.EventManager;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.Event;
import org.gcreator.plugins.Plugin;
import org.gcreator.project.standard.DefaultProjectType;
import org.gcreator.project.ProjectType;
import org.gcreator.project.io.FormatSupporter;
import org.gcreator.project.standard.ImageSupporter;
import org.gcreator.project.standard.PlainTextSupporter;

/**
 * The Plugin class for Pineapple.
 * 
 * @author Luís Reis
 */
public final class PineapplePlugin extends Plugin {

    /**
     * The {@link PineappleGUI} object.
     */
    private static PineappleGUI gui;
    /**
     * The format supporters.
     */
    private static Vector<FormatSupporter> formats;
    /**
     * The project types.
     */
    private static Vector<ProjectType> projectTypes;
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
     * Gives static access to the plugin's name.
     */
    public static final String PLUGIN_NAME = "Pineapple Default Plug-In";

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return PLUGIN_NAME;
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
        try {
            EventManager.addEventHandler(this, REGISTER_FORMATS, EventPriority.MEDIUM);
            EventManager.addEventHandler(this, REGISTER_PROJECT_TYPES, EventPriority.MEDIUM);
            EventManager.addEventHandler(this, DefaultEventTypes.PLUGINS_LOADED);

            gui = new PineappleGUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
    public void handleEvent(Event event) {
        if (event.getEventType().equals(DefaultEventTypes.PLUGINS_LOADED)) {
            
            PineapplePlugin.formats = new Vector<FormatSupporter>(4);
            EventManager.fireEvent(this, PineapplePlugin.REGISTER_FORMATS);
            PineapplePlugin.projectTypes = new Vector<ProjectType>(2);
            EventManager.fireEvent(this, PineapplePlugin.REGISTER_PROJECT_TYPES);
            
        } else if (event.getEventType().equals(REGISTER_FORMATS)) {
            
            PineapplePlugin.addFormatSupporter(new PlainTextSupporter());
            PineapplePlugin.addFormatSupporter(new ImageSupporter());
            
        } else if (event.getEventType().equals(REGISTER_PROJECT_TYPES)) {
            
            PineapplePlugin.addProjectType(new DefaultProjectType());
            
        }
    }

    /**
     * {@inheritDoc}
     */
    public String getAuthor() {
        return "Serge Humphrey, Luís Reis";
    }
    
    /**
     * @return The {@link PineappleGUI} instance.
     */
    public static PineappleGUI getGUI() {
        return gui;
    }
    
    /**
     * @return A list of the available project types.
     */
    @SuppressWarnings("unchecked")
    public static Vector<ProjectType> getProjectTypes() {
        return (Vector<ProjectType>) projectTypes.clone();
    }
    
    /**
     * @return A list of the available format supporters.
     */
    @SuppressWarnings("unchecked")
    public static Vector<FormatSupporter> getFormatSupporters() {
        return (Vector<FormatSupporter>) formats.clone();
    }
}