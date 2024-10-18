/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lauti
 */

public abstract class Vehiculo {
    
    enum EstadoVehiculo{
        DISPONIBLE,
        EN_REPARACION,
        FUERA_DE_SERVICIO;
        
    };
    
    protected String codigoVehiculo;
    protected String modelo;
    protected double precioBase;
    protected EstadoVehiculo estado;
    protected List<String> historialReparaciones;

    public Vehiculo(String codigoVehiculo, String modelo, double precioBase) {
        if (codigoVehiculo.length() != 7) {
            throw new IllegalArgumentException("El código del vehículo debe tener 7 caracteres.");
        }
         
         
        this.codigoVehiculo = codigoVehiculo;
        this.modelo = modelo;
        this.precioBase = precioBase;
        this.estado = EstadoVehiculo.DISPONIBLE;
        this.historialReparaciones = new ArrayList<>();
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        if (codigoVehiculo.length() != 7) {
            throw new IllegalArgumentException("El código del vehículo debe tener 7 caracteres.");
        }
        this.estado = estado;
    }

    public String getCodigoVehiculo() {
        return codigoVehiculo;
    }

    public void setCodigoVehiculo(String codigoVehiculo) throws Exception{
        
        this.codigoVehiculo = codigoVehiculo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public List<String> getHistorialReparaciones() {
        return historialReparaciones;
    }

    public void setHistorialReparaciones(List<String> historialReparaciones) {
        this.historialReparaciones = historialReparaciones;
    }
    
    public abstract double calcularCostoReparacion(int horas);
    
    public void iniciarReparacion(String nombreTaller, String descripcion){
        this.estado = EstadoVehiculo.EN_REPARACION;
        this.historialReparaciones.add(LocalDate.now().toString() + " [" + nombreTaller + "]: " + descripcion);
    }
    
    public void finalizarReparacion(){
        this.estado = EstadoVehiculo.DISPONIBLE;
        this.historialReparaciones.add(LocalDate.now().toString() + ": Finalizado.");
    }
    
    public List<String> obtenerHistorialReparaciones() {
        return historialReparaciones;
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "codigoVehiculo=" + codigoVehiculo + ", modelo=" + modelo + ", precioBase=" + precioBase + ", estado=" + estado + ", historialReparaciones=" + historialReparaciones + '}';
    }
    
    
    
}
