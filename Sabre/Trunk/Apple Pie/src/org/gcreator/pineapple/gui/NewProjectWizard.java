/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<serge@bobtheblueberry.com>

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
/*
 * NewProjectWizard.java
 *
 * Created on November 16, 2008, 6:54 PM
 */
package org.gcreator.pineapple.gui;

import java.awt.CardLayout;
import java.io.File;
import javax.swing.AbstractListModel;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.gcreator.pineapple.core.Core;
import org.gcreator.pineapple.core.PineappleCore;

/**
 * Wizard that creates a new project.
 * 
 * @author Serge Humphrey
 */
public final class NewProjectWizard extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private CardLayout layout;
    private int step = 0;

    /** Creates new form NewProjectWizard
     * @param parent The parent frame for the dialog.
     */
    public NewProjectWizard(java.awt.Frame parent) {
        super(parent);
        initComponents();

        DocumentListener dl1 = new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                update();
            }

            public void removeUpdate(DocumentEvent e) {
                update();
            }

            public void changedUpdate(DocumentEvent e) {
                update();
            }

            private void update() {
                updateProjectFolder();
                String text = projectNameTextField.getText();
                // Silly Windows
                if (text == null || text.equals("") || text.contains(File.separator) || !text.matches("^(?!((con|prn|aux|nul|com1|com2|com3|com4|com5|com6|com7|com8|com9|lpt1|lpt2|lpt3|lpt4|lpt5|lpt6|lpt7|lpt8|lpt9)((\\.[^\\\\/:*?<>|]{1,3}$)|$))|[\\s\\.])[^\\\\/:*?<>|]{1,254}$")) {
                    setErrorMessage("Error: Invalid project name");
                    nextButton.setEnabled(false);
                } else if (new File(projectFolderTextField.getText()).exists()) {
                    setErrorMessage("Error: Folder exists. Please specify a different location.");
                    nextButton.setEnabled(false);
                } else {
                    errorLabel.setVisible(false);
                    nextButton.setEnabled(true);
                }
            }
        };

        DocumentListener dl2 = new DocumentListener() {

            public void insertUpdate(DocumentEvent e) {
                updateProjectFolder();
            }

            public void removeUpdate(DocumentEvent e) {
                updateProjectFolder();
            }

            public void changedUpdate(DocumentEvent e) {
                updateProjectFolder();
            }
        };

        projectNameTextField.getDocument().addDocumentListener(dl1);
        projectLocationTextField.getDocument().addDocumentListener(dl2);

        projectsList.setModel(new AbstractListModel() {

            private static final long serialVersionUID = 1;

            public int getSize() {
                return PineappleCore.getProjectTypes().size();
            }

            public Object getElementAt(int index) {
                return PineappleCore.getProjectTypes().get(index).getName();
            }
        });

        projectLocationTextField.setText(System.getProperty("user.home") + File.separator + "PineappleProjects" + File.separator);

        this.setLocationRelativeTo(null);
    }

    private void finish() {
        File f = null;
        try {
            f = new File(projectFolderTextField.getText());
            if (!f.mkdirs() && !f.exists()) {
                throw new Exception();
            }
        } catch (Exception exc) {
            setErrorMessage("Cannot create directory " + f);
            return;
        }
        PineappleCore.setProject(PineappleCore.getProjectTypes().
                get(projectsList.getSelectedIndex()).create(projectNameTextField.getText(), f));
        PineappleGUI.tree.updateUI();
        dispose();
    }

    private void updateProjectFolder() {
        projectFolderTextField.setText(projectLocationTextField.getText() +
                ((projectLocationTextField.getText().endsWith(File.separator)) ? "" : File.separator) + projectNameTextField.getText());
    }

    private void setErrorMessage(String s) {
        errorLabel.setText("<html><span style=\"color: red;\">" + s + "</span></html>");
        errorLabel.setVisible(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        step1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        descriptionTextPane = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projectsList = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        projectNameTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        projectLocationTextField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        projectFolderTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Project");
        setModalityType(ModalityType.APPLICATION_MODAL);

        /*
        mainPanel.setLayout(new java.awt.CardLayout());
        */
        mainPanel.setLayout(layout = new java.awt.CardLayout());

        descriptionTextPane.setEditable(false);
        jScrollPane2.setViewportView(descriptionTextPane);

        jLabel2.setText("Project Type");

        projectsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                projectsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(projectsList);

        jLabel3.setText("Description");

        jLabel1.setText("<html><strong>Choose Project Type</strong></html>");

        javax.swing.GroupLayout step1Layout = new javax.swing.GroupLayout(step1);
        step1.setLayout(step1Layout);
        step1Layout.setHorizontalGroup(
            step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, step1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(step1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(step1Layout.createSequentialGroup()
                        .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        step1Layout.setVerticalGroup(
            step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, step1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
        );

        mainPanel.add(step1, "card2");

        jLabel4.setText("<html><strong>Name and Location</strong></html>");

        jLabel5.setText("Project Name:");

        projectNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectNameTextFieldActionPerformed(evt);
            }
        });

        jLabel6.setText("Project Location:");

        projectLocationTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectLocationTextFieldActionPerformed(evt);
            }
        });

        jLabel7.setText("Project Folder:");

        projectFolderTextField.setEditable(false);

        browseButton.setText("Browse...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        errorLabel.setVisible(false);
        errorLabel.setText("<html><span style=\"color: red;\">Invalid Project Folder or Name</span></html>");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(projectFolderTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                                    .addComponent(projectNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                                    .addComponent(projectLocationTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addComponent(browseButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel4)))
                .addGap(12, 12, 12))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(projectNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(projectLocationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(projectFolderTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel4, "card3");

        backButton.setText("Back");
        backButton.setEnabled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(350, Short.MAX_VALUE)
                .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(mainPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
            .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    layout.next(mainPanel);
    nextButton.setEnabled(false);
    backButton.setEnabled(true);
    step++;
    if (step > 0) {
        nextButton.setText("Finish");
    }
    if (step > 1) {
        finish();
    }
}//GEN-LAST:event_nextButtonActionPerformed

private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
    JFileChooser fc = new JFileChooser();
    fc.setMultiSelectionEnabled(false);
    fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    if (fc.showOpenDialog(Core.getStaticContext().getMainFrame()) == JFileChooser.APPROVE_OPTION) {
        File f = fc.getSelectedFile();
        if (f == null || !f.exists() || !f.isDirectory()) {
            return;
        }
        projectLocationTextField.setText(f.getPath() + File.pathSeparator);
    }
}//GEN-LAST:event_browseButtonActionPerformed

private void projectLocationTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectLocationTextFieldActionPerformed
    updateProjectFolder();
}//GEN-LAST:event_projectLocationTextFieldActionPerformed

private void projectNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectNameTextFieldActionPerformed
    updateProjectFolder();
}//GEN-LAST:event_projectNameTextFieldActionPerformed

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    dispose();
}//GEN-LAST:event_cancelButtonActionPerformed

private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    layout.previous(mainPanel);
    backButton.setEnabled(step > 1);
    nextButton.setEnabled(true);
    if (step > 0) {
        nextButton.setText("Next");
    }
    step--;
}//GEN-LAST:event_backButtonActionPerformed

private void projectsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_projectsListValueChanged
    int i = projectsList.getSelectedIndex();
    if (i < 0) {
        nextButton.setEnabled(false);
        descriptionTextPane.setText(null);
        return;
    }
    nextButton.setEnabled(true);
    descriptionTextPane.setText(PineappleCore.getProjectTypes().get(i).getDescription());
}//GEN-LAST:event_projectsListValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextPane descriptionTextPane;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField projectFolderTextField;
    private javax.swing.JTextField projectLocationTextField;
    private javax.swing.JTextField projectNameTextField;
    private javax.swing.JList projectsList;
    private javax.swing.JPanel step1;
    // End of variables declaration//GEN-END:variables
}