/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author xenap
 */
import business.GestionCompaniasAereas;
import business.CompaniaAerea;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GestionCompaniasAereasTest {

    private GestionCompaniasAereas gestionCompaniasAereas;

    @Before
    public void setUp() {
        // Inicializar antes de cada prueba
        gestionCompaniasAereas = new GestionCompaniasAereas();
    }

    @After
    public void tearDown() {
        
    }

    @Test
    public void testAgregarCompaniaAerea() {
        // Agregar una compañía aérea
        CompaniaAerea companiaAerea = new CompaniaAerea(1, "IB", "Iberia", "Madrid", "Madrid", "123456789", "987654321");
        gestionCompaniasAereas.agregarCompaniaAerea(companiaAerea);

        // Obtener la lista de compañías y verificar que contiene la compañía agregada
        assertEquals(1, gestionCompaniasAereas.obtenerTodasLasCompanias().size());
        assertTrue(gestionCompaniasAereas.obtenerTodasLasCompanias().contains(companiaAerea));
    }

    @Test
    public void testEliminarCompaniaAerea() {
        // Agregar una compañía aérea
        CompaniaAerea companiaAerea = new CompaniaAerea(1, "IB", "Iberia", "Madrid", "Madrid", "123456789", "987654321");
        gestionCompaniasAereas.agregarCompaniaAerea(companiaAerea);

        // Eliminar la compañía aérea
        gestionCompaniasAereas.eliminarCompaniaAerea(companiaAerea);

        // Verificar que la lista de compañías está vacía después de la eliminación
        assertEquals(0, gestionCompaniasAereas.obtenerTodasLasCompanias().size());
    }

    @Test
    public void testModificarCompaniaAerea() {
        // Agregar una compañía aérea
        CompaniaAerea companiaAerea = new CompaniaAerea(1, "IB", "Iberia", "Madrid", "Madrid", "123456789", "987654321");
        gestionCompaniasAereas.agregarCompaniaAerea(companiaAerea);

        // Modificar la compañía aérea
        CompaniaAerea nuevaCompaniaAerea = new CompaniaAerea(1, "BA", "British Airways", "Londres", "Londres", "987654321", "123456789");
        gestionCompaniasAereas.modificarCompaniaAerea(nuevaCompaniaAerea);

        // Verificar que la lista de compañías contiene la compañía modificada
        assertEquals(1, gestionCompaniasAereas.obtenerTodasLasCompanias().size());
        assertTrue(gestionCompaniasAereas.obtenerTodasLasCompanias().contains(nuevaCompaniaAerea));
    }
}
