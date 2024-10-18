/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lauti
 */
public class Taller {
    
    private String nombreTaller;
    private List<Vehiculo> inventarioVehiculos;
    private List<Vehiculo> vehiculosEnReparacion;
    private List<Vehiculo> vehiculosFueraDeServicio;

    public Taller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
        this.inventarioVehiculos = new ArrayList<>();
        this.vehiculosEnReparacion = new ArrayList<>();
        this.vehiculosFueraDeServicio = new ArrayList<>();
        
    }
    
    public void agregarVehiculo(Vehiculo vehiculo) throws Exception{
        for (Vehiculo v: inventarioVehiculos){
            if (v.getCodigoVehiculo().equals(vehiculo.getCodigoVehiculo())){
                throw new Exception("Ya existe un vehículo con ese código");
            }
        }
        
        inventarioVehiculos.add(vehiculo);
    }
    
    public double calcularCostoReparacion(String codigoVehiculo, int horas) throws Exception{
        for (Vehiculo v: inventarioVehiculos){
            if (v.getCodigoVehiculo().equals(codigoVehiculo)){
                if (v.getEstado() != Vehiculo.EstadoVehiculo.EN_REPARACION){
                    throw new Exception("El vehículo no está en reparación");
                    
                }
                
                return v.calcularCostoReparacion(horas);
            }   
        }
        throw new Exception("No existe un vehículo con ese código");
    }
    
    public void iniciarReparacion(String codigoVehiculo, String descripcion) throws Exception{
        for (Vehiculo v: inventarioVehiculos){
            if (v.getCodigoVehiculo().equals(codigoVehiculo)){
                if (v.getEstado() == Vehiculo.EstadoVehiculo.EN_REPARACION){
                    throw new Exception("El vehículo ya está en repaarción");
                }
                
                v.iniciarReparacion(nombreTaller, descripcion);
                vehiculosEnReparacion.add(v);
                return;
            }
        }
        throw new Exception("No existe un vehículo con ese código");
    }
    
    public void finalizarReparacion(String codigoVehiculo) throws Exception{
        for (Vehiculo v: inventarioVehiculos){
            if (v.getCodigoVehiculo().equals(codigoVehiculo)){
                
                v.finalizarReparacion();
                vehiculosEnReparacion.remove(v);
            }
        }
        throw new Exception("No existe un vehículo con ese código");
    }
    
    public List<Vehiculo> traerVehiculosDisponibles(){
        List<Vehiculo> disponibles = new ArrayList<>();
        
        for (Vehiculo v : inventarioVehiculos) {
            if (v.getEstado() == Vehiculo.EstadoVehiculo.DISPONIBLE) {
                disponibles.add(v);
            }
        }
        
        return disponibles;
    }
    
    public List<Vehiculo> traerVehiculos(Vehiculo.EstadoVehiculo estado) {
        List<Vehiculo> vehiculosPorEstado = new ArrayList<>();
        
        for (Vehiculo v : inventarioVehiculos) {
            if (v.getEstado() == estado) {
                vehiculosPorEstado.add(v);
            }
        }
        
        return vehiculosPorEstado;
    }
    
    public List<String> obtenerHistorialReparaciones(String codigoVehiculo) throws Exception {
        for (Vehiculo v: inventarioVehiculos){
            if (v.getCodigoVehiculo().equals(codigoVehiculo)){
                v.getHistorialReparaciones();
            }
        }
        throw new Exception("No existe un vehículo con ese código");
    }
    
}
