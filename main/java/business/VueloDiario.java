/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author xenap
 * */
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class VueloDiario implements Serializable {
    private static final long serialVersionUID = 1L;

    private VueloBase vueloBase;
    private Date fechaVuelo;
    private String horaSalidaReal;
    private String horaLlegadaReal;
    private int numPlazasOcupadas;
    private double precioVuelo;

    public VueloDiario(VueloBase vueloBase, String fechaVuelo, String horaSalidaReal,
                       String horaLlegadaReal, int numPlazasOcupadas, double precioVuelo) {
        this.vueloBase = vueloBase;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        try {
            this.fechaVuelo = dateFormat.parse(fechaVuelo);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.horaSalidaReal = horaSalidaReal;
        this.horaLlegadaReal = horaLlegadaReal;
        this.numPlazasOcupadas = numPlazasOcupadas;
        this.precioVuelo = precioVuelo;
    }

    public VueloBase getVueloBase() {
        return vueloBase;
    }

    public void setVueloBase(VueloBase vueloBase) {
        this.vueloBase = vueloBase;
    }

    public Date getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(Date fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public String getHoraSalidaReal() {
        return horaSalidaReal;
    }

    public void setHoraSalidaReal(String horaSalidaReal) {
        this.horaSalidaReal = horaSalidaReal;
    }

    public String getHoraLlegadaReal() {
        return horaLlegadaReal;
    }

    public void setHoraLlegadaReal(String horaLlegadaReal) {
        this.horaLlegadaReal = horaLlegadaReal;
    }

    public int getNumPlazasOcupadas() {
        return numPlazasOcupadas;
    }

    public void setNumPlazasOcupadas(int numPlazasOcupadas) {
        this.numPlazasOcupadas = numPlazasOcupadas;
    }

    public double getPrecioVuelo() {
        return precioVuelo;
    }

    public void setPrecioVuelo(double precioVuelo) {
        this.precioVuelo = precioVuelo;
    }

   
  
    @Override
    public String toString() {
        return "VueloDiario{" +
                "vueloBase=" + vueloBase +
                ", fechaVuelo=" + fechaVuelo +
                ", horaSalidaReal='" + horaSalidaReal + '\'' +
                ", horaLlegadaReal='" + horaLlegadaReal + '\'' +
                ", numPlazasOcupadas=" + numPlazasOcupadas +
                ", precioVuelo=" + precioVuelo +
                '}';
    }
}
