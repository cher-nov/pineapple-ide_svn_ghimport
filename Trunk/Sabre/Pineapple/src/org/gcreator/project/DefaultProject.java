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

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.gcreator.project.io.ProjectManager;
import java.util.Hashtable;
import java.util.Vector;
import org.gcreator.project.io.BasicFile;
import org.gcreator.project.io.DefaultProjectManager;

/**
 * A default implementation of {@link Project}.
 * 
 * @author Serge Humphrey
 */
public class DefaultProject extends Project {
    
    protected Vector<ProjectElement> files;
    protected Hashtable<String, String> settings;
    protected ProjectManager manager;
    protected ProjectType type;
    
    public DefaultProject() {
        this.files = new Vector<ProjectElement>();
        this.settings = new Hashtable<String, String>();
        this.manager = new DefaultProjectManager(this);
        this.type = new DefaultProjectType();
    }

    public DefaultProject(BasicFile f) {
        this();
        try {
            this.files.add(createElement(f));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DefaultProject.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector<ProjectElement> getFiles() {
        return files;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectElement getFileAt(int index) throws IndexOutOfBoundsException {
        return files.get(index);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getFileCount() {
        return files.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Hashtable<String, String> getSettings() {
        return settings;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(ProjectElement e) {
        files.add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(ProjectElement e) {
        return files.remove(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectManager getManager() {
        return manager;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectType getProjectType() {
        return type;
    }
}
