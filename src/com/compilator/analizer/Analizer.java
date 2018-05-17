/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.analizer;

import com.compilator.objects.Object;
import com.compilator.objects.ObjectClass;
import com.compilator.objects.ObjectFunction;
import com.sun.xml.internal.ws.util.StringUtils;

/**
 *
 * @author jmendieta
 */
public class Analizer implements AnalizerConstants{
    Object generalScope ;
    Object currentScope = null;
    public void analizeWord(String word) throws Exception{
        if(currentScope != null){
            if(structuresName.contains(word)){
                if(word.equals("function")){
                    ((ObjectClass) currentScope).addfunction(new ObjectFunction());
                }else{
                    throw new Exception("Error al asignar un objeto a la clase");
                }
            }else{
                if(currentScope.getName() == null){
                    System.out.println("print "+word);
                    currentScope.setName(word);
                }
            }
        }else if(structuresName.contains(word)){
            switch(StringUtils.capitalize(word)){
                case "Class":
                    this.currentScope = new ObjectClass();
                break;
                case "Function":
                    this.currentScope = new ObjectFunction();
                break;
                default:
                    throw new Error("Inconpatible object");
            }
        }	
    }	
}
