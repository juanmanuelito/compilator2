/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.analizer;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jmendieta
 */
public interface AnalizerConstants {
	final List<String> structuresName = Arrays.asList("Class","function","if","while");
	final List<String> structures = Arrays.asList("if","while","else");
	final List<String> logical = Arrays.asList("<",">","&&","||","==");
	final List<String> sentences = Arrays.asList("=","new");
	final List<String> def = Arrays.asList("var");
	final String structuresEnd ="end";
}
