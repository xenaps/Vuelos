/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

/**
 *
 * @author xenap
 */
import business.GestionCompaniasAereas;
import business.GestionVuelos;
import com.opencsv.exceptions.CsvValidationException;

public class DataPersistence {
    private CompaniaAereaDAO companiaAereaDAO;
    private VueloBaseDAO vueloBaseDAO;
    private VueloDiarioDAO vueloDiarioDAO;

    public DataPersistence() {
        this.companiaAereaDAO = new CompaniaAereaDAO();
        this.vueloBaseDAO = new VueloBaseDAO();
        this.vueloDiarioDAO = new VueloDiarioDAO();
    }

    public void guardarDatos() {
        companiaAereaDAO.guardarCompaniasAereas(GestionCompaniasAereas.getInstance().obtenerTodasLasCompanias());
        vueloBaseDAO.guardarVuelosBase(GestionVuelos.getInstance().obtenerTodosLosVuelosBase());
        vueloDiarioDAO.guardarVuelosDiarios(GestionVuelos.getInstance().obtenerTodosLosVuelosDiarios());
    }

    public void cargarDatos() throws CsvValidationException {
        GestionCompaniasAereas.getInstance().setCompaniasAereas(companiaAereaDAO.cargarCompaniasAereas());
        GestionVuelos.getInstance().setVuelosBase(vueloBaseDAO.cargarVuelosBase());
        GestionVuelos.getInstance().setVuelosDiarios(vueloDiarioDAO.cargarVuelosDiarios());
    }
}
