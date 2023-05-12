/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.saquicelaj_villae_observer;

import Observador.Observer;
import java.util.ArrayList;

/**
 *
 * @author Jonna
 */
public class SujetoBateria extends SujetoAbstract{
    private ArrayList<Observer> observadoresLista = new ArrayList<>();
    private boolean estadoEnCarga = false;
    private int porcentajeBateria = 0;
    
   
    public void agregarObservador(Observer observadorAgregar) {
       observadoresLista.add(observadorAgregar); 
    }
    
    @Override
    public void notificarObservadores() {
        for (Observer ob : observadoresLista) {
            ob.actualizar();            
        }
    }

    public boolean isEstadoEnCarga() {
        return estadoEnCarga;
    }

    public void setEstadoEnCarga(boolean estadoEnCarga) {
        this.estadoEnCarga = estadoEnCarga;
    }

   
    public int getPorcentajeBateria() {
        return porcentajeBateria;
    }

    public void setPorcentajeBateria(int porcentajeBateria) {
        this.porcentajeBateria = porcentajeBateria;
    }

    
}
