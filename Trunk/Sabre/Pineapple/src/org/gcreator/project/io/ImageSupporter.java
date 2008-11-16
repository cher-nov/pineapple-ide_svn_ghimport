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


package org.gcreator.project.io;

import javax.imageio.ImageIO;
import org.gcreator.editors.ImagePreviewer;
import org.gcreator.gui.DocumentPane;
import org.gcreator.pineapple.PineapplePlugin;
import org.gcreator.plugins.NotifyEvent;

/**
 * Allows you to load images in Pineapple
 * using {@link javax.imageio.ImageIO}.
 * 
 * @author Serge Humphrey
 */
public class ImageSupporter implements FormatSupporter {
    
    public String[] getFormats() {
        return ImageIO.getReaderFileSuffixes();
    }

    public DocumentPane load(BasicFile f) {
        return new ImagePreviewer(f);
    }

    public void handleEvent(NotifyEvent event) {
        if (event.getEventType().equals(PineapplePlugin.REGISTER_FORMATS)) {
            PineapplePlugin.addFormatSupporter(this);
        }
    }

    public String getName() {
        return "Java ImageIO Image Loader";
    }

    public String getDescription() {
        String s = "Loads images of the following types: ";
        for (String f : ImageIO.getReaderFormatNames()) {
            s += f+" ";
        }
        s += ".";
        return s;
    }

}
