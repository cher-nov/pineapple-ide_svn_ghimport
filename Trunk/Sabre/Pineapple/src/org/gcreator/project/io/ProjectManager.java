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

import java.io.File;
import org.gcreator.project.Project;

/**
 *
 * This interface provides basic project management,
 * and handles I/O things like loading, saving, and
 * exporting.
 * 
 * @author Serge Humphrey
 */
public interface ProjectManager {
    
    /**
     * Saves the project to a given file.
     * 
     * @param f The {@link java.io.File} to save to.
     * This should be one the strings from {@see #getProjectFileTypes()}.
     * 
     * @see #getProjectFileTypes() 
     */
    public void save(File f);
    
    /**
     * Creates a new {@link Project} from a {@link java.io.File}.
     * 
     * @param f The {@link java.io.File} to be loaded.
     * @return A new {@link Project} created from the given {@link java.io.File}.
     * 
     * @see #getProjectFileTypes() 
     * @see #allowsProject(java.io.File) 
     */
    public Project load(File f);
    
    /**
     * Creates a {@link Basicfile} implementation for a
     * given {@link java.io.File java.io.File}.
     * 
     * @param f The {@link java.io.File} to use.
     * @return a {@link Basicfile} implementation for a
     * given {@link java.io.File java.io.File}.
     */
    public BasicFile createBasicFileFromFile(File f);
    
    /**
     * @return This manager's project.
     */
    public Project getProject();
}
