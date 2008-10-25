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
import java.io.FileNotFoundException;
import java.util.Vector;

/**
 * Represents a folder and holds files belonging to the folder.
 * 
 * @author Serge Humphrey
 */
public class FolderElement extends BaseElement {
    
    private Vector<BaseElement> children;
    private File folder;
    
    /**
     * Creates a new {@link FolderElement} and scans for files and adds them to its children.
     * 
     * @param folder The folder that this {@link FolderElement} should represent.
     * @throws java.lang.IllegalArgumentException If {@link java.io.File#isDirectory() folder.isDirecotry()} returns <tt>false</tt>.
     */
    public FolderElement(File folder) throws IllegalArgumentException {
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("Illegal Folder: " + folder);
        }
        this.folder = folder;
        children = new Vector<BaseElement>(folder.listFiles().length);
        reload();
    }
    
    public void reload() {
        children.clear();
        for (File f : folder.listFiles()) {
            BaseElement e;
            if (f.isDirectory()) {
                e = new FolderElement(f);
            } else {
                e = new FileElement(f);
            }
            children.add(e);
        }
    }
    
    /**
     * Gets the folder's children.
     * 
     * @return The folder's children.
     */
    public Vector<BaseElement> getChildren() {
        return children;
    }
    
    /**
     * Returns the child at the given index.
     * 
     * @param index The index the child is at.
     * @return The child at hte given index.
     * 
     * @throws java.lang.ArrayIndexOutOfBoundsException If the index if smaller
     * than zero or greater than or equal to the number of children.
     * 
     * @see #getChildrenCount()
     */
    public BaseElement getChildAt(int index) throws ArrayIndexOutOfBoundsException {
        return children.get(index);
    }
    
    /**
     * Return the nmber of children.
     * 
     * @return The number of children this folder has.
     */
    public int getChildrenCount() {
        return children.size();
    }
    
    /**
     * Gets the {@link java.io.File} that this {@link FolderElement} represents.
     * 
     * @return The {@link java.io.File} that this {@link FolderElement} represents.
     */
    public File getFile() {
        return folder;
    }
    
    /**
     * Adds a child to the children.
     * Same as getChildren().add(e).
     * 
     * @param e The {@link BaseElement} to add.
     */
    public void addChild(BaseElement e) {
        addChild(e);
    }
    
    /**
     * Adds a child to the children.
     * 
     * @param f The {@link java.io.File} to add.
     * 
     * @throws java.io.FileNotFoundException If the given file does not exist.
     */
    public void addChild(File f) throws FileNotFoundException {
        addChild(Project.createElement(f));
    }
}
