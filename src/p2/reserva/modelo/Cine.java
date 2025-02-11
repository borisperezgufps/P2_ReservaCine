/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.reserva.modelo;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ing
 */
public class Cine {
    
    private ArrayList<Sala> salas;
    private ArrayList<Espectaculo> espectaculos;
    private ArrayList<Reserva> reservas;

    public Cine() {
        salas = new ArrayList<>();
        espectaculos = new ArrayList<>();
        reservas = new ArrayList<>();
        
        // SE INVOCA EL METODO PARA HACER LA CARGA INICIAL
        cargaInicialDatos();
    }
    
    
    public String[] obtenerSalas(){
        String[] nombreSalas = new String[salas.size()];
        int pos = 0;
        
        for (Sala sala : salas) {
            nombreSalas[pos] = sala.getIdentificador();
            pos++;
        }
        
        return nombreSalas;
    }
    
    public String[] obtenerFilasSala(String identificadorSala){
        
        for (Sala sala : salas) {
            if(sala.getIdentificador().equals(identificadorSala)){
                return sala.obtenerFilas();
            }
        }
        
        return null;        
    }
    
    public String[] obtenerEspectaculosSala(String identificadorSala){
        for (Sala sala : salas) {
            if(sala.getIdentificador().equals(identificadorSala)){
                return sala.obtenerEspectaculos();
            }
        }
        return null;
    }
    
    public String[] obtenerAsientosLibres(String identificadorSala, String identificadorFila) {
        
        Sala salaBuscada = null;
        for (Sala sala : salas) {
            if(sala.getIdentificador().equals(identificadorSala)){
                salaBuscada = sala;
            }
        }
        
        if(salaBuscada!=null){
            return salaBuscada.obtenerAsientosLibres(identificadorFila);
        }
        
        return null;
    }
    
    /**
     * 
     * @param idSala
     * @param idFila
     * @param numeroAsiento
     * @param idEspectaculo Se espera de la forma: XXXXXX - Nombre espectaculo. Se debe hacer split
     * @param celular 
     */
    public void reservar(String idSala, String idFila, String numeroAsiento, String idEspectaculo, String celular){
        
        Asiento asiento = null;
        // Encontrar la sala, encontrar la fila, obtener el asiento.
       
        for (Sala sala : salas) {
            if(sala.getIdentificador().equals(idSala)){
                asiento = sala.obtenerAsiento(idFila, numeroAsiento);
            }
        }
        
        String[] espectaculoDividido = idEspectaculo.split(" - ");
        
        Espectaculo esp = null;
        int intIdEspectaculo = Integer.parseInt(espectaculoDividido[0]);
        for (Espectaculo espectaculo : espectaculos) {
            if(espectaculo.getIdentificador()==intIdEspectaculo)
                esp = espectaculo;
        }
        
        Reserva reserva = new Reserva();
        reserva.generarReserva(asiento, esp, celular);
        reservas.add(reserva);
    }
    
    
    /*
        ESTOS METODOS SE USAN PARA CARGAR LA INFORMACIÓN DENTRO DEL MODELO
        QUE LUEGO SERÁ USADA PARA INTERACTUAR CON EL SISTEMA DE RESERVA.
        EN LA PRÁCTICA, ESTA INFORMACIÓN DEBERÍA CREARSE TODA A TRAVÉS
        DE UNA INTERFAZ GRÁFICA.
    */
    
    private void cargaInicialDatos(){
        crearEspectaculos();
        crearSalas();
        
        asignarEspectaculoASala(202501, "A1");
        asignarEspectaculoASala(202502, "A1");
        asignarEspectaculoASala(202503, "B1");
        asignarEspectaculoASala(202504, "C3");
        asignarEspectaculoASala(202505, "C3");
    }
    
    private void crearEspectaculos(){
        Espectaculo e = null;
        
        e = new Espectaculo("11/02/25", "11:00", 202501, "El príncipe del oriente");
        espectaculos.add(e);
        
        e = new Espectaculo("11/02/25", "15:00", 202502, "Las raices del miedo");
        espectaculos.add(e);
        
        e = new Espectaculo("11/02/25", "19:00", 202503, "El príncipe del oriente");
        espectaculos.add(e);
        
        e = new Espectaculo("12/02/25", "11:00", 202504, "Las raices del miedo");
        espectaculos.add(e);
        
        e = new Espectaculo("12/02/25", "15:00", 202505, "El sol a media noche");
        espectaculos.add(e);
        
    }
    
    private void asignarEspectaculoASala(int idEspectaculo, String identificadorSala){
        
        Espectaculo espectaculoMostrar = null;
        
        for (Espectaculo espectaculo : espectaculos) {
            if(espectaculo.getIdentificador()==idEspectaculo){
                espectaculoMostrar = espectaculo;
                break;
            }
        }
        
        if(espectaculoMostrar!=null){        
            for (Sala sala : salas) {
                if(sala!=null){
                    if(sala.getIdentificador().equals(identificadorSala)){
                        sala.asignarEspectaculo(espectaculoMostrar);
                        break;
                    }
                }
            }
        }
    }
    
    private void crearSalas(){
        
        Sala s = null;
        
        try {
            s = new Sala(5, "A1");
            salas.add(s);
            
            s = new Sala(6, "B1");
            salas.add(s);
            
            s = new Sala(4, "C3");
            salas.add(s);
            
        } catch (Exception ex) {
            Logger.getLogger(Cine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
}
