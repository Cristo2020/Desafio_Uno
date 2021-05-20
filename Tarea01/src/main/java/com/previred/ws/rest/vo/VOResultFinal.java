package com.previred.ws.rest.vo;

import java.util.List;

public class VOResultFinal extends VOResult {

	private List<String> fechasFaltantes;
	
	
	public List<String> getFechasFaltantes() {
		return fechasFaltantes;
	}
	
	public void setFechasFaltantes(List<String> fechasFaltantes) {
		this.fechasFaltantes = fechasFaltantes;
	}
	
	
}
