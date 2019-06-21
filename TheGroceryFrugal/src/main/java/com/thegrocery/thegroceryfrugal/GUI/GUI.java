package com.thegrocery.thegroceryfrugal.GUI;

import com.thegrocery.thegroceryfrugal.Main;
import com.thegrocery.thegroceryfrugal.Models.Ingredients;
import com.thegrocery.thegroceryfrugal.Models.Measurement;
import com.thegrocery.thegroceryfrugal.Models.Recipe;
import com.thegrocery.thegroceryfrugal.Utility.IngredientUtility;
import com.thegrocery.thegroceryfrugal.Utility.MeasurementUtility;
import com.thegrocery.thegroceryfrugal.Utility.RecipeUtility;

import java.util.Iterator;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.transaction.Transactional.TxType;

public class GUI extends javax.swing.JFrame {

	public GUI() {
		initComponents();

	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jScrollPane3 = new javax.swing.JScrollPane();
		displayPane = new javax.swing.JTextArea();
		modifyBtn = new javax.swing.JButton();
		newBtn = new javax.swing.JButton();
		deleteBtn = new javax.swing.JButton();
		logoutBtn = new javax.swing.JButton();
		jLabel2 = new javax.swing.JLabel();
		openBtn = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		dropdownList = new javax.swing.JComboBox<>();
		jScrollPane1 = new javax.swing.JScrollPane();
		searchTextArea = new javax.swing.JTextArea();
		searchBtn = new javax.swing.JButton();
		RecipeRadBtn = new javax.swing.JRadioButton();
		GroceryListRadBtn = new javax.swing.JRadioButton();
		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0),
				new java.awt.Dimension(0, 32767));
		jScrollPane2 = new javax.swing.JScrollPane();
		treeDisplay = new javax.swing.JTree();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Overview");

		displayPane.setColumns(20);
		displayPane.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		displayPane.setRows(5);
		jScrollPane3.setViewportView(displayPane);

		modifyBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		modifyBtn.setText("Modify Existing");
		modifyBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		modifyBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				modifyBtnActionPerformed(evt);
			}
		});

		newBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		newBtn.setText("New");
		newBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		newBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				newBtnActionPerformed(evt);
			}
		});

		deleteBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		deleteBtn.setText("Delete");
		deleteBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		deleteBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				deleteBtnActionPerformed(evt);
			}
		});

		logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		logoutBtn.setText("Log Out");
		logoutBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		logoutBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoutBtnActionPerformed(evt);
			}
		});

		jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		jLabel2.setText("Selection Display:");

		openBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		openBtn.setText("Open Existing");
		openBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		openBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				openBtnActionPerformed(evt);
			}
		});

		jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		jLabel1.setText("Search Existing Files:");

		dropdownList.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		dropdownList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Name", "Ingredient" }));
		dropdownList.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				dropdownListActionPerformed(evt);
			}
		});

		jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

		searchTextArea.setColumns(20);
		searchTextArea.setRows(5);
		jScrollPane1.setViewportView(searchTextArea);

		searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
		searchBtn.setText("Search!");
		searchBtn.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
		searchBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				searchBtnActionPerformed(evt);
			}
		});

		RecipeRadBtn.setText("Recipe");
		RecipeRadBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				RecipeRadBtnActionPerformed(evt);
			}
		});

		GroceryListRadBtn.setText("Grocery List");
		GroceryListRadBtn.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				GroceryListRadBtnActionPerformed(evt);
			}
		});

		treeDisplay.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
			public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
				treeDisplayValueChanged(evt);
			}
		});
		jScrollPane2.setViewportView(treeDisplay);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
								.addComponent(filler1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(32, 32, 32)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createSequentialGroup()
												.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 155,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
												.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 490,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(layout.createSequentialGroup().addComponent(jLabel1).addGap(8, 8, 8)
												.addComponent(dropdownList, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addGap(18, 18, 18)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(searchBtn)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
						.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
								layout.createSequentialGroup().addComponent(jLabel2).addGap(208, 208, 208)))
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(GroceryListRadBtn)
						.addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 136,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(RecipeRadBtn))
				.addGap(40, 40, 40)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(191, 191, 191).addComponent(filler1,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addGap(24, 24, 24)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel1).addComponent(dropdownList,
														javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(searchBtn).addComponent(GroceryListRadBtn)))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(
												layout.createSequentialGroup().addGap(12, 12, 12).addComponent(jLabel2))
										.addGroup(layout.createSequentialGroup()
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(RecipeRadBtn)))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addComponent(jScrollPane2).addComponent(jScrollPane3)
										.addGroup(layout.createSequentialGroup()
												.addComponent(newBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(openBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 58,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(modifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(deleteBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54,
														javax.swing.GroupLayout.PREFERRED_SIZE)))))
				.addContainerGap(20, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_newBtnActionPerformed
		// creates a new list or recipe, will go to correct form (NewGroceryList or
		// NewRecipe) based on which radio button is selected
		if (RecipeRadBtn.isSelected()) {
			NewRecipe nr = new NewRecipe();
			nr.setVisible(true);
			nr.setAutoRequestFocus(true);
			nr.setLocationRelativeTo(null);
		} else if (GroceryListRadBtn.isSelected()) {
			NewGroceryList nr = new NewGroceryList();
			nr.setVisible(true);
			nr.setAutoRequestFocus(true);
			nr.setLocationRelativeTo(null);

		}
	}// GEN-LAST:event_newBtnActionPerformed

	private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_logoutBtnActionPerformed
		// needs to logout of thing, will throw window that confirms successful log out
		dispose();
		Main.login.setLocationRelativeTo(null);
		Main.login.setVisible(true);
		Main.login.clearLogin();
	}// GEN-LAST:event_logoutBtnActionPerformed

	private void openBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_openBtnActionPerformed
		// needs to open existing list or recipe and display folder in the Jtree area,
		// and display ingredients or recipe in view selection area
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeDisplay.getLastSelectedPathComponent();
		if (selectedNode == null) {
			return;
		}
		if (RecipeRadBtn.isSelected() && (selectedNode.getUserObject() instanceof Recipe)) {
			Recipe re = (Recipe) selectedNode.getUserObject();
			
			NewRecipe nr = new NewRecipe(re);
			nr.setVisible(true);
			nr.setAutoRequestFocus(true);
			nr.setLocationRelativeTo(null);

		}
		
		if (GroceryListRadBtn.isSelected() && (selectedNode.getUserObject() instanceof Measurement)) {
			Measurement re = (Measurement) selectedNode.getUserObject();
			
			NewGroceryList nr = new NewGroceryList(re);
			nr.setVisible(true);
			nr.setAutoRequestFocus(true);
			nr.setLocationRelativeTo(null);

		}
	}// GEN-LAST:event_openBtnActionPerformed

	private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_modifyBtnActionPerformed
		// allow user to add or remove items from list or recipe
		
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeDisplay.getLastSelectedPathComponent();
		if (selectedNode == null) {
			return;
		}
		if (RecipeRadBtn.isSelected() && (selectedNode.getUserObject() instanceof Recipe)) {
			Recipe re = (Recipe) selectedNode.getUserObject();
			
			NewRecipe nr = new NewRecipe(re);
			nr.setVisible(true);
			nr.setAutoRequestFocus(true);
			nr.setLocationRelativeTo(null);

		}
		
		if (GroceryListRadBtn.isSelected() && (selectedNode.getUserObject() instanceof Measurement)) {
			Measurement re = (Measurement) selectedNode.getUserObject();
			
			NewGroceryList nr = new NewGroceryList(re);
			nr.setVisible(true);
			nr.setAutoRequestFocus(true);
			nr.setLocationRelativeTo(null);

		}
		
	}// GEN-LAST:event_modifyBtnActionPerformed

	private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_deleteBtnActionPerformed
		// allow user to delete entire recipe or list
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeDisplay.getLastSelectedPathComponent();
		if (selectedNode == null) {
			return;
		}
		if (RecipeRadBtn.isSelected() && (selectedNode.getUserObject() instanceof Recipe)) {
			Recipe re = (Recipe) selectedNode.getUserObject();
		}

	}// GEN-LAST:event_deleteBtnActionPerformed

	private void dropdownListActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_dropdownListActionPerformed
		// allow user to search by name OR ingredient
	}// GEN-LAST:event_dropdownListActionPerformed

	private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchBtnActionPerformed
		// run the search
		if (dropdownList.getSelectedItem() == "Ingredient") {
			List<Ingredients> ingredients = IngredientUtility.findIngredientsByName(searchTextArea.getText());
			for (Iterator iter = ingredients.iterator(); iter.hasNext();) {
				Ingredients ingredient = (Ingredients) iter.next();
				displayPane.append(ingredient.toString());
			}
		}
		System.out.println(dropdownList.getSelectedItem());
	}// GEN-LAST:event_searchBtnActionPerformed

	private void RecipeRadBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_RecipeRadBtnActionPerformed
		// specifies to draw from recipe database
		if (!RecipeRadBtn.isSelected()) {
			return;
		}
		GroceryListRadBtn.setSelected(false);
		List<Recipe> recipes = RecipeUtility.listAllRecipes();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Recipes");
		for (Recipe re : recipes) {
			root.add(new DefaultMutableTreeNode(re));
		}
		treeDisplay.setModel(new DefaultTreeModel(root));
	}// GEN-LAST:event_RecipeRadBtnActionPerformed

	private void GroceryListRadBtnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_GroceryListRadBtnActionPerformed
		// specifies to draw from grocery database
		if (!GroceryListRadBtn.isSelected()) {
			return;
		}
		RecipeRadBtn.setSelected(false);

		List<Measurement> measurements = MeasurementUtility.listAllMeasurements();
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Grocery List");
		for (Measurement re : measurements) {
			root.add(new DefaultMutableTreeNode(re));
		}
		treeDisplay.setModel(new DefaultTreeModel(root));

	}// GEN-LAST:event_GroceryListRadBtnActionPerformed

	private void treeDisplayValueChanged(javax.swing.event.TreeSelectionEvent evt) {// GEN-FIRST:event_treeDisplayValueChanged
		// used to initiate and change nodes in the tree
		displayPane.setText("");
		DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) treeDisplay.getLastSelectedPathComponent();
		if (selectedNode == null) {
			return;
		}

		if (selectedNode.getUserObject() instanceof Recipe) {
			Recipe re = (Recipe) selectedNode.getUserObject();
			displayPane.append(String.format("Name: %s\n", re.getName()));
			displayPane.append(String.format("Description: %s\n", re.getDescription()));
			displayPane.append(String.format("Steps: %s\n", re.getSteps()));
			displayPane.append(String.format("Nutrition: %s\n", re.getNutrition()));
			displayPane.append(String.format("Categories: %s\n", re.getCategories()));
			return;
		}

		if (selectedNode.getUserObject() instanceof Measurement) {
			Measurement re = (Measurement) selectedNode.getUserObject();
			displayPane.append(String.format("Id: %s\n", re.getId()));			
			displayPane.append(String.format("Name: %s\n", re.getName()));
			return;
		}
	}// GEN-LAST:event_treeDisplayValueChanged

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		// </editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JRadioButton GroceryListRadBtn;
	private javax.swing.JRadioButton RecipeRadBtn;
	private javax.swing.JButton deleteBtn;
	private javax.swing.JTextArea displayPane;
	private javax.swing.JComboBox<String> dropdownList;
	private javax.swing.Box.Filler filler1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JButton logoutBtn;
	private javax.swing.JButton modifyBtn;
	private javax.swing.JButton newBtn;
	private javax.swing.JButton openBtn;
	private javax.swing.JButton searchBtn;
	private javax.swing.JTextArea searchTextArea;
	private javax.swing.JTree treeDisplay;
	// End of variables declaration//GEN-END:variables
}
