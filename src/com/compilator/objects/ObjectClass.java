/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.objects;

import java.util.ArrayList;

/**
 *
 * @author jmendieta
 */
public class ObjectClass implements Object {
    private String name;
    private ArrayList<ObjectFunction> functions = null;
    
    public ObjectClass addfunction(ObjectFunction function) throws Exception{
        if(functions != null){
            if(functions.size() > 0){
               if(functions.get(functions.size()-1).end())
                   functions.add(function);
                else
                   throw new Exception("Error de sintaxis en la definicion de la funcion");
            }else functions.add(function);
        }else{
            functions = new ArrayList();
            functions.add(function);
        }
        return this;
    }
    
    @Override
    public Object setName(String name) {
        this.name = new String(name);
        return this;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void build() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean end() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
}
