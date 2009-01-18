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

package org.gcreator.pinedl.cpp;

import java.io.OutputStream;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Luís Reis
 */
public class CompilerFrame extends javax.swing.JFrame {

    public class PineDLOutputStream extends OutputStream{
        public void write(int c){
            if(c=='\n'){
                jEditorPane1.setText(jEditorPane1.getText() + "<br>\n");
            }
            else{
                jEditorPane1.setText(jEditorPane1.getText() + ((char) c));
            }
        }
    }
    
    public void writeLine(String s){
        jEditorPane1.setText(jEditorPane1.getText() + s.replaceAll("\n","<br>\n") + "<br>\n");
    }
    
    /** Creates new form CompilerFrame */
    public CompilerFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(300, 200));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        jButton1.setText("Open Folder");
        jPanel1.add(jButton1);

        jButton2.setText("Run Game");
        jPanel1.add(jButton2);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_END);

        jEditorPane1.setEditable(false);
        jEditorPane1.setText("Compiling...\n");
        jScrollPane1.setViewportView(jEditorPane1);

        getContentPane().add(jScrollPane1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
