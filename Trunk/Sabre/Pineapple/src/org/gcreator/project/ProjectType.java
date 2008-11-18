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

import java.awt.Panel;
import java.io.File;

/**
 * Provides information about a type of {@link Project}.
 * 
 * @author Serge Humphrey
 */
public interface ProjectType {
    
    /**
     * Creates a new project, of a certain type.
     * 
     * @return A new {@link Project} implementation.
     */
    public Project create();
    
    /**
     * Creates and loads a new project from a given file.
     * 
     * @param f The {@link File} to load.
     * @return A new {@link Project} implementation.
     */
    public Project create(File f);
    
    /**
     * Returns the file types that the manager can import.
     * This is similar to {@link #getProjectFileTypes()}, however, importing
     * projects may be done in a different way.
     * 
     * @return An array containing all of the file types that this
     * manager can import.
     */
    public String[] getImportFileTypes();
    
    /**
     * Returns a list of file types that the manager can export projects to.
     * @return An array containing all of the file types that this
     * manager can export.
     */
    public String[] getExportFileTypes();
    
    /**
     * Verifies that the given file can be imported.
     * 
     * @param f The {@link java.io.File} to verify.
     * @return Wheather or not the given file can be imported by the manager.
     */
    public boolean allowsImport(File f);
    
    /**
     * Verifies that a project with the manager can be exported to a given file.
     * <br/>
     * Not very useful.
     * 
     * @param f The {@link java.io.File} to verify.
     * @return Wheather a project with this class as their project
     * manger can be exported to the given file.
     */
    public boolean allowsExport(File f);
    
    /**
     * Gets the file formats that this {@link ProjectManager} can save/load.
     * 
     * @return An array of strings for each of the
     * file formats this {@link ProjectManager} can save/load.
     * 
     * @see #getImportFileTypes() 
     * @see #getExportFileTypes() 
     */
    public String[] getProjectFileTypes();
    
    /**
     * Verifies that this {@link ProjectManager} can load a
     * given file.
     * 
     * @param f The {@link java.io.File} to verify.
     * @return <tt>true</tt> if this {@link ProjectManager} can
     * load the given {@link File}. Otherwise <tt>false</tt>.
     */
    public boolean allowsProject(File f);
    
    /**
     * @return A human-readable name project type.
     */
    public String getName();
    
    /**
     * @return A human-readable description of this project type.
     */
    public String getDescription();
}
