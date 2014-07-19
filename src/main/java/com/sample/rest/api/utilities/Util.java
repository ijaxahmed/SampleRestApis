package com.sample.rest.api.utilities;

import java.util.HashMap;
import java.util.Map;

public class Util {

	public static String HashToQueryParameter(
			HashMap<String, String> parameterHash) {
		String qeryPatameter = null;
		int counter = 0;

		for (Map.Entry<String, String> entry : parameterHash.entrySet()) {
			// System.out.print("key,val: ");
			// System.out.println(entry.getKey() + "=" + entry.getValue());

			if (counter == 0) {
				qeryPatameter = entry.getKey() + "=" + entry.getValue();
			} else
				qeryPatameter = qeryPatameter + "&" + entry.getKey() + "="
						+ entry.getValue();
			counter++;
		}

		return qeryPatameter;

	}
}
