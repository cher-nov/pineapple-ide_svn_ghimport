/*
 * NewProjectWizard.java
 *
 * Created on November 16, 2008, 6:54 PM
 */
package org.gcreator.gui;

import java.awt.CardLayout;
import java.io.File;
import javax.swing.AbstractListModel;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.gcreator.core.Core;
import org.gcreator.pineapple.PineapplePlugin;

/**
 * Wizard that creates a new project.
 * 
 * @author Serge Humphrey
 */
public final class NewProjectWizard extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private CardLayout layout;

    /** Creates new form NewProjectWizard
     * @param parent The parent frame for the dialog.
     */
    public NewProjectWizard(java.awt.Frame parent) {
        super(parent);
        initComponents();
        
        DocumentListener dl1 = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {update();}
            public void removeUpdate(DocumentEvent e) {update();}
            public void changedUpdate(DocumentEvent e) {update();}
            
            private void update() {
                updateProjectFolder();
                String text = projectNameTextField.getText();
                if (text != null && !text.equals("") && !text.contains(File.separator)) {
                    finishButton.setEnabled(true);
                } else {
                    finishButton.setEnabled(false);
                }
                if (text.contains(File.separator)) {
                    setErrorMessage("Error: Project name can't contain " + File.separator);
                } else {
                    errorLabel.setVisible(false);
                }
            }
        };
        
        DocumentListener dl2 = new DocumentListener() {
            public void insertUpdate(DocumentEvent e) {updateProjectFolder();}
            public void removeUpdate(DocumentEvent e) {updateProjectFolder();}
            public void changedUpdate(DocumentEvent e) {updateProjectFolder();}
        };
        
        projectNameTextField.getDocument().addDocumentListener(dl1);
        projectLocationTextField.getDocument().addDocumentListener(dl2);
        
        projectsList.setModel(new AbstractListModel() {

            private static final long serialVersionUID = 1;
            
            public int getSize() {
                return PineapplePlugin.projectTypes.size();
            }

            public Object getElementAt(int index) {
                return PineapplePlugin.projectTypes.get(index).getName();
            }
        });
        
        projectLocationTextField.setText(System.getProperty("user.home") + File.separator + "PineappleProjects" + File.separator);
    }
    
    private void updateProjectFolder() {
        projectFolderTextField.setText(projectLocationTextField.getText() +
                ((projectLocationTextField.getText().endsWith(File.separator)) ? "" : File.separator)
                + projectNameTextField.getText());
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
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
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
        finishButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

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
        jPanel1.setLayout(new java.awt.CardLayout());
        */
        jPanel1.setLayout(layout = new java.awt.CardLayout());

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, "card2");

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
                                    .addComponent(projectFolderTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(projectNameTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                    .addComponent(projectLocationTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE))
                                .addGap(4, 4, 4)
                                .addComponent(browseButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel4)))
                .addGap(12, 12, 12))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
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
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, "card3");

        backButton.setText("< Back");
        backButton.setEnabled(false);
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        nextButton.setText("Next >");
        nextButton.setEnabled(false);
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        finishButton.setText("Finish");
        finishButton.setEnabled(false);
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
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
                .addContainerGap(138, Short.MAX_VALUE)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(nextButton)
                    .addComponent(backButton)
                    .addComponent(finishButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    layout.next(jPanel1);
    nextButton.setEnabled(false);
    backButton.setEnabled(true);
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
    layout.previous(jPanel1);
    backButton.setEnabled(false);
    finishButton.setEnabled(false);
    nextButton.setEnabled(true);
}//GEN-LAST:event_backButtonActionPerformed

private void projectsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_projectsListValueChanged
    int i = evt.getFirstIndex();
    if (i < 0) {
        nextButton.setEnabled(false);
        return;
    }
    nextButton.setEnabled(true);
    descriptionTextPane.setText(PineapplePlugin.projectTypes.get(i).getDescription());
}//GEN-LAST:event_projectsListValueChanged

private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
    File f = null;
    try {
        f = new File(projectFolderTextField.getText());
        if (!f.mkdirs() && !f.exists()) {
            throw new Exception();
        }
    } catch (Exception exc) {
        setErrorMessage("Can't create directory " + f);
        return;
    }
    PineappleGUI.project = PineapplePlugin.projectTypes.get(projectsList.getSelectedIndex()).create();
    PineappleGUI.project.setProjectFolder(f);
    PineappleGUI.tree.updateUI();
    dispose();
}//GEN-LAST:event_finishButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextPane descriptionTextPane;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton nextButton;
    private javax.swing.JTextField projectFolderTextField;
    private javax.swing.JTextField projectLocationTextField;
    private javax.swing.JTextField projectNameTextField;
    private javax.swing.JList projectsList;
    // End of variables declaration//GEN-END:variables
}
