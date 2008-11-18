/*
    Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
    Copyright (C) 2008 Serge Humphrey<bob@bobtheblueberry.com>

    This file is part of PineDL Integration.

    PineDL Integration is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    PineDL Integration is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with PineDL Integration.  If not, see <http://www.gnu.org/licenses/>.

 */


package org.gcreator.pinedli;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rtextarea.RTextScrollPane;
import org.gcreator.editors.TextEditor;
import org.gcreator.gui.DocumentPane;
import org.gcreator.project.io.BasicFile;

/**
 *
 * @author Luís Reis
 */
public class PineDLEditor extends DocumentPane {

    private static final long serialVersionUID = 1L;
    private RTextScrollPane scroll;
    private RSyntaxTextArea editor;
    private BasicFile file;
    
    public PineDLEditor(BasicFile file) {
        super(file);
        this.setLayout(new BorderLayout());
        this.editor = new RSyntaxTextArea();
        this.file = file;
        
        editor.restoreDefaultSyntaxHighlightingColorScheme();
        editor.setSyntaxEditingStyle(RSyntaxTextArea.PINEDL_SYNTAX_STYLE);
        
        if (file.exists()) {
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(file.getInputStream());
                StringBuilder b = new StringBuilder((int) file.getLength());
                int r;
                while ((r = in.read()) != -1) {
                    b.append((char) r);
                }
                editor.setText(b.toString());
            } catch (IOException ex) {
                Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(TextEditor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        editor.getDocument().addDocumentListener(new DocumentListener() {

            public void insertUpdate(DocumentEvent evt) {
                setModified(true);
            }

            public void removeUpdate(DocumentEvent evt) {
                setModified(true);
            }

            public void changedUpdate(DocumentEvent evt) {
                setModified(true);
            }
        });
        
        scroll = new RTextScrollPane(getWidth(), getHeight(), editor, true);
        this.add(scroll, BorderLayout.CENTER);
    }

    /**
     * Saves the file
     * @return 
     */
    @Override
    public boolean saveBackend() {
        try {
            BufferedOutputStream out = new BufferedOutputStream(file.getOutputStream());
            out.write(editor.getText().getBytes());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean setupEditMenu(JMenu editMenu) {
        JMenuItem cut = new JMenuItem("Cut");
        cut.setMnemonic('t');
        cut.setVisible(true);
        cut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                editor.cut();
            }
        });
        editMenu.add(cut);
        JMenuItem copy = new JMenuItem("Copy");
        copy.setMnemonic('y');
        copy.setVisible(true);
        copy.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                editor.copy();
            }
        });
        editMenu.add(copy);
        JMenuItem paste = new JMenuItem("Paste");
        paste.setMnemonic('P');
        paste.setVisible(true);
        paste.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                editor.paste();
            }
        });
        editMenu.add(paste);
        JMenuItem selall = new JMenuItem("Select All");
        selall.setMnemonic('A');
        selall.setVisible(true);
        selall.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent evt) {
                editor.selectAll();
            }
        });
        editMenu.add(selall);

        return true;
    }
}
