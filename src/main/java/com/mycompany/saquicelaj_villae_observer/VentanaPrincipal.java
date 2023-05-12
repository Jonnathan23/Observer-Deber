/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.saquicelaj_villae_observer;

import Hilos.HilosCargar;
import Hilos.HilosDescargar;
import Observador.ObservadorCarga;
import Observador.ObservadorDescarga;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Jonna; Erika Gil
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    /* ----------- PRINCIPAL -------------*/
    static SujetoBateria bateria;// = new SujetoBateria();
    static HilosCargar hiloCarga ;
    static HilosDescargar hiloDescarga;
    

    static ObservadorDescarga obDescarga;
    static int cantidad;
    static ObservadorCarga obCarga; //= new ObservadorCarga(bateria);

    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btCargar = new javax.swing.JButton();
        btDesconectar = new javax.swing.JButton();
        btDescargar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtBateria = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btCargar.setText("Cargar");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });

        btDesconectar.setText("Desconectar");
        btDesconectar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDesconectarActionPerformed(evt);
            }
        });

        btDescargar.setText("Descargar");

        jLabel1.setText("Bateria");

        jLabel2.setText("%");

        jLabel3.setText("Tiempo");

        lbReloj.setText("00:00");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(txtBateria, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCargar, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(lbReloj, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btDesconectar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btDescargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(79, 79, 79))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCargar)
                    .addComponent(jLabel1)
                    .addComponent(txtBateria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btDesconectar)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(lbReloj)))
                .addGap(31, 31, 31)
                .addComponent(btDescargar)
                .addContainerGap(243, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        System.out.println("Clic");

        if (bateria.isEstadoEnCarga() == false) {
            System.out.println("Entro");
            bateria.setPorcentajeBateria(Integer.valueOf(this.txtBateria.getText()));
            System.out.println("Bateria: " + bateria.getPorcentajeBateria());

            System.out.println("Sujeto: " + obCarga);
            obCarga.actualizar();

            hiloCarga.start();
            hiloDescarga.stop();

        }


    }//GEN-LAST:event_btCargarActionPerformed

    private void btDesconectarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDesconectarActionPerformed
        if (bateria.isEstadoEnCarga()) {
            System.out.println("Entro");
            System.out.println("Bateria: " + bateria.getPorcentajeBateria());
            System.out.println("Sujeto: " + obCarga);
            obDescarga.actualizar();

            hiloDescarga.start();
            hiloCarga.stop();

        }
    }//GEN-LAST:event_btDesconectarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        bateria = new SujetoBateria();
        hiloCarga = new HilosCargar();
        hiloDescarga = new HilosDescargar();
        obCarga = new ObservadorCarga(bateria);

        //bateria.setPorcentajeBateria();
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);

            }
        });
    }
/**/
    public static SujetoBateria getBateria() {
        return bateria;
    }

    public static void setBateria(SujetoBateria bateria) {
        VentanaPrincipal.bateria = bateria;
    }

    public static HilosCargar getHiloCarga() {
        return hiloCarga;
    }

    public static void setHiloCarga(HilosCargar hiloCarga) {
        VentanaPrincipal.hiloCarga = hiloCarga;
    }

    public static HilosDescargar getHiloDescarga() {
        return hiloDescarga;
    }

    public static void setHiloDescarga(HilosDescargar hiloDescarga) {
        VentanaPrincipal.hiloDescarga = hiloDescarga;
    }

    public static ObservadorDescarga getObDescarga() {
        return obDescarga;
    }

    public static void setObDescarga(ObservadorDescarga obDescarga) {
        VentanaPrincipal.obDescarga = obDescarga;
    }

    public static int getCantidad() {
        return cantidad;
    }

    public static void setCantidad(int cantidad) {
        VentanaPrincipal.cantidad = cantidad;
    }

    /* -- */
    public static void setObCarga(ObservadorCarga obCarga) {
        VentanaPrincipal.obCarga = obCarga;
    }

    public JButton getBtCargar() {
        return btCargar;
    }

    public void setBtCargar(JButton btCargar) {
        this.btCargar = btCargar;
    }

    public JButton getBtDescargar() {
        return btDescargar;
    }

    public void setBtDescargar(JButton btDescargar) {
        this.btDescargar = btDescargar;
    }

    public JButton getBtDesconectar() {
        return btDesconectar;
    }

    public void setBtDesconectar(JButton btDesconectar) {
        this.btDesconectar = btDesconectar;
    }

    public JLabel getLbReloj() {
        return lbReloj;
    }

    public void setLbReloj(JLabel lbReloj) {
        this.lbReloj = lbReloj;
    }

    public JTextField getTxtBateria() {
        return txtBateria;
    }

    public void setTxtBateria(JTextField txtBateria) {
        this.txtBateria = txtBateria;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btDescargar;
    private javax.swing.JButton btDesconectar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lbReloj;
    private javax.swing.JTextField txtBateria;
    // End of variables declaration//GEN-END:variables
}
