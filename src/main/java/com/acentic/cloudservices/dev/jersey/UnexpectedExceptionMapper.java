/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.acentic.cloudservices.dev.jersey;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jettison.json.JSONException;

/**
 *
 * @author uli
 */
public class UnexpectedExceptionMapper implements ExceptionMapper<JSONException> {

    private static final transient ObjectMapper MAPPER = new ObjectMapper();

    @Override
    public Response toResponse(final JSONException exception) {
        ResponseBuilder builder = null;
        try {
            builder = Response.status(Status.BAD_REQUEST)
                    .entity(defaultJSON(exception))
                    .type(MediaType.APPLICATION_JSON);
        } catch (IOException ex) {
            Logger.getLogger(UnexpectedExceptionMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return builder.build();
    }

    private String defaultJSON(final Exception exception) throws IOException {
        ErrorInfo errorInfo = new ErrorInfo(null, exception.getMessage(), exception.getMessage(), (String) null);
        try {
            return MAPPER.writeValueAsString(errorInfo);
        } catch (JsonProcessingException e) {
            return "{\"message\":\"An internal error occurred\"}";
        }
    }

}
