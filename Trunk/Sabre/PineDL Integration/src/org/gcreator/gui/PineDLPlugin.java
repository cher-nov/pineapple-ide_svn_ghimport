/*
    Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
    Copyright (C) 2008 Serge Humphrey<bob@bobtheblueberry.com>

    This file is part of PineDL Integration.

    PineDL Integration is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PineDL Integration is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with PineDL Integration.  If not, see <http://www.gnu.org/licenses/>.

 */

package org.gcreator.gui;

import java.io.File;
import org.gcreator.plugins.EventManager;
import org.gcreator.plugins.EventPriority;
import org.gcreator.plugins.NotifyEvent;
import org.gcreator.plugins.PluginCore;

/**
 * The PineDL integration core
 * 
 * @author Luís Reis
 */
public class PineDLPlugin extends PluginCore {

    @Override
    public String getName() {
        return "PineDL Integration";
    }

    @Override
    public String getDescription() {
        return "PineDL Integration adds several PineDL edition tools to " + "Pineapple, including syntax highlighting";
    }

    @Override
    public void initialize() {
        EventManager.addEventHandler(this, PineappleGUI.FILE_OPENED, EventPriority.MEDIUM);
    }

    @Override
    public void handleEvent(NotifyEvent evt) {
        if (evt.getEventType().equals(PineappleGUI.FILE_OPENED)) {
            DocumentPane p;
            Object[] arguments = evt.getArguments();
            File f = (File) arguments[0];
            String format = arguments[1].toString(); //Good to avoid exceptions
            if (!format.equals("pdl")) {
                return;
            }
            p = new PineDLEditor(f);
            PineappleGUI.dip.add(p.getFile().getName(), p);
            evt.handleEvent();
        }
    }
}
