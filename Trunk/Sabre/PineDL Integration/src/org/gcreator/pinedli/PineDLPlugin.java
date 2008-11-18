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
GNU Lesser General Public License for more details.

You should have received a copy of the GNU General Public License
along with PineDL Integration.  If not, see <http://www.gnu.org/licenses/>.

 */
package org.gcreator.pinedli;

import org.gcreator.gui.DocumentPane;
import org.gcreator.managers.EventManager;
import org.gcreator.pineapple.PineapplePlugin;
import org.gcreator.plugins.DefaultEventTypes;
import org.gcreator.plugins.Event;
import org.gcreator.plugins.Plugin;
import org.gcreator.project.io.BasicFile;
import org.gcreator.project.io.FormatSupporter;

/**
 * The PineDL integration core
 * 
 * @author Luís Reis
 */
public class PineDLPlugin extends Plugin implements FormatSupporter {

    private final String[] FORMATS = {
        "pdl",
        "pinedl",
    };

    /**
     * {@inheritDoc}
     */
    @Override
    public String getName() {
        return "PineDL Integration";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return "PineDL Integration adds several PineDL edition tools to " +
                "Pineapple, including syntax highlighting";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void handleEvent(Event e) {
        if (e.getEventType().equals(PineapplePlugin.REGISTER_FORMATS)) {
            PineapplePlugin.addFormatSupporter(this);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void initialize() {
        EventManager.addEventHandler(this, PineapplePlugin.REGISTER_FORMATS);
    }

    /**
     * {@inheritDoc}
     */
    public String[] getFormats() {
        return FORMATS;
    }

    /**
     * {@inheritDoc}
     */
    public DocumentPane load(BasicFile f) {
        return new PineDLEditor(f);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getAuthor() {
        return "Luís Reis, Serge Humphrey";
    }
}
