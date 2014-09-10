
ReadME:
==========

A wrapper REST web service for Foursquare and GoogleGeocoding API

Prerequisites
--------------
In order to run the code Foursquare Authentication credentials required. Perform following step
- Register with Foursquare and get CLIENT_ID and CLIENT _SECRET
- update following fields in below class with your CLIENT _ID and CLIENT _SECRET 

private static String CLIENT_ID = "FAKECLIENTID";
private static String CLIENT_SECRET = "FAKESECRETKEY";
/src/main/java/com/sample/rest/api/foursquare/connector/FoursquareResourceConnector.java


RUN:
--------------
- Find .war inside project /target dir (or find attached)
-deply .war into application server (Jboss6 or above, tomcate etc)



Sample Test URLS
-------------------
Foursquare:
http://localhost:8080/SampleRestApis/foursquare/vanue/uberall/ Chausseestra�e/berlin
http://localhost:8080/SampleRestApis/foursquare/vanue/Einstein/Friedrichstr/berlin
http://localhost:8080/SampleRestApis/foursquare/vanue/K20%20Grabbeplatz/Grabbeplatz 5/dusseldorf
http://localhost:8080/SampleRestApis/foursquare/vanue/DROM/ 85 Avenue A /New York
http://localhost:8080/SampleRestApis/foursquare/vanue/Chelsea Market/ 75 9th Ave/ New York
http://localhost:8080/SampleRestApis/foursquare/vanue/Nando's/ 100 B-2 M. M Alam Rd /Lahore
http://localhost:8080/SampleRestApis/foursquare/vanue/Hyde Park / Serpentine Rd /London

Locations:
http://localhost:8080/SampleRestApis/geocode/coordinates/Chester Rd /London
http://localhost:8080/SampleRestApis/geocode/coordinates/ 199 V N Sphere Mal /Mumbai
