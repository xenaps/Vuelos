/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

/**
 *
 * @author xenap
 */

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;

import javax.swing.*;
import java.awt.*;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TemperaturaFrame extends javax.swing.JFrame {

   
    private JTextField municipioField;
    private JButton consultarButton;
    private JTextArea resultadosArea;

    private final String apiKey;
    
    
    public TemperaturaFrame() {
        initComponents();
        initComponents1();
         apiKey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ4ZW5hcHMyNEBlZHVjYXN0dXIuZXMiLCJqdGkiOiI5MTFmYTZlYS01YTA0LTRhZTktYWM2YS04MjI5NGYwNjNhYmYiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTcwNTY4Mzc5MiwidXNlcklkIjoiOTExZmE2ZWEtNWEwNC00YWU5LWFjNmEtODIyOTRmMDYzYWJmIiwicm9sZSI6IiJ9.WIyRvwwWXW-VoeD2w4T_FdAluSeIQvstLS1PJBs5KsQ";
    }
private void initComponents1() {

        municipioField = new javax.swing.JTextField();
        consultarButton = new javax.swing.JButton();
        resultadosArea = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        consultarButton.setText("Consultar Temperaturas");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarTemperaturas();
            }
        });

        resultadosArea.setColumns(20);
        resultadosArea.setRows(5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(municipioField)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(consultarButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(resultadosArea, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(municipioField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(consultarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(resultadosArea, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void consultarTemperaturas() {
        String municipio = municipioField.getText().trim();

        // Obtener código de municipio desde el archivo CSV
        String codigoMunicipio = obtenerCodigoMunicipio(municipio);

        if (codigoMunicipio != null) {
            // Llamar a la API de AEMET con el código del municipio y la clave API
            String url = "https://opendata.aemet.es/opendata/api/prediccion/especifica/municipio/" + codigoMunicipio + "/";

            // Configuración de la solicitud HTTP
            HttpClient httpClient = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
             .uri(URI.create(url))
            .header("api_key", apiKey)
             .build();

              // Realizar la solicitud y obtener la respuesta
                     try {
                       HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                        if (response.statusCode() == 200) {
               String jsonResponse = response.body();

            // Parsear el JSON 
                  ObjectMapper objectMapper = new ObjectMapper();
                JsonNode jsonNode = objectMapper.readTree(jsonResponse);

                // Obtener el nodo "temperaturas"
              JsonNode temperaturasNode = jsonNode.path("temperaturas");

                // Verificar si el nodo "temperaturas" existe
                if (!temperaturasNode.isMissingNode()) {
                 // Obtener las temperaturas mínima y máxima
            int temperaturaMinima = temperaturasNode.path("temperatura_minima").asInt();
            int temperaturaMaxima = temperaturasNode.path("temperatura_maxima").asInt();

             // Mostrar las temperaturas en resultadosArea
             resultadosArea.setText("Temperaturas obtenidas: Mínima: " + temperaturaMinima + "°C, Máxima: " + temperaturaMaxima + "°C");
            } else {
             resultadosArea.setText("No se encontró el nodo 'temperaturas' en el JSON.");
                }}
            } catch (IOException | InterruptedException e) {
        e.printStackTrace();
              resultadosArea.setText("Error en la solicitud HTTP: " + e.getMessage());
}
        } else {
            resultadosArea.setText("Municipio no encontrado en el archivo CSV.");
        }
    }

    private String obtenerCodigoMunicipio(String municipioBuscado) {
        try (CSVReader reader = new CSVReader(new FileReader("Municipios.csv"))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String municipio = nextLine[0];
                String codigo = nextLine[1];
                if (municipio.equalsIgnoreCase(municipioBuscado)) {
                    return codigo;
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        return null;
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
            java.util.logging.Logger.getLogger(TemperaturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TemperaturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TemperaturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TemperaturaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TemperaturaFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
