/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Persistencia;

import Exceptions.ModelException;
import Model.Model.Nota;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuário
 */

/*
Classe responsável por salvar e carregar os dados. É feita em forma de Singleton
*/
public class Persistencia{
    private static Persistencia persist;
    //URL onde serão salvos dados de configuração do programa. Isso inclui 
    //os nomes dos arquivos e das notas referentes a cada um dos instrumentos,
    //assim como as músicas criadas e similares.
    private final String urlCfg;
    private Scanner input;//Responsável pela leitura de arquivos
    private LinkedList<Nota> aux; //Salva as notas durante a leitura
    
    private Nota[] bateria;
    private Nota[] baixo;
    private Nota[] guitarra1;
    private Nota[] guitarra2;
    
    
    private Persistencia(){
        this.urlCfg="src/Model/Persistencia/config.txt";
        String separator="\\s*,\\s*";
        String lineSeparator="\\s*"+System.getProperty("line.separator");
        
        try {
            input=new Scanner(Paths.get(urlCfg));
            input.useDelimiter(separator+"|"+lineSeparator);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível abrir o arquivo!");
        }
        aux=new LinkedList();
        this.setNotas();
    }
    
    public static Persistencia getPersistencia(){
        if(persist==null)
            persist=new Persistencia();
        return persist;
    }
    
    /*
    Funções relacionadas à persistência de dados deverão ser implementadas
    */
    
    public Nota[] getBateria(){return bateria;}    
    public Nota[] getBaixo(){return baixo;}    
    public Nota[] getGuitarra1(){return guitarra1;}    
    public Nota[] getGuitarra2(){return guitarra2;}    

        
    private void setNotas() {
        while (input.hasNext()){
            String token=input.next();
            switch(token){
                case "Bateria":
                    this.setNotasBateria();
                    break;
                case "Guitarra 1":
                    this.setNotasG1();
                    break;
                case "Guitarra 2":
                    this.setNotasG2();
                    break;
                case "Baixo":
                    this.setNotasBass();
                    break;
                default:
//                    System.out.println(token+"\t"+(";".equals(token)));
            }
        }
            }
    private void setNotasBateria(){
        aux.clear();
        String token=input.next();
   
        while(!";".equals(token)){
            String nome=token;
            token=input.next();
            String url=token;
            Nota n;
            try {
                n = new Nota(nome,url);
                aux.add(n);
            } catch (ModelException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            

            token=input.next();
        }
        bateria=new Nota[aux.size()];
        aux.toArray(bateria);
        
    }
    private void setNotasG1(){
        aux.clear();
        String token=input.next();
   
        while(!";".equals(token)){
            String nome=token;
            token=input.next();
            String url=token;
            Nota n;
            try {
                n = new Nota(nome,url);
                aux.add(n);
            } catch (ModelException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            token=input.next();
        }
        guitarra1=new Nota[aux.size()];
        aux.toArray(guitarra1);
    }
    private void setNotasG2(){
        aux.clear();
        String token=input.next();
        int i = 0;
        while(!";".equals(token)){
            String nome=token;
            token=input.next();
            String url=token;
            Nota n;
            try {
                n = new Nota(nome,url);
                aux.add(n);
            } catch (ModelException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            token=input.next();
        }
        guitarra2=new Nota[aux.size()];
        aux.toArray(guitarra2);
    }
    private void setNotasBass(){
        aux.clear();
        String token=input.next();
  
        while(!";".equals(token)){
            String nome=token;
            token=input.next();
            String url=token;
            Nota n;
            try {
                n = new Nota(nome,url);
                aux.add(n);
            } catch (ModelException ex) {
                Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            token=input.next();
        }
        baixo=new Nota[aux.size()];
        aux.toArray(baixo);
    }
}
