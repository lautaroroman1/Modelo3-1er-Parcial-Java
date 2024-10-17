/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author lauti
 */
public class VehiculoSUV extends Vehiculo {
    
    private boolean traccionIntegral;

    public VehiculoSUV(boolean traccionIntegral, String codigoVehiculo, String modelo, double precioBase) {
        super(codigoVehiculo, modelo, precioBase);
        this.traccionIntegral = traccionIntegral;
    }
    
    public boolean esTraccionIntegral() {
        return traccionIntegral;
    }

    @Override
    public double calcularCostoReparacion(int horas) {
        double costoTotal = this.precioBase * horas;
        
        if (esTraccionIntegral()){
            costoTotal *= 1.10;
        }
        
        return costoTotal;
    }
    
    
    
}
