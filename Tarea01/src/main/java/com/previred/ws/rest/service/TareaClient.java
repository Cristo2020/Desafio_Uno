package com.previred.ws.rest.service;

import com.previred.ws.rest.vo.VOResult;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

public class TareaClient {
	
	public static VOResult fechas(){
		VOResult result = new VOResult();
		
		ClientConfig clientConfig = new DefaultClientConfig();
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
		Client client = Client.create(clientConfig);
		WebResource webResource = client.resource("http://localhost:8089/GDD");
		ClientResponse response = webResource.type("application/json")
				.get(ClientResponse.class);
		result = response.getEntity(VOResult.class);
		return result;
		
	}

}
