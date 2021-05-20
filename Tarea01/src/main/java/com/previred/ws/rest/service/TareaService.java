package com.previred.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.previred.ws.rest.util.Util;
import com.previred.ws.rest.vo.VOResult;
import com.previred.ws.rest.vo.VOResultFinal;

@Path("/tarea01")
public class TareaService {
	
	
	@Path("/obtenerFechas")
	@POST
	@Consumes({MediaType.APPLICATION_JSON})
	@Produces({MediaType.APPLICATION_JSON})
	public VOResultFinal obtenerFechas(){
		
		VOResultFinal resultFinal = new VOResultFinal();
		VOResult result = new VOResult();
		
		result = TareaClient.fechas();
		
		resultFinal = Util.calcular (result);
		
		return resultFinal;
		
	}

}
