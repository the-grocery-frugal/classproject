/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thegrocery.thegroceryfrugal.GUI;

import com.thegrocery.thegroceryfrugal.Models.Ingredients;
import com.thegrocery.thegroceryfrugal.Models.Measurement;
import com.thegrocery.thegroceryfrugal.Utility.IngredientUtility;
import com.thegrocery.thegroceryfrugal.Utility.MeasurementUtility;
import com.thegrocery.thegroceryfrugal.Utility.RecipeIngredientUtility;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Mila
 */
public class FindIngredient extends javax.swing.JFrame {

    public FindIngredient() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        searchTtle = new javax.swing.JLabel();
        searchFld = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        quantityLbl = new javax.swing.JLabel();
        quantityField = new javax.swing.JTextField();
        typeLbl = new javax.swing.JLabel();
        typeDropDown = new javax.swing.JComboBox<>();
        notesLbl = new javax.swing.JLabel();
        notesField = new javax.swing.JTextField();
        addToRecipeBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();


        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingredients");

        searchTtle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchTtle.setText("Search:");

        searchFld.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFldActionPerformed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(186, 207, 242));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        searchBtn.setText("Search");
        searchBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setText("Choose ingredient from results:");

        quantityLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        quantityLbl.setText("Quantity:");

        quantityField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        quantityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityFieldActionPerformed(evt);
            }
        });

        typeLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        typeLbl.setText("Quantity Type:");
        
        // CUSTOM CODE BY SHIMER FOR HANDLING QUANTITY TYPES
        List<Measurement> measurements = MeasurementUtility.listAllMeasurements();
        String[] types = new String[measurements.size()];
        for (int i = 0; i < measurements.size(); i++) {
            types[i] = measurements.get(i).getName();
            
        }
        // END CUSTOM CODE
        
        typeDropDown.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        typeDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(types));
        typeDropDown.setToolTipText("");
        typeDropDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeDropDownActionPerformed(evt);
            }
        });

        notesLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        notesLbl.setText("Notes:");

        notesField.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        notesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                notesFieldActionPerformed(evt);
            }
        });

        addToRecipeBtn.setBackground(new java.awt.Color(186, 207, 242));
        addToRecipeBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        addToRecipeBtn.setText("Add to Recipe");
        addToRecipeBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        addToRecipeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addToRecipeBtnActionPerformed(evt);
            }
        });

        

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(searchTtle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchBtn))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(quantityLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(typeLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(typeDropDown, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(notesLbl)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(notesField, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(36, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(addToRecipeBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTtle)
                    .addComponent(searchFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLbl)
                    .addComponent(quantityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeDropDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typeLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(notesLbl)
                    .addComponent(notesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addToRecipeBtn)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        //allows user to search for ingredient
        if (searchFld.getText().isEmpty()){
            // error checking for empty searches
        } else {
            final javax.swing.JPanel panel = new javax.swing.JPanel();
            javax.swing.ButtonGroup radioGroup = new javax.swing.ButtonGroup();
            List<Ingredients> ingredients = IngredientUtility.findIngredientsByName(searchFld.getText());
            for (Iterator iter = ingredients.iterator(); iter.hasNext();) {
                Ingredients ingredient = (Ingredients)iter.next();
                javax.swing.JRadioButton radio_button = new javax.swing.JRadioButton(ingredient.getName());
                radio_button.setActionCommand(ingredient.getName());
                radioGroup.add(radio_button);
                panel.add(radio_button);
            }
            JOptionPane.showMessageDialog(null, panel);
            selected_ingredient = radioGroup.getSelection().getActionCommand();
            if (selected_ingredient.isEmpty()){
                // ERROR CHECKING FOR EMPTY INGREDIENT
            } else {
                
            }
        }
        
    }//GEN-LAST:event_searchBtnActionPerformed

    private void searchFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFldActionPerformed
        //where the user types the input they are searching for
    }//GEN-LAST:event_searchFldActionPerformed

    private void addToRecipeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addToRecipeBtnActionPerformed
        //adds results to recipe
    }//GEN-LAST:event_addToRecipeBtnActionPerformed

    private void typeDropDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeDropDownActionPerformed
        //dropdown for selection of quantity type
    }//GEN-LAST:event_typeDropDownActionPerformed

    private void quantityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityFieldActionPerformed
        //where the user types the quantity input
    }//GEN-LAST:event_quantityFieldActionPerformed

    private void notesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_notesFieldActionPerformed
        //where the user types notes
    }//GEN-LAST:event_notesFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FindIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FindIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FindIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FindIngredient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FindIngredient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addToRecipeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField notesField;
    private javax.swing.JLabel notesLbl;
    private javax.swing.JTextField quantityField;
    private javax.swing.JLabel quantityLbl;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchFld;
    private javax.swing.JLabel searchTtle;
    private javax.swing.JComboBox<String> typeDropDown;
    private javax.swing.JLabel typeLbl;
    private String selected_ingredient;
    // End of variables declaration//GEN-END:variables
}
 
