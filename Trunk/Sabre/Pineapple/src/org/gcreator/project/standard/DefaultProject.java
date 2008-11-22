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
import org.gcreator.tree.ProjectTreeNode;

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
    protected ProjectTreeNode treeNode;
    
    /**
     * Creates a new {@link DefaultProject}.
     * 
     * @param folder The folder to use as the project folder.
     * @param type The project type class.
     * @param manager The manager for this project.
     */
    public DefaultProject(File folder, DefaultProjectType type, DefaultProjectManager manager) {
        this.projectFolder = folder;
        this.files = new Vector<ProjectElement>();
        this.settings = new Hashtable<String, String>();
        this.manager = manager;
        this.type = type;
        this.treeNode = new ProjectTreeNode(this);
    }

    /**
     * Creates a new {@link DefaultProject}.
     * 
     * @param folder The folder to use as the project folder.
     * @param type The project type class.
     */
    public DefaultProject(File folder, DefaultProjectType type) {
        this(folder, type, null);
        this.manager = new DefaultProjectManager(this);
    }
    
    /**
     * Creates a new {@link DefaultProject}.
     * 
     * @param folder The folder to use as the project folder.
     * @param manager The manager for this project.
     */
    public DefaultProject(File folder, DefaultProjectManager manager) {
        this(folder, new DefaultProjectType(), manager);
    }
    
    /**
     * Creates a new {@link DefaultProject}.
     * 
     * @param folder The folder to use as the project folder.
     */
    public DefaultProject(File folder) {
        this(folder, new DefaultProjectType(),  null);
        this.manager = new DefaultProjectManager(this);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    @SuppressWarnings("unchecked")
    public Iterable<ProjectElement> getFiles() {
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
        if (!e.allowsDelete()) {
            return false;
        }
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

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectTreeNode getTreeNode() {
        return treeNode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void clear() {
        files.clear();
        manager.saveToManifest();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int indexOf(Object o) {
        return files.indexOf(o);
    }
}
