/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import com.mycompany.saquicelaj_villae_observer.SujetoBateria;
import com.mycompany.saquicelaj_villae_observer.VentanaPrincipal;
//import java.awt.Label;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Jonna
 */
public class HilosCargar extends Thread {

    VentanaPrincipal vt = new VentanaPrincipal();
    boolean ejecutar = vt.getEstadoBateria();
    SujetoBateria sjBateria = vt.getBateria();
    int bateria = vt.getPorcentajeBateria();
    JLabel reloj = vt.getLbReloj();

    String frase = "";
    int minutos = 0;
    int segundos = 0;

    @Override
    public void run() {
        try {
            while (ejecutar) {

                Thread.sleep(250);
                segundos += 1;

                if (segundos == 60) {
                    minutos += 1;
                    segundos = 0;
                    if (bateria < 100) {
                        if (bateria == 99) {
                            bateria += 1;
                        } else {
                            bateria += 2;
                        }

                        sjBateria.setPorcentajeBateria(bateria);
                    }

                }
                frase = " " + minutos + " : " + segundos;
                reloj.setText(frase);

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosCargar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
