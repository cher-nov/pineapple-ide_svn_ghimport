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

import java.awt.Frame;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.gcreator.core.Core;
import org.gcreator.plugins.EventManager;
import org.gcreator.plugins.PluginCore;

/**
 * Allows the user to uninstall plugins
 * In the future, plugin installation and updating would also
 * be nice
 * @author Luís Reis
 */
public final class PluginDialog extends JDialog {

    private static final long serialVersionUID = 1L;
    
    public static String PLUGINDIALOG_OPEN = "plugindialog-open";

    public JSplitPane splitPane;
    public JList plugList;
    public JScrollPane scrollPane;
    public JEditorPane editorPane;
    
    public PluginDialog(Frame f) {
        super(f);
        this.setTitle("Plugins");
        this.setModalityType(ModalityType.APPLICATION_MODAL);
        this.setSize(300, 200);
        
        plugList = new JList(Core.getStaticContext().getPlugins());
        plugList.setCellRenderer(new PluginCellRenderer());
        
        plugList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                Object o = plugList.getSelectedValue();
                if(o==null){
                    editorPane.setText("-No plugin selected-");
                }
                else if(o instanceof PluginCore){
                    editorPane.setText(((PluginCore) o).getDescription());
                }
            }
        });
        
        editorPane = new JEditorPane();
        editorPane.setContentType("text/html");
        editorPane.setEditable(false);
        editorPane.setVisible(true);
        
        scrollPane = new JScrollPane(editorPane);
        scrollPane.setVisible(true);
        
        splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, plugList, scrollPane);
        splitPane.setVisible(true);
        this.add(splitPane);
        
        EventManager.fireEvent(this, PLUGINDIALOG_OPEN, this);
    }
}
