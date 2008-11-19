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

package org.gcreator.project.standard;

import java.io.File;
import org.gcreator.project.io.ProjectManager;
import java.util.Hashtable;
import java.util.Vector;
import org.gcreator.project.Project;
import org.gcreator.project.ProjectElement;
import org.gcreator.project.ProjectType;

/**
 * A default implementation of {@link Project}.
 * 
 * @author Serge Humphrey
 */
public class DefaultProject extends Project {
    
    protected Vector<ProjectElement> files;
    protected Hashtable<String, String> settings;
    protected DefaultProjectManager manager;
    protected ProjectType type;
    
    /**
     * Creates a new {@link DefaultProject}.
     * 
     * @param folder The folder to use as the project folder.
     */
    public DefaultProject(File folder) {
        this.projectFolder = folder;
        this.files = new Vector<ProjectElement>();
        this.settings = new Hashtable<String, String>();
        this.manager = new DefaultProjectManager(this);
        this.type = new DefaultProjectType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Vector<ProjectElement> getFiles() {
        return (Vector<ProjectElement>) files.clone();
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
    @SuppressWarnings("unchecked")
    public Hashtable<String, String> getSettings() {
        return (Hashtable<String, String>) settings.clone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void add(ProjectElement e) {
        files.add(e);
        manager.saveToManifest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(ProjectElement e) {
        boolean b = files.remove(e);
        manager.saveToManifest();
        return b;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean allowsSave() {
        return false;
    }
}
