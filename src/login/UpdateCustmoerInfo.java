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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author moeja
 */
public class UpdateCustmoerInfo extends javax.swing.JFrame {

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

    private void setUpTableListener() {
        table5.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting() && table5.getSelectedRow() != -1) {
                    int selectedRow = table5.getSelectedRow();
                    if (selectedRow >= 0) {
                        Object name = table5.getModel().getValueAt(selectedRow, 1); // Assuming name is in column 1
                        Object email = table5.getModel().getValueAt(selectedRow, 2); // Assuming email is in column 2
                        NameToBeInserted.setText(name.toString());
                        EmailToBeInserted.setText(email.toString());
                    }
                }
            }
        });
    }

    public UpdateCustmoerInfo() {
        initComponents();
        
        setTitle("Update Customer Informations");
        Image icon = new ImageIcon(this.getClass().getResource("/Program Logo.png")).getImage();
        this.setIconImage(icon);
        
        applyHoverEffect(UpdateBtn);
        table5.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table5.setRowSelectionAllowed(true);
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
        setLocationRelativeTo(null);
        con = DBConnection.ConnectionDB();
        table5.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (!evt.getValueIsAdjusting()) {
                    int selectedRow = table5.getSelectedRow();
                    if (selectedRow != -1) {
                        Object name = table5.getValueAt(selectedRow, 1); // assuming name is in column 1
                        Object email = table5.getValueAt(selectedRow, 2); // assuming email is in column 2
                        NameToBeInserted.setText(name.toString());
                        EmailToBeInserted.setText(email.toString());
                    }
                }
            }
        });
        UpdateTable();
        updatecombo();
    }

    public void updatecombo() {
        String sql = "select * from Customer4";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
//                ID2.addItem(rs.getString("ID"));
            }
        } catch (Exception e) {
        }

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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        CustomerTable = new javax.swing.JScrollPane();
        table5 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NameToBeInserted = new javax.swing.JTextField();
        EmailToBeInserted = new javax.swing.JTextField();
        UpdateBtn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        searchTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 235, 218));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(99, 63, 42));
        jLabel2.setText("Update Customer Info");

        CustomerTable.setBackground(new java.awt.Color(255, 232, 191));
        CustomerTable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
        CustomerTable.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        table5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        table5.setForeground(new java.awt.Color(99, 63, 42));
        table5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table5MouseClicked(evt);
            }
        });
        table5.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                table5VetoableChange(evt);
            }
        });
        CustomerTable.setViewportView(table5);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(99, 63, 42));
        jLabel8.setText("Name:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(99, 63, 42));
        jLabel9.setText("Email:");

        NameToBeInserted.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
        NameToBeInserted.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NameToBeInsertedActionPerformed(evt);
            }
        });

        EmailToBeInserted.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));

        UpdateBtn.setBackground(new java.awt.Color(255, 232, 191));
        UpdateBtn.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        UpdateBtn.setText("Update");
        UpdateBtn.setAlignmentY(0.0F);
        UpdateBtn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 60, 42), 2));
        UpdateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UpdateBtnActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(244, 235, 218));
        jButton6.setIcon(new javax.swing.ImageIcon("C:\\Users\\hassa\\Downloads\\Mohamed-Latest-Changes\\SOFTWARE-CONSTRUCTION-Project-Main2-bug fixing\\Images\\back button.png")); // NOI18N
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.setFocusPainted(false);
        jButton6.setFocusable(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(99, 63, 42));
        jLabel5.setText("Customer Table");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hassa\\Desktop\\Database\\Login\\Images\\Refresh icon.png")); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\hassa\\Desktop\\Database\\Login\\Images\\Search Icon.png")); // NOI18N
        jLabel11.setText("  Search Bar");

        searchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTextFieldActionPerformed(evt);
            }
        });
        searchTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchTextFieldSearchForACustomerInCMPage(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jButton6)
                .addGap(233, 233, 233)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(CustomerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(EmailToBeInserted, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NameToBeInserted, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(135, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CustomerTable, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NameToBeInserted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(EmailToBeInserted, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(91, 91, 91)
                        .addComponent(UpdateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table5MouseClicked
table5.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_table5MouseClicked

    private void NameToBeInsertedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NameToBeInsertedActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NameToBeInsertedActionPerformed

    private void UpdateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateBtnActionPerformed

        int selectedRow = table5.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                String id = table5.getModel().getValueAt(selectedRow, 0).toString(); // Assuming ID is in column 0
                String name = NameToBeInserted.getText().trim();
                String email = EmailToBeInserted.getText().trim();

                if (name.isEmpty() || email.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name and Email cannot be empty");
                    return;
                }

                String sql = "UPDATE Customer4 SET Name = ?, Email = ? WHERE ID = ?;";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, name);
                    pst.setString(2, email);
                    pst.setInt(3, Integer.parseInt(id));

                    int affectedRows = pst.executeUpdate();
                    if (affectedRows > 0) {
                        JOptionPane.showMessageDialog(null, "Update Successful");
                        UpdateTable();
                        updatecombo();
                    } else {
                        JOptionPane.showMessageDialog(null, "Update Failed");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error updating record: " + ex.getMessage());
            }
        }
        

    }//GEN-LAST:event_UpdateBtnActionPerformed

    private void table5VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_table5VetoableChange


    }//GEN-LAST:event_table5VetoableChange

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        UpdateTable();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void searchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTextFieldActionPerformed

    }//GEN-LAST:event_searchTextFieldActionPerformed

    private void searchTextFieldSearchForACustomerInCMPage(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchTextFieldSearchForACustomerInCMPage
        // TODO add your handling code here:
    }//GEN-LAST:event_searchTextFieldSearchForACustomerInCMPage

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton6ActionPerformed
    private void table5ValueChanged(javax.swing.event.ListSelectionEvent evt) {
        // Check if the selection is still adjusting
        if (!evt.getValueIsAdjusting()) {
            int selectedRow = table5.getSelectedRow();
            if (selectedRow != -1) {  // Valid row must be selected
                Object name = table5.getModel().getValueAt(selectedRow, 1); // Assuming name is in column 1
                Object email = table5.getModel().getValueAt(selectedRow, 2); // Assuming email is in column 2
                NameToBeInserted.setText(name.toString());
                EmailToBeInserted.setText(email.toString());
            }
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
            java.util.logging.Logger.getLogger(UpdateCustmoerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCustmoerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCustmoerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCustmoerInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCustmoerInfo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane CustomerTable;
    private javax.swing.JTextField EmailToBeInserted;
    private javax.swing.JTextField NameToBeInserted;
    private javax.swing.JButton UpdateBtn;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JTable table5;
    // End of variables declaration//GEN-END:variables
}
