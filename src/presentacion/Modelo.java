package presentacion;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.NoCeroException;
import logica.Sistema;

public class Modelo implements Runnable {

    private Thread hiloDibujo = new Thread();    
    private VistaPrincipal ventanaPrincipal;
    private Sistema miSistema;
    private boolean corriendo;
    private BufferedImage dobleBuffer;

    public Modelo() {
        corriendo = true;
        dobleBuffer = new BufferedImage(getVentanaPrincipal().getLienzo().getWidth(), getVentanaPrincipal().getLienzo().getHeight(), BufferedImage.TYPE_INT_ARGB);        
        hiloDibujo = new Thread(this);
    }
    
    

    public void iniciar() {
        getVentanaPrincipal().setSize(560, 200);
        getVentanaPrincipal().setVisible(true);
        hiloDibujo.start();
    }

    public void calcular() {

        int n1, n2, r;

        try {
            n1 = Integer.parseInt(getVentanaPrincipal().getTxtNum1().getText());
            n2 = Integer.parseInt(getVentanaPrincipal().getTxtNum2().getText());

            getMiSistema().setN1(n1);
            getMiSistema().setN2(n2);

            r = getMiSistema().hallarMayor();           
            
            getVentanaPrincipal().getLblResultado().setText("El numero mayor de estos digitados es " + r);
        } catch (java.lang.NumberFormatException ex) {
            getVentanaPrincipal().getLblResultado().setText("Error el introducir los datos " + ex.getMessage());
        } catch (NoCeroException ex) {
            getVentanaPrincipal().getLblResultado().setText("No debe ser 0 " + ex.getMessage());
        }
        
    }

    public void dibujar() {
       int n1, n2;
       
       Canvas lienzo = ventanaPrincipal.getLienzo();
       Graphics lapiz = dobleBuffer.getGraphics();
       
       lapiz.setColor(Color.white);
       lapiz.fillRect(0, 0, lienzo.getWidth(), lienzo.getHeight());
       
       lapiz.setColor(Color.PINK);
        for (int i = 0; i < getMiSistema().getCantidadBolitas(); i++) {
            lapiz.fillOval(getMiSistema().getBolita(i).getX(), getMiSistema().getBolita(i).getY(), getMiSistema().getBolita(i).getR(), getMiSistema().getBolita(i).getR());
        }
       
       
       try {
            n1 = Integer.parseInt(getVentanaPrincipal().getTxtNum1().getText());
            n2 = Integer.parseInt(getVentanaPrincipal().getTxtNum2().getText());
            
            lapiz.setColor(Color.red);
            lapiz.fillRect(0, 5, n1, 25);
            lapiz.setColor(Color.blue);
            lapiz.fillRect(0, 35, n2, 25);
            
                      
        } catch (java.lang.NumberFormatException ex) {
            
        } 
       Graphics lapizCanvas = lienzo.getGraphics();
       lapizCanvas.drawImage(dobleBuffer, 0, 0, lienzo);
    }

    @Override
    public void run() {
        while(corriendo){
            dibujar();
        }
    }

    public VistaPrincipal getVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new VistaPrincipal(this);
        }
        return ventanaPrincipal;
    }

    public Sistema getMiSistema() {
        if (miSistema == null) {
            miSistema = new Sistema();
        }
        return miSistema;
    }

}
