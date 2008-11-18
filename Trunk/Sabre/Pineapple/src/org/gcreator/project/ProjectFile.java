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

import javax.swing.Icon;
import org.gcreator.project.io.BasicFile;
import org.gcreator.tree.BaseTreeNode;
import org.gcreator.tree.FileTreeNode;

/**
 * Stores a File and some information about it.
 * 
 * @author Serge Humphrey
 */
public class ProjectFile extends ProjectElement {

    protected BasicFile file;
    protected String format;
    protected Icon icon;
    protected FileTreeNode treeNode;
    protected Project project;
    
    /**
     * Creates a new {@link ProjectFile} object and sets the format automatically.
     * 
     * @param file The {@link java.io.File} object.
     * @param p The {@link Project} that this file should belong to.
     */
    public ProjectFile(BasicFile file, Project p) {
        this(file, getFormat(file.getName()), p);
    }
    
    /**
     * Creates a new {@link ProjectFile} object.
     * 
     * @param file The {@link java.io.File} object.
     * @param format The format of the file.
     * @param p The {@link Project} that this file should belong to.
     */
    public ProjectFile(BasicFile file, String format, Project p) {
        this.file = file;
        this.format = format;
        this.treeNode = new FileTreeNode(this);
        this.project = p;
    }

    /**
     * Creates a new {@link ProjectFile} object with an icon.
     * 
     * @param file file The {@link java.io.File} object.
     * @param format format The format of the file.
     * @param icon The {@link javax.swing.Icon} to be drawn in the {@link javax.swing.JTree}.
     * @param p The {@link Project} that this file should belong to.
     */
    public ProjectFile(BasicFile file, String format, Icon icon, Project p) {
        this(file, format, p);
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
     * {@inheritDoc}
     */
    public BasicFile getFile() {
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
    public void setFile(BasicFile file) {
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
    
    private static String getFormat(String file) {
        int i = file.lastIndexOf(".");
        if (i < 0) {
            return null;
        }
        return file.substring(i+1);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseTreeNode getTreeNode() {
        return treeNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Project getProject() {
        return project;
    }
}