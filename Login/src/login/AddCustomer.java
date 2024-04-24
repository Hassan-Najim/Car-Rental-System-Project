/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package login;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class AddCustomer extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
  
    public AddCustomer() {
        initComponents();
         con=DBConnection.ConnectionDB();
        UpdateTable();
        updatecombo();
        updatecombo2();
      
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
     
        
    
    private void updatecombo(){
        String sql = "select * from Car3";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                JJ.addItem(rs.getString("ID"));
            }
        } catch (Exception e) {
        }
        
    }
    private void updatecombo2(){
        String sql = "select * from Car3";
        try {
            pst = con.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                jj2.addItem(rs.getString("Availability"));
            }
        } catch (Exception e) {
        }
        
    }
   
/*
    
    String sql = "UPDATE Car SET CustomerRenter = (SELECT CustomerRenter FROM Customer4  WHERE CustomerRenter = ?) WHERE ID = "+JJ.getSelectedItem().toString();
        try {
                
//)"+   Customer.getText() + "'" + "
            pst = con.prepareStatement(sql);
          pst.setString(1, Customer.getText());
          int rows=pst.executeUpdate();
            UpdateTable();
            if(rows>0){
        JOptionPane.showMessageDialog(null, " Update Successfully ");

            }
            else{
          JOptionPane.showMessageDialog(null, "Error. Customer Does Not Exist");

            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    ///////////////////////////
      try {
    String updateSql = "UPDATE Car SET CustomerRenter = ? WHERE ID = ? AND Availability = ? AND EXISTS (SELECT 1 FROM Customer4 WHERE Name = ?)";
    pst = con.prepareStatement(updateSql);
    pst.setString(1, Customer.getText());
    pst.setString(2, JJ.getSelectedItem().toString());
   pst.setString(3, jj2.getSelectedItem().toString());
      pst.setString(4, Customer.getText());
    int rows = pst.executeUpdate();
    UpdateTable();
    
    if (rows > 0) {
        JOptionPane.showMessageDialog(null, "Customer Added Successfully");
    } else {
        JOptionPane.showMessageDialog(null, "Error. Customer Does Not Exist");
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}
    //////////////////////////////////////
    
     int row = table3.getSelectedRow();
        String selection = table3.getModel().getValueAt(row, 0).toString();
        String sql = "select * from Car3 where ID =" + selection;
        String selection2 = table3.getModel().getValueAt(row, 7).toString();
    String sql2 = "select * from Car3 where Availability =" + selection2;
   
        //
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if(rs.next()){
                 idcar.setText(rs.getString("ID"));
                id1.setText(rs.getString("ID"));
                JJ.setSelectedItem(rs.getString("ID"));
                jj2.setSelectedItem(rs.getString("Availability"));;
                Customer.setText(rs.getString("CustomerRenter"));
              

                // JOptionPane.showMessageDialog(null, "Update Complete");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    
    
    
    
    
    
    
    
    
    
    
    
    */
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        JJ = new javax.swing.JComboBox<>();
        update = new javax.swing.JButton();
        Customer = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jj2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        idcar = new javax.swing.JTextField();
        id1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        searchcar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        jScrollPane1.setViewportView(table3);

        jLabel9.setText("Customer: ");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Rent A Car");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        JJ.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JJActionPerformed(evt);
            }
        });

        update.setText("Rent");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        jButton1.setText("<----");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Availability:");

        jj2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "Not Available" }));

        jLabel3.setText("Car ID:");

        jLabel4.setText("ID:");

        searchcar.setText("Search Car");
        searchcar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchcarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(346, 346, 346)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(159, 159, 159)
                .addComponent(JJ, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(283, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(135, 135, 135)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(idcar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel2))
                                            .addComponent(jLabel3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(update, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jj2, 0, 136, Short.MAX_VALUE)
                                            .addComponent(Customer)
                                            .addComponent(id1, javax.swing.GroupLayout.Alignment.TRAILING)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(jLabel4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(searchcar)
                        .addGap(159, 159, 159)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(JJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1)))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(idcar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(searchcar)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(id1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(Customer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addComponent(update)
                        .addGap(81, 81, 81)))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
   
   int row = table3.getSelectedRow();
String selection = table3.getModel().getValueAt(row, 0).toString();
String sql = "SELECT * FROM Car3 WHERE ID = ?";
String selection2 = table3.getModel().getValueAt(row, 7).toString();
String sql2 = "SELECT * FROM Car3 WHERE Availability = ?";

try {
    // First query
    pst = con.prepareStatement(sql);
    pst.setString(1, selection);
    rs = pst.executeQuery();
    if(rs.next()) {
        idcar.setText(rs.getString("ID"));
        id1.setText(rs.getString("ID"));
        JJ.setSelectedItem(rs.getString("ID"));
        jj2.setSelectedItem(rs.getString("Availability"));
        Customer.setText(rs.getString("CustomerRenter"));
    }

    // Second query
    pst = con.prepareStatement(sql2);
    pst.setString(1, selection2);
    rs = pst.executeQuery();
    // Process results if needed
} catch (Exception e) {
    JOptionPane.showMessageDialog(null, e);
}


    }//GEN-LAST:event_table3MouseClicked

    private void table3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table3KeyReleased

    }//GEN-LAST:event_table3KeyReleased

    private void JJActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JJActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JJActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
       // String sql = "update Car set "
        //+ " CustomerRenter = '" +Customer.getText() + "'" +
        //"where ID = " +JJ.getSelectedItem().toString();
        try {
  //  String updateSql = "UPDATE Car SET CustomerRenter = ? AND Availability = ?  WHEREID = ?  AND EXISTS (SELECT 1 FROM Customer4 WHERE Name = ?)";
  String updateSql = "UPDATE Car3 SET " + " ID = ?," +" CustomerRenter = ?," + "Availability = ?" + "WHERE ID = ? AND EXISTS (SELECT 1 FROM Customer4 WHERE Name = ?)";

    pst = con.prepareStatement(updateSql);
     pst.setString(1, id1.getText());
    pst.setString(2, Customer.getText());
    pst.setString(3, jj2.getSelectedItem().toString());
    pst.setString(4, JJ.getSelectedItem().toString());
    pst.setString(5, Customer.getText());
    int rows = pst.executeUpdate();
    UpdateTable();
    
    if (rows > 0) {
        JOptionPane.showMessageDialog(null, "Customer Added Successfully");
    } else {
        JOptionPane.showMessageDialog(null, "Error. Customer Does Not Exist");
    }
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

       

  
    }//GEN-LAST:event_updateActionPerformed
