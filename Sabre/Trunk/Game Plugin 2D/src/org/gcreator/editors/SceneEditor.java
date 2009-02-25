/*
Copyright (C) 2008-2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008-2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.editors;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.gcreator.formats.Scene;
import org.gcreator.gui.BehaviourPanel;
import org.gcreator.gui.DocumentPane;
import org.gcreator.gui.SceneEditorArea;
import org.gcreator.gui.SceneProperties;
import org.gcreator.validators.ActorValidator;
import org.gcreator.project.io.BasicFile;

/**
 * The editor of game scenes.
 * 
 * @author Luís Reis
 */
public class SceneEditor extends DocumentPane {

    private static final long serialVersionUID = 1L;
    public Scene s = null;
    private BehaviourPanel panel = null;
    public SceneProperties sp = null;
    public SceneEditorArea sea = null;

    /** 
     * Creates new form SceneEditor
     * 
     * @param f The file to edit
     */
    public SceneEditor(BasicFile f) {
        super(f);
        initComponents();
        s = new Scene(f);
        panel = new BehaviourPanel(s, this);
        panel.setVisible(true);
        tabs.add(panel, "Behavior");
        actorChooser.setResourceValidator(new ActorValidator());
        actorChooser.setVisible(true);
        sp = new SceneProperties(this);
        settingsPanel.add(sp, BorderLayout.CENTER);
        sea = new SceneEditorArea();
        sea.setVisible(true);
        sea.sceneEditor = this;
        sea.updateUI();
        seaScrollPane.setViewportView(sea);
        seaScrollPane.getVerticalScrollBar().setUnitIncrement(16);
	seaScrollPane.getVerticalScrollBar().setBlockIncrement(64);
	seaScrollPane.getHorizontalScrollBar().setUnitIncrement(16);
	seaScrollPane.getHorizontalScrollBar().setBlockIncrement(64);
    }

    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean save() {
        boolean success = false;
        try {
            s.save(file);
            success = true;
        } catch (IOException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(SceneEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return success;
    }
    
    /**
     * Saves the file
     */
    @Override
    public boolean saveBackend() {
        return save();
    }
  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toolButtonGroup = new javax.swing.ButtonGroup();
        tabs = new javax.swing.JTabbedPane();
        Splitter = new javax.swing.JSplitPane();
        settingsPanel = new javax.swing.JPanel();
        environmentTab = new javax.swing.JPanel();
        seaScrollPane = new javax.swing.JScrollPane();
        topToolBar = new javax.swing.JToolBar();
        actorChooser = new org.gcreator.gui.ResourceChooser();
        addActorButton = new javax.swing.JToggleButton();
        editActorButton = new javax.swing.JToggleButton();
        deleteActorButton = new javax.swing.JToggleButton();

        setLayout(new java.awt.BorderLayout());

        settingsPanel.setLayout(new java.awt.BorderLayout());
        Splitter.setLeftComponent(settingsPanel);

        topToolBar.setFloatable(false);
        topToolBar.setRollover(true);
        topToolBar.add(actorChooser);

        toolButtonGroup.add(addActorButton);
        addActorButton.setSelected(true);
        addActorButton.setText("Add");
        addActorButton.setFocusable(false);
        addActorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addActorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addActorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActorButtonActionPerformed(evt);
            }
        });
        topToolBar.add(addActorButton);

        toolButtonGroup.add(editActorButton);
        editActorButton.setText("Edit");
        editActorButton.setFocusable(false);
        editActorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editActorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editActorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActorButtonActionPerformed(evt);
            }
        });
        topToolBar.add(editActorButton);

        toolButtonGroup.add(deleteActorButton);
        deleteActorButton.setText("Delete");
        deleteActorButton.setFocusable(false);
        deleteActorButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteActorButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteActorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActorButtonActionPerformed(evt);
            }
        });
        topToolBar.add(deleteActorButton);

        javax.swing.GroupLayout environmentTabLayout = new javax.swing.GroupLayout(environmentTab);
        environmentTab.setLayout(environmentTabLayout);
        environmentTabLayout.setHorizontalGroup(
            environmentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(topToolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
            .addComponent(seaScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
        );
        environmentTabLayout.setVerticalGroup(
            environmentTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(environmentTabLayout.createSequentialGroup()
                .addComponent(topToolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seaScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                .addContainerGap())
        );

        Splitter.setRightComponent(environmentTab);

        tabs.addTab("Environment", Splitter);

        add(tabs, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

private void addActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_ADD;
    sea.repaint();
}//GEN-LAST:event_addActorButtonActionPerformed

private void editActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_EDIT;
    sea.repaint();
}//GEN-LAST:event_editActorButtonActionPerformed

private void deleteActorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActorButtonActionPerformed
    sea.mode = SceneEditorArea.MODE_DELETE;
    sea.repaint();
}//GEN-LAST:event_deleteActorButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSplitPane Splitter;
    public org.gcreator.gui.ResourceChooser actorChooser;
    private javax.swing.JToggleButton addActorButton;
    private javax.swing.JToggleButton deleteActorButton;
    private javax.swing.JToggleButton editActorButton;
    private javax.swing.JPanel environmentTab;
    public javax.swing.JScrollPane seaScrollPane;
    public javax.swing.JPanel settingsPanel;
    private javax.swing.JTabbedPane tabs;
    private javax.swing.ButtonGroup toolButtonGroup;
    private javax.swing.JToolBar topToolBar;
    // End of variables declaration//GEN-END:variables
}
