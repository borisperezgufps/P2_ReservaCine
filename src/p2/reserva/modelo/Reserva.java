/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.reserva.modelo;

/**
 *
 * @author ing
 */
public class Reserva {
    
    private Asiento asiento;
    private Espectaculo espectaculo;
    private String celular;
    
    public void generarReserva(Asiento asiento, Espectaculo espectaculo, String celular){
        this.asiento = asiento;
        this.espectaculo = espectaculo;
        this.celular = celular;
        
        this.asiento.setDisponible(false);
    }
    
}
