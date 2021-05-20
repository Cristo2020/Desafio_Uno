package com.previred.ws.rest.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

import com.previred.ws.rest.vo.VOResult;
import com.previred.ws.rest.vo.VOResultFinal;

public class Util {

	public static VOResultFinal calcular(VOResult resultado){
		VOResultFinal resultadoFinal = new VOResultFinal();
		int com = 100;
		Date fechaInicio = ParseFecha(resultado.getFechaCreacion());
		Date fechaFin = ParseFecha(resultado.getFechaFin());
		List <String> fechasFaltantes = new ArrayList<String>();
		List <String> fechas = new ArrayList<String>();
		fechas = resultado.getFechas();
		int esta=0;
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		com = fechaFin.compareTo(fechaInicio);
		
		switch (com) {
		  case 0:
		    System.out.println("Las fechas de inicio y fin son iguales");
		    break;
		  case 1:
			  c1.setTime(fechaFin);
		      c1.add(Calendar.MONTH, 1);
		      fechaFin = c1.getTime();
			for (;fechaInicio.compareTo(fechaFin) == -1; ) {
				esta=0;
			    for (String fecha: fechas) {	
			    	if (fechaInicio.compareTo(ParseFecha(fecha)) == 0){
			    		esta=1;
			    	}
			      }
			    if (esta==0){
			    	fechasFaltantes.add(formatter.format(fechaInicio));
			    }
			  c1.setTime(fechaInicio);
		      c1.add(Calendar.MONTH, 1);
		      fechaInicio = c1.getTime();
			  System.out.println("proxima: " + formatter.format(fechaInicio));
			}
		    break;
		  case -1:
			    System.out.println("fecha fin mayor a fecha inicio");
			    break;
		}
		
		resultadoFinal.setId(resultado.getId());
		resultadoFinal.setFechaCreacion(resultado.getFechaCreacion());
		resultadoFinal.setFechaFin(resultado.getFechaFin());
		resultadoFinal.setFechas(resultado.getFechas());
		resultadoFinal.setFechasFaltantes(fechasFaltantes);
		
		return resultadoFinal;
	}
	
	public static Date ParseFecha(String fecha)
    {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaDate = null;
        
        try {
            fechaDate = formato.parse(fecha);
        } 
        catch (ParseException ex) 
        {
            System.out.println(ex);
        }
        return fechaDate;
    }
}
