/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.reserva.modelo;

/**
 *
 * @author ing
 */
public class Fila {

    private Asiento[] asientos;
    private String letra;

    public Fila(String letra) {
        this(20, letra);
    }

    public Fila(int cantidadAsientos, String letra) {
        asientos = new Asiento[cantidadAsientos];
        this.letra = letra;
        cargarAsientos();
    }

    private void cargarAsientos() {
        for (int t = 0; t < asientos.length; t++) {
            asientos[t] = new Asiento(t + 1);
        }
    }

    public boolean validarAsientoDisponible(int numero) {
        if (asientos[numero] != null) {
            return asientos[numero].isDisponible();
        }
        return false;
    }

    public void reservarAsiento(int numero) {
        if (asientos[numero] != null) {
            asientos[numero].setDisponible(false);
        }
    }

    public String getLetra() {
        return letra;
    }

    String[] obtenerAsientosLibres() {
        int totalAsientosLibres = 0;

        for (Asiento asiento : asientos) {
            if (asiento.isDisponible()) {
                totalAsientosLibres++;
            }
        }

        if (totalAsientosLibres > 0) {
            int t = 0;
            String[] asientosLibres = new String[totalAsientosLibres];
            for (Asiento asiento : asientos) {
                if (asiento.isDisponible()) {
                    asientosLibres[t] = String.valueOf(asiento.getNumero());
                    t++;
                }
            }
            return asientosLibres;
        }

        return null;
    }

    Asiento obtenerAsiento(String numeroAsiento) {
        
        int intNumeroAsiento = Integer.parseInt(numeroAsiento);
        
        for (Asiento asiento : asientos) {
            if (asiento.getNumero()==intNumeroAsiento) {
                return asiento;
            }
        }
        
        return null;
    }

}
