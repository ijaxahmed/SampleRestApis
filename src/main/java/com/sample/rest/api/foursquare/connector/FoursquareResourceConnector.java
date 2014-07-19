package com.sample.rest.api.foursquare.connector;

import java.util.HashMap;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.sample.rest.api.utilities.Util;

public class FoursquareResourceConnector {

	private static String API_URL = "https://api.foursquare.com/v2/venues/search";
	private static String CLIENT_ID = "KFLW5PUSG25GYKSCJZITCZAFO3CQJARQ1KKM0G3WUDA2SYIF";
	private static String CLIENT_SECRET = "NZ0XYSMNC1TVXTS2URDI43DLX4EESVRXXV50DUFK43ZYUN41";
	private static String VERSION = "20130815";

	public static ResteasyWebTarget buildEndPoint(
			HashMap<String, String> parameterHash) {

		ResteasyWebTarget target = null;
		try {
			String queryParameters = null;
			ResteasyClient client = new ResteasyClientBuilder().build();
			if (parameterHash.size() > 0) {
				parameterHash.put("v", VERSION);
				parameterHash.put("client_id", CLIENT_ID);
				parameterHash.put("client_secret", CLIENT_SECRET);
				queryParameters = Util.HashToQueryParameter(parameterHash);
				target = client.target(API_URL + "?" + queryParameters);
			} else
				target = client.target(API_URL);

		} catch (Exception e) {

			e.printStackTrace();

		}

		return target;
	}
}
