
package logica;

public class Sistema {
    private int n1, n2;
    private Bola bolita[];
    private int cantidadBolitas;

    public Sistema() {
        cantidadBolitas = 8;
        bolita = new Bola[cantidadBolitas];
        for (int i = 0; i < bolita.length; i++) {
            bolita[i] = new Bola();
            bolita[i].start();
        }
        
    }    

    public Bola[] getBolita() {
        return bolita;
    }

    public int getCantidadBolitas() {
        return cantidadBolitas;
    }
    
    public Bola getBolita(int i) {
        return bolita[i];
    }       

    public int getN1() {
        return n1;
    }

    public void setN1(int n1) {
        this.n1 = n1;
    }

    public int getN2() {
        return n2;
    }

    public void setN2(int n2) throws NoCeroException{
        if(n2 == 0){
            throw new NoCeroException("No es válido digitar un 0");
        }
        this.n2 = n2;
    }
    
    public int hallarMayor(){
        if(n1 > n2){
            return n1;
        }else{
            if(n2>n1){
                return n2;
            }
            else{
                return n2;
            }
        }
    }
    
}
