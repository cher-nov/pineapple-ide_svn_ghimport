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

import java.util.Hashtable;
import java.util.Vector;

/**
 * An implementation of {@link Project}.
 * 
 * @author Serge Humphrey
 */
public class DefaultProject extends Project {

    protected Vector<BaseElement> files;
    protected Hashtable<String, String> settings;

    public DefaultProject() {
        this.files = new Vector<BaseElement>();
        this.settings = new Hashtable<String, String>();
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

}
