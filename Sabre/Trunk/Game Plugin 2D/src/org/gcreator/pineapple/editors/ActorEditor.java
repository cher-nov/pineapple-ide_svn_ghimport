/*
Copyright (C) 2008, 2009 Luís Reis<luiscubal@gmail.com>
Copyright (C) 2008, 2009 Serge Humphrey<bob@bobtheblueberry.com>

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
package org.gcreator.pineapple.editors;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import org.gcreator.pineapple.formats.Actor;
import org.gcreator.pineapple.gui.BehaviourPanel;
import org.gcreator.pineapple.gui.DocumentPane;
import org.gcreator.pineapple.validators.ActorValidator;
import org.gcreator.pineapple.validators.ImageValidator;
import org.gcreator.pineapple.project.io.BasicFile;

/**
 * A very nice editor for actors.
 * 
 * @author Luís Reis
 * @author Serge Humphrey
 */
public final class ActorEditor extends DocumentPane {

    private static final long serialVersionUID = 1L;
    private Actor actor = null;
    private BehaviourPanel behaviour;
    private CardLayout clayout = new CardLayout();
    
    /**
     * Creates a new ActorEditor
     * 
     * @param f The actor file.
     */
    public ActorEditor(BasicFile f) {
        super(f);
        try {
            actor = new Actor(f);
        } catch (Exception e) {
            e.printStackTrace();
            actor = new Actor();
        }

        initComponents();
        behaviour = new BehaviourPanel(actor, this);
        behaviour.setVisible(true);
        behaviour.fieldsTable.getModel().addTableModelListener(new TableModelListener() {

            public void tableChanged(TableModelEvent e) {
                setModified(true);
            }
        });
        depthSpinner.setValue(actor.getZ());
        depthSpinner.addChangeListener(new ChangeListener() {

            public void stateChanged(ChangeEvent e) {
                actor.setZ((Float) depthSpinner.getValue());
                setModified(true);
            }
        });
        view.add(behaviour, "behavior");
        
        spriteChooser.setResourceValidator(new ImageValidator());
        spriteChooser.setSelectedFile(actor.getImage());
        spriteChooser.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actor.setImage(spriteChooser.getSelectedFile());
                setModified(true);
            }
        });
        
        parentChooser.setResourceValidator(new ActorValidator());
        parentChooser.setSelectedFile(actor.getParent());
        parentChooser.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                actor.setParent(parentChooser.getSelectedFile());
                setModified(true);
            }
        });
        drawSpriteCheckBox.setSelected(actor.isAutoDrawn());
    }
    
    /**
     * Saves the file
     */
    @Override
    public boolean saveBackend() {
        boolean saved = false;
        try {
            behaviour.save();
            actor.save(file);
            saved = true;
        } catch (IOException ex) {
            Logger.getLogger(ActorEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(ActorEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ActorEditor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ActorEditor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return saved;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        toggles = new javax.swing.ButtonGroup();
        toolBar = new javax.swing.JToolBar();
        propertiesToggle = new javax.swing.JToggleButton();
        membersToggle = new javax.swing.JToggleButton();
        view = new javax.swing.JPanel();
        propertiesPanel = new javax.swing.JPanel();
        inGameRenderingPanel = new javax.swing.JPanel();
        depthSpinner = new javax.swing.JSpinner();
        depthLabel = new javax.swing.JLabel();
        drawSpriteCheckBox = new javax.swing.JCheckBox();
        spriteChooser = new org.gcreator.pineapple.gui.ResourceChooser();
        spriteLabel = new javax.swing.JLabel();
        polymorhpismPanel = new javax.swing.JPanel();
        parentChooser = new org.gcreator.pineapple.gui.ResourceChooser();
        parentLabel = new javax.swing.JLabel();

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        toggles.add(propertiesToggle);
        propertiesToggle.setSelected(true);
        propertiesToggle.setText("Properties");
        propertiesToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                propertiesToggleActionPerformed(evt);
            }
        });
        toolBar.add(propertiesToggle);

        toggles.add(membersToggle);
        membersToggle.setText("Members");
        membersToggle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                membersToggleActionPerformed(evt);
            }
        });
        toolBar.add(membersToggle);

        view.setLayout(clayout = new java.awt.CardLayout());
        /*
        view.setLayout(new java.awt.CardLayout());
        */

        propertiesPanel.setMaximumSize(new java.awt.Dimension(100, 218));
        propertiesPanel.setMinimumSize(new java.awt.Dimension(100, 218));
        propertiesPanel.setPreferredSize(new java.awt.Dimension(100, 218));

        inGameRenderingPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("In-Game Rendering"));

        depthSpinner.setModel(new javax.swing.SpinnerNumberModel(Float.valueOf(0.0f), null, null, Float.valueOf(5.0f)));

        depthLabel.setText("Depth (z):");

        drawSpriteCheckBox.setSelected(true);
        drawSpriteCheckBox.setText("Draw sprite automatically");
        drawSpriteCheckBox.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        drawSpriteCheckBox.setOpaque(true);
        drawSpriteCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                drawSpriteCheckBoxActionPerformed(evt);
            }
        });

        spriteLabel.setText("Sprite:");

        javax.swing.GroupLayout inGameRenderingPanelLayout = new javax.swing.GroupLayout(inGameRenderingPanel);
        inGameRenderingPanel.setLayout(inGameRenderingPanelLayout);
        inGameRenderingPanelLayout.setHorizontalGroup(
            inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                .addGroup(inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                        .addComponent(spriteLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spriteChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                        .addComponent(depthLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(depthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(drawSpriteCheckBox))
                .addGap(18, 18, 18))
        );
        inGameRenderingPanelLayout.setVerticalGroup(
            inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                .addGroup(inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(inGameRenderingPanelLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(spriteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 21, Short.MAX_VALUE))
                    .addComponent(spriteChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(inGameRenderingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(depthLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(drawSpriteCheckBox)
                .addContainerGap())
        );

        polymorhpismPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Polymorphism"));

        parentLabel.setText("Parent:");

        javax.swing.GroupLayout polymorhpismPanelLayout = new javax.swing.GroupLayout(polymorhpismPanel);
        polymorhpismPanel.setLayout(polymorhpismPanelLayout);
        polymorhpismPanelLayout.setHorizontalGroup(
            polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(polymorhpismPanelLayout.createSequentialGroup()
                .addComponent(parentLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(parentChooser, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                .addContainerGap())
        );
        polymorhpismPanelLayout.setVerticalGroup(
            polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(polymorhpismPanelLayout.createSequentialGroup()
                .addGroup(polymorhpismPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(parentChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(parentLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout propertiesPanelLayout = new javax.swing.GroupLayout(propertiesPanel);
        propertiesPanel.setLayout(propertiesPanelLayout);
        propertiesPanelLayout.setHorizontalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, propertiesPanelLayout.createSequentialGroup()
                .addGroup(propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(polymorhpismPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(inGameRenderingPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        propertiesPanelLayout.setVerticalGroup(
            propertiesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(propertiesPanelLayout.createSequentialGroup()
                .addComponent(inGameRenderingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(polymorhpismPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        view.add(propertiesPanel, "card2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
            .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void propertiesToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_propertiesToggleActionPerformed
    clayout.first(view);
}//GEN-LAST:event_propertiesToggleActionPerformed

private void membersToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_membersToggleActionPerformed
    clayout.last(view);
}//GEN-LAST:event_membersToggleActionPerformed

private void drawSpriteCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_drawSpriteCheckBoxActionPerformed
    actor.setAutoDraw(drawSpriteCheckBox.isSelected());
    setModified(true);
}//GEN-LAST:event_drawSpriteCheckBoxActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel depthLabel;
    private javax.swing.JSpinner depthSpinner;
    private javax.swing.JCheckBox drawSpriteCheckBox;
    private javax.swing.JPanel inGameRenderingPanel;
    private javax.swing.JToggleButton membersToggle;
    private org.gcreator.pineapple.gui.ResourceChooser parentChooser;
    private javax.swing.JLabel parentLabel;
    private javax.swing.JPanel polymorhpismPanel;
    private javax.swing.JPanel propertiesPanel;
    private javax.swing.JToggleButton propertiesToggle;
    private org.gcreator.pineapple.gui.ResourceChooser spriteChooser;
    private javax.swing.JLabel spriteLabel;
    private javax.swing.ButtonGroup toggles;
    private javax.swing.JToolBar toolBar;
    private javax.swing.JPanel view;
    // End of variables declaration//GEN-END:variables

}
