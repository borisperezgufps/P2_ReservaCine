/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.reserva.controlador;

import javax.swing.DefaultComboBoxModel;
import p2.reserva.modelo.Cine;
import p2.reserva.vista.ReservaVista;

/**
 *
 * @author ing
 */
public class ReservaControlador {
    private ReservaVista vista;
    private Cine cine;

    public ReservaControlador(ReservaVista vista) {
        this.vista = vista;
        cine = new Cine();
        
        cargarSalas();
    }
    
    private void cargarSalas(){
        // Se obtiene la lista de salas del cine
        String[] salas = cine.obtenerSalas();
        
        // Se llena el combo de salas con la lista que se obtuvo del modelo
        if(salas!=null){
            DefaultComboBoxModel<String> modeloSalas = (DefaultComboBoxModel<String>)vista.getCmbSalas().getModel();
            for (String sala : salas) {
                modeloSalas.addElement(sala);
            }
        }
    }

    public void obtenerDatosSala() {
        
        String identificadorSala = vista.getCmbSalas().getSelectedItem().toString();
        String[] espectaculos = cine.obtenerEspectaculosSala(identificadorSala);
        String[] filas = cine.obtenerFilasSala(identificadorSala);
        
        System.out.println(espectaculos.length);
        
        if(espectaculos!=null){
            DefaultComboBoxModel<String> modeloEspectaculos = (DefaultComboBoxModel<String>)vista.getCmbEspectaculos().getModel();
            modeloEspectaculos.removeAllElements();
            for (String espectaculo : espectaculos) {
                modeloEspectaculos.addElement(espectaculo);
            }
        }
        
        if(filas!=null){
            DefaultComboBoxModel<String> modeloFilas = (DefaultComboBoxModel<String>)vista.getCmbFilas().getModel();
            modeloFilas.removeAllElements();
            for (String fila : filas) {
                modeloFilas.addElement(fila);
            }
        }
        
        vista.getCmbEspectaculos().setEnabled(true);
        vista.getCmbFilas().setEnabled(true);
        
    }

    public void listarAsientosLibres() {
        
        String identificadorSala = vista.getCmbSalas().getSelectedItem().toString();
        String identificadorFila = vista.getCmbFilas().getSelectedItem().toString();
        
        String[] asientosLibres = cine.obtenerAsientosLibres(identificadorSala, identificadorFila);
        if(asientosLibres!=null){
            DefaultComboBoxModel<String> modeloAsientos = (DefaultComboBoxModel<String>)vista.getCmbAsientos().getModel();
            modeloAsientos.removeAllElements();
            for (String asiento : asientosLibres) {
                modeloAsientos.addElement(asiento);
            }
        }
    }

    public void reservar() {
        String identificadorSala = vista.getCmbSalas().getSelectedItem().toString();
        String identificadorFila = vista.getCmbFilas().getSelectedItem().toString();
        String identificadorAsiento = vista.getCmbAsientos().getSelectedItem().toString();
        String espectaculoSeleccionado = vista.getCmbEspectaculos().getSelectedItem().toString();
        String celular = vista.getTxtCelular().getText();
        
        try{
            cine.reservar(identificadorSala, identificadorFila, identificadorAsiento, espectaculoSeleccionado, celular);
            listarAsientosLibres();
            vista.getLblResultado().setText("Resultado: OK");
        }catch(Exception e){
            vista.getLblResultado().setText("Resultado: "+e.getMessage());
        }
        
        
    }
    
    private void refrescarAsientosLibres(){
        
    }
    
    
    
}
