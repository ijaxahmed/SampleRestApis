package com.sample.rest.api.googlegeo.connector;

import java.util.HashMap;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import com.sample.rest.api.utilities.Util;

public class GoogleGeocodeResourceConnector {

	private static String API_URL = "http://maps.googleapis.com/maps/api/geocode/json";

	public static ResteasyWebTarget buildEndPoint(
			HashMap<String, String> parameterHash) {

		ResteasyWebTarget target = null;
		try {
			String queryParameters = null;
			ResteasyClient client = new ResteasyClientBuilder().build();
			if (parameterHash.size() > 0) {
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
