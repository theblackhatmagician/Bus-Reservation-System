/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.reservation.system;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sijo
 */
public class MainScreen extends javax.swing.JFrame {

    /*
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        createTable();
        //updateTable();
    }

    private static final String URL = "jdbc:h2:~/BR";
    private static final String USER = "root";
    private static final String PASS = "";

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Statement st = null;
    ResultSetMetaData rsmd = null;
    private static final String Create_Table_Accounts = "Create table user_details ( userid varchar(50) not null primary key,\n"
            + "firstname varchar(50),\n"
            + "lastname varchar(50),\n"
            + "password varchar(50) not null,\n"
            + "email_id varchar(50) not null, \n"
            + "web_url varchar(50))";
    private static final String Create_Table_Admin_Details = "Create table admin_details ( username varchar(50) not null primary key,\n"
            + "name varchar(50),\n"
            + "password varchar(50) not null)";
    private static final String Create_Table_Bus_Details = "Create table bus_details ( bus_no number(20) not null primary key,\n"
            + "bus_source varchar(50),\n"
            + "bus_dest varchar(50),\n"
            + "depart_time varchar(20),\n"
            + "price varchar(20),\n"
            + "total_seat varchar(50) not null)";
    private static final String Create_Table_Booking = "Create table bus_booking ( User varchar(20),\n"
            + "bus_no number(20) not null,\n"
            + "paid  varchar(20) not null,\n"
            + "seat_no varchar(10) not null,\n"
            + "name varchar(10) not null, \n"
            + "foreign key(bus_no) references bus_details(bus_no))";

    private void createTable() {
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            try {
                //pst = con.prepareStatement("drop table if exists bus_booking");
                //pst.execute(); 
                pst = con.prepareStatement(Create_Table_Bus_Details);
                pst.execute();
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(this, ex);
            }
            try {
                //pst = con.prepareStatement("drop table if exists admin_details");
                //pst.execute(); 
                pst = con.prepareStatement(Create_Table_Admin_Details);
                pst.execute();
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(this, ex);
            }
            try {
                //pst = con.prepareStatement("drop table if exists bus_booking");
                //pst.execute(); 
                pst = con.prepareStatement(Create_Table_Booking);
                pst.execute();
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(this, ex);
            }
            try {
                /*pst = con.prepareStatement("drop table if exists user_details");
                pst.execute(); */
                pst = con.prepareStatement(Create_Table_Accounts);
                pst.execute();
            } catch (SQLException ex) {
                //JOptionPane.showMessageDialog(this, ex);
            }
            con.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }
    String InsertAdmin = "insert into admin_details values ('" + "aswin" + "'," + "'" + "aswin" + "'," + "'" + "pass" + "')";

    private void updateTable() {
        try {
            con = DriverManager.getConnection(URL, USER, PASS);
            pst = con.prepareStatement(InsertAdmin);
            pst.execute();
            con.close();
            //JOptionPane.showMessageDialog(this, "Updated");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        LHeading = new javax.swing.JLabel();
        BLogin = new javax.swing.JButton();
        BCreateAccount = new javax.swing.JButton();
        BALogin = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LHeading.setFont(new java.awt.Font("URW Chancery L", 1, 36)); // NOI18N
        LHeading.setText("Bus Reservation System");

        BLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        BLogin.setText("Login");
        BLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BLoginActionPerformed(evt);
            }
        });

        BCreateAccount.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        BCreateAccount.setText("Create Account");
        BCreateAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BCreateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BCreateAccountActionPerformed(evt);
            }
        });

        BALogin.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        BALogin.setText("Admin Login");
        BALogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BALogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BALoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(LHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BALogin, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(LHeading, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(BLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BCreateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BALogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        LHeading.getAccessibleContext().setAccessibleName("LHeading");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BCreateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BCreateAccountActionPerformed
        // TODO add your handling code here:
        dispose();
        NewUser nu = new NewUser();
        nu.setLocationRelativeTo(null);
        nu.setVisible(true);
    }//GEN-LAST:event_BCreateAccountActionPerformed

    private void BLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BLoginActionPerformed
        // TODO add your handling code here:
        dispose();
        UserLogin ul = new UserLogin();
        ul.setLocationRelativeTo(null);
        ul.setVisible(true);
    }//GEN-LAST:event_BLoginActionPerformed

    private void BALoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BALoginActionPerformed
        // TODO add your handling code here:
        dispose();
        AdminLogin al = new AdminLogin();
        al.setLocationRelativeTo(null);
        al.setVisible(true);
    }//GEN-LAST:event_BALoginActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BALogin;
    private javax.swing.JButton BCreateAccount;
    private javax.swing.JButton BLogin;
    private javax.swing.JLabel LHeading;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
