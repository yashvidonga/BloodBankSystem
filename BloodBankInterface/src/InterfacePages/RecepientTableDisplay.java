/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package InterfacePages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ridds
 */
public class RecepientTableDisplay extends javax.swing.JFrame {

    /**
     * Creates new form RecepientTableDisplay
     */
    public RecepientTableDisplay() {
        initComponents();
        PreparedStatement pst = null;
        Connection connector = null;
        String recepient_id;
        String name;
        int age;
        String phone_number;
	String sex;
        String date_of_birth;
        String email;
        String address;
        String blood_type;
        double quantity;
        String date_of_requirement;
        String hospital_id;
        String hospital_name;
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/BloodBankManagementSystem";
            Properties parameters = new Properties();
            parameters.put("user", "postgres");
	    parameters.put("password", "root");
            connector = DriverManager.getConnection(url, parameters);
            pst = connector.prepareStatement("SELECT * FROM \"public\".recipient;");
            ResultSet r = pst.executeQuery();
            DefaultTableModel m=(DefaultTableModel)recepientdisplay.getModel();
            if(m.getRowCount()>0)
                m.setRowCount(0);
            while (r.next()){
                recepient_id=r.getString(1);
                name= r.getString(2);
                age=r.getInt(3);
                phone_number= r.getString(4);
                address= r.getString(5);
                blood_type= r.getString(6);
                quantity= r.getDouble(7);
                date_of_requirement=r.getString(8);
                sex=r.getString(9);
                email=r.getString(10);
                date_of_birth=r.getString(11);
                hospital_id=r.getString(12);
                hospital_name=r.getString(13);

                Object[] row={recepient_id,name,age,phone_number,sex,date_of_birth,email,address,blood_type,quantity,date_of_requirement,hospital_id,hospital_name};
                m.addRow(row);
            }
            pst.close();
            connector.close();
            }
        catch(Exception e){
            System.out.println(e.getMessage());
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

        jScrollPane1 = new javax.swing.JScrollPane();
        recepientdisplay = new javax.swing.JTable();
        backdisplay = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recepientdisplay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Recepient ID", "Name", "Age", "Phone No.", "Sex", "Date of Birth", "Email", "Address", "Blood Type", "Quantity", "Date of Requirement", "Hospital ID", "Hospital Name"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(recepientdisplay);

        backdisplay.setText("BACK");
        backdisplay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backdisplayActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(backdisplay)
                .addGap(616, 616, 616))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(86, 86, 86)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(backdisplay)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backdisplayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backdisplayActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        Recipient form = new Recipient();
        form.setVisible(true);
    }//GEN-LAST:event_backdisplayActionPerformed

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
            java.util.logging.Logger.getLogger(RecepientTableDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecepientTableDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecepientTableDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecepientTableDisplay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecepientTableDisplay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backdisplay;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable recepientdisplay;
    // End of variables declaration//GEN-END:variables
}
