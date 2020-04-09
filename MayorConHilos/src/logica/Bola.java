/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiantes
 */
public class Bola extends Thread{
    private boolean moviendose;
    private int x, y, r;
    private int limX, limY;
    private int incX, incY;

    public Bola() {
    
        moviendose = true;
        r = 10;
        limX = 50;
        limY = 60;
        incX = 1;
        incY = 1;
        x = (int) Math.floor(Math.random()* 30 + 1);
        y = (int) Math.floor(Math.random()* 40 + 1);
    }

    public boolean isMoviendose() {
        return moviendose;
    }

    public void setMoviendose(boolean moviendose) {
        this.moviendose = moviendose;
    }

    public int getLimX() {
        return limX;
    }

    public void setLimX(int limX) {
        this.limX = limX;
    }

    public int getLimY() {
        return limY;
    }

    public void setLimY(int limY) {
        this.limY = limY;
    }            

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    @Override
    public void run() {
        while(moviendose){
            x += incX;
            y += incY;
            if(x > limX || x < 0){
                incX *= -1;
            }
            if(y > limY || y < 0){
                incY *= -1;
            }        
            try {
                Thread.sleep(50);
            } catch (InterruptedException ex) {
            }
        }
    }
    
    
}
