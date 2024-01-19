/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

/**
 *
 * @author xenap
 */
import business.GestionVuelos;
import business.VueloBase;
import business.VueloDiario;

import static org.junit.Assert.*;

import java.util.List;
import  org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GestionVuelosTest {

    private GestionVuelos gestionVuelos;

    @Before
    public void setUp() {
        // Inicializar antes de cada prueba
        gestionVuelos = new GestionVuelos();
    }

    @After
    public void tearDown() {
        // Limpiar después de cada prueba si es necesario
    }

    @Test
    public void testAgregarVueloBase() {
        // Agregar un vuelo base
        VueloBase vueloBase = new VueloBase("IB123", "MAD", "BCN", 150, "10:00", "12:00", "LMXJVSD");
        gestionVuelos.agregarVueloBase(vueloBase);

        // Obtener la lista de vuelos base y verificar que contiene el vuelo base agregado
        assertEquals(1, gestionVuelos.obtenerTodosLosVuelosBase().size());
        assertTrue(gestionVuelos.obtenerTodosLosVuelosBase().contains(vueloBase));
    }

    @Test
    public void testEliminarVueloBase() {
        // Agregar un vuelo base
        VueloBase vueloBase = new VueloBase("IB123", "MAD", "BCN", 150, "10:00", "12:00", "LMXJVSD");
        gestionVuelos.agregarVueloBase(vueloBase);

        // Eliminar el vuelo base
        gestionVuelos.eliminarVueloBase(vueloBase);

        // Verificar que la lista de vuelos base está vacía después de la eliminación
        assertEquals(0, gestionVuelos.obtenerTodosLosVuelosBase().size());
    }

    @Test
    public void testAgregarVueloDiario() {
        // Agregar un vuelo base
        VueloBase vueloBase = new VueloBase("IB123", "MAD", "BCN", 150, "10:00", "12:00", "LMXJVSD");
        gestionVuelos.agregarVueloBase(vueloBase);

        // Agregar un vuelo diario
        VueloDiario vueloDiario = new VueloDiario(vueloBase, "2024/01/20", "10:00", "12:00", 100, 200.0);
        gestionVuelos.agregarVueloDiario(vueloDiario);

        // Obtener la lista de vuelos diarios y verificar que contiene el vuelo diario agregado
        assertEquals(1, gestionVuelos.obtenerTodosLosVuelosDiarios().size());
        assertTrue(gestionVuelos.obtenerTodosLosVuelosDiarios().contains(vueloDiario));
    }

    @Test
    public void testEliminarVueloDiario() {
        // Agregar un vuelo base
        VueloBase vueloBase = new VueloBase("IB123", "MAD", "BCN", 150, "10:00", "12:00", "LMXJVSD");
        gestionVuelos.agregarVueloBase(vueloBase);

        // Agregar un vuelo diario
        VueloDiario vueloDiario = new VueloDiario(vueloBase, "2024/01/20", "10:00", "12:00", 100, 200.0);
        gestionVuelos.agregarVueloDiario(vueloDiario);

        // Eliminar el vuelo diario
        gestionVuelos.eliminarVueloDiario(vueloDiario);

        // Verificar que la lista de vuelos diarios está vacía después de la eliminación
        assertEquals(0, gestionVuelos.obtenerTodosLosVuelosDiarios().size());
    }

    

}
