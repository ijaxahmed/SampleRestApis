package com.sample.rest.api.foursquare.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

import com.sample.rest.api.foursquare.endpoints.interfaces.Foursqaure;
import com.sample.rest.api.foursquare.endpoints.services.VanueService;
import com.sample.rest.api.foursquare.entities.Vanue;
import com.sample.rest.api.jsonparser.ResponseParser;

@Path("/foursquare")
public class FoursquareImpl implements Foursqaure {

	@Override
	@BadgerFish
	@GET
	@Path("/vanue/{query}/{street}/{city}")
	@Produces("application/json")
	public Vanue searchVanue(@PathParam("query") String query,
			@PathParam("street") String street, @PathParam("city") String city) {

		VanueService vService = new VanueService();
		ResponseParser cParser = new ResponseParser();
		String responseStr = vService.searchVanue(query, street, city);
		Vanue vanue = cParser.extractVanue(responseStr);
		// System.out.println(vanue.toString());
		if (vanue != null)
			vanue.setDesc("FOUND");
		else{
			vanue=new Vanue();
			vanue.setDesc("NOT FOUND");

		}
			

		return vanue;

	}

	public static void main(String[] args) {

		new FoursquareImpl().searchVanue("Einstein", "Friedrichstr", "Berlin");
		// new RESTEasyJSONServices().produceJSON01("uberall",//
		// "Chausseestraﬂe");
		// dusseldorf
		// new FoursquareImpl().searchVanue("TOYKIO Gallery",
		// "Immermannstr. 18", "dusseldorf");

	}
}
