/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modeloparical3;

import model.Taller;
import model.VehiculoCompacto;
import model.VehiculoSUV;

/**
 *
 * @author lauti
 */
public class ModeloParical3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("1-1");
        try {
            VehiculoCompacto vehiculoCompacto1 = new VehiculoCompacto(2024, "ABC123", "Toyota Corolla", 2000.0);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
         System.out.println("1-2");
        try {
            VehiculoCompacto vehiculoCompacto2 = new VehiculoCompacto(2023, "XYZ5678", "Honda Civic", 2200.0);
            System.out.println("Código: " + vehiculoCompacto2.getCodigoVehiculo());
            System.out.println("Modelo: " + vehiculoCompacto2.getModelo());
            System.out.println("Precio: " + vehiculoCompacto2.getPrecioBase());
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
        
        System.out.println("1-3");
        try {
            VehiculoSUV vehiculoSUV = new VehiculoSUV(false, "QRS7890", "Chevrolet Tahoe", 4000.0);
            System.out.println("Código: " + vehiculoSUV.getCodigoVehiculo());
            System.out.println("Modelo: " + vehiculoSUV.getModelo());
            System.out.println("Precio Base: " + vehiculoSUV.getPrecioBase());
            System.out.println("Tracción Integral: " + vehiculoSUV.esTraccionIntegral());
        } catch (IllegalArgumentException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
        
        System.out.println("2-1");
        try {
            VehiculoCompacto vehiculoCompacto2 = new VehiculoCompacto(2023, "XYZ5678", "Honda Civic", 2200.0);
            System.out.println(vehiculoCompacto2.calcularCostoReparacion(5));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("2-2");
        try {
            VehiculoSUV vehiculoSUV = new VehiculoSUV(false, "QRS7890", "Chevrolet Tahoe", 4000.0);
            System.out.println(vehiculoSUV.calcularCostoReparacion(3));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("3-1");
        try {
            Taller taller1 = new Taller("Taller Lo de Pablo");
            
            taller1.agregarVehiculo(new VehiculoCompacto(2024, "LMN1111", "Volkswagen Polo", 1800.0));
            taller1.agregarVehiculo(new VehiculoSUV(true, "OPQ2222", "Toyota RAV4", 3000.0));
            System.out.println(taller1.traerVehiculosDisponibles());
            
            System.out.println("3-2");
            taller1.agregarVehiculo(new VehiculoSUV(true, "OPQ2222", "Toyota RAV4", 3000.0));
            
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        System.out.println("4-1");
        try {
            Taller taller1 = new Taller("Taller Lo de Pablo");
            taller1.agregarVehiculo(new VehiculoCompacto(2024, "LMN1111", "Volkswagen Polo", 1800.0));
            taller1.agregarVehiculo(new VehiculoSUV(true, "OPQ2222", "Toyota RAV4", 3000.0));
            taller1.agregarVehiculo(new VehiculoCompacto(2023, "XYZ5678", "Honda Civic", 2200.0));
            taller1.agregarVehiculo(new VehiculoSUV(false, "QRS7890", "Chevrolet Tahoe", 4000.0));
            
            taller1.iniciarReparacion("LMN1111", "En proceso de reaparcion");
            
            
            
            System.out.println(taller1.traerVehiculosDisponibles());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        
    }
    
}
