/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge_1994@hotmail.com>

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;

/**
 * The about dialog, contains credits and license
 * @author Luís Reis
 */
public class AboutDialog extends JDialog{
    private static final long serialVersionUID = -3046667469132936123L;
    
    
    
    public AboutDialog(JFrame frame){
        super(frame);
        
        setTitle("About");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setSize(500, 300);
        setModalityType(ModalityType.APPLICATION_MODAL);
        
        setLayout(new BorderLayout());
        
        JSeparator sep = new JSeparator();
        sep.setVisible(true);
        add(sep, BorderLayout.SOUTH);
        
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(100, 30));
        panel.setVisible(true);
        add(panel, BorderLayout.SOUTH);
        FlowLayout l = new FlowLayout();
        panel.setLayout(l);
        l.setAlignment(FlowLayout.RIGHT);
        JButton ok = new JButton("OK");
        ok.setVisible(true);
        ok.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                AboutDialog.this.dispose();
            }
        });
        panel.add(ok);
        
        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Credits", createCreditsTab());
        tabs.add("License", createLicenseTab());
        
        add(tabs, BorderLayout.CENTER);
    }
    
    public JScrollPane createCreditsTab(){
        JEditorPane editor = new JEditorPane();
        editor.setVisible(true);
        editor.setEditable(false);
        editor.setContentType("text/html");
        editor.setText("Development Team:<br>"+
                "Luís 'luiscubal' Reis<br>"+
                "Serge 'BobSerge' Humphrey<br>" +
                "'Rusky'");
        JScrollPane scroll = new JScrollPane(editor);
        scroll.setVisible(true);
        
        return scroll;
    }
    
    public JScrollPane createLicenseTab(){
        JEditorPane editor = new JEditorPane();
        editor.setVisible(true);
        editor.setEditable(false);
        editor.setContentType("text/html");
        editor.setText("Most code is licensed as MIT.<br>"+
                "Different licenses may be used in some modules, though.");
        JScrollPane scroll = new JScrollPane(editor);
        scroll.setVisible(true);
        
        return scroll;
    }
}
