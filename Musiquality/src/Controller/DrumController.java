/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Exceptions.ModelException;
import Exceptions.SystemException;
import Main.Util;
import Model.Model.Levada;
import Model.Model.Notas;
import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JLabel;

/**
 *
 * @author Usuário
 */
public class DrumController{
    private Notas bateria;
    public Levada[] levada;
    public DrumController(){
        try {
            bateria=new Notas(Util.DRUM);
        } catch (ModelException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
        levada=new Levada[10];
        for(int i=0;i<levada.length;i++)
            levada[i]=new Levada(bateria);
    }
    
    public String[] getNomes(){
        return bateria.getNomes();
    }

    public int getQtd() {
        return bateria.getQtd();
    }


    public String switchNota(int selec, String text, int j) {
        String returnString = "";
        try {
            returnString = levada[selec].switchNota(text, j);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
      return returnString;
    }

    public String removeNota(int selec, String nome, int t) {
        System.out.print("Remove");
        String returnString = "";
        try {
            returnString = levada[selec].removeNota(selec, nome);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ModelException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return returnString;
    }

    public int load(int l,JLabel[] notes, JLabel[][] tempo,Color bg, Color selected) {
        for(int i=0;i<tempo.length;i++){
            String nome=notes[i].getText();
            for(int j=0;j<tempo[i].length;j++){
                if(j>=levada[l].getTamanho())
                    tempo[i][j].setBackground(Color.BLACK);
                else{
                    if(levada[l].contains(nome, j))
                        tempo[i][j].setBackground(selected);
                    else
                        tempo[i][j].setBackground(bg);
                    }
                }
        }
        return levada[l].getTamanho();
    }

    public void setMaxTempo(int selec, int maxTempos) {
        try {
            levada[selec].setTamanhoMax(maxTempos+1);
        } catch (SystemException ex) {
            Logger.getLogger(DrumController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
}
