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
package org.gcreator.core;

import org.gcreator.managers.DefaultUncaughtExceptionHandler;
import org.gcreator.managers.SettingsManager;
import org.gcreator.managers.PluginManager;
import org.gcreator.gui.MainFrame;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.EventHandler;
import org.gcreator.managers.EventManager;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.NotifyEvent;
import org.gcreator.plugins.PluginCore;
import java.io.File;
import java.net.URL;
import java.util.Vector;

/**
 * The Core class.
 * Main class for G-Creator, handles core functions, loading, etc.
 * 
 * @author Serge Humphrey
 * @author Russell
 */
public class Core
{
    /* 0.97...  -> Alpha
     * ...004   -> 4
     */
    private static final double version = 0.97004;
    private static boolean safe = false;
    private static File appDataFolder = null;
    private static File appExeFolder = null;
    private static MainFrame mainFrame = null;
    private static Vector<PluginCore> plugins = null;
    
    /**
     * Don't allow instantation
     */
    private Core() {}

    /**
     * Called by the JVM when the application is started.
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //decide what to do with the arguments
        if (args.length > 0 && args[0].startsWith("-"))
        {
            String arg =args[0].substring(1).toLowerCase();
            if (arg.equals("-help") || arg.equals("h"))
            {
                System.out.println("G-Creator version " + version);
                System.out.println("Usage: gcreator [options] [file]");
                System.out.println("-h --help          Displays this help message");
                System.out.println("-v --version       Displays the G-Creator version");
                System.out.println("-s --safe          Doesn't load plug-ins and settings (Safe mode)");
                System.exit(0);
            }
            else if (arg.equals("-version") || arg.equals("v"))
            {
                System.out.println("G-Creator version " + version);
                System.out.println("Copyright © 2005-2008 The G-Creator Organization");
                System.out.println("http://www.g-creator.org");
                System.exit(0);
            }
            else if (arg.equals("-safe") || arg.equals("s"))
            {
                safe = true;
            }
        }
        Core.load();
    }
    
    public static File getApplicationDataFolder()
    {
        return appDataFolder;
    }
    
    public static File getApplicationExecutableFolder()
    {
        return appExeFolder;
    }
    
    public static void addPlugin(PluginCore plugin){
        plugins.add(plugin);
    }
    
    @SuppressWarnings("unchecked")
    public Vector<PluginCore> getPlugins(){
        return (Vector<PluginCore>)plugins.clone();
    }
    
    /**
     * Loads the G-Creator core, modules, and settings.
     * @param safe If <tt>true</tt>, don't load plugins and settings.
     * @see #unload()
     */
    protected static void load()
    {
        //Set up the AppData folder
        String s = System.getProperty("APPDATA");
        if (s == null) {
            s = System.getProperty("user.home") + "/.sabre/";
        } else {
            s += "/Sabre/";
        }
        appDataFolder = new File(s);
        if (!appDataFolder.exists()) {
            appDataFolder.mkdir();
        }
        
        //Set up the AppExe folder
        URL u = Core.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            File fl = new File(u.toURI());
            appExeFolder = new File(fl.getParent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        //Exception handling
        Thread.setDefaultUncaughtExceptionHandler(new DefaultUncaughtExceptionHandler());
        
        //Load settings and plugins
        plugins = new Vector<PluginCore>();
        if (!Core.safe)
        {
            SettingsManager.load();
            PluginManager.loadPlugins();
        }

        //Init main window
        EventManager.addEventHandler(new EventHandler() {
            @Override
            public void handleEvent(NotifyEvent evt)
            {
                mainFrame = new MainFrame();
                mainFrame.initialize();
                EventManager.fireEvent(this, DefaultEventTypes.WINDOW_CREATED, mainFrame);
                mainFrame.setVisible(true);
            }
        }, DefaultEventTypes.APPLICATION_INITIALIZED, EventPriority.LOW);

        EventManager.fireEvent(null, DefaultEventTypes.APPLICATION_INITIALIZED);
    }
    
    /**
     * Unloads the G-Creator core, modules, and saves the settings.
     * @see #load(boolean)
     */
    protected static void unload()
    {
        if (!Core.safe)
            SettingsManager.unload();
    }
}
