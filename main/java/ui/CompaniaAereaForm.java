/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import business.CompaniaAerea;
import business.GestionCompaniasAereas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author xenap
 */
public class CompaniaAereaForm extends javax.swing.JFrame {

      private JTextField prefijoField;
    private JTextField codigoField;
    private JTextField nombreField;
    private JTextField direccionField;
    private JTextField municipioField;
    private JTextField infoPasajeroField;
    private JTextField infoAeropuertosField;

    private JButton guardarButton;
    private JButton cancelarButton;
    
  public CompaniaAereaForm() {
       initComponents();
        initMyComponents(); 
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

  
   private void initMyComponents() {
        // Configuración del frame
        setTitle("Formulario de Compañía Aérea");

        // Creación de componentes
        prefijoField = new JTextField();
        codigoField = new JTextField();
        nombreField = new JTextField();
        direccionField = new JTextField();
        municipioField = new JTextField();
        infoPasajeroField = new JTextField();
        infoAeropuertosField = new JTextField();

        guardarButton = new JButton("Guardar");
        cancelarButton = new JButton("Cancelar");

        // Configuración de eventos
        guardarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCompaniaAerea();
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el formulario
            }
        });

        // Creación del diseño del frame
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup()
                                .addComponent(new JLabel("Prefijo"))
                                .addComponent(prefijoField)
                                .addComponent(new JLabel("Código"))
                                .addComponent(codigoField)
                                .addComponent(new JLabel("Nombre"))
                                .addComponent(nombreField)
                                .addComponent(new JLabel("Dirección"))
                                .addComponent(direccionField)
                        )
                        .addGroup(layout.createParallelGroup()
                                .addComponent(new JLabel("Municipio"))
                                .addComponent(municipioField)
                                .addComponent(new JLabel("Teléfono Pasajero"))
                                .addComponent(infoPasajeroField)
                                .addComponent(new JLabel("Teléfono Aeropuertos"))
                                .addComponent(infoAeropuertosField)
                        )
                )
                .addGroup(layout.createSequentialGroup()
                        .addComponent(guardarButton)
                        .addComponent(cancelarButton)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(new JLabel("Prefijo"))
                                .addComponent(prefijoField)
                                .addComponent(new JLabel("Código"))
                                .addComponent(codigoField)
                                .addComponent(new JLabel("Nombre"))
                                .addComponent(nombreField)
                                .addComponent(new JLabel("Dirección"))
                                .addComponent(direccionField)
                        )
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(new JLabel("Municipio"))
                                .addComponent(municipioField)
                                .addComponent(new JLabel("Teléfono Pasajero"))
                                .addComponent(infoPasajeroField)
                                .addComponent(new JLabel("Teléfono Aeropuertos"))
                                .addComponent(infoAeropuertosField)
                        )
                )
                .addGroup(layout.createParallelGroup()
                        .addComponent(guardarButton)
                        .addComponent(cancelarButton)
                )
        );
    }
  private void guardarCompaniaAerea() {
        try {
            // Obtener los valores de los campos
            int prefijo = Integer.parseInt(prefijoField.getText());
            String codigo = codigoField.getText();
            String nombre = nombreField.getText();
            String direccion = direccionField.getText();
            String municipio = municipioField.getText();
            String telefonoPasajero = infoPasajeroField.getText();
            String telefonoAeropuertos = infoAeropuertosField.getText();

            // Validar

            // Crear una instancia de CompaniaAerea con los datos proporcionados
            CompaniaAerea companiaAerea = new CompaniaAerea(prefijo, codigo, nombre, direccion, municipio, telefonoPasajero, telefonoAeropuertos);

            // Llamar a la capa de lógica de negocio para guardar la compañía aérea
            GestionCompaniasAereas.getInstance().agregarCompaniaAerea(companiaAerea);

            // Éxito
            JOptionPane.showMessageDialog(this, "Compañía aérea guardada exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Cerrar
            dispose();
        } catch (NumberFormatException e) {
            // Manejar la excepción si no se puede convertir el prefijo a un número
            JOptionPane.showMessageDialog(this, "El prefijo debe ser un número entero", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Manejar otras excepciones
            JOptionPane.showMessageDialog(this, "Error al guardar la compañía aérea", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CompaniaAereaForm().setVisible(true);
            }
        });
    }
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

