/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 BobSerge<serge_1994@hotmail.com>

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
package org.gcreator.gui;

import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;
import org.gcreator.tree.ProjectTreeNode;
import org.gcreator.project.ProjectFile;
import org.gcreator.project.Project;
import org.gcreator.tree.FileTreeNode;

/**
 * A FolderProject tree cell renderer
 * 
 * @author Luís Reis
 * @see javax.swing.tree.DefaultTreeCellRenderer
 */
public class ProjectTreeRenderer extends DefaultTreeCellRenderer {

    private static final long serialVersionUID = 1;
    
    public ProjectTreeRenderer() {
        setOpaque(false);
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object val,
            boolean isSelected, boolean isExpanded, boolean isLeaf, int row,
            boolean hasFocus) {

        JLabel l = (JLabel) super.getTreeCellRendererComponent(tree, val, isSelected, isExpanded, isLeaf, row, hasFocus);

        if (val instanceof ProjectTreeNode) {
            try {
                ProjectTreeNode n = (ProjectTreeNode)val;
                Project p = n.getProject();
                String name = p.getSettings().get("name");
                if (name != null) {
                    l.setText(name);
                } else {
                    l.setText("Project");
                }
            } catch (Exception exc) {
                l.setText("Project");
            }
        }
        
        if (val instanceof FileTreeNode) {
            FileTreeNode node = (FileTreeNode) val;
            ProjectFile el = (ProjectFile) node.getElement();
            if (el.getIcon() != null) {
                l.setIcon(el.getIcon());
            }
        }

        return l;
    }
}
