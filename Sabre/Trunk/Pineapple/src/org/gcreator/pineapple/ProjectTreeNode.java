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


package org.gcreator.pineapple;

import org.gcreator.project.Project;
import java.util.Enumeration;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * The tree node for the project
 * 
 * @author Serge Humphrey
 */
public class ProjectTreeNode implements TreeNode {
    
    private Project project;
    
    /**
     * Creates a new {@link ProjectTreeNode}.
     * 
     * @param project The project this node belongs to.
     */
    public ProjectTreeNode(Project project) {
        this.project = project;
    }

    /**
     * Returns a child at a specific index.
     * 
     * @param childIndex The index the child is at.
     * @return The TreeNode at the given index.
     */
    public TreeNode getChildAt(int childIndex) {
        return new DefaultMutableTreeNode(project.getFileAt(childIndex));
    }

    /**
     * Gets the number of children.
     * 
     * @return The number of children.
     */
    public int getChildCount() {
        return project.getFileCount();
    }

    /**
     * Returns <tt>null</tt>.
     * 
     * @return <tt>null</tt>.
     */
    public TreeNode getParent() {
        return null;
    }

    /**
     * Returns the index of the given node, or -1 if it is not in the tree.
     *  
     * @param node The node.
     * @return The index of the given node, or -1 if it is not in the tree.
     */
    public int getIndex(TreeNode node) {
        return project.getFiles().indexOf(node);
    }

    /**
     * Returns <tt>true</tt>.
     * @return <tt>true</tt>
     */
    public boolean getAllowsChildren() {
        return true;
    }

    /**
     * Returns <tt>false</tt>.
     * @return <tt>flase</tt>.
     */
    public boolean isLeaf() {
        return false;
    }

    public Enumeration children() {
        return new Enumeration() {
            private int index = 0;
            public boolean hasMoreElements() {
                return index < project.getFileCount();
            }

            public Object nextElement() {
                return project.getFileAt(index++);
            }
        };
    }

}
