/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.cliente;

import com.azptec.controlciber.common.EntidadCliente;
import com.azptec.controlciber.common.EntidadSocketListener;
import javax.swing.JFrame;

/**
 *
 * @author sazpeitia
 */
public class ListenerBloqueo extends EntidadSocketListener {

    

    private JFrame ventana;
    private EntidadCliente cliente;
    private boolean running;
    private String estadoCliente;

    @Override
    public void run() {

        while (isRunning()) {
            if (  !cliente.isConectado()) {

                System.out.println("No visible...");
                ventana.setVisible(false);
            }

            if (cliente.isConectado()) {

                System.out.println("Visible...");
                ventana.setVisible(true);

                if (cliente.getMensajeEntrada().equals("UNLOCK")) {

                    System.out.println("No visible...");
                    ventana.setVisible(false);
                }
            }

            enfrenteSiempre();
            
            
 
            esperar(50, "Thread: " + Thread.currentThread().getName() + " Bloquear Cliente Listener");
        }
    }

    public void enfrenteSiempre() {

        //getVentana().setExtendedState(JFrame.MAXIMIZED_BOTH);
        // getVentana().toFront();
    }

    /**
     * @return the ventana
     */
    public JFrame getVentana() {
        return ventana;
    }

    /**
     * @param ventana the ventana to set
     */
    public void setVentana(JFrame ventana) {
        this.ventana = ventana;
    }

    /**
     * @return the cliente
     */
    public EntidadCliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(EntidadCliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the running
     */
    public boolean isRunning() {
        return running;
    }

    /**
     * @param running the running to set
     */
    public void setRunning(boolean running) {
        this.running = running;
    }
    
    /**
     * @return the estadoCliente
     */
    public String getEstadoCliente() {
        return estadoCliente;
    }

    /**
     * @param estadoCliente the estadoCliente to set
     */
    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
}
