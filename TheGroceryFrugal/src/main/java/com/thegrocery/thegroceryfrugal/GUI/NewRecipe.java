package com.thegrocery.thegroceryfrugal.GUI;

import com.thegrocery.thegroceryfrugal.Models.Recipe;
import com.thegrocery.thegroceryfrugal.Utility.RecipeUtility;
import javax.swing.JOptionPane;

public class NewRecipe extends javax.swing.JFrame {

    public NewRecipe() {
        initComponents();
    }

    public NewRecipe(Recipe re) {
    	initComponents();
    	recipeTitle.setText(re.getName());
    	descriptionPne.setText(re.getDescription());
    	stepsPne.setText(re.getSteps());
    	this.recipe = re;
    	
	}

	/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        recipeLabel = new javax.swing.JLabel();
        recipeTitle = new javax.swing.JTextField();
        descriptionLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionPne = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        doneBtn = new javax.swing.JButton();
        stepsLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        stepsPne = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("New Recipe");

        recipeLabel.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        recipeLabel.setText("Recipe Title:");

        recipeTitle.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        recipeTitle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                recipeTitleActionPerformed(evt);
            }
        });

        descriptionLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        descriptionLbl.setText("Description");

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        descriptionPne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane1.setViewportView(descriptionPne);

        doneBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        doneBtn.setText("Done");
        doneBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        stepsLbl.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        stepsLbl.setText("Steps");

        stepsPne.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jScrollPane2.setViewportView(stepsPne);
        stepsPne.getAccessibleContext().setAccessibleParent(jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(descriptionLbl)
                        .addGap(153, 153, 153))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(stepsLbl)
                        .addGap(165, 165, 165))))
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(recipeLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(recipeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(jLabel6))
                            .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(recipeLabel)
                    .addComponent(recipeTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(descriptionLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stepsLbl)
                .addGap(2, 2, 2)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(doneBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>                        

    private void recipeTitleActionPerformed(java.awt.event.ActionEvent evt) {                                            
        //allows user to add recipe title
    }                                           

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // allows user to finish with steps and description, moves forward to ingredient search and add
            	
    	NewIngredient ni = new NewIngredient();

        // Create the new recipe
        // Need to add checks to see if an ingredient by that name exists
        if (RecipeUtility.findRecipeByName(recipeTitle.getText()).isEmpty()) {
            RecipeUtility.addRecipe(recipeTitle.getText(), descriptionPne.getText(), stepsPne.getText());
            if (descriptionPne.getText() != null){
                RecipeUtility.addDescription(recipeTitle.getText(), descriptionPne.getText());
            }

            if (stepsPne.getText() != null){
                RecipeUtility.addSteps(recipeTitle.getText(), stepsPne.getText());
            }
            ni.setVisible(true); 
            ni.setLocationRelativeTo(null);
            
            ni.setAlwaysOnTop(true);
            
        } else {
            // Add error message about creating a recipe that already exists
            JOptionPane.showMessageDialog(null, "ERROR - Recipe Already Exists", "Error", JOptionPane.ERROR_MESSAGE);
        }
       
       
       
    }                                       

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
            java.util.logging.Logger.getLogger(NewRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewRecipe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewRecipe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JLabel descriptionLbl;
    private javax.swing.JTextPane descriptionPne;
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel recipeLabel;
    private javax.swing.JTextField recipeTitle;
    private javax.swing.JLabel stepsLbl;
    private javax.swing.JTextPane stepsPne;
    // End of variables declaration        
    
    private Recipe recipe;
}
