/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * MiscOptionsPanel.java
 *
 * Created on Oct 5, 2011, 3:19:21 PM
 */
package views;

import controller.Controller;
import java.io.File;

import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import model.Model;

/**
 *
 * @author gq114c
 */
public class ExcludedPathsPanel extends javax.swing.JPanel implements IUpdateView {

    Controller controller;
    private DefaultListModel listModel;

    /** Creates new form MiscOptionsPanel */
    public ExcludedPathsPanel() {
	this(null);

    }

    public ExcludedPathsPanel(Controller c) {
	this.controller = c;
	listModel = new DefaultListModel();
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

        pathsToExcludeChooser = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        excludedPathsList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        addExcludedPathBtn = new javax.swing.JButton();
        removeExcludedPathBtn = new javax.swing.JButton();

        pathsToExcludeChooser.setDialogTitle("Directory To Be Excluded In Search");
        pathsToExcludeChooser.setFileSelectionMode(javax.swing.JFileChooser.DIRECTORIES_ONLY);

        excludedPathsList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(excludedPathsList);

        jLabel1.setText("Paths To Exclude: ");

        addExcludedPathBtn.setText("Add Path To Exclude");
        addExcludedPathBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addExcludedPathBtnActionPerformed(evt);
            }
        });

        removeExcludedPathBtn.setText("Remove Excluded Path");
        removeExcludedPathBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeExcludedPathBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                            .addComponent(jLabel1))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(removeExcludedPathBtn)
                        .addContainerGap(105, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addExcludedPathBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 143, Short.MAX_VALUE)
                        .addGap(105, 105, 105))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(removeExcludedPathBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addExcludedPathBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addExcludedPathBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addExcludedPathBtnActionPerformed
	if (pathsToExcludeChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
	    controller.getModel().getFilesToExclude().add(pathsToExcludeChooser.getSelectedFile());
	    updateView();
	}
    }//GEN-LAST:event_addExcludedPathBtnActionPerformed

    private void removeExcludedPathBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeExcludedPathBtnActionPerformed
	controller.getModel().getFilesToExclude().remove(excludedPathsList.getSelectedValue());
	updateView();
    }//GEN-LAST:event_removeExcludedPathBtnActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addExcludedPathBtn;
    private javax.swing.JList excludedPathsList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFileChooser pathsToExcludeChooser;
    private javax.swing.JButton removeExcludedPathBtn;
    // End of variables declaration//GEN-END:variables

    @Override
    public void updateView() {
	listModel.removeAllElements();
	for (File p : controller.getModel().getFilesToExclude()) {
	    listModel.addElement(p);
	}
	excludedPathsList.setModel(listModel);
    }
}