// String sql = "UPDATE car SET CustomerRenter = (SELECT CustomerRenter FROM customer WHERE  = ?)+Customer.getText() + "'" + WHERE ID = "+JJ.getSelectedItem().toString();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void searchcarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchcarActionPerformed
        try{
               String sql = "SELECT * from Car3 WHERE ID = ?; ";
               pst = con.prepareStatement(sql);
               pst.setString(1, idcar.getText());
               rs = pst.executeQuery();
               if(rs.next()){
                   String []aa = {" ID:  "   +   rs.getString("ID")," Type:  "+rs.getString("Type"),"Brand:  "+rs.getString("Brand"),"Model:  "+rs.getString("Model"),"Manufacture Year:  " + rs.getString("ManufactureYear"),"Color:  "+rs.getString("Color"),"LicensePlate:  "+rs.getString("LicensePlate")," Availability: "+rs.getString("Availability")," Hourly Rate: "+rs.getString("HourlyRate"),"Customer:  "+rs.getString("CustomerRenter") };
                
                    JOptionPane.showMessageDialog(null, aa    );
               }
               else{
                   JOptionPane.showMessageDialog(null, "Incorrect Data");
               }
      }
      catch(Exception e){
          JOptionPane.showMessageDialog(null, e  );
      }finally{
            try{
            rs.close();
            pst.close();
            
        }
            catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_searchcarActionPerformed

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
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddCustomer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Customer;
    private javax.swing.JComboBox<String> JJ;
    private javax.swing.JTextField id1;
    private javax.swing.JTextField idcar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jj2;
    private javax.swing.JButton searchcar;
    private javax.swing.JTable table3;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
