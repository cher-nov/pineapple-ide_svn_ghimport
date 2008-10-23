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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;

/**
 *
 * @author Luís Reis
 */
public class PineDLEditor extends DocumentPane{
    private RTextScrollPane scroll;
    private RSyntaxTextArea editor;
    
    public PineDLEditor(File file){
        super(file);
        System.out.println("Using this");
        this.setLayout(new BorderLayout());
        editor = new RSyntaxTextArea();
        if(file.exists()){
            try{
                FileInputStream fs = new FileInputStream(file);
                String text = "";
                while(fs.available()>0){
                    text += (char) fs.read();
                }
                editor.setText(text);
            }
            catch(Exception e){}
        }
        editor.getDocument().addDocumentListener(new DocumentListener(){
            public void insertUpdate(DocumentEvent evt){
                setModified(true);
            }
            public void removeUpdate(DocumentEvent evt){
                setModified(true);
            }
            public void changedUpdate(DocumentEvent evt){
                setModified(true);
            }
        });
        editor.restoreDefaultSyntaxHighlightingColorScheme();
        editor.setSyntaxEditingStyle(RSyntaxTextArea.JAVA_SYNTAX_STYLE);
        scroll = new RTextScrollPane(getWidth(), getHeight(), editor, true);
        this.add(scroll, BorderLayout.CENTER);
        //scroll.setViewportView(editor);
    }
    
        /**
     * Saves the file
     */
    @Override
    public boolean saveBackend(){
        try{
            FileOutputStream fs = new FileOutputStream(getFile());
            fs.write(editor.getText().getBytes());
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setupEditMenu(JMenu editMenu){
        JMenuItem cut = new JMenuItem("Cut");
        cut.setMnemonic('t');
        cut.setVisible(true);
        cut.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                editor.cut();
            }
        });
        editMenu.add(cut);
        JMenuItem copy = new JMenuItem("Copy");
        copy.setMnemonic('y');
        copy.setVisible(true);
        copy.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                editor.copy();
            }
        });
        editMenu.add(copy);
        JMenuItem paste = new JMenuItem("Paste");
        paste.setMnemonic('P');
        paste.setVisible(true);
        paste.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                editor.paste();
            }
        });
        editMenu.add(paste);
        JMenuItem selall = new JMenuItem("Select All");
        selall.setMnemonic('A');
        selall.setVisible(true);
        selall.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                editor.selectAll();
            }
        });
        editMenu.add(selall);
        
        return true;
    }
}
