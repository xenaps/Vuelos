/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author xenap
 */
import java.io.Serializable;

public class CompaniaAerea implements Serializable {
    private static final long serialVersionUID = 1L;

    private int prefijo;
    private String codigo;
    private String nombre;
    private String direccion;
    private String municipio;
    private String telefonoPasajero;
    private String telefonoAeropuertos;

    public CompaniaAerea(int prefijo, String codigo, String nombre, String direccion, String municipio,
                         String telefonoPasajero, String telefonoAeropuertos) {
        this.prefijo = prefijo;
        this.codigo = codigo;
        this.nombre = nombre;
        this.direccion = direccion;
        this.municipio = municipio;
        this.telefonoPasajero = telefonoPasajero;
        this.telefonoAeropuertos = telefonoAeropuertos;
    }

    // Métodos de acceso (getters y setters)

    public int getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(int prefijo) {
        this.prefijo = prefijo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getTelefonoPasajero() {
        return telefonoPasajero;
    }

    public void setTelefonoPasajero(String telefonoPasajero) {
        this.telefonoPasajero = telefonoPasajero;
    }

    public String getTelefonoAeropuertos() {
        return telefonoAeropuertos;
    }

    public void setTelefonoAeropuertos(String telefonoAeropuertos) {
        this.telefonoAeropuertos = telefonoAeropuertos;
    }

    @Override
    public String toString() {
        return "CompaniaAerea{" +
                "prefijo=" + prefijo +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", municipio='" + municipio + '\'' +
                ", telefonoPasajero='" + telefonoPasajero + '\'' +
                ", telefonoAeropuertos='" + telefonoAeropuertos + '\'' +
                '}';
    }
}

