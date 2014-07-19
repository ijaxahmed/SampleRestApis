package com.sample.rest.api.foursquare.endpoints.services;

import java.util.HashMap;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.sample.rest.api.foursquare.connector.FoursquareResourceConnector;
import com.sample.rest.api.googlegeo.endpoints.services.CoordinateService;
import com.sample.rest.api.googlegeo.entities.Coordinates;
import com.sample.rest.api.jsonparser.ResponseParser;

public class VanueService {

	public String searchVanue(String query, @PathParam("street") String street,
			@PathParam("city") String city) {

		HashMap<String, String> parameterHash = new HashMap<String, String>();
		CoordinateService cService = new CoordinateService();
		ResponseParser cParser = new ResponseParser();
		parameterHash.put("address", street + ", " + city);
		String coordinateJsonStr = cService.getCooordinates(parameterHash);
		parameterHash.clear();
		Coordinates coordinates = cParser.extractCoordinates(coordinateJsonStr);
		// System.out.println("lat: " + coordinates.getLat() + " lng :"
		// + coordinates.getLng());
		parameterHash.put("ll",
				coordinates.getLat() + "," + coordinates.getLng());
		parameterHash.put("query", query);
		parameterHash.put("intent", "match");
		String responseStr = getVanue(parameterHash);
		// System.out.println("Response: " + responseStr);

		return responseStr;
	}

	public String getVanue(HashMap<String, String> parameterHash) {

		String responseStr = null;

		try {
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = FoursquareResourceConnector
					.buildEndPoint(parameterHash);
			Response response = target.request().get();

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ response.getStatus());
			}
			responseStr = response.readEntity(String.class);
			// System.out.println("Server response : \n");
			// System.out.println(responseStr);

			response.close();

		} catch (Exception e) {

			e.printStackTrace();

		}

		return responseStr;
	}

}
