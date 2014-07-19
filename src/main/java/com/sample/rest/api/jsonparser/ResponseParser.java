package com.sample.rest.api.jsonparser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.sample.rest.api.foursquare.entities.Vanue;
import com.sample.rest.api.googlegeo.entities.Coordinates;

public class ResponseParser {

	public Coordinates extractCoordinates(String geoCodeJson) {

		ArrayList<Double> cordinates = new ArrayList<Double>();
		Coordinates coordinates = new Coordinates();

		try {
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(geoCodeJson);

			JSONArray results = (JSONArray) jsonObject.get("results");
			JSONObject obj = (JSONObject) results.get(0);
			JSONObject geometry = (JSONObject) obj.get("geometry");
			// System.out.println("geometry : " + geometry);
			JSONObject location = (JSONObject) geometry.get("location");
			// System.out.println("location : " + location);

			Double lat = ((Double) location.get("lat"));
			Double lng = ((Double) location.get("lng"));
			System.out.println("Lat, Lag: " + lat + " " + lng);

			coordinates.setLat(lat);
			coordinates.setLng(lng);

		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		return coordinates;

	}

	public Vanue extractVanue(String vanueJson) {

		Vanue vanue = new Vanue();
		try {

			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(vanueJson);

			JSONObject structure = (JSONObject) jsonObject.get("response");
			JSONArray vanues = (JSONArray) structure.get("venues");
			// System.out.println("Into job structure, name: "
			// + structure.get("venues"));

			// for(int i=0; i<vanues.size(); i++){
			// System.out.println("The " + i +
			// " element of the array: "+vanues.get(i));
			// }
			//
			Iterator i = vanues.iterator();
			JSONObject location;
			JSONObject innerObj;
			if(vanues.size()>0){
				innerObj = (JSONObject) vanues.get(0);

				vanue.setId((String) innerObj.get("id"));
				vanue.setName((String) innerObj.get("name"));
				location = (JSONObject) innerObj.get("location");

				vanue.setStreet((String) location.get("address"));
				vanue.setPostalcode((String) location.get("postalCode"));
				vanue.setCity((String) location.get("city"));
				vanue.setState((String) location.get("state"));
				vanue.setCounrty((String) location.get("country"));

				System.out.println("ID " + innerObj.get("id") + " Name "
						+ innerObj.get("name") + " Address "
						+ location.get("address") + " PostalCode "
						+ location.get("postalCode") + " city "
						+ location.get("city") + " State " + location.get("state")
						+ " Country " + (String) location.get("country"));

			}else
				vanue=null;
			
		} catch (ParseException ex) {
			ex.printStackTrace();
		} catch (NullPointerException ex) {
			ex.printStackTrace();
		}

		return vanue;
	}

}
