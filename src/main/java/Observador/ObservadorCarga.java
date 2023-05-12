/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observador;

import Hilos.HilosCargar;
import com.mycompany.saquicelaj_villae_observer.SujetoBateria;

/**
 *
 * @author Jonna
 */
public class ObservadorCarga extends Observer {

    public ObservadorCarga(SujetoBateria sujeto) {
        this.sujeto = sujeto;
        this.sujeto.agregarObservador(this);
    }


    @Override
    public void actualizar() {
        this.sujeto.setEstadoEnCarga(true);
    }

   
    
    

}
