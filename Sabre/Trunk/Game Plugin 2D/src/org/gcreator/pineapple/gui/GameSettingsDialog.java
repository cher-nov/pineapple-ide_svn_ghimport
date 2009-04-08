/*
Copyright (C) 2008 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008 Serge Humphrey<bob@bobtheblueberry.com>

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

import java.util.Arrays;
import java.util.Hashtable;
import java.util.Vector;
import javax.swing.AbstractListModel;
import org.gcreator.pineapple.validators.SceneValidator;
import org.gcreator.pineapple.project.Project;
import org.gcreator.pineapple.project.ProjectElement;
import org.gcreator.pineapple.project.ProjectFile;
import org.gcreator.pineapple.project.ProjectFolder;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * Sets the settings of the game in a visually appealing way.
 * 
 * @author Luís Reis
 */
public class GameSettingsDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 8008329836505148430L;
    private Project p = null;
    private Vector<BasicFile> sceneOrder = new Vector<BasicFile>();

    /** Creates new form GameSettingsDialog
     * @param parent The parent of this dialog
     * @param modal Whether this dialog is modal or not
     * @param p The project to edit
     */
    public GameSettingsDialog(java.awt.Frame parent, boolean modal, Project p) {
        super(parent, modal);
        initComponents();
        this.p = p;
        Hashtable<String, String> settings = p.getSettings();
        String st = settings.get("game-fullscreen");
        System.out.println("st=" + st);
        if (st != null && st.equals("true")) {
            System.out.println("enabling");
            runInFS.setSelected(true);
        }
        st = settings.get("game-resizable");
        if (st != null && st.equals("true")) {
            allowResize.setSelected(true);
        }
        st = settings.get("game-optimize");
        if (st != null && st.equals("false")) {
            optimizeGame.setSelected(false);
        }
        String s = settings.get("scene-order");
        if (s != null) {
            String[] scenes = s.split(";");
            for (String scene : scenes) {
                BasicFile f = getScene(scene, p);
                if (f != null) {
                    sceneOrder.add(f);
                }
            }
        }
        sceneList.setModel(new AbstractListModel() {

            private static final long serialVersionUID = 1L;

            public Object getElementAt(int index) {
                return sceneOrder.get(index);
            }

            public int getSize() {
                return sceneOrder.size();
            }
        });
        sceneList.setCellRenderer(new BasicFileRenderer());
        actorSelector.setResourceValidator(new SceneValidator());
    }

    private BasicFile getScene(String scene, Project p) {
        for (ProjectElement elem : p.getFiles()) {
            if (elem instanceof ProjectFile) {
                if (elem.getFile().getPath().equals(scene)) {
                    return elem.getFile();
                }
            } else if (elem instanceof ProjectFolder) {
                BasicFile f = getScene(scene, (ProjectFolder) elem);
                if (f != null) {
                    return f;
                }
            }
        }
        return null;
    }

    private BasicFile getScene(String scene, ProjectFolder p) {
        for (ProjectElement elem : p.getChildren()) {
            if (elem instanceof ProjectFile) {
                if (elem.getFile().getPath().equals(scene)) {
                    return elem.getFile();
                }
            } else if (elem instanceof ProjectFolder) {
                BasicFile f = getScene(scene, (ProjectFolder) elem);
                if (f != null) {
                    return f;
                }
            }
        }
        return null;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tabs = new javax.swing.JTabbedPane();
        generalSettings = new javax.swing.JPanel();
        runInFS = new javax.swing.JCheckBox();
        allowResize = new javax.swing.JCheckBox();
        optimizeGame = new javax.swing.JCheckBox();
        sceneOrderPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        actorSelector = new org.gcreator.pineapple.gui.ResourceChooser();
        addScene = new javax.swing.JButton();
        removeScene = new javax.swing.JButton();
        moveUp = new javax.swing.JButton();
        moveDown = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        sceneList = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Game Settings");

        jLabel1.setText("Changes to the game settings are applied automatically");
        getContentPane().add(jLabel1, java.awt.BorderLayout.PAGE_START);

        runInFS.setText("Run in fullscreen mode");
        runInFS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runInFSActionPerformed(evt);
            }
        });

        allowResize.setText("Allow the player to resize the window");
        allowResize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allowResizeActionPerformed(evt);
            }
        });

        optimizeGame.setSelected(true);
        optimizeGame.setText("Optimize game executable");
        optimizeGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optimizeGameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout generalSettingsLayout = new javax.swing.GroupLayout(generalSettings);
        generalSettings.setLayout(generalSettingsLayout);
        generalSettingsLayout.setHorizontalGroup(
            generalSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(generalSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runInFS)
                    .addComponent(allowResize)
                    .addComponent(optimizeGame))
                .addContainerGap(119, Short.MAX_VALUE))
        );
        generalSettingsLayout.setVerticalGroup(
            generalSettingsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generalSettingsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(runInFS)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(allowResize)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(optimizeGame)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        tabs.addTab("General Settings", generalSettings);

        sceneOrderPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.add(actorSelector);

        addScene.setText("Add");
        addScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSceneActionPerformed(evt);
            }
        });
        jPanel3.add(addScene);

        removeScene.setText("Remove");
        removeScene.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeSceneActionPerformed(evt);
            }
        });
        jPanel3.add(removeScene);

        moveUp.setText("Move Up");
        moveUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveUpActionPerformed(evt);
            }
        });
        jPanel3.add(moveUp);

        moveDown.setText("Move Down");
        moveDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                moveDownActionPerformed(evt);
            }
        });
        jPanel3.add(moveDown);

        sceneOrderPanel.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jScrollPane1.setViewportView(sceneList);

        sceneOrderPanel.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        tabs.addTab("Scene Order", sceneOrderPanel);

        getContentPane().add(tabs, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void runInFSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runInFSActionPerformed
    p.getSettings().put("game-fullscreen", runInFS.isSelected() ? "true" : "false");
}//GEN-LAST:event_runInFSActionPerformed

    private void allowResizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allowResizeActionPerformed
    p.getSettings().put("game-resizable", allowResize.isSelected() ? "true" : "false");
}//GEN-LAST:event_allowResizeActionPerformed

    private void optimizeGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optimizeGameActionPerformed
    p.getSettings().put("game-optimize", optimizeGame.isSelected() ? "true" : "false");
}//GEN-LAST:event_optimizeGameActionPerformed

