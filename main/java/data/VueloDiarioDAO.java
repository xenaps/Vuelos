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
import business.VueloDiario;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VueloDiarioDAO {
    private static final String FILE_PATH = "vuelos_diarios.csv";

    public void guardarVuelosDiarios(List<VueloDiario> vuelosDiarios) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(FILE_PATH))) {
            for (VueloDiario vueloDiario : vuelosDiarios) {
                String[] data = {
                        vueloDiario.getVueloBase().getCodigoVuelo(),
                        new SimpleDateFormat("yyyy/MM/dd").format(vueloDiario.getFechaVuelo()),
                        vueloDiario.getHoraSalidaReal(),
                        vueloDiario.getHoraLlegadaReal(),
                        String.valueOf(vueloDiario.getNumPlazasOcupadas()),
                        String.valueOf(vueloDiario.getPrecioVuelo()),
                        vueloDiario.getVueloBase().getAeropuertoOrigen(),
                        vueloDiario.getVueloBase().getAeropuertoDestino()
                };
                csvWriter.writeNext(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<VueloDiario> cargarVuelosDiarios() throws CsvValidationException {
        List<VueloDiario> vuelosDiarios = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(FILE_PATH))) {
            String[] data;
            while ((data = csvReader.readNext()) != null) {
                VueloBase vueloBase = new VueloBase(data[0], data[6], data[7], 0, "", "", "");
                VueloDiario vueloDiario = new VueloDiario(
                        vueloBase,
                        data[1],
                        data[2],
                        data[3],
                        Integer.parseInt(data[4]),
                        Double.parseDouble(data[5])
                );
                vuelosDiarios.add(vueloDiario);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vuelosDiarios;
    }

  
}
