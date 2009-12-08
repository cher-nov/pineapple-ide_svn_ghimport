/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<serge@bobtheblueberry.com>

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
package org.gcreator.pineapple.gui;

import java.awt.CardLayout;
import javax.swing.AbstractListModel;
import javax.swing.SwingUtilities;
import org.gcreator.pineapple.core.PineappleCore;
import org.gcreator.pineapple.gui.base.GUIBase;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFolder;

/**
 * Wizard to create a new file.
 * 
 * @author Serge Humphrey
 */
public final class NewFileWizard extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private static final String FOLDER = "Folder";
    private CardLayout cardLayout;
    private ProjectFolder folder;
    private Project project;
    private String type;

    /**
     * Creates a {@link NewFileWizard}.
     * Note that this does not show the dialog.
     * 
     * @param parent The parent for the dialog.
     * @param p The project to create the file to.
     * @param f The default folder to be selected. May be <tt>null</tt>.
     * @param allowChoose Whether to allow the user to chose another
     * folder in the project to add the file in.
     */
    public NewFileWizard(java.awt.Frame parent, Project p, ProjectFolder f, boolean allowChoose) {
        super(parent);
        this.project = p;
        this.folder = f;
        initComponents();
        locationTextField.setText((folder == null) ? "/" : folder.getFile().getPath());
        browseButton.setEnabled(allowChoose);

        typesList.setModel(new AbstractListModel() {

            private static final long serialVersionUID = 1;

            @Override
            public int getSize() {
                return GUIBase.fileTypeNames.size() + 1;
            }

            @Override
            public Object getElementAt(int index) {
                if (index == 0) {
                    return FOLDER;
                }
                int i = 0;
                for (String k : GUIBase.fileTypeNames.values()) {
                    if (index - 1 == i) {
                        return k;
                    }
                    i++;
                }
                return null;
            }
        });

        setLocationRelativeTo(parent);

    }

    /**
     * Creates and shows a {@link NewFileWizard} with the default
     * selected folder as the project root, and allows you to chage
     * the folder.
     * 
     * @param parent The parent for the dialog.
     * @param p The project to add the file to.
     */
    public NewFileWizard(java.awt.Frame parent, Project p) {
        this(parent, p, null, true);
    }

    private void setError(String msg) {
        errorLabel.setText("<html><span style=\"color: red; font-weight: bold;\">" + msg +
                "</span></html>");
    }

    private void checkFinish() {
        String text = fileNameTextField.getText();
        if (text.contains(".")) {
            if (text.equals(".")) {
                text = "";
            } else {
                text = text.substring(0, text.indexOf('.') - 1);
            }

            final String fText = text;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    fileNameTextField.setText(fText);
                }
            });

        }
        if (text.equals("") || text.contains("\\") || text.contains("/")) {
            finishButton.setEnabled(false);
            setError("Invalid File Name");
            return;
        }
        String fname;
        if (type != null) {
            fname = text + "." + type;
        } else {
            fname = text;
        }
        if (folder == null) {
            for (ProjectElement e : project.getFiles().getChildren()) {
                if (e.getName().equals(fname)) {
                    finishButton.setEnabled(false);
                    setError("File already exists.");
                    return;
                }
            }
        } else {
            for (ProjectElement e : folder.getChildren()) {
                if (e.getName().equals(fname)) {
                    finishButton.setEnabled(false);
                    setError("File already exists.");
                    return;
                }
            }
        }
        setError("");
        finishButton.setEnabled(true);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        finishButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        nextButton = new javax.swing.JButton();
        stepsPanel = new javax.swing.JPanel();
        step1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        typesList = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        fileDescriptionPane = new javax.swing.JEditorPane();
        fileTypeHeading = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        fileTypeHeading1 = new javax.swing.JLabel();
        fileNameLabel = new javax.swing.JLabel();
        fileNameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        locationTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        errorLabel = new javax.swing.JLabel();
        extensionLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add New File");

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        finishButton.setText("Finish");
        finishButton.setEnabled(false);
        finishButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishButtonActionPerformed(evt);
            }
        });

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

        /*
        stepsPanel.setLayout(new java.awt.CardLayout());
        */
        stepsPanel.setLayout(cardLayout = new java.awt.CardLayout());

        typesList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        typesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                typesListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(typesList);

        fileDescriptionPane.setContentType("text/html");
        fileDescriptionPane.setEditable(false);
        jScrollPane2.setViewportView(fileDescriptionPane);

        fileTypeHeading.setFont(fileTypeHeading.getFont().deriveFont(fileTypeHeading.getFont().getStyle() | java.awt.Font.BOLD));
        fileTypeHeading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileTypeHeading.setText("Choose File Type");

        jLabel2.setText("File Type:");

        jLabel3.setText("Description:");

        javax.swing.GroupLayout step1Layout = new javax.swing.GroupLayout(step1);
        step1.setLayout(step1Layout);
        step1Layout.setHorizontalGroup(
            step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fileTypeHeading, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(step1Layout.createSequentialGroup()
                        .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        step1Layout.setVerticalGroup(
            step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(step1Layout.createSequentialGroup()
                .addComponent(fileTypeHeading)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(step1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap())
        );

        stepsPanel.add(step1, "step1");

        fileTypeHeading1.setFont(fileTypeHeading1.getFont().deriveFont(fileTypeHeading1.getFont().getStyle() | java.awt.Font.BOLD));
        fileTypeHeading1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fileTypeHeading1.setText("File Name and Location");

        fileNameLabel.setText("Name:");

        fileNameTextField.setText("newFile");
        fileNameTextField.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                fileNameTextFieldCaretUpdate(evt);
            }
        });
        fileNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNameTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Location:");

        locationTextField.setEditable(false);
        locationTextField.setText("/");

        browseButton.setText("Browse...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        errorLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        extensionLabel.setText(".pdl");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addComponent(fileTypeHeading1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fileNameLabel)
                            .addComponent(jLabel1))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(browseButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(extensionLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(fileTypeHeading1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fileNameLabel)
                    .addComponent(fileNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(extensionLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(locationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
        );

        stepsPanel.add(jPanel1, "step2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(146, Short.MAX_VALUE)
                .addComponent(backButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nextButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finishButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cancelButton)
                .addContainerGap())
            .addComponent(stepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(stepsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(backButton)
                    .addComponent(nextButton)
                    .addComponent(finishButton)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
    dispose();
}//GEN-LAST:event_cancelButtonActionPerformed

private void typesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_typesListValueChanged
    Object o = typesList.getSelectedValue();
    if (o == null) {
        nextButton.setEnabled(false);
        return;
    }
    nextButton.setEnabled(true);
    if (o.equals(FOLDER)) {
        type = null;
        extensionLabel.setText(null);
        fileDescriptionPane.setText("A new folder.");
        return;
    }
    for (String k : GUIBase.fileTypeNames.keySet()) {
        if (GUIBase.fileTypeNames.get(k).equals(o)) {
            this.type = k;
            extensionLabel.setText("." + type);
            fileDescriptionPane.setText(GUIBase.fileTypeDescriptions.get(k));
            break;
        }
    }
}//GEN-LAST:event_typesListValueChanged

private void finishButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishButtonActionPerformed
    if (type != null) {
        project.getManager().createFile(folder, fileNameTextField.getText(), type);
    } else {
        project.getManager().createFolder(folder, fileNameTextField.getText());
    }
    PineappleGUI.tree.updateUI();
    dispose();
}//GEN-LAST:event_finishButtonActionPerformed

private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    nextButton.setEnabled(typesList.getSelectedIndex() > 0);
    finishButton.setEnabled(false);
    backButton.setEnabled(false);
    cardLayout.previous(stepsPanel);
}//GEN-LAST:event_backButtonActionPerformed

private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
    backButton.setEnabled(true);
    nextButton.setEnabled(false);
    finishButton.setEnabled(true);
    if (type != null) {
        fileNameTextField.setText("new" + type.toUpperCase() + "File");
    } else {
        fileNameTextField.setText("newFolder");
    }
    cardLayout.next(stepsPanel);
}//GEN-LAST:event_nextButtonActionPerformed

private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
    folder = SelectFolderTree.showFolderDialog(project, this, "Select Folder");
    locationTextField.setText((folder == null) ? "/" : folder.getFile().getPath());
}//GEN-LAST:event_browseButtonActionPerformed

private void fileNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNameTextFieldActionPerformed
    checkFinish();
}//GEN-LAST:event_fileNameTextFieldActionPerformed

private void fileNameTextFieldCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_fileNameTextFieldCaretUpdate
    checkFinish();
}//GEN-LAST:event_fileNameTextFieldCaretUpdate
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backButton;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel errorLabel;
    private javax.swing.JLabel extensionLabel;
    private javax.swing.JEditorPane fileDescriptionPane;
    private javax.swing.JLabel fileNameLabel;
    private javax.swing.JTextField fileNameTextField;
    private javax.swing.JLabel fileTypeHeading;
    private javax.swing.JLabel fileTypeHeading1;
    private javax.swing.JButton finishButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField locationTextField;
    private javax.swing.JButton nextButton;
    private javax.swing.JPanel step1;
    private javax.swing.JPanel stepsPanel;
    private javax.swing.JList typesList;
    // End of variables declaration//GEN-END:variables
}
