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

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.gcreator.plugins.EventHandler;
import org.gcreator.plugins.EventManager;
import org.gcreator.plugins.NotifyEvent;
import org.gcreator.project.DefaultProject;
import org.gcreator.project.Project;

/**
 * A Dialog to create new projects
 * @author Luís Reis
 */
public class NewProjectDialog extends JDialog implements EventHandler {

    public static String GENERATE_CATEGORIES = "newprojectdialog-generatecats";
    public static String GENERATE_PROJECTS = "newprojectdialog-generateprojs";
    public static String BUTTON_OK = "newprojectdialog-ok";
    private JList projects;

    public NewProjectDialog(Frame owner) {
        super(owner);
        EventManager.addEventHandler(this, GENERATE_CATEGORIES);
        EventManager.addEventHandler(this, GENERATE_PROJECTS);
        EventManager.addEventHandler(this, BUTTON_OK);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        setSize(500, 300);
        setModalityType(ModalityType.APPLICATION_MODAL);
        JLabel title = new JLabel("Choose a project category and type");
        title.setVisible(true);
        this.add(title, BorderLayout.NORTH);
        JSplitPane split = new JSplitPane();
        split.setVisible(true);
        this.add(split, BorderLayout.CENTER);
        JList categories = new JList();
        categories.setVisible(true);
        split.setLeftComponent(categories);
        projects = new JList();
        projects.setVisible(true);
        split.setRightComponent(projects);
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 30));
        panel.setVisible(true);
        FlowLayout l = new FlowLayout();
        panel.setLayout(l);
        l.setAlignment(FlowLayout.RIGHT);
        JButton ok = new JButton("OK");
        ok.setVisible(true);
        ok.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (PineappleGUI.project != null) {
                    int i = JOptionPane.showConfirmDialog(NewProjectDialog.this,
                            "Do you wish to close the current project?",
                            "Close current project?", JOptionPane.YES_NO_OPTION);
                    if (i == JOptionPane.YES_OPTION) {
                        PineappleGUI.project = null;
                        EventManager.fireEvent(this, BUTTON_OK, projects.getSelectedValue());
                    }
                } else {
                    EventManager.fireEvent(this, BUTTON_OK, projects.getSelectedValue());
                }
            }
        });
        panel.add(ok);
        JButton cancel = new JButton("Cancel");
        cancel.setVisible(true);
        cancel.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        panel.add(cancel);
        this.add(panel, BorderLayout.SOUTH);
        DefaultListModel model = new DefaultListModel();
        EventManager.fireEvent(this, GENERATE_CATEGORIES, categories, model);
        categories.setModel(model);
        categories.addListSelectionListener(new ListSelectionListener() {

            public void valueChanged(ListSelectionEvent e) {
                DefaultListModel model = new DefaultListModel();
                EventManager.fireEvent(this, GENERATE_PROJECTS, projects, model);
                projects.setModel(model);
            }
        });
    }

    @Override
    public void handleEvent(NotifyEvent evt) {
        if (evt.getEventType().equals(GENERATE_CATEGORIES)) {
            System.out.println("Generate categories");
            Object[] args = evt.getArguments();
            DefaultListModel model = (DefaultListModel) args[1];
            model.addElement("Default Projects");
        } else if (evt.getEventType().equals(GENERATE_PROJECTS)) {
            Object[] args = evt.getArguments();
            DefaultListModel model = (DefaultListModel) args[1];
            model.addElement("Empty Project");
        } else if (evt.getEventType().equals(BUTTON_OK)) {
            Object[] args = evt.getArguments();
            if (args[0] == null) {
                return;
            }
            String s = args[0].toString();
            if (s.equals("Empty Project")) {
                //Will have to change later
                Project p = new DefaultProject();
                PineappleGUI.project = p;
                PineappleGUI.projectNode.setProject(p);
                PineappleGUI.tree.updateUI();
                dispose();
            }
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void dispose(){
        System.out.println("dispose()");
        EventManager.removeEventHandler(this);
        super.dispose();
    }
}
