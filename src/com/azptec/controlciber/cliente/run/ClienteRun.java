/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.azptec.controlciber.cliente.run;

import com.azptec.controlciber.cliente.ListenerBloqueo;
import com.azptec.controlciber.cliente.BloquearJFrame;
import com.azptec.controlciber.cliente.ListenerConexion;
import com.azptec.controlciber.common.EntidadCliente;
import com.azptec.controlciber.common.EntidadClienteListener;
import com.azptec.controlciber.common.EntidadClienteListenerMensajes;

/**
 *
 * @author sazpeitia
 */
public class ClienteRun {

    public static void main(String[] args) {

        EntidadCliente cliente = new EntidadCliente();
        cliente.setHost("samy-latitud");
        cliente.setPort(42001);
        cliente.setIdEntidad(1);

        ListenerConexion listenerConexion = new ListenerConexion();
        listenerConexion.setCliente(cliente);
        listenerConexion.setRunning(true);

        Thread hiloListenerConexion = new Thread(listenerConexion);
        hiloListenerConexion.start();
    }
}
