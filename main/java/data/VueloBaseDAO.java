/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author xenap
 */
import business.VueloBase;
import com.opencsv.CSVWriter;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class VueloBaseDAO {
    private static final String FILE_PATH = "vuelos_base.csv";

    public void guardarVuelosBase(List<VueloBase> vuelosBase) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(FILE_PATH))) {
            // Escribir la línea de encabezado al archivo CSV
            String[] header = {"CodigoVuelo", "AeropuertoOrigen", "AeropuertoDestino",
                    "NumPlazas", "HoraSalida", "HoraLlegada", "DiasOperacion"};
            csvWriter.writeNext(header);

            // Escribir cada vuelo al archivo CSV
            for (VueloBase vuelo : vuelosBase) {
                String[] data = {
                        vuelo.getCodigoVuelo(),
                        vuelo.getAeropuertoOrigen(),
                        vuelo.getAeropuertoDestino(),
                        String.valueOf(vuelo.getNumPlazas()),
                        vuelo.getHoraSalida(),
                        vuelo.getHoraLlegada(),
                        vuelo.getDiasOperacion()
                };
                csvWriter.writeNext(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<VueloBase> cargarVuelosBase() {
        List<VueloBase> vuelosBase = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            // Leer la línea de encabezado 
            reader.readLine();

            // Leer cada línea del archivo CSV y convertirla a un objeto VueloBase
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                VueloBase vuelo = new VueloBase(
                        data[0],
                        data[1],
                        data[2],
                        Integer.parseInt(data[3]),
                        data[4],
                        data[5],
                        data[6]
                );
                vuelosBase.add(vuelo);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return vuelosBase;
    }

}

