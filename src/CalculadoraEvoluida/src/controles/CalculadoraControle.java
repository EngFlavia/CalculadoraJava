/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controles;

import javax.script.ScriptEngine;

/**
 *
 * @author Flavia Florentino
 */
import javax.script.*;

public class CalculadoraControle {
    
    ScriptEngine engine;
    
    public CalculadoraControle() {
        ScriptEngineManager  manager = new ScriptEngineManager();
        engine = manager.getEngineByName("JavaScript");
    }
    
    public String calcularOperacao(String equacaoTela) {     
        String cal =  equacaoTela;
        
        cal = AvaliaRaiz(cal);
        System.out.println(cal);
               
        try {
            Object teste = engine.eval(cal);
            return (String.valueOf(teste));
        } catch (Exception e) {
            return ("ERRO");
        }
    }
    
    private String AvaliaRaiz(String equacao){            
        int index = equacao.indexOf("√");
        
        if (index != -1 ){
            String inicio = equacao.substring(0, index).toString();
            String resto = equacao.substring(index + 1, equacao.length()).toString();
            
            System.out.println(inicio + " " + resto);
            
            int indexSoma = resto.indexOf("+");
            if(indexSoma != -1){
                System.out.println(indexSoma);
                String meio = resto.substring(0, indexSoma).toString();
                resto = resto.substring(indexSoma, resto.length()).toString();
               
                System.out.println(inicio + " " + meio + " " + resto); 
                equacao = inicio + "Math.pow(" + meio + ",0.5)" + resto;        
                System.out.println(equacao.substring(equacao.length()));//pega o ultimo caracter
            }
            else {
             equacao = equacao.replace("√", "Math.pow(") +  ", 0.5)";
            }
                      
        }        
        
        //equacao = "Math.pow((2+2), 0.5)";
        return equacao;
        
    }
}
