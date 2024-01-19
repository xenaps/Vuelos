/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author xenap
 */
import com.opencsv.exceptions.CsvValidationException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import data.VueloDiarioDAO;

public class GestionVuelos {
    private static GestionVuelos instance;
    private List<VueloBase> vuelosBase;
    private List<VueloDiario> vuelosDiarios;
    private VueloDiarioDAO vueloDiarioDAO;

    public GestionVuelos() {
        this.vuelosBase = new ArrayList<>();
        this.vuelosDiarios = new ArrayList<>();
        this.vueloDiarioDAO = new VueloDiarioDAO();
    }

    public static GestionVuelos getInstance() {
        if (instance == null) {
            instance = new GestionVuelos();
        }
        return instance;
    }

    public void agregarVueloBase(VueloBase vueloBase) {
        vuelosBase.add(vueloBase);
    }

    public void eliminarVueloBase(VueloBase vueloBase) {
        vuelosBase.remove(vueloBase);
    }

    public void modificarVueloBase(VueloBase vueloBase) {
        // Lógica de modificación
    }

    public VueloBase consultarVueloBase(String codigoVuelo) {
        for (VueloBase vuelo : vuelosBase) {
            if (vuelo.getCodigoVuelo().equals(codigoVuelo)) {
                return vuelo;
            }
        }
        return null;
    }

    public List<VueloBase> obtenerTodosLosVuelosBase() {
        return new ArrayList<>(vuelosBase);
    }

    public void agregarVueloDiario(VueloDiario vueloDiario) {
        vuelosDiarios.add(vueloDiario);
    }

    public void eliminarVueloDiario(VueloDiario vueloDiario) {
        vuelosDiarios.remove(vueloDiario);
    }

    public void modificarVueloDiario(VueloDiario vueloDiario) {
        VueloDiario vueloExistente = consultarVueloDiario(vueloDiario.getVueloBase(), vueloDiario.getFechaVuelo());

        if (vueloExistente != null) {
            vueloExistente.setHoraSalidaReal(vueloDiario.getHoraSalidaReal());
            vueloExistente.setHoraLlegadaReal(vueloDiario.getHoraLlegadaReal());
            vueloExistente.setNumPlazasOcupadas(vueloDiario.getNumPlazasOcupadas());
            vueloExistente.setPrecioVuelo(vueloDiario.getPrecioVuelo());

            System.out.println("Vuelo Diario modificado con éxito.");

            // Persistencia de cambios en el archivo CSV
            vueloDiarioDAO.guardarVuelosDiarios(vuelosDiarios);
        } else {
            System.out.println("Vuelo Diario no encontrado.");
        }
    }

    public VueloDiario consultarVueloDiario(VueloBase vueloBase, Date fechaVuelo) {
        for (VueloDiario vuelo : vuelosDiarios) {
            if (vuelo.getVueloBase().equals(vueloBase) && vuelo.getFechaVuelo().equals(fechaVuelo)) {
                return vuelo;
            }
        }
        return null;
    }

    public List<VueloDiario> obtenerTodosLosVuelosDiarios() {
        return new ArrayList<>(vuelosDiarios);
    }

    public void setVuelosBase(List<VueloBase> vuelosBase) {
        this.vuelosBase = vuelosBase;
    }

    public void setVuelosDiarios(List<VueloDiario> vuelosDiarios) {
        this.vuelosDiarios = vuelosDiarios;
    }

    public void persistirVuelosDiarios() {
        vueloDiarioDAO.guardarVuelosDiarios(vuelosDiarios);
    }

    public void cargarVuelosDiarios() throws CsvValidationException {
        vuelosDiarios = vueloDiarioDAO.cargarVuelosDiarios();
    }
}
