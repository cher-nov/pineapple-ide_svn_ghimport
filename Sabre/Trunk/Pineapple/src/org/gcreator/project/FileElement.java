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
package org.gcreator.project;

import java.io.File;
import javax.swing.Icon;

/**
 * Stores a File and some information about it.
 * 
 * @author Serge Humphrey
 */
public class FileElement extends BaseElement {

    private File file;
    private String format;
    private Icon icon;

    /**
     * Creates a new {@link FileElement} object and sets the format automatically.
     * 
     * @param file The {@link java.io.File} object.
     */
    public FileElement(File file) {
        this(file, getFormat(file.getName()));
    }
    
    /**
     * Creates a new {@link FileElement} object.
     * 
     * @param file The {@link java.io.File} object.
     * @param format The format of the file.
     */
    public FileElement(File file, String format) {
        this.file = file;
        this.format = format;
    }

    /**
     * Creates a new {@link FileElement} object with an icon.
     * 
     * @param file file The {@link java.io.File} object.
     * @param format format The format of the file.
     * @param icon The {@link javax.swing.Icon} to be drawn in the {@link javax.swing.JTree}.
     */
    public FileElement(File file, String format, Icon icon) {
        this(file, format);
        this.icon = icon;
    }

    /**
     * Gets this file's format.
     * 
     * @return The file's format, or <tt>null</tt> if the file has no format.
     */
    public String getFormat() {
        return format;
    }

    /**
     * Gets the file.
     * 
     * @return The File.
     */
    public File getFile() {
        return file;
    }

    /**
     * Gets the icon.
     * 
     * @return The icon.
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Sets the format.
     * 
     * @param format The new file format.
     */
    public void setFormat(String format) {
        this.format = format;
    }

    /**
     * Sets the file.
     * 
     * @param file The new File.
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * Sets the icon.
     * 
     * @param icon The new {@link javax.swing.Icon}.
     */
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    /**
     * Returns the same as the file's {@link java.io.File#getName()} method 
     * or the {@link java.lang.String} literal 'null' if the file is <tt>null</tt>.
     * 
     * @return The file's name or 'null'.
     */
    @Override
    public String toString() {
        return ((file != null) ? file.getName() : "null");
    }

    /**
     * {@inheritDoc}
     * 
     * @param o The {@link java.lang.Object} to compare with.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }

        if (o instanceof FileElement) {
            FileElement f = (FileElement) o;
            return (f.hashCode() == this.hashCode());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (this.file != null ? this.file.hashCode() : 0);
        hash = 89 * hash + (this.format != null ? this.format.hashCode() : 0);
        return hash;
    }
    
    private static String getFormat(String file) {
        int i = file.lastIndexOf(".");
        if (i < 0) {
            return null;
        }
        return file.substring(i+1);
    }
}
