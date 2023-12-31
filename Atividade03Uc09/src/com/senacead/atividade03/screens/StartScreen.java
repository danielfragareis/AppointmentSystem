/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.senacead.atividade03.screens;

import com.senacead.atividade03.model.Appointment;
import com.senacead.atividade03.model.AppointmentList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danie
 */
public class StartScreen extends javax.swing.JFrame {

    private final String[] columns = {"Nome", "CPF", "Telefone", "Data", "Já era paciente?", "Consulta realizada"};
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    List<Appointment> fullList = AppointmentList.listAll();
    
    /**
     * Creates new form StartScreen
     */
    public StartScreen() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        newAppointmentScreen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        mainTable = new javax.swing.JTable();
        deleteBtn = new javax.swing.JButton();
        finishAppointmentBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        newAppointmentScreen.setText("Nova consulta");
        newAppointmentScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newAppointmentScreenActionPerformed(evt);
            }
        });

        updateTable();
        jScrollPane1.setViewportView(mainTable);

        deleteBtn.setText("Excluir consulta");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        finishAppointmentBtn.setText("Finalizar consulta");
        finishAppointmentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishAppointmentBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(newAppointmentScreen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteBtn)
                .addGap(71, 71, 71)
                .addComponent(finishAppointmentBtn)
                .addGap(20, 20, 20))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 507, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newAppointmentScreen)
                    .addComponent(deleteBtn)
                    .addComponent(finishAppointmentBtn)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
  
    private void updateTable() {
    tableModel.setRowCount(0);
    if (!fullList.isEmpty()) {
        for (int i = 0; i < fullList.size(); i++) {
            Appointment thisAppointment = fullList.get(i);
            String[] row = {
                thisAppointment.getPacientName(),
                thisAppointment.getPacientCpf(),
                thisAppointment.getPacientPhone(),
                thisAppointment.getAppointmentDate(),
                thisAppointment.getIsPacient(),
                thisAppointment.getAppointmentCompleted()
            };
            tableModel.addRow(row);
        }

        mainTable.setModel(tableModel);
    }else{
         mainTable.setModel(tableModel);
     }     
  }
    
    private void newAppointmentScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newAppointmentScreenActionPerformed
        RegisterAppointment registerAppointmentScreen = new RegisterAppointment();
        registerAppointmentScreen.setVisible(true);
    }//GEN-LAST:event_newAppointmentScreenActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        deleteAppointment(getAppointmentPosition());
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void finishAppointmentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishAppointmentBtnActionPerformed
        int appointmentPosition = getAppointmentPosition();
        if (appointmentPosition >= 0) {
            Appointment thisAppointment = fullList.get(appointmentPosition);
            FinishAppointment finishAppointmentScreen = new FinishAppointment(getAppointmentPosition());
            finishAppointmentScreen.setVisible(true);   
        }
    }//GEN-LAST:event_finishAppointmentBtnActionPerformed

    private int getAppointmentPosition(){
        int posAppointment = mainTable.getSelectedRow();
        if (posAppointment == -1){
            JOptionPane.showMessageDialog(rootPane,"Selecione um registro");
        }
        return posAppointment;
    }
    
    
    private void deleteAppointment(int posAppointment){
        if(posAppointment >= 0){
            String[] options = {"Sim", "Não"};
            
            int delete = JOptionPane.showOptionDialog(
                rootPane,
                "Deseja excluir esta consulta? ",
                "Exclusão de registro de consulta",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
            );
            
            if (delete == 0){
                fullList.remove(posAppointment);
                updateTable();
            }else{
                mainTable.clearSelection();
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
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StartScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton finishAppointmentBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTable mainTable;
    private javax.swing.JButton newAppointmentScreen;
    // End of variables declaration//GEN-END:variables
}
