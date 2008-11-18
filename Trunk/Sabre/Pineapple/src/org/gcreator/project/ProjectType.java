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
     * @return A human-readable name project type.
     */
    public String getName();
    
    /**
     * @return A human-readable description of this project type.
     */
    public String getDescription();
}
