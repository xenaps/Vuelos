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

public class VueloBase implements Serializable {
    private static final long serialVersionUID = 1L;

    private String codigoVuelo;
    private String aeropuertoOrigen;
    private String aeropuertoDestino;
    private int numPlazas;
    private String horaSalida;
    private String horaLlegada;
    private String diasOperacion;

    public VueloBase(String codigoVuelo, String aeropuertoOrigen, String aeropuertoDestino,
                     int numPlazas, String horaSalida, String horaLlegada, String diasOperacion) {
        this.codigoVuelo = codigoVuelo;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.numPlazas = numPlazas;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.diasOperacion = diasOperacion;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(String aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public String getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(String aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(String horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public String getDiasOperacion() {
        return diasOperacion;
    }

    public void setDiasOperacion(String diasOperacion) {
        this.diasOperacion = diasOperacion;
    }

    @Override
    public String toString() {
        return "VueloBase{" +
                "codigoVuelo='" + codigoVuelo + '\'' +
                ", aeropuertoOrigen='" + aeropuertoOrigen + '\'' +
                ", aeropuertoDestino='" + aeropuertoDestino + '\'' +
                ", numPlazas=" + numPlazas +
                ", horaSalida='" + horaSalida + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", diasOperacion='" + diasOperacion + '\'' +
                '}';
    }
}
