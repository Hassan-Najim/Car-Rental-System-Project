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
    
    
    
//     private void setUpTableListener() {
//        table3.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//            public void valueChanged(ListSelectionEvent event) {
//                if (!event.getValueIsAdjusting() && table3.getSelectedRow() != -1) {
//                    int selectedRow = table3.getSelectedRow();
//                    if (selectedRow >= 0) {
//                        Object Type = table3.getModel().getValueAt(selectedRow, 1); 
//                        Object Brand = table3.getModel().getValueAt(selectedRow, 2); 
//                        Object Model = table3.getModel().getValueAt(selectedRow, 3); 
//                        Object Color = table3.getModel().getValueAt(selectedRow, 4); 
//                        Object LicensePlate = table3.getModel().getValueAt(selectedRow, 5); 
//                        Object Availability = table3.getModel().getValueAt(selectedRow, 6); 
//                        Object HourRate = table3.getModel().getValueAt(selectedRow, 7); 
//                        Object CustomerRenter = table3.getModel().getValueAt(selectedRow, 8); 
//                        
//                        TypeField.setText(Type.toString());
//                        BrandField.setText(Brand.toString());
//                        ModelField.setText(Model.toString());
//                        ColorField.setText(Color.toString());
//                        LicensePlateField.setText(LicensePlate.toString());
//                        AvailabilityField.getSelectedItem().toString();
//                        HourlyRateField.setText(HourRate.toString());
//                        CustomerField.setText(CustomerRenter.toString());
//                        
//                    }
//                }
//            }
//        });
//    }
    
    
    
    
    /**
     * Creates new form UpdateCar
     */
    public UpdateCar() {
        initComponents();
 
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
        table3.getSelectionModel().addListSelectionListener(new ListSelectionListenerImpl());
           
           UpdateTable();
        
           
    }
    private void UpdateTable(){
        String sql = "select * from Car3;";
        try {
            pst = con.prepareStatement(sql);
            rs= pst.executeQuery();
         table3.setModel(DbUtils.resultSetToTableModel(rs));
             
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
         finally{
            try{
            rs.close();
            pst.close();
            
        }
            catch(Exception e){
                
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
        ModelField = new javax.swing.JTextField();
        LicensePlateField = new javax.swing.JTextField();
        TypeField = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        update = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        CustomerField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        BrandField = new javax.swing.JTextField();
        ManuYearField = new javax.swing.JTextField();
        AvailabilityField = new javax.swing.JComboBox<>();
        HourlyRateField = new javax.swing.JTextField();
        ColorField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        SearchTextFieldCarUpdate = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        backBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Car Rental System");

        jPanel1.setBackground(new java.awt.Color(244, 235, 218));

        ModelField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModelFieldActionPerformed(evt);
            }
        });

        TypeField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TypeFieldActionPerformed(evt);
            }
        });

        jLabel10.setText("Manufacture Year:");

        jLabel2.setText("Type:");

        update.setText("Update");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jLabel8.setText("Hourly Rate:");

        jLabel5.setText("Color:");

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
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
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
        table3.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                table3VetoableChange(evt);
            }
        });
        jScrollPane1.setViewportView(table3);

        jLabel9.setText("Current Renter:");

        jLabel3.setText("Brand:");

        jLabel4.setText("Model:");

        jLabel6.setText("License Plate#: ");

        ManuYearField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManuYearFieldActionPerformed(evt);
            }
        });

        AvailabilityField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Not Available" }));
        AvailabilityField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AvailabilityFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Cars Table");

        jLabel7.setText("Availability:");

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

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\hassa\\Desktop\\Database\\Login\\Images\\Search Icon.png")); // NOI18N
        jLabel11.setText("  Search Bar");

        jLabel12.setIcon(new javax.swing.ImageIcon("C:\\Users\\hassa\\Desktop\\Database\\Login\\Images\\Refresh icon.png")); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/back_button.png"))); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(SearchTextFieldCarUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(backBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(TypeField, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(BrandField, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(30, 30, 30)
                                .addComponent(ModelField)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ManuYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(LicensePlateField, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(HourlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(24, 24, 24)
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(CustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(update))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(24, 24, 24)
                                        .addComponent(ColorField, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(AvailabilityField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(84, 84, 84))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(backBtn)
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(SearchTextFieldCarUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TypeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(BrandField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(ModelField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(ManuYearField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(ColorField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AvailabilityField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LicensePlateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(HourlyRateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(CustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(74, 74, 74)
                        .addComponent(update)
                        .addGap(9, 9, 9)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

        int selectedRow = table3.getSelectedRow();
        if (selectedRow >= 0) {
            try {
                String id = table3.getModel().getValueAt(selectedRow, 0).toString(); // Assuming ID is in column 0
                String Type = TypeField.getText().trim().toUpperCase(); 
                String Brand = BrandField.getText().trim().toUpperCase(); 
                String Model = ModelField.getText().trim().toUpperCase();
                String ManfactureYear = ManuYearField.getText().trim().toUpperCase();
                String Color = ColorField.getText().trim().toUpperCase(); 
                String LicensePlate = LicensePlateField.getText().trim().toUpperCase();
                String Availability = AvailabilityField.getSelectedItem().toString().trim().toUpperCase(); 
                String HourRate = HourlyRateField.getText().trim().toUpperCase(); 
                String CustomerRenter = CustomerField.getText().trim().toUpperCase();

                        if (id.isEmpty() || Type.isEmpty()
                        || Brand.isEmpty()|| Model.isEmpty()
                        || ManfactureYear.isEmpty()|| Color.isEmpty()
                        || LicensePlate.isEmpty()|| Availability.isEmpty()
                        || HourRate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Name and Email cannot be empty");
                    return;
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
                     pst.setString(1, TypeField.getText());
                     pst.setString(2, BrandField.getText());
                     pst.setString(3, ModelField.getText());
                     pst.setString(4, ManuYearField.getText());
                     pst.setString(5, ColorField.getText());
                     pst.setString(6, LicensePlateField.getText());
                     pst.setString(7, AvailabilityField.getSelectedItem().toString());
                     pst.setString(8, HourlyRateField.getText());
                     pst.setString(9, CustomerField.getText());
                     System.out.println(rs.getString("ID"));
                     pst.setString(10, table3.getModel().getValueAt(table3.getSelectedRow(), 0).toString() );

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
            }finally {
            try {
                rs.close();
                pst.close();

            } catch (Exception e) {

            }
        }
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
//        try {
//           
//                String sql = "UPDATE Car3 SET "
//               + "Type = ?, "
//               + "Brand = ?, "
//               + "Model = ?, " 
//               + "ManufactureYear = ?,"
//               + "Color = ?, "
//               + "LicensePlate = ?, "
//               + "Availability = ?, "
//               + "HourlyRate = ?, "
//               + "CustomerRenter = ? "
//               + "WHERE ID = ?";
//    
//    pst = con.prepareStatement(sql);
//    pst.setString(1, TypeField.getText());
//    pst.setString(2, BrandField.getText());
//    pst.setString(3, ModelField.getText());
//    pst.setString(4, ManuYearField.getText());
//    pst.setString(5, ColorField.getText());
//    pst.setString(6, LicensePlateField.getText());
//    pst.setString(7, AvailabilityField.getSelectedItem().toString());
//    pst.setString(8, HourlyRateField.getText());
//    pst.setString(9, CustomerField.getText());
//            System.out.println(rs.getString("ID"));
//    pst.setString(10, table3.getModel().getValueAt(table3.getSelectedRow(), 0).toString() );
//           
//    
//    pst.executeUpdate();
//    UpdateTable();
//    JOptionPane.showMessageDialog(null, "Record Updated successfully");
//} catch (SQLException e) {
//    JOptionPane.showMessageDialog(null, e.getMessage());
//} 
//       finally{
//            try{
//            rs.close();
//            pst.close();
//            
//        }
//            catch(Exception e){
//                
//            }
//        }


  
       
    }//GEN-LAST:event_updateActionPerformed

    private void TypeFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TypeFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TypeFieldActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked

        int row = table3.getSelectedRow();
    //  String sql2 =  jj.getSelectedItem().toString();
     String selection = table3.getModel().getValueAt(row, 0).toString();
     String sql = "select * from Car3 where ID =" + selection;
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                TypeField.setText(rs.getString("Type"));
                BrandField.setText(rs.getString("Brand"));
                ModelField.setText(rs.getString("Model"));
                ManuYearField.setText(rs.getString("ManufactureYear"));
                ColorField.setText(rs.getString("Color"));
                LicensePlateField.setText(rs.getString("LicensePlate"));
                AvailabilityField.setSelectedItem(rs.getString("Availability"));
                AvailabilityField.setSelectedItem(rs.getString("Availability"));;
                HourlyRateField.setText(rs.getString("HourlyRate"));
                CustomerField.setText(rs.getString("CustomerRenter"));
               
             // JOptionPane.showMessageDialog(null, "Update Complete");


            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
     
    }//GEN-LAST:event_table3MouseClicked

    private void table3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table3KeyReleased
          
     
    }//GEN-LAST:event_table3KeyReleased

    private void ManuYearFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManuYearFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ManuYearFieldActionPerformed

    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked
        UpdateTable();
    }//GEN-LAST:event_jLabel12MouseClicked

    private void ModelFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModelFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ModelFieldActionPerformed

    private void AvailabilityFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AvailabilityFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AvailabilityFieldActionPerformed

    private void table3VetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_table3VetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_table3VetoableChange

    private void backBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMouseClicked
        this.dispose();
    }//GEN-LAST:event_backBtnMouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table3;
    private javax.swing.JButton update;
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

    private class ListSelectionListenerImpl implements ListSelectionListener {

        public ListSelectionListenerImpl() {
        }

        @Override
        public void valueChanged(ListSelectionEvent evt) {
            if (!evt.getValueIsAdjusting()) {
                int selectedRow = table3.getSelectedRow();
                if (selectedRow != -1) {
                    Object Type = table3.getValueAt(selectedRow, 1);
                    Object Brand = table3.getValueAt(selectedRow, 2);
                    Object Model = table3.getValueAt(selectedRow, 3);
                    Object ManfactureYear = table3.getValueAt(selectedRow, 4);
                    Object Color = table3.getValueAt(selectedRow, 5);
                    Object LicensePlate = table3.getValueAt(selectedRow, 6);
                    Object Availability = table3.getValueAt(selectedRow, 7);
                    Object HourRate = table3.getValueAt(selectedRow, 8);
                    Object CustomerRenter = table3.getValueAt(selectedRow, 9);
                    TypeField.setText(Type.toString());
                    BrandField.setText(Brand.toString());
                    ModelField.setText(Model.toString());
                    ManuYearField.setText(ManfactureYear.toString());
                    ColorField.setText(Color.toString());
                    LicensePlateField.setText(LicensePlate.toString());
                    AvailabilityField.getSelectedItem().toString();
                    HourlyRateField.setText(HourRate.toString());
                    CustomerField.setText(CustomerRenter.toString());
                }
            }
        }
    }
    
    
    
}
