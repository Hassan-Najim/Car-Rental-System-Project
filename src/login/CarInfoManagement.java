/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import java.awt.Image;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import net.proteanit.sql.DbUtils;

public class CarInfoManagement extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    public CarInfoManagement() {
        initComponents();
        con = DBConnection.ConnectionDB();
        UpdateTable();
        
        setTitle("Cars Info Management");
        Image icon = new ImageIcon(this.getClass().getResource("/Program Logo.png")).getImage();
        this.setIconImage(icon);

        SearchTextFieldCar.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTableWithSearchFilter(SearchTextFieldCar.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTableWithSearchFilter(SearchTextFieldCar.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // This is not typically called for plain text components.
            }
        });
    }
     
    

    private void UpdateTable() {
        String sql = "select * from Car3;";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            table3.setModel(DbUtils.resultSetToTableModel(rs));

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


    private String getStringValueFromTable(int row, int column) {
    Object value = table3.getValueAt(row, column);
    return (value != null) ? value.toString() : "";
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
        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SearchTextFieldCar = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 235, 218));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 60, 42)));

        table3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        table3.setForeground(new java.awt.Color(99, 63, 42));
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Car ID", "Type", "Brand", "Model", "Color", "License Plate", "Availability", "Hour Rate", "Customer "
            }

        ) {
            //public boolean isCellEditable(int row, int column) {
                // Make all cells non-editable
                //return false;}
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }

        }

    );
    table3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            table3MouseClicked(evt);
        }
    });
    table3.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            table3KeyReleased(evt);
        }
    });
    jScrollPane1.setViewportView(table3);

    jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
    jLabel1.setForeground(new java.awt.Color(99, 63, 42));
    jLabel1.setText("Car Management");

    jPanel2.setBackground(new java.awt.Color(225, 220, 209));

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 9, Short.MAX_VALUE)
    );
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGap(0, 0, Short.MAX_VALUE)
    );

    SearchTextFieldCar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            SearchTextFieldCarActionPerformed(evt);
        }
    });

    jButton1.setBackground(new java.awt.Color(255, 232, 191));
    jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jButton1.setText("Update Car Info");
    jButton1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
    jButton1.setPreferredSize(new java.awt.Dimension(103, 51));
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
        }
    });

    jButton3.setBackground(new java.awt.Color(255, 232, 191));
    jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jButton3.setText("Add Car");
    jButton3.setAlignmentY(0.0F);
    jButton3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
    jButton3.setPreferredSize(new java.awt.Dimension(103, 51));
    jButton3.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton3ActionPerformed(evt);
        }
    });

    jButton4.setBackground(new java.awt.Color(255, 232, 191));
    jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    jButton4.setText("Remove Car");
    jButton4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 2, true));
    jButton4.setPreferredSize(new java.awt.Dimension(103, 51));
    jButton4.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton4ActionPerformed(evt);
        }
    });

    jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel3MouseClicked(evt);
        }
    });

    jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
    jLabel4.setForeground(new java.awt.Color(99, 63, 42));
    jLabel4.setText("All Cars Table");

    jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
    jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search Icon.png"))); // NOI18N
    jLabel2.setText("  Search Bar");

    jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh icon.png"))); // NOI18N
    jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jLabel5MouseClicked(evt);
        }
    });

    jButton6.setBackground(new java.awt.Color(244, 235, 218));
    jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back button.png"))); // NOI18N
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
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                    .addGap(18, 18, 18)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(16, 38, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(52, 52, 52)
                    .addComponent(jLabel4)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(218, 218, 218))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addComponent(SearchTextFieldCar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton6)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGap(183, 183, 183)))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(69, 69, 69)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addContainerGap(81, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jButton6)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(SearchTextFieldCar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(29, 29, 29))
        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(27, 27, 27)
            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(35, 35, 35)
            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGap(116, 116, 116))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
    setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Get the selected row index
  
  int selectedRow = table3.getSelectedRow();

// Check if a row is selected
if (selectedRow == -1) {
    JOptionPane.showMessageDialog(this, "Please select a row to delete.", "No row selected", JOptionPane.WARNING_MESSAGE);
    return;
}

