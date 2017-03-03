/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.cliente;

import com.azptec.controlciber.common.EntidadClienteListener;

/**
 *
 * @author sazpeitia
 */
public class ListenerConexion extends EntidadClienteListener {

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

    
    private boolean running;
    
    @Override
    public void run() {
        
        while ( isRunning() ) {
            
            if (getCliente() != null) {
                
                if ( !getCliente().isConectado() ){
                    System.out.println("Cliente. no conectado, intentando conectar...");
                    getCliente().iniciarConexion();
                } else {
                    System.out.println("Cliente conectado. Revisando si no esta rota la comunicación...");
                    if ( getCliente().isBrockenPipe() ) {
                        
                        System.out.println("Cliente roto, cerrar conexion...");
                        getCliente().cerrarConexion();
                    }
                }
                
                
            } else {
                
                System.out.println("Cliente nulo");
            }
            
            esperar(5000, "Cliente-> Esperando 5 segundos antes de volver a conectar...");
        }
    }
    
}
