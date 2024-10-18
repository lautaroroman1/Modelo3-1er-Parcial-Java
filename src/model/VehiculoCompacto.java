/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author lauti
 */
public class VehiculoCompacto extends Vehiculo {
    
    private int anio;

    public VehiculoCompacto(int anio, String codigoVehiculo, String modelo, double precioBase) {
        super(codigoVehiculo, modelo, precioBase);
        this.anio = anio;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
    public boolean esVehiculoNuevo(){
        if (this.anio == LocalDate.now().getYear()){
            return true;
        }
        else{
            return false;
        }

    }
    
    @Override
    public double calcularCostoReparacion(int horas) {
        double costoTotal = this.precioBase * horas;
        
        if (esVehiculoNuevo()){
            costoTotal *= 0.95;
        }
        
        return costoTotal; 
    }
    
    
    
}
