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
import org.gcreator.tree.BaseTreeNode;

/**
 * A base class for {@link FileElement} and {@link FolderElement}.
 *  
 * @author Serge Humphrey
 */
public abstract class BaseElement {
    
    /**
     * This file's parent.
     */
    protected BaseElement parent;
    
    /**
     * Gets the file.
     * 
     * @return The File.
     */
    public abstract File getFile();
    
    /**
     * Gets the {@link org.gcreator.tree.BaseTreeNode} to be used for the tree.
     * 
     * @return A {@link org.gcreator.tree.BaseTreeNode} to be used for the tree.
     */
    public abstract BaseTreeNode getTreeNode();
    
    /**
     * This returns the parent or null if it has not been set.
     * 
     * @return This file's parent. This may be null and is not very reliable.
     * @see setParent(BaseElement e)
     */
    public BaseElement getParent() {
        return parent;
    }
    
    /**
     * Sets the parent of this file.
     * 
     * @param e The new parent for this file.
     * 
     * @see getParent()
     */
    public void setParent(BaseElement e) {
        this.parent = e;
    }
}
