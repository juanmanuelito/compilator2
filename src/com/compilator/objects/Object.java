/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.objects;

/**
 *
 * @author jmendieta
 */
public interface Object {
    String name = null;
    public Object setName(String name);
    public String getName();
    public void build();
    public boolean end();   
}
