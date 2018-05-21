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
		Arrays.asList("addEnd","replace"),
		Arrays.asList("addEnd"),Arrays.asList("addEnd"),Arrays.asList("replace"),
		Arrays.asList("replace"),Arrays.asList("replace"),
		Arrays.asList("replace"),Arrays.asList("replace"),
		Arrays.asList("","replace"),Arrays.asList("","replace"),Arrays.asList("addIni","")
	);
	final List<String> target = Arrays.asList(
		"(if\\s*\\(.*?\\))(?:\\s*\\n*.*?\\s*)(end)",
		"(((private|public|)\\s*)(int|string|bool|float)(.*)\\s*=\\s*(.*))|puts\\((.*)\\)|\\w+\\s+=\\s+new\\s+\\w+\\(.*\\)|\\w+\\.\\w+\\(.*\\)|\\w+\\(.*\\)",
        "(function\\s*\\w+\\s*\\(.*?\\)).*",
		"string","bool","function","end","puts","(int\\s+\\w+\\s*\\=\\s*)(gets\\(\\))",
		"(string\\s+\\w+\\s*\\=\\s*|String\\s+\\w+\\s*\\=\\s*)(gets\\(\\))",
		"(\\w+\\s+=\\s+)new\\s+(\\w+)\\(.*\\)"
	);
	final List<List<String>> remplacement = Arrays.asList(
            Arrays.asList("{","}"),Arrays.asList(";"),Arrays.asList("{"),Arrays.asList("String"),
            Arrays.asList("boolean"),Arrays.asList("public void"),Arrays.asList("}")
           ,Arrays.asList("System.out.println"),Arrays.asList("","(new java.util.Scanner(System.in)).nextInt()")
			,Arrays.asList("","(new java.util.Scanner(System.in)).next()")
			,Arrays.asList(" ","")
	);
}
