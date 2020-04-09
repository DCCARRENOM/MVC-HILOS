/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.Canvas;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Estudiantes
 */
public class VistaPrincipal extends javax.swing.JFrame {

    private Controlador control;
    private Modelo modelo;
        
    public VistaPrincipal(Modelo m) {
        modelo = m;
        initComponents();
        capturarEventos();
    }

    public Controlador getControl() {
        if(control == null){
            control = new Controlador(this);
        }
        return control;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public JLabel getLblResultado() {
        return lblResultado;
    }

    public JTextField getTxtNum1() {
        return txtNum1;
    }

    public JTextField getTxtNum2() {
        return txtNum2;
    }

    public Canvas getLienzo() {
        return lienzo;
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNum2 = new javax.swing.JTextField();
        txtNum1 = new javax.swing.JTextField();
        btnMayor = new javax.swing.JButton();
        lblResultado = new javax.swing.JLabel();
        lienzo = new java.awt.Canvas();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Número 2:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 50, 60, 20);

        jLabel2.setText("Número 1:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 20, 60, 20);
        getContentPane().add(txtNum2);
        txtNum2.setBounds(80, 50, 110, 20);
        getContentPane().add(txtNum1);
        txtNum1.setBounds(80, 20, 110, 20);

        btnMayor.setText("Mayor");
        getContentPane().add(btnMayor);
        btnMayor.setBounds(210, 20, 80, 50);
        getContentPane().add(lblResultado);
        lblResultado.setBounds(10, 90, 280, 30);
        getContentPane().add(lienzo);
        lienzo.setBounds(310, 20, 170, 130);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMayor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblResultado;
    private java.awt.Canvas lienzo;
    private javax.swing.JTextField txtNum1;
    private javax.swing.JTextField txtNum2;
    // End of variables declaration//GEN-END:variables

    private void capturarEventos() {
        btnMayor.addActionListener(getControl());        
    }
    
}
