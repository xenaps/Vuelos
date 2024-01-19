/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 *
 * @author xenap
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class LLegadasPanel extends javax.swing.JFrame {
    private JTable llegadasTable;
    private JButton actualizarButton;
    
    public LLegadasPanel() {
        initComponents();
        initComponents1();
    }
    // </editor-fold>

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


   
  private void initComponents1() {
 setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Creación de componentes
        llegadasTable = new JTable();
        actualizarButton = new JButton("Actualizar");

        // Configuración de eventos
        actualizarButton.addActionListener(e -> actualizarLlegadas());

        // Creación del diseño del panel
        JScrollPane scrollPane = new JScrollPane(llegadasTable);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup()
            .addGroup(layout.createSequentialGroup()
                .addComponent(scrollPane)
            )
            .addGroup(layout.createSequentialGroup()
                .addComponent(actualizarButton)
            )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
            .addComponent(scrollPane)
            .addComponent(actualizarButton)
        );

        pack();
    }

    private void actualizarLlegadas() {
        try {
            // Lógica para obtener la información de las llegadas desde la capa de lógica de negocio
            Object[][] data = {
                    {"Vuelo1", "Aeropuerto1", "10:00", "Origen1"},
                    {"Vuelo2", "Aeropuerto2", "11:30", "Origen2"},
                    {"Vuelo3", "Aeropuerto3", "12:45", "Origen3"}
            };

            String[] columnNames = {"Vuelo", "Aeropuerto", "Hora", "Origen"};

            // Crear un nuevo modelo de tabla con los datos y nombres de columna
            DefaultTableModel model = new DefaultTableModel(data, columnNames);

            // Establecer el modelo en la JTable
            llegadasTable.setModel(model);
        } catch (Exception ex) {
            // Manejar excepciones 
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al actualizar las llegadas", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LLegadasPanel().setVisible(true);
            }
        });
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

