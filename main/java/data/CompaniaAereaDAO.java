/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author xenap
 */
import business.CompaniaAerea;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CompaniaAereaDAO {
    private static final String FILE_PATH = "companias_aereas.csv";

    public void guardarCompaniasAereas(List<CompaniaAerea> companiasAereas) {
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(FILE_PATH))) {
            for (CompaniaAerea compania : companiasAereas) {
                String[] data = {
                        String.valueOf(compania.getPrefijo()),
                        compania.getCodigo(),
                        compania.getNombre(),
                        compania.getDireccion(),
                        compania.getMunicipio(),
                        compania.getTelefonoPasajero(),
                        compania.getTelefonoAeropuertos()
                };
                csvWriter.writeNext(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<CompaniaAerea> cargarCompaniasAereas() throws CsvValidationException {
        List<CompaniaAerea> companiasAereas = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(FILE_PATH))) {
            String[] data;
            while ((data = csvReader.readNext()) != null) {
                CompaniaAerea compania = new CompaniaAerea(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        data[5],
                        data[6]
                );
                companiasAereas.add(compania);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return companiasAereas;
    }
}
