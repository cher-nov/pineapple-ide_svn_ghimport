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

package org.gcreator.gui;

import java.io.File;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.EventManager;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.NotifyEvent;
import org.gcreator.plugins.PluginCore;

/**
 * The PineDL integration core
 * @author Luís Reis
 */
public class PineDLPlugin extends PluginCore{
    @Override
    public void initialize(){
        EventManager.addEventHandler(this, DefaultEventTypes.FILE_OPENED, EventPriority.MEDIUM);
    }
    
    @Override
    public void handleEvent(NotifyEvent evt){
        if(evt.getEventType().equals(DefaultEventTypes.FILE_OPENED)){
            System.out.println("Got here");
            DocumentPane p;
            Object[] arguments = evt.getArguments();
            File f = (File) arguments[0];
            String format = arguments[1].toString(); //Good to avoid exceptions
            if (!format.equals("pdl"))
                return;
            System.out.println("Got here");
            p = new PineDLEditor(f);
            System.out.println("And here too");
            PineappleGUI.dip.add(p.getFile().getName(), p);
            evt.handleEvent();
        }
    }
}
