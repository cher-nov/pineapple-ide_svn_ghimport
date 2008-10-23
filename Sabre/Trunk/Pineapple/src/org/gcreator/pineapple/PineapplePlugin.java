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

import org.gcreator.gui.PineappleGUI;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.EventManager;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.PluginCore;

/**
 * The Plugin class for Pineapple.
 * 
 * @author Luís Reis
 */
public class PineapplePlugin extends PluginCore {
    
    public static PineappleGUI gui;
    
    /**
     * Initializes the plugin(Registers the event handlers)
     */
    @Override
    public void initialize() {
        
        gui = new PineappleGUI();
        
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_CREATED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.WINDOW_DISPOSED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.FILE_OPENED, EventPriority.LOW);
        EventManager.addEventHandler(this, DefaultEventTypes.FILE_CHANGED, EventPriority.MEDIUM);
        EventManager.addEventHandler(this, DefaultEventTypes.PROJECT_OPENED, EventPriority.MEDIUM);
    }   
}