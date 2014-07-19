package com.sample.rest.api.googlegeo.endpoints.services;

import java.util.ArrayList;
import java.util.HashMap;

import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sample.rest.api.googlegeo.connector.GoogleGeocodeResourceConnector;

public class CoordinateService {

	public String getCooordinates(HashMap<String, String> parameterHash) {

		String responseStr = null;
		try {

			ResteasyWebTarget target = GoogleGeocodeResourceConnector
					.buildEndPoint(parameterHash);
			Response response = target.request().get();
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			responseStr = response.readEntity(String.class);
			// System.out.println("Server response : \n");
			// System.out.println(responseStr);

		} catch (Exception e) {

			e.printStackTrace();

		}
		return responseStr;
	}

}
