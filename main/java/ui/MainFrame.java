/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author xenap
 */
public class MainFrame extends javax.swing.JFrame {
    private JButton gestionCompaniasButton;
    private JButton gestionVuelosButton;
    private JButton salidasButton;
    private JButton llegadasButton;
    public MainFrame() {
       
        initComponents();

        // Configuración del frame
        setTitle("Gestión de Aeropuerto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);

        // Creación de botones
        gestionCompaniasButton = new JButton("Gestión de Compañías Aéreas");
        gestionVuelosButton = new JButton("Gestión de Vuelos");
        salidasButton = new JButton("Panel de Salidas");
        llegadasButton = new JButton("Panel de Llegadas");

        // Configuración de eventos de botones
        gestionCompaniasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir la ventana de gestión de compañías aéreas
                abrirVentanaGestionCompanias();
            }
        });

        gestionVuelosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para abrir la ventana de gestión de vuelos
                abrirVentanaGestionVuelos();
            }
        });

        salidasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                abrirPanelSalidas();
            }
        });

        llegadasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             
                abrirPanelLlegadas();
            }
        });

        // Creación del diseño del frame
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(gestionCompaniasButton)
                .addComponent(gestionVuelosButton)
                .addComponent(salidasButton)
                .addComponent(llegadasButton)
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addComponent(gestionCompaniasButton)
                .addComponent(gestionVuelosButton)
                .addComponent(salidasButton)
                .addComponent(llegadasButton)
        );
    }

    private void abrirVentanaGestionCompanias() {
        
        JOptionPane.showMessageDialog(this, "Abriendo la ventana de gestión de compañías aéreas");
    }

    private void abrirVentanaGestionVuelos() {
   
        JOptionPane.showMessageDialog(this, "Abriendo la ventana de gestión de vuelos");
    }

    private void abrirPanelSalidas() {
       
        JOptionPane.showMessageDialog(this, "Abriendo el panel de salidas");
    }

    private void abrirPanelLlegadas() {
       
        JOptionPane.showMessageDialog(this, "Abriendo el panel de llegadas");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
