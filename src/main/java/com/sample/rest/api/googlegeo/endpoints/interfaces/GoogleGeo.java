package com.sample.rest.api.googlegeo.endpoints.interfaces;

import com.sample.rest.api.googlegeo.entities.Coordinates;

public interface GoogleGeo {

	public Coordinates pullCooordinates(String street, String city);

}