private void addSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSceneActionPerformed
    BasicFile f = actorSelector.getSelectedFile();
    if (f != null) {
        sceneOrder.add(f);
        sceneList.updateUI();
        updateSceneOrder();
    }
}//GEN-LAST:event_addSceneActionPerformed

private void removeSceneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeSceneActionPerformed
    int indexes[] = sceneList.getSelectedIndices();
    Arrays.sort(indexes);
    int shift = 0;
    for (int index : indexes) {
        sceneOrder.remove(index - shift);
        shift++;
    }
    updateSceneOrder();
    sceneList.updateUI();
}//GEN-LAST:event_removeSceneActionPerformed

private void moveUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveUpActionPerformed
    int selObj = sceneList.getSelectedIndex();
    if (selObj < 1) {
        return;
    }
    BasicFile o = sceneOrder.get(selObj - 1);
    sceneOrder.set(selObj - 1, sceneOrder.get(selObj));
    sceneOrder.set(selObj, o);
    updateSceneOrder();
    sceneList.updateUI();
}//GEN-LAST:event_moveUpActionPerformed

private void moveDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_moveDownActionPerformed
    int selObj = sceneList.getSelectedIndex();
    if (selObj < 0 || selObj >= sceneOrder.size() - 1) {
        return;
    }
    BasicFile o = sceneOrder.get(selObj + 1);
    sceneOrder.set(selObj + 1, sceneOrder.get(selObj));
    sceneOrder.set(selObj, o);
    updateSceneOrder();
    sceneList.updateUI();
}//GEN-LAST:event_moveDownActionPerformed

    public void updateSceneOrder() {
        String sceneList = "";
        boolean isFirst = true;
        for (BasicFile f : sceneOrder) {
            if (!isFirst) {
                sceneList += ";";
            }
            sceneList += f.getPath();
            isFirst = false;
        }
        p.getSettings().put("scene-order", sceneList);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.gcreator.pineapple.gui.ResourceChooser actorSelector;
    private javax.swing.JButton addScene;
    private javax.swing.JCheckBox allowResize;
    private javax.swing.JPanel generalSettings;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton moveDown;
    private javax.swing.JButton moveUp;
    private javax.swing.JCheckBox optimizeGame;
    private javax.swing.JButton removeScene;
    private javax.swing.JCheckBox runInFS;
    private javax.swing.JList sceneList;
    private javax.swing.JPanel sceneOrderPanel;
    private javax.swing.JTabbedPane tabs;
    // End of variables declaration//GEN-END:variables
}