// Extract information from the selected row
String id = getStringValueFromTable(selectedRow, 0);
String type = getStringValueFromTable(selectedRow, 1);
String brand = getStringValueFromTable(selectedRow, 2);
String model = getStringValueFromTable(selectedRow, 3);
String manufactureYear = getStringValueFromTable(selectedRow, 4);
String color = getStringValueFromTable(selectedRow, 5);
String licensePlate = getStringValueFromTable(selectedRow, 6);
String availability = getStringValueFromTable(selectedRow, 7);
String hourlyRate = getStringValueFromTable(selectedRow, 8);
String customerRenter = getStringValueFromTable(selectedRow, 9);

// Construct the confirmation message
String confirmationMessage = "Are you sure you want to delete the following car entry?\n\n"
        + "ID: " + id + "\n"
        + "Type: " + type + "\n"
        + "Brand: " + brand + "\n"
        + "Model: " + model + "\n"
        + "Manufacture Year: " + manufactureYear + "\n"
        + "Color: " + color + "\n"
        + "License Plate: " + licensePlate + "\n"
        + "Availability: " + availability + "\n"
        + "Hourly Rate: " + hourlyRate + "\n"
        + "Customer Renter: " + customerRenter + "\n\n"
        + "This action cannot be undone.";

// Display confirmation dialog
int choice = JOptionPane.showConfirmDialog(this, confirmationMessage, "Confirm Deletion", JOptionPane.OK_CANCEL_OPTION);

// Check user's choice
if (choice == JOptionPane.OK_OPTION) {
    // User confirmed deletion, delete the entry from the database
    String deleteQuery = "DELETE FROM Car3 WHERE ID = ?";
    try {
        pst = con.prepareStatement(deleteQuery);
        pst.setString(1, id);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(this, "Car entry deleted successfully.", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
        UpdateTable(); // Update the table after deletion
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Error deleting car entry: " + ex.getMessage(), "Deletion Error", JOptionPane.ERROR_MESSAGE);
    }
}
  
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCar().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton3ActionPerformed

    private void table3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table3KeyReleased

    }//GEN-LAST:event_table3KeyReleased

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
table3.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_table3MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        UpdateTable();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCar().setVisible(true);
            }
        });
    }//GEN-LAST:event_jButton1ActionPerformed

    private void SearchTextFieldCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchTextFieldCarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchTextFieldCarActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        UpdateTable();
    }//GEN-LAST:event_jLabel5MouseClicked

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
            java.util.logging.Logger.getLogger(CarInfoManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CarInfoManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CarInfoManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CarInfoManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CarInfoManagement().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SearchTextFieldCar;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table3;
    // End of variables declaration//GEN-END:variables

    private void updateTableWithSearchFilter(String toSearch) {
        // Use LIKE for partial matches on each key release.
        String sql = "SELECT * FROM Car3 WHERE ID LIKE ?"
                + " OR Type LIKE ?"
                + " OR Brand LIKE ?"
                + " OR Model LIKE ?"
                + " OR ManufactureYear LIKE ?"
                + " OR Color LIKE ?"
                + " OR LicensePlate LIKE ?"
                + " OR Availability LIKE ?"
                + " OR HourlyRate LIKE ?"
                + " OR CustomerRenter LIKE ?;";
        try {
            pst = con.prepareStatement(sql);
            // Using % around the search text to find any matching part.
            pst.setString(1, "%" + toSearch + "%");
            pst.setString(2, "%" + toSearch + "%");
            pst.setString(3, "%" + toSearch + "%");
            pst.setString(4, "%" + toSearch + "%");
            pst.setString(5, "%" + toSearch + "%");
            pst.setString(6, "%" + toSearch + "%");
            pst.setString(7, "%" + toSearch + "%");
            pst.setString(8, "%" + toSearch + "%");
            pst.setString(9, "%" + toSearch + "%");
            pst.setString(10, "%" + toSearch + "%");
            rs = pst.executeQuery();
            // Set the table model using DbUtils; this handles empty result sets as well.
            table3.setModel(DbUtils.resultSetToTableModel(rs));
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

}
