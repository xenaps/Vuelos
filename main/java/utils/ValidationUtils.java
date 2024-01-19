/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

/**
 *
 * @author xenap
 */
public class ValidationUtils {

    // Método para validar un código de compañía aérea
    public static boolean validarCodigoCompaniaAerea(String codigo) {
        //El código debe tener dos caracteres, una letra seguida de un número
        return codigo.matches("[A-Z]\\d");
    }

    // Método para validar un número de teléfono
    public static boolean validarNumeroTelefono(String telefono) {
        // El número debe tener un código de país de tres dígitos y el resto del teléfono hasta 12 dígitos
        return telefono.matches("\\d{3}\\d{1,12}");
    }

    // Método para validar un código IATA de aeropuerto
    public static boolean validarCodigoIATA(String codigoIATA) {
        // El código IATA debe tener tres letras
        return codigoIATA.matches("[A-Z]{3}");
    }

    public static void main(String[] args) {
        // Ejemplos de uso
        System.out.println("Código de Compañía Aérea válido: " + validarCodigoCompaniaAerea("A1"));
        System.out.println("Número de Teléfono válido: " + validarNumeroTelefono("123456789012"));
        System.out.println("Código IATA válido: " + validarCodigoIATA("ABC"));
    }
}
