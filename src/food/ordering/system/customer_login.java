package food.ordering.system;

import static com.mysql.cj.conf.PropertyKey.logger;
import com.mysql.cj.jdbc.result.ResultSetMetaData;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sanan
 */
public class customer_login extends javax.swing.JFrame {

    /**
     * Creates new form user_login
     */
    public customer_login() {
        initComponents();
        Connect();
        this.setLocationRelativeTo(null);
    }
        Connection con;
    PreparedStatement pst;
  ResultSet rs;

    /**
     *this is the connection class used to connect to database
     */
    public void Connect()
{
try {
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost/main_menu","root","");


}catch (ClassNotFoundException | SQLException ex) {
java.util.logging.Logger.getLogger(customer_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
}

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        submitbtn = new javax.swing.JButton();
        txtpass1 = new javax.swing.JPasswordField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(36, 33, 33));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(java.awt.Color.white);
        jLabel2.setFont(new java.awt.Font("Tw Cen MT", 1, 38)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Username  :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 254, -1, 36));

        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        jPanel2.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 261, 217, 36));

        jLabel3.setFont(new java.awt.Font("Tw Cen MT", 1, 38)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Password  :");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 352, 190, 31));

        submitbtn.setBackground(java.awt.Color.white);
        submitbtn.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        submitbtn.setText("SUBMIT");
        submitbtn.setBorder(new javax.swing.border.MatteBorder(null));
        submitbtn.setInheritsPopupMenu(true);
        submitbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitbtnActionPerformed(evt);
            }
        });
        jPanel2.add(submitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 431, 182, 56));

        txtpass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpass1ActionPerformed(evt);
            }
        });
        jPanel2.add(txtpass1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 343, 217, 40));

        jLabel5.setBackground(java.awt.Color.white);
        jLabel5.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText(" CUSTOMER   LOGIN");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 120, 443, 72));

        jLabel4.setBackground(java.awt.Color.white);
        jLabel4.setFont(new java.awt.Font("Tw Cen MT", 1, 48)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("        WELCOME");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 470, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/food/ordering/system/pic2.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtusernameActionPerformed

    private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitbtnActionPerformed
        
        String user = txtusername.getText();
       String password = txtpass1.getText();
       
       
   try{
        pst = con.prepareStatement("insert into userlogin(user,password)values(?,?) ");
        pst.setString(1,user);
        pst.setString(2,password);
       
       
           txtusername.setText("");
           txtpass1.setText("");
           txtusername.requestFocus();
           int k = pst.executeUpdate();
           
       if(k==1){
        JOptionPane.showMessageDialog(this, "Registered");
        this.dispose();
       }
       else{
           JOptionPane.showMessageDialog(this, "Error");
           this.dispose();
           
       }
         
       
       }catch (SQLException ex) {
           
      System.err.println("Message: " + ex.getMessage());

        }
        
        
                    new user_panel().setVisible(true);

        
    }//GEN-LAST:event_submitbtnActionPerformed

    private void txtpass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpass1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpass1ActionPerformed

   
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
            java.util.logging.Logger.getLogger(customer_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(customer_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(customer_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(customer_login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new customer_login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton submitbtn;
    private javax.swing.JPasswordField txtpass1;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
