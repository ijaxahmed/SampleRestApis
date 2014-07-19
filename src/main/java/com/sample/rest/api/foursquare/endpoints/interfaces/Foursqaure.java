package com.sample.rest.api.foursquare.endpoints.interfaces;

import com.sample.rest.api.foursquare.entities.Vanue;

public interface Foursqaure {

	public Vanue searchVanue(String query, String street, String city);

}
