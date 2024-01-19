/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author xenap
 * */
import java.util.ArrayList;
import java.util.List;
import data.CompaniaAereaDAO;

public class GestionCompaniasAereas {
    private static GestionCompaniasAereas instance;
    private List<CompaniaAerea> companiasAereas;
    private CompaniaAereaDAO companiaAereaDAO; 

    public GestionCompaniasAereas() {
        this.companiasAereas = new ArrayList<>();
        this.companiaAereaDAO = new CompaniaAereaDAO();  
    }

    public static GestionCompaniasAereas getInstance() {
        if (instance == null) {
            instance = new GestionCompaniasAereas();
        }
        return instance;
    }

    public void agregarCompaniaAerea(CompaniaAerea companiaAerea) {
        companiasAereas.add(companiaAerea);
    }

    public void eliminarCompaniaAerea(CompaniaAerea companiaAerea) {
        companiasAereas.remove(companiaAerea);
    }

    public void modificarCompaniaAerea(CompaniaAerea nuevaCompaniaAerea) {
        // Buscar la compañía por su identificador
        int prefijo = nuevaCompaniaAerea.getPrefijo();
        CompaniaAerea companiaExistente = consultarCompaniaAerea(prefijo);

        // Verificar si la compañía existe antes de intentar modificarla
        if (companiaExistente != null) {
            // Actualizar los datos de la compañía existente con los datos de la nueva compañía
            companiaExistente.setNombre(nuevaCompaniaAerea.getNombre());
            companiaExistente.setDireccion(nuevaCompaniaAerea.getDireccion());

            // Persistir cambios en el archivo CSV
            companiaAereaDAO.guardarCompaniasAereas(companiasAereas);
            System.out.println("Compañía Aérea modificada con éxito.");
        } else {
            // Manejar el caso en el que la compañía no exista
            System.out.println("La compañía a modificar no existe.");
        }
    }

    public CompaniaAerea consultarCompaniaAerea(int prefijo) {
        for (CompaniaAerea compania : companiasAereas) {
            if (compania.getPrefijo() == prefijo) {
                return compania;
            }
        }
        return null;
    }

    public List<CompaniaAerea> obtenerTodasLasCompanias() {
        return new ArrayList<>(companiasAereas);
    }

    public void limpiarCompaniasAereas() {
        companiasAereas.clear();
    }

    public void setCompaniasAereas(List<CompaniaAerea> nuevasCompanias) {
        this.companiasAereas = new ArrayList<>(nuevasCompanias);
    }
}
