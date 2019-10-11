/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Model.Notas;
import Model.Model.NotasBateria;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Usuário
 */
public class DrumTab {
    private JPanel mainTab,top,bot;
    private JPanel auxTop1,auxTop2; 
    private JPanel auxBot1,auxBot2;
    private JPanel auxBot21;
    private JCheckBox[][] rhythms;
    private JButton[] rhythmList;
    private JCheckBox[][] tempo;
    private JLabel[] notes, nTempo;
    private Notas n;
    
    public DrumTab(){
        n=new NotasBateria();
        this.iniialize();
    }

    private void iniialize() {
        this.initializeComponents();
        mainTab.setLayout(new GridLayout(2,1));
        this.iniializeTop();
        
        this.iniializeBot();
        
       mainTab.add(top);
       mainTab.add(bot);
    }

    JPanel get() {
        return mainTab;
    }

    private void iniializeTop() {
        top.setLayout(new BorderLayout());
        
        auxTop1 = new JPanel();
        auxTop1.setLayout(new GridLayout(10,1));
        
        rhythms = new JCheckBox[10][50];
        
        auxTop2 = new JPanel();
        auxTop2.setLayout(new GridLayout(rhythms.length,rhythms[0].length));
        
        rhythmList = new JButton[10];
        for(int i=0;i<rhythms.length;i++){
            for(int j=0;j<rhythms[i].length;j++){
                rhythms[i][j] = new JCheckBox();
                auxTop2.add(rhythms[i][j]);
            }
            rhythmList[i] = new JButton("Ritmo " + (i+1));
            auxTop1.add(rhythmList[i]);
        }
        top.add(auxTop1,BorderLayout.WEST);
        top.add(auxTop2,BorderLayout.CENTER);
        
    }

    private void iniializeBot() {
       bot.setLayout(new GridLayout(10,17));
       double p=0;
       nTempo[0]=new JLabel();
       for(int i = 1;i<nTempo.length;i++,p+=0.25)
            nTempo[i]=new JLabel(String.valueOf(p));
       
           
       for(int i=0;i<17;i++)
           bot.add(nTempo[i]);
       
       
       
       for(int i = 0;i<9;i++){
           notes[i]=new JLabel("Nota "+ i);
           bot.add(notes[i]);
           for(int j=0;j<16;j++){
               tempo[i][j]=new JCheckBox();
               bot.add(tempo[i][j]);
           }
       }
       
       
    }

    private void initializeComponents() {
        mainTab = new JPanel();
        top=new JPanel();
        bot=new JPanel();
        auxBot1=new JPanel();
        auxBot2=new JPanel();
        auxBot21=new JPanel();
        nTempo=new JLabel[17];
       //tempo=new JCheckBox[n.getQtd()][16];
        tempo=new JCheckBox[9][16];
        //notes=new JLabel[n.getQtd()];
        notes=new JLabel[9];
        
    }
}