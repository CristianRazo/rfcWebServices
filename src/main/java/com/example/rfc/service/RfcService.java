package com.example.rfc.service;

import org.springframework.stereotype.Service;

@Service
public class RfcService {

	
	 public String generateRFCFromData(String nombre, String primerApellido, String segundoApellido, String fechaNacimiento) {
	        String primeraLetraApellidoPaterno = primerApellido.substring(0, 1);
	        String primeraVocalNombre = encontrarPrimeraVocal(primerApellido);
	        String primeraLetraApellidoMaterno = segundoApellido.substring(0, 1);
	        String primeraLetraNombre = nombre.substring(0, 1);
	        String ultimasDosCifrasAnio = fechaNacimiento.substring(8, 10);
	        String mesNacimiento = fechaNacimiento.substring(3, 5);
	        String diaNacimiento = fechaNacimiento.substring(0, 2);
	        String rfc = primeraLetraApellidoPaterno + primeraVocalNombre + primeraLetraApellidoMaterno + primeraLetraNombre + ultimasDosCifrasAnio + mesNacimiento + diaNacimiento;
	        return rfc.toUpperCase();
	    }

	    private String encontrarPrimeraVocal(String str) {
	        str = str.toLowerCase();
	        for (char c : str.toCharArray()) {
	            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
	                return String.valueOf(c);
	            }
	        }
	        return "X";
	    }
	
	}

