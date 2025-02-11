/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.reserva.modelo;

/**
 *
 * @author ing
 */
public class Espectaculo {
    
    /**
     * Formato dd/mm/yy
     */
    private String fecha;
    /**
     * Formato HH:MM
     */
    private String hora_minuto;
    private String nombre;
    private int identificador;

    /**
     * Fecha: dd/mm/yy
     * Hora: HH:MM
     */
    public Espectaculo(String fecha, String hora_minuto, int identificador, String nombre) {
        this.fecha = fecha;
        this.hora_minuto = hora_minuto;
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    @Override
    public String toString() {
        return identificador + " - " + nombre;
    }
    
    
    
}
