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
import java.util.Hashtable;
import java.util.Vector;

/**
 * A basic foundation for projects.
 * 
 * @author Serge Humphrey
 */
public abstract class Project {

    /**
     * Gets all of the files in the form of a {@link java.util.Vector}.
     * 
     * @return A {@link java.util.Vector} containing all of the project's file/folders in it.
     */
    public abstract Vector<BaseElement> getFiles();

    /**
     * Adds a file to the project.
     * 
     * @param e The file to add.
     */
    public abstract void add(BaseElement e);
    
    /**
     * Removes a file from the project.
     * 
     * @param e The file to remove.
     * @return <tt>true</tt> if the element was in the list.
     */
    public abstract boolean remove(BaseElement e);
    
    /**
     * Returns the {@link BaseElement} at index <tt>index</tt>.
     * Same as getFiles().get(index).
     * 
     * @param index The index to fetch.
     * @return Returns the {@link BaseElement} at index <tt>index</tt>.
     * 
     * @throws java.lang.IndexOutOfBoundsException If <tt>index</tt> was smaller 
     * than zero or greater than or equal to {@link #getFileCount()}.
     */
    public abstract BaseElement getFileAt(int index) throws IndexOutOfBoundsException;

    /**
     * Returns the number of elements belonging to this project.
     * Same as getFiles().size()
     * 
     * @return The number of elements belonging to this project.
     */
    public abstract int getFileCount();

    /**
     * Gets a {@link java.util.Hashtable} containing various settings for this
     * project.
     * 
     * @return A {@link java.util.Hashtable} containing various settings for this
     * project.
     */
    public abstract Hashtable<String, String> getSettings();

    /**
     * Creates an element, either a {@link FileElement} or {@link FolderElement}, depending on
     * whether the given file is a directory or not.
     * 
     * @param f The {@link java.io.File} which the element must exist.
     * @return An element that represents the given file.
     * 
     * @throws java.io.FileNotFoundException If the given file does not exist.
     */
    public static final BaseElement createElement(File f) throws FileNotFoundException {
        if (!f.exists()) {
            throw new FileNotFoundException("File '" + f + "' does not exist.");
        }
        BaseElement e;
        if (f.isDirectory()) {
            e = new FolderElement(f);
        } else {
            e = new FileElement(f);
        }
        return e;
    }
}
