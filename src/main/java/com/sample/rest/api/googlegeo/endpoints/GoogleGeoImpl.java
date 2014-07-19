package com.sample.rest.api.googlegeo.endpoints;

import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import com.sample.rest.api.googlegeo.endpoints.interfaces.GoogleGeo;
import com.sample.rest.api.googlegeo.endpoints.services.CoordinateService;
import com.sample.rest.api.googlegeo.entities.Coordinates;
import com.sample.rest.api.jsonparser.ResponseParser;

@Path("/geocode")
public class GoogleGeoImpl implements GoogleGeo {

	@Override
	@BadgerFish
	@GET
	@Path("/coordinates/{street}/{city}")
	@Produces("application/json")
	public Coordinates pullCooordinates(@PathParam("street") String street,
			@PathParam("city") String city) {
		// TODO Auto-generated method stub
		String responseStr = null;
		CoordinateService cService = new CoordinateService();
		ResponseParser cParser = new ResponseParser();
		Coordinates coordinates = new Coordinates();
		try {

			HashMap<String, String> parameterHash = new HashMap<String, String>();
			parameterHash.put("address", street + ", " + city);
			responseStr = cService.getCooordinates(parameterHash);
			coordinates = cParser.extractCoordinates(responseStr);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return coordinates;

	}

}
