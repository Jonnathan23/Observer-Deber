/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observador;

import com.mycompany.saquicelaj_villae_observer.SujetoBateria;

/**
 *
 * @author Jonna
 */
public class ObservadorDescarga extends Observer{
    public ObservadorDescarga(SujetoBateria sujeto) {
        this.sujeto = sujeto;
        this.sujeto.agregarObservador(this);
    }


    @Override
    public void actualizar() {
        this.sujeto.setEstadoEnCarga(false);
    }
}
