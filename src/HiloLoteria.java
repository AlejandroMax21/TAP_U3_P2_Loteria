
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author alejo
 */
public class HiloLoteria extends Thread{
    
    private int num,nueva,con=0;
    private ImageIcon icono;
    private boolean estaVivo=true,nuevo;
    private int[] repetidas = new int[54];
    private Ventana v;
    
    public HiloLoteria(Ventana v){
        this.v=v;
    }
    public void run(){
        while(con<54){
            num=(int)(Math.random()*54+1);
            nueva=CartaNueva(num);
            repetidas[con]=nueva;
            con++;
            icono=new ImageIcon(getClass().getResource("/cartas separadas/"+nueva+".png"));
            v.jLabel1.setIcon(icono);
            System.out.println(nueva);
            try {
                sleep(5000);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloLoteria.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    public int CartaNueva(int num){
        nueva=num;
        for(int i =0;i<con;i++){
            if(repetidas[i]==nueva){
                nueva=(int)(Math.random()*54+1);
                i=0;
            }
        }
        return nueva;
    }
    public boolean vive(){
        return estaVivo;
    }
}
