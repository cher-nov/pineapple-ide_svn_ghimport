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
import java.util.Hashtable;
import java.util.Vector;
import org.gcreator.xml.Node;
import org.gcreator.xml.SAXImporter;
import org.xml.sax.SAXException;

/**
 * An implementation of {@link Project}.
 * 
 * @author Serge Humphrey
 */
public class DefaultProject extends Project {

    protected File manifestFile;
    protected Vector<BaseElement> files;
    protected Hashtable<String, String> settings;

    public DefaultProject() {
        this.files = new Vector<BaseElement>();
        this.settings = new Hashtable<String, String>();
        this.manifestFile = null;
    }

    public DefaultProject(File f) {
        this();
        this.manifestFile = f;
        update();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Vector<BaseElement> getFiles() {
        return files;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public BaseElement getFileAt(int index) throws IndexOutOfBoundsException {
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
    public void add(BaseElement e) {
        files.add(e);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean remove(BaseElement e) {
        return files.remove(e);
    }

    /**
     * Gets the files and settings from a file
     */
    @Override
    public void update() {
        if (manifestFile != null) {
            try {
                SAXImporter importer = new SAXImporter(manifestFile);
                Node root = importer.getDocumentRoot();
                if (!root.getName().equals("pineapple-project")) {
                    throw new SAXException("Not a pineapple project");
                }
                if (!root.hasAttribute("version")) {
                    throw new SAXException("Not a valid pineapple project");
                }
                if (!root.getAttributeValue("version").equals("1.0")) {
                    throw new SAXException("Can not read given project version");
                }
                Hashtable<String, String> hs = new Hashtable<String, String>();
                Vector<BaseElement> fileTmp = new Vector<BaseElement>();
                for (Node node : root.getChildren()) {
                    if (node.getName().equals("setting")) {
                        hs.put(node.getAttributeValue("key"), node.getAttributeValue("value"));
                    }
                    if(node.getName().equals("file")) {
                        fileTmp.add(createElement(new File(node.getContent())));
                    }
                }
                //So far, no exceptions, so let's do this!
                //I hope the Garbage Collection does its job.
                settings = hs;
                files = fileTmp;
                
            } catch (Exception e) {
            }
        }
    }
}
