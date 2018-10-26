/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acentic.cloudservices.dev.jersey;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.TimeZone;
import javax.ws.rs.core.Context;
import javax.ws.rs.Path;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * REST Web Service
 * 
 * [
  {"vorname": "Uli",
   "nachname": "Hansen",
   "geburtstag": "1968-02-24T00:00Z"
   "adresse":{
      "strasse": "Kornblumenweg 11",
      "plz": 50259,
      "ort": "Pulheim"
    }
  },
  {"vorname": "Acentic",
   "nachname": "GmbH",
   "geburtstag": "1970-02-24T00:00Z",
   "adresse":{
       "strasse": "Butzweilerhofallee 4",
       "plz": 50878,
       "ort": "Köln"
    }
}]
 * 
 *
 * @author uhansen
 */
@Path("/rest/person")
@Component
public class jsonTest1 implements ApplicationContextAware {

    ApplicationContext applicationContext;
    private static final Logger LOGGER = LogManager.getLogger(jsonTest1.class);
    private static final String ISO8601_DATE_TIME_FORMAT = "yyyy-MM-dd'T'HH:mm'Z'";

    @Context
    HttpServletResponse resp;

    /**
     * Creates a new instance of LocationsResource
     */
    public jsonTest1() {
        LOGGER.log(Level.TRACE, "Constructor for jsonTest1");
    }

    /**
     * Retrieves representation of an instance of
     * com.acentic.weather.rest.LocationsResource
     *
     * @param persons
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson(List<Person> persons) {
    
        DateFormat df = new SimpleDateFormat(ISO8601_DATE_TIME_FORMAT); // Quoted "Z" to indicate UTC, no timezone offset
        TimeZone tz = TimeZone.getTimeZone("UTC");

        JSONObject json;
        JSONArray array = new JSONArray();

        LOGGER.log(Level.DEBUG, "HTTP-POST addPerson()");
        
        for (Person temp : persons) {
            LOGGER.debug("Add new person: " + temp.getNachname() + ", " + temp.getVorname());
            json = new JSONObject();
            try {
                json.put("vorname", temp.getVorname());
                json.put("nachname", temp.getNachname());
                json.put("geburtstag", df.format(temp.getGeburtstag()));
                json.put("adresse", new JSONObject()
                        .put("strasse", temp.getAdresse().getStrasse())
                        .put("plz", temp.getAdresse().getPlz())
                        .put("ort", temp.getAdresse().getOrt()));
            } catch (JSONException jSONException) {
            }
            array.put(json);
        }
//            See the Java Json specification. This is the right way:
//            String json = Json.createObjectBuilder()
//            .add("key1", "value1")
//            .add("key2", "value2")
//            .build()
//            .toString();
        return Response.ok()
                .entity(array.toString())
                .header("Allow", "OPTIONS,GET")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "OPTIONS,GET")
                .build();

    }

    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response addPerson() {
    //public Response addPerson() {
        DateFormat df = new SimpleDateFormat(ISO8601_DATE_TIME_FORMAT); // Quoted "Z" to indicate UTC, no timezone offset
        TimeZone tz = TimeZone.getTimeZone("UTC");

        JSONObject json;
        JSONArray array = new JSONArray();
        LOGGER.log(Level.DEBUG, "HTTP-Get addPerson()");
        
        Adresse myAddr;
        Person myPerson;
        try {
            json = new JSONObject();
            myAddr = new Adresse("Kornblumenweg 11", 50259, "Pulheim");
            myPerson = new Person("Uli", "Hansen", myAddr);
            myPerson.setGeburtstag("1968-02-24T00:00Z");

            json.put("vorname", myPerson.getVorname());
            json.put("nachname", myPerson.getNachname());
            json.put("geburtstag", df.format(myPerson.getGeburtstag()));
            json.put("adresse", new JSONObject()
                    .put("strasse", myPerson.getAdresse().getStrasse())
                    .put("plz", myPerson.getAdresse().getPlz())
                    .put("ort", myPerson.getAdresse().getOrt()));
            array.put(json);

            json = new JSONObject();
            myAddr = new Adresse("Kornblumenweg 11", 50259, "Pulheim");
            myPerson = new Person("Uli", "Hansen", myAddr);
            myPerson.setGeburtstag("1968-02-24T00:00Z");

            json.put("vorname", myPerson.getVorname());
            json.put("nachname", myPerson.getNachname());
            json.put("geburtstag", df.format(myPerson.getGeburtstag()));
            json.put("adresse", new JSONObject()
                    .put("strasse", myPerson.getAdresse().getStrasse())
                    .put("plz", myPerson.getAdresse().getPlz())
                    .put("ort", myPerson.getAdresse().getOrt()));
            array.put(json);

        } catch (ParseException | JSONException ex) {
            LOGGER.log(Level.ERROR, ex);
        }

//            See the Java Json specification. This is the right way:
//            String json = Json.createObjectBuilder()
//            .add("key1", "value1")
//            .add("key2", "value2")
//            .build()
//            .toString();
        return Response.ok()
                .entity(array.toString())
                .header("Allow", "OPTIONS,GET")
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "OPTIONS,GET")
                .build();

    }
    
    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.applicationContext = ac;
    }

    private Object defaultJSON(JSONException ex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
