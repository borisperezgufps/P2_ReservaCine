/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.reserva.modelo;

import java.util.ArrayList;

/**
 *
 * @author ing
 */
public class Sala {
    private ArrayList<Espectaculo> espectaculos;
    private Fila[] filas;
    private String identificador;

    public Sala(String identificador) throws Exception {
        this(10, identificador);
    }
    
    public Sala(int cantidadFilas, String identificador) throws Exception{
        if(cantidadFilas<=10){
            this.identificador = identificador;
            filas = new Fila[cantidadFilas];
            espectaculos = new ArrayList<>();
            cargarFilas();
        }
        else
            throw new Exception("No se puede crear más de 10 filas");
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public Asiento obtenerAsiento(String idFila, String numeroAsiento) {
       
        for (Fila fila : filas) {
            if(fila.getLetra().equals(idFila)){
                return fila.obtenerAsiento(numeroAsiento);
            }
        }
        
        return null;
    }
    
    public String[] obtenerFilas(){
        String[] todasFilas = new String[filas.length];
        
        for(int t=0;t<filas.length;t++){
            todasFilas[t] = filas[t].getLetra();
        }
        
        return todasFilas;
    }
    
    public String[] obtenerEspectaculos(){
        String[] todosEspectaculos = new String[espectaculos.size()];
        int t = 0;
        
        for (Espectaculo espectaculo : espectaculos) {
            todosEspectaculos[t] = espectaculo.toString();
            t++;
        }
        
        return todosEspectaculos;
    }
    
    private void cargarFilas(){
        for(int t=0;t<filas.length;t++){
            filas[t] = new Fila(obtenerLetra(t+1));
        }
    }
    
    public String[] obtenerAsientosLibres(String identificadorFila){
        Fila filaEncontrada = null;
        for (Fila fila : filas) {
            if(fila.getLetra().equals(identificadorFila)){
                filaEncontrada = fila;
            }
        }
        
        if(filaEncontrada!=null){
            return filaEncontrada.obtenerAsientosLibres();
        }
        
        return null;
    }
    
    public void asignarEspectaculo(Espectaculo esp){
        espectaculos.add(esp);
    }
    
    public void retirarEspectaculos(Espectaculo esp){
        espectaculos.remove(esp);
    }
    
    private String obtenerLetra(int numero){
        switch (numero) {
            case 1 -> {
                return "A";
            }
            case 2 -> {
                return "B";
            }
            case 3 -> {
                return "C";
            }
            case 4 -> {
                return "D";
            }
            case 5 -> {
                return "E";
            }
            case 6 -> {
                return "F";
            }
            case 7 -> {
                return "G";
            }
            case 8 -> {
                return "H";
            }
            case 9 -> {
                return "I";
            }
            case 10 -> {
                return "J";
            }
            default -> throw new AssertionError();
        }
    }

    
}
