/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package food.ordering.system;



import java.sql.Connection;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author ganashree 
 */
  
public class user_panel extends javax.swing.JFrame {
    /**
     * Creates new form user_panel
     */
    public user_panel() {
        initComponents();
        Connect();
          this.setLocationRelativeTo(null);
        
        
      
         }
    Connection conn;
    PreparedStatement pst1;
    ResultSet rss;
    
    
    
    private void Connect()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/main_menu", "root", "");  
            } catch (ClassNotFoundException | SQLException ex) {
            java.util.logging.Logger.getLogger(user_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    DefaultTableModel model = new DefaultTableModel();
    
    
       
    
    public void sales() 
    {
            int lastid = 0;
            try {
            
            int rows = jTable1.getRowCount();

            String query1 = "insert into sales_product(prodname,price,qty,total,sub_total,payment,balance)values(?,?,?,?,?,?,?)";
    
            pst1 = conn.prepareStatement(query1);

            
            String prodname = " ";
             int price;
             int qty ;
            int total = 0;
            String sub = txtsub.getText();
            String pay = txtpay.getText();
            String bal = txtbal.getText();
            
            
            for(int i=0;i<jTable1.getRowCount();i++)
            {
                   
                   prodname = (String)jTable1.getValueAt(i, 0);
                   price = (int)jTable1.getValueAt(i, 1);
                   qty = (int)jTable1.getValueAt(i, 2);
                   total = (int)jTable1.getValueAt(i, 3);
                   
                   
                   
                    pst1.setString(1, prodname);
                    pst1.setInt(2, price);
                    pst1.setInt(3, qty);
                    pst1.setInt(4, total);
                    pst1.setString(5,sub);
                    pst1.setString(6, pay);
                    pst1.setString(7, bal);
                    
            pst1.executeUpdate();
                    
            }
                     
            
    
    pst1.addBatch();
    JOptionPane.showMessageDialog(this,"Sales Complete");
              new customer_address().setVisible(true);
              this.dispose();
        
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(user_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        addbtn = new javax.swing.JButton();
        ordbtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtpay = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtsub = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtbal = new javax.swing.JTextField();
        chk1 = new javax.swing.JCheckBox();
        chk2 = new javax.swing.JCheckBox();
        chk3 = new javax.swing.JCheckBox();
        chk4 = new javax.swing.JCheckBox();
        chk5 = new javax.swing.JCheckBox();
        chk6 = new javax.swing.JCheckBox();
        chk7 = new javax.swing.JCheckBox();
        txt1 = new javax.swing.JSpinner();
        txt2 = new javax.swing.JSpinner();
        txt3 = new javax.swing.JSpinner();
        txt4 = new javax.swing.JSpinner();
        txt5 = new javax.swing.JSpinner();
        txt6 = new javax.swing.JSpinner();
        txt7 = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(36, 33, 33));
        jPanel1.setForeground(java.awt.Color.white);
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(java.awt.Color.black);
        jLabel3.setFont(new java.awt.Font("Gill Sans Ultra Bold", 0, 48)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("   Food Ordering System");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 734, 60));

        jTable1.setBackground(java.awt.Color.gray);
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white));
        jTable1.setForeground(java.awt.Color.white);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product Name", "Price", "Qty", "Total"
            }
        ));
        jTable1.setGridColor(java.awt.Color.white);
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 510, 382));

        addbtn.setBackground(java.awt.Color.white);
        addbtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        addbtn.setText("ADD");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });
        jPanel1.add(addbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 119, 78));

        ordbtn.setBackground(java.awt.Color.white);
        ordbtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        ordbtn.setText("ORDER");
        ordbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordbtnActionPerformed(evt);
            }
        });
        jPanel1.add(ordbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 540, -1, 78));

        jLabel10.setBackground(java.awt.Color.black);
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 255));
        jLabel10.setText("Sub Total :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 490, -1, 34));

        txtpay.setBackground(new java.awt.Color(36, 33, 33));
        txtpay.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtpay.setForeground(java.awt.Color.white);
        txtpay.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        txtpay.setDisabledTextColor(java.awt.Color.white);
        txtpay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpayActionPerformed(evt);
            }
        });
        jPanel1.add(txtpay, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 540, 210, 34));

        jLabel11.setBackground(java.awt.Color.black);
        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 255));
        jLabel11.setText("Pay :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 540, -1, 34));

        txtsub.setEditable(false);
        txtsub.setBackground(new java.awt.Color(36, 33, 33));
        txtsub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtsub.setForeground(java.awt.Color.white);
        txtsub.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        txtsub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsubActionPerformed(evt);
            }
        });
        jPanel1.add(txtsub, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 210, 34));

        jLabel12.setBackground(java.awt.Color.black);
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 255));
        jLabel12.setText("Balance :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 580, -1, 34));

        txtbal.setEditable(false);
        txtbal.setBackground(new java.awt.Color(36, 33, 33));
        txtbal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtbal.setForeground(java.awt.Color.white);
        txtbal.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.white, 2));
        txtbal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbalActionPerformed(evt);
            }
        });
        jPanel1.add(txtbal, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 590, 210, 34));

        chk1.setBackground(new java.awt.Color(36, 33, 33));
        chk1.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        chk1.setForeground(java.awt.Color.white);
        chk1.setText("Sandwich");
        chk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk1ActionPerformed(evt);
            }
        });
        jPanel1.add(chk1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 195, -1, -1));

        chk2.setBackground(new java.awt.Color(36, 33, 33));
        chk2.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        chk2.setForeground(java.awt.Color.white);
        chk2.setText("Gobi Rice");
        chk2.setToolTipText("");
        chk2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk2ActionPerformed(evt);
            }
        });
        jPanel1.add(chk2, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 242, -1, -1));

        chk3.setBackground(new java.awt.Color(36, 33, 33));
        chk3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        chk3.setForeground(java.awt.Color.white);
        chk3.setText("Pizza");
        chk3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk3ActionPerformed(evt);
            }
        });
        jPanel1.add(chk3, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 280, -1, -1));

        chk4.setBackground(new java.awt.Color(36, 33, 33));
        chk4.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        chk4.setForeground(java.awt.Color.white);
        chk4.setText("Burger");
        chk4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk4ActionPerformed(evt);
            }
        });
        jPanel1.add(chk4, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 327, -1, -1));

        chk5.setBackground(new java.awt.Color(36, 33, 33));
        chk5.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        chk5.setForeground(java.awt.Color.white);
        chk5.setText("Coke");
        chk5.setToolTipText("");
        chk5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk5ActionPerformed(evt);
            }
        });
        jPanel1.add(chk5, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 382, -1, -1));

        chk6.setBackground(new java.awt.Color(36, 33, 33));
        chk6.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        chk6.setForeground(java.awt.Color.white);
        chk6.setText("Pepsi");
        chk6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk6ActionPerformed(evt);
            }
        });
        jPanel1.add(chk6, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 434, -1, -1));

        chk7.setBackground(new java.awt.Color(36, 33, 33));
        chk7.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        chk7.setForeground(java.awt.Color.white);
        chk7.setText("Noodles");
        chk7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk7ActionPerformed(evt);
            }
        });
        jPanel1.add(chk7, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 468, -1, -1));
        jPanel1.add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 199, 69, -1));
        jPanel1.add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 247, 69, -1));
        jPanel1.add(txt3, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 283, 69, -1));
        jPanel1.add(txt4, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 335, 69, -1));
        jPanel1.add(txt5, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 387, 69, -1));
        jPanel1.add(txt6, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 439, 69, -1));
        jPanel1.add(txt7, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 473, 69, -1));

        jLabel20.setBackground(java.awt.Color.black);
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(java.awt.Color.white);
        jLabel20.setText("₹ 50");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 195, -1, 34));

        jLabel13.setBackground(java.awt.Color.black);
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setText("₹ 30");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 239, -1, 34));

        jLabel21.setBackground(java.awt.Color.black);
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(java.awt.Color.white);
        jLabel21.setText("₹ 90");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 275, 52, 34));

        jLabel22.setBackground(java.awt.Color.black);
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(java.awt.Color.white);
        jLabel22.setText("₹ 50");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 327, 52, 34));

        jLabel23.setBackground(java.awt.Color.black);
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(java.awt.Color.white);
        jLabel23.setText("₹ 20");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 379, 52, 34));

        jLabel24.setBackground(java.awt.Color.black);
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(java.awt.Color.white);
        jLabel24.setText("₹ 20");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 431, 52, 34));

        jLabel25.setBackground(java.awt.Color.black);
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(java.awt.Color.white);
        jLabel25.setText("₹ 30");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(156, 465, 55, 34));

        jLabel1.setBackground(java.awt.Color.black);
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 40)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("MENU");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 150, 60));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/food/ordering/system/PPPPPPPP.jpg"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-40, 0, 890, 630));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.getAccessibleContext().setAccessibleParent(jPanel1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chk7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk7ActionPerformed

    private void chk6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk6ActionPerformed

    private void chk5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk5ActionPerformed

    private void chk4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk4ActionPerformed

    private void chk3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk3ActionPerformed

    private void chk2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk2ActionPerformed

    private void chk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk1ActionPerformed

    private void txtbalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbalActionPerformed

    private void txtsubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsubActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsubActionPerformed

    private void txtpayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpayActionPerformed

    private void ordbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordbtnActionPerformed
        // TODO add your handling code here:

        int sub,pay,bal;
        sub = Integer.parseInt(txtsub.getText());
        pay = Integer.parseInt(txtpay.getText());

        bal = pay - sub;

        txtbal.setText(String.valueOf(bal));

        sales();

    }//GEN-LAST:event_ordbtnActionPerformed

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        // TODO add your handling code here:
        int sum = 0;
        int price;
        int qty;
        int tot = 0;

        if(chk1.isSelected())
        {
            
            String Sandwich = chk1.getText();
            price = 50;
            qty = Integer.parseInt(txt1.getValue().toString());

            tot = price * qty;
            model = (DefaultTableModel)jTable1.getModel();

            model.addRow(new Object[]
                {
                    Sandwich,
                    price,
                    qty,
                    tot
                });
            }

            if(chk2.isSelected())
            {
                String GobiRice  = chk2.getText();
                price = 30;
                qty = Integer.parseInt(txt2.getValue().toString());

                tot = price * qty;
                model = (DefaultTableModel)jTable1.getModel();

                model.addRow(new Object[]
                    {
                        GobiRice,
                        price,
                        qty,
                        tot

                    });
                }

                if(chk3.isSelected())
                {
                    String Pizza   = chk3.getText();
                    price = 90;
                    qty = Integer.parseInt(txt3.getValue().toString());

                    tot = price * qty;
                    model = (DefaultTableModel)jTable1.getModel();

                    model.addRow(new Object[]
                        {
                            Pizza,
                            price,
                            qty,
                            tot

                        });
                    }

                    if(chk4.isSelected())
                    {
                        String Burger   = chk4.getText();
                        price = 50;
                        qty = Integer.parseInt(txt4.getValue().toString());

                        tot = price * qty;
                        model = (DefaultTableModel)jTable1.getModel();

                        model.addRow(new Object[]
                            {
                            
                                Burger,
                                price,
                                qty,
                                tot

                            });
                        }

                        if(chk5.isSelected())
                        {
                            String Coke   = chk5.getText();
                            price = 20;
                            qty = Integer.parseInt(txt5.getValue().toString());

                            tot = price * qty;
                            model = (DefaultTableModel)jTable1.getModel();

                            model.addRow(new Object[]
                                {
                                    Coke,
                                    price,
                                    qty,
                                    tot

                                });
                            }

                            if(chk6.isSelected())
                            {
                                String Pepsi   = chk6.getText();
                                price = 20;
                                qty = Integer.parseInt(txt6.getValue().toString());

                                tot = price * qty;
                                model = (DefaultTableModel)jTable1.getModel();

                                model.addRow(new Object[]
                                    {
                                        Pepsi,
                                        price,
                                        qty,
                                        tot

                                    });
                                }
                                if(chk7.isSelected())
                                {
                                    String Noodles   = chk7.getText();
                                    price = 30;
                                    qty = Integer.parseInt(txt7.getValue().toString());

                                    tot = price * qty;
                                    model = (DefaultTableModel)jTable1.getModel();

                                    model.addRow(new Object[]
                                        {
                                            Noodles,
                                            price,
                                            qty,
                                            tot

                                        });
                                    }

                                    for(int i=0; i <jTable1.getRowCount(); i++)
                                    {
                                        sum = sum + Integer.parseInt(jTable1.getValueAt(i, 3).toString());

                                    }

                                    txtsub.setText(Integer.toString(sum));

                                    JOptionPane.showMessageDialog(this,"ENTER THE AMOUNT TO PAY");
    }//GEN-LAST:event_addbtnActionPerformed

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
            java.util.logging.Logger.getLogger(user_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user_panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new user_panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JCheckBox chk1;
    private javax.swing.JCheckBox chk2;
    private javax.swing.JCheckBox chk3;
    private javax.swing.JCheckBox chk4;
    private javax.swing.JCheckBox chk5;
    private javax.swing.JCheckBox chk6;
    private javax.swing.JCheckBox chk7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton ordbtn;
    private javax.swing.JSpinner txt1;
    private javax.swing.JSpinner txt2;
    private javax.swing.JSpinner txt3;
    private javax.swing.JSpinner txt4;
    private javax.swing.JSpinner txt5;
    private javax.swing.JSpinner txt6;
    private javax.swing.JSpinner txt7;
    private javax.swing.JTextField txtbal;
    private javax.swing.JTextField txtpay;
    private javax.swing.JTextField txtsub;
    // End of variables declaration//GEN-END:variables
}
