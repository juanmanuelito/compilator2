/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.compilator.generator;

import java.util.Arrays;
import java.util.List;
import org.omg.IOP.CodecOperations;

/**
 *
 * @author jmendieta
 */
public interface CodeConstants {
	final List<List<String>> type = Arrays.asList(
		Arrays.asList("add","replace"),
		Arrays.asList("add"),Arrays.asList("replace"),Arrays.asList("replace")
	);
	final List<String> target = Arrays.asList(
		"(if\\s*\\(.*?\\))(?:\\s*\\n*.*?\\s*)(end)",
		"((private|public|)\\s*)(int|string|bool|float)(.*)",
		"string","bool"	
	);
	final List<List<String>> remplacement = Arrays.asList(
		Arrays.asList("{","}"),
		Arrays.asList(";"),
		Arrays.asList("String"),
		Arrays.asList("boolean")
	);
}
