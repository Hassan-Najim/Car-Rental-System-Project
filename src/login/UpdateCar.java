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
 * @author hassa
 */
public class UpdateCar extends javax.swing.JFrame {

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

    public UpdateCar() {
        initComponents();

        setTitle("Update Car Informations");
        Image icon = new ImageIcon(this.getClass().getResource("/Program Logo.png")).getImage();
        this.setIconImage(icon);

        applyHoverEffect(update);

        table3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table3.setRowSelectionAllowed(true);

        SearchTextFieldCarUpdate.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateTableWithSearchFilter(SearchTextFieldCarUpdate.getText());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateTableWithSearchFilter(SearchTextFieldCarUpdate.getText());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                // This is not typically called for plain text components.
            }
        });
        setLocationRelativeTo(null);
        con = DBConnection.ConnectionDB();
        table3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent evt) {
               try{
                 if (!evt.getValueIsAdjusting()) {
                    int selectedRow = table3.getSelectedRow();
                    if (selectedRow != -1) {
                        Object Type = table3.getValueAt(selectedRow, 1);
                        Object Brand = table3.getValueAt(selectedRow, 2);
                        Object Model = table3.getValueAt(selectedRow, 3);
                        Object ManfactureYear = table3.getValueAt(selectedRow, 4);
                        Object Color = table3.getValueAt(selectedRow, 5);
                        Object LicensePlate = table3.getValueAt(selectedRow, 6);
                        Object Availablity = table3.getValueAt(selectedRow, 7);
                        Object HourRate = table3.getValueAt(selectedRow, 8);
                        String CustomerRenter = (String) table3.getValueAt(selectedRow, 9);
                        TypeField.setText(Type.toString());
                        BrandField.setText(Brand.toString());
                        ModelField.setText(Model.toString());
                        ManuYearField.setText(ManfactureYear.toString());
                        ColorField.setText(Color.toString());
                        LicensePlateField.setText(LicensePlate.toString());
                        AvailabilityField.setSelectedItem(Availablity);
                        HourlyRateField.setText(HourRate.toString());
                        CustomerField.setText(CustomerRenter);
                    }
                }
               
               }catch(Exception e){
                   System.out.println(e);
               }
              finally{
                   try {
                        rs.close();
                pst.close();
                       
                   } catch (Exception e) {
                   }
               }
            }

        });
        UpdateTable();
    }

    public void UpdateTable() {
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

    public void updateTableWithSearchFilter(String toSearch) {
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
        SearchTextFieldCarUpdate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        TypeField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        BrandField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        ModelField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        ColorField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        LicensePlateField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        AvailabilityField = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        HourlyRateField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        ManuYearField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        CustomerField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(244, 235, 218));

        jScrollPane1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(97, 60, 42), 1, true));

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Car ID", "Type", "Brand", "Model", "Color", "License Plate", "Availability", "Hour Rate", "Customer ", "ManuYear"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
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

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(99, 63, 42));
        jLabel1.setText("All Cars Table");

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

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Search Icon.png"))); // NOI18N
        jLabel11.setText("  Search Bar");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Refresh icon.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        update.setBackground(new java.awt.Color(255, 232, 191));
        update.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        update.setText("Update");
        update.setAlignmentY(0.0F);
        update.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(97, 60, 42), 2));
        update.setFocusPainted(false);
        update.setFocusable(false);
        update.setPreferredSize(new java.awt.Dimension(82, 32));
        
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(244, 235, 218));
        jButton1.setForeground(new java.awt.Color(244, 235, 218));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/back button.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setFocusPainted(false);
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(99, 63, 42));
        jLabel13.setText("Update Car Info");

        jPanel3.setBackground(new java.awt.Color(244, 235, 218));
        jPanel3.setLayout(new java.awt.GridLayout(9, 2, 5, 10));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Type:");
        jPanel3.add(jLabel2);

        TypeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeFieldActionPerformed(evt);
            }
        });
        jPanel3.add(TypeField);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Brand:");
        jPanel3.add(jLabel3);
        jPanel3.add(BrandField);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setText("Model:");
        jPanel3.add(jLabel4);

        ModelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModelFieldActionPerformed(evt);
            }
        });
        jPanel3.add(ModelField);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setText("Color:");
        jPanel3.add(jLabel5);
        jPanel3.add(ColorField);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setText("License Plate#: ");
        jPanel3.add(jLabel6);
        jPanel3.add(LicensePlateField);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setText("Availability:");
        jPanel3.add(jLabel7);

        AvailabilityField.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AvailabilityField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Rented" }));
        AvailabilityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailabilityFieldActionPerformed(evt);
            }
        });
        jPanel3.add(AvailabilityField);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setText("Hourly Rate:");
        jPanel3.add(jLabel8);
        jPanel3.add(HourlyRateField);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setText("Manufacture Year:");
        jPanel3.add(jLabel10);

        ManuYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManuYearFieldActionPerformed(evt);
            }
        });
        jPanel3.add(ManuYearField);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setText("Current Renter:");
        jPanel3.add(jLabel9);
        jPanel3.add(CustomerField);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(backBtn)
                                .addGap(688, 688, 688))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(148, 148, 148))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(109, 109, 109)
                                .addComponent(jLabel12)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(SearchTextFieldCarUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 107, Short.MAX_VALUE)))
                .addGap(33, 33, 33))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(backBtn))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchTextFieldCarUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(update, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ModelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModelFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModelFieldActionPerformed

    private void TypeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeFieldActionPerformed

    private void ManuYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManuYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManuYearFieldActionPerformed

    private void AvailabilityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailabilityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AvailabilityFieldActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        UpdateTable();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked

    }//GEN-LAST:event_backBtnMouseClicked

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        int selectedRow = table3.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                String id = table3.getModel().getValueAt(selectedRow, 0).toString(); // Assuming ID is in column 0
            
                String Type = TypeField.getText().trim();
                String Brand = BrandField.getText().trim();
                String Model = ModelField.getText().trim();
                String ManufactureYear = ManuYearField.getText().trim();
                String Color = ColorField.getText().trim();
                String LicensePlate = LicensePlateField.getText().trim();
                String Availability = AvailabilityField.getSelectedItem().toString();
                String HourRate = HourlyRateField.getText().trim();
                String CustomerRenter = "0";
                if (CustomerField.getText().trim() == null) {
                    CustomerRenter = "0";
                } else {
                    CustomerRenter = CustomerField.getText().trim();
                }

                if (Type.isEmpty() || Brand.isEmpty() || Model.isEmpty() || ManufactureYear.isEmpty()
                        || Color.isEmpty() || LicensePlate.isEmpty() || Availability.isEmpty() || HourRate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All Fields Must Be Full");
                    return;
                }
                  if (CustomerRenter.isEmpty()) {
            CustomerRenter = null; // Set it to "0" if empty
        } else {
          
                 String customerCheckQuery = "SELECT * FROM Customer4 WHERE ID = ?";
        try (PreparedStatement customerCheckStmt = con.prepareStatement(customerCheckQuery)) {
            customerCheckStmt.setString(1, CustomerRenter);
            ResultSet customerCheckResult = customerCheckStmt.executeQuery();
            if (!customerCheckResult.next()) {
                JOptionPane.showMessageDialog(this, "Customer ID does not exist", "Error",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        
                }
                String sql = "UPDATE Car3 SET "
                        + "Type = ?, "
                        + "Brand = ?, "
                        + "Model = ?, "
                        + "ManufactureYear = ?,"
                        + "Color = ?, "
                        + "LicensePlate = ?, "
                        + "Availability = ?, "
                        + "HourlyRate = ?, "
                        + "CustomerRenter = ? "
                        + "WHERE ID = ?";
                try (PreparedStatement pst = con.prepareStatement(sql)) {
                    pst.setString(1, Type.toUpperCase());
                    pst.setString(2, Brand.substring(0, 1).toUpperCase() + Brand.substring(1).toLowerCase());
                    pst.setString(3, Model.substring(0, 1).toUpperCase() + Model.substring(1).toLowerCase());
                    pst.setString(4, ManufactureYear);
                    pst.setString(5, Color.substring(0, 1).toUpperCase() + Color.substring(1).toLowerCase());
                    pst.setString(6, LicensePlate.toUpperCase());
                    pst.setString(7, Availability);
                    pst.setString(8, HourRate);
                    pst.setString(9, CustomerRenter);
                    pst.setString(10, id);

                    int affectedRows = pst.executeUpdate();
                    if (affectedRows > 0) {
                        JOptionPane.showMessageDialog(null, "Update Successful");
                        UpdateTable();
                    } else {
                        JOptionPane.showMessageDialog(null, "Update Failed");
                    }
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error updating record: " + ex.getMessage());
            } finally {
                try {
                    rs.close();
                    pst.close();

                } catch (Exception e) {

                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No row selected");
        }


    }//GEN-LAST:event_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try {
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
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    private void table3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table3KeyReleased

    }//GEN-LAST:event_table3KeyReleased

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
        table3.setDefaultEditor(Object.class, null);
    }//GEN-LAST:event_table3MouseClicked

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
            java.util.logging.Logger.getLogger(UpdateCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateCar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateCar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AvailabilityField;
    private javax.swing.JTextField BrandField;
    private javax.swing.JTextField ColorField;
    private javax.swing.JTextField CustomerField;
    private javax.swing.JTextField HourlyRateField;
    private javax.swing.JTextField LicensePlateField;
    private javax.swing.JTextField ManuYearField;
    private javax.swing.JTextField ModelField;
    private javax.swing.JTextField SearchTextFieldCarUpdate;
    private javax.swing.JTextField TypeField;
    private javax.swing.JLabel backBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table3;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
