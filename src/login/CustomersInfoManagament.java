/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import java.awt.Color;
import java.awt.Image;					  
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author moeja
 */
public class CustomersInfoManagament extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    private void applyHoverEffect(JButton button) {
        Color originalColor = button.getBackground();
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(originalColor.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(originalColor);
            }
        });
    }

    public CustomersInfoManagament() {
        initComponents();
        Image icon = new ImageIcon(this.getClass().getResource("/Program Logo.png")).getImage();
        this.setIconImage(icon);																															
        applyHoverEffect(addCutmoerBttn);
        applyHoverEffect(removeAcustomer);
        applyHoverEffect(updateACustomerInfo);

        searchTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTableWithSearchFilter(searchTextField.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTableWithSearchFilter(searchTextField.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // This is not typically called for plain text components.
            }
        });
        setTitle("Customers Info Management");
        setLocationRelativeTo(null);
        con = DBConnection.ConnectionDB();
        UpdateTable();
    }

    protected void UpdateTable() {
        String sql = "select * from Customer4;";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            table5.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {

            }
        }
        
        
       
    }
//    String sql = "SELECT * FROM Customer4 WHERE ID LIKE ? OR Name LIKE ? OR Email LIKE ?;";

    public void updateTableWithSearchFilter(String toSearch) {
        // Use LIKE for partial matches on each key release.
        String sql = "SELECT * FROM Customer4 WHERE ID LIKE ? OR Name LIKE ? OR Email LIKE ?;";
        try {
            pst = con.prepareStatement(sql);
            // Using % around the search text to find any matching part.
            pst.setString(1, "%" + toSearch + "%");
            pst.setString(2, "%" + toSearch + "%");
            pst.setString(3, "%" + toSearch + "%");

            rs = pst.executeQuery();
            // Set the table model using DbUtils; this handles empty result sets as well.
            table5.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error during search: " + e.getMessage());
        } finally {
            try {
                // Ensure resources are closed.
                if (rs != null) {
                    rs.close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error closing resources: " + e.getMessage());
            }
        }
    }



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        addCutmoerBttn = new javax.swing.JButton();
        updateACustomerInfo = new javax.swing.JButton();
        removeAcustomer = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CustomerTable = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        searchTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(244, 235, 218));
        setMinimumSize(new java.awt.Dimension(960, 540));
        setSize(new java.awt.Dimension(960, 540));

        jPanel1.setBackground(new java.awt.Color(244, 235, 218));
        jPanel1.setPreferredSize(new java.awt.Dimension(960, 540));

        addCutmoerBttn.setBackground(new java.awt.Color(255, 232, 191));
        addCutmoerBttn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        addCutmoerBttn.setText("Add a customer");
        addCutmoerBttn.setAlignmentX(2.0F);
        addCutmoerBttn.setAlignmentY(2.0F);
        addCutmoerBttn.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
        addCutmoerBttn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addCutmoerBttn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addCutmoerBttn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCutmoerBttnActionPerformed(evt);
            }
        });

        updateACustomerInfo.setBackground(new java.awt.Color(255, 232, 191));
        updateACustomerInfo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateACustomerInfo.setText("Update a customer info");
        updateACustomerInfo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
        updateACustomerInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateACustomerInfoActionPerformed(evt);
            }
        });

        removeAcustomer.setBackground(new java.awt.Color(255, 232, 191));
        removeAcustomer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        removeAcustomer.setText("Remove a customer");
        removeAcustomer.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
        removeAcustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAcustomerActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(99, 63, 42));
        jLabel5.setText("Customer Table");

        jLabel4.setBackground(new java.awt.Color(0, 102, 102));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(99, 63, 42));
        jLabel4.setText("Customer Managment");

        CustomerTable.setBackground(new java.awt.Color(255, 232, 191));
        CustomerTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
        CustomerTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        table5.setFont(new java.awt.Font("Arial", 0, 12));
        table5.setForeground(new java.awt.Color(99, 63, 42));
        table5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table5MouseClicked(evt);
            }
        });
        CustomerTable.setViewportView(table5);

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                SearchForACustomerInCMPage(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\hassa\\Desktop\\Database\\Login\\Images\\Search Icon.png")); // NOI18N
        jLabel2.setText("  Search Bar");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hassa\\Desktop\\Database\\Login\\Images\\Refresh icon.png")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(244, 235, 218));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\hassa\\Downloads\\Mohamed-Latest-Changes\\SOFTWARE-CONSTRUCTION-Project-Main2-bug fixing\\src\\login\\back_button.png")); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CustomerTable, javax.swing.GroupLayout.DEFAULT_SIZE, 677, Short.MAX_VALUE))
                .addGap(66, 66, 66)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addCutmoerBttn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateACustomerInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(removeAcustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton6)
                .addGap(199, 199, 199)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jButton6))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addCutmoerBttn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(removeAcustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(updateACustomerInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CustomerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 979, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table5MouseClicked

    }//GEN-LAST:event_table5MouseClicked

    private void addCutmoerBttnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCutmoerBttnActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddACustomer().setVisible(true);
            }
        });
    }//GEN-LAST:event_addCutmoerBttnActionPerformed

    private void removeAcustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeAcustomerActionPerformed

 int selectedRow = table5.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No row selected", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = table5.getValueAt(selectedRow, 0).toString();
        String name = table5.getValueAt(selectedRow, 1).toString();
        String email = table5.getValueAt(selectedRow, 2).toString();

        String confirmationMessage = "Are you sure you want to delete the selected customer?\n\n"
                + "ID: " + id + "\n"
                + "Name: " + name + "\n"
                + "Email: " + email + "\n"
                + "This action cannot be undone.";

        int choice = JOptionPane.showConfirmDialog(this, confirmationMessage, "Confirm Deletion", JOptionPane.OK_CANCEL_OPTION);

        if (choice == JOptionPane.OK_OPTION) {
            // User confirmed deletion, delete the entry from the database
            String deleteQuery = "DELETE FROM Customer4 WHERE ID = ?";
            try (PreparedStatement pst = con.prepareStatement(deleteQuery)) {
                pst.setString(1, id);
                int rowsAffected = pst.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Customer deleted successfully.", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                    UpdateTable(); // Update the table after deletion
                } else {
                    JOptionPane.showMessageDialog(this, "No customer found with ID: " + id, "Deletion Unsuccessful", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error deleting a customer entry: " + ex.getMessage(), "Deletion Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_removeAcustomerActionPerformed

    private void updateACustomerInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateACustomerInfoActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCustmoerInfo().setVisible(true);
            }
        });
    }//GEN-LAST:event_updateACustomerInfoActionPerformed

    private void SearchForACustomerInCMPage(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_SearchForACustomerInCMPage
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchForACustomerInCMPage

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed

    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        UpdateTable();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(CustomersInfoManagament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomersInfoManagament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomersInfoManagament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomersInfoManagament.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomersInfoManagament().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CustomerTable;
    private javax.swing.JButton addCutmoerBttn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton removeAcustomer;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table5;
    private javax.swing.JButton updateACustomerInfo;
    // End of variables declaration//GEN-END:variables
}
