/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hilos;

import com.mycompany.saquicelaj_villae_observer.SujetoBateria;
import com.mycompany.saquicelaj_villae_observer.VentanaPrincipal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Jonna
 */
public class HilosDescargar extends Thread{
    
    VentanaPrincipal vt = new VentanaPrincipal();
    boolean ejecutar;
    SujetoBateria sjBateria = vt.getBateria();
    int bateria;
    JLabel reloj = vt.getLbReloj();

    String frase = "";
    int minutos = 0;
    int segundos = 0;
    
    @Override
    public void run() {
        System.out.println("Run");
        
        ejecutar = sjBateria.isEstadoEnCarga();
        bateria = sjBateria.getPorcentajeBateria();
        System.out.println("Ejecutar en hilos: " + ejecutar);
       
        try {
            while (ejecutar == false) {

                Thread.sleep(250);
                segundos += 1;

                if (segundos == 60) {
                    minutos += 1;
                    segundos = 0;
                    if (bateria > 0) {
                        if (bateria == 1) {
                            bateria -= 1;
                        } else {
                            bateria -= 2;
                        }

                        sjBateria.setPorcentajeBateria(bateria);
                    }

                }
                frase = "Bateria: "+ bateria + minutos + " : " + segundos;
                System.out.println(frase);
                reloj.setText(frase);
                ejecutar = sjBateria.isEstadoEnCarga();

            }
        } catch (InterruptedException ex) {
            Logger.getLogger(HilosCargar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
