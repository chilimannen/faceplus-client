package com.rduda.Model;

import com.rduda.Model.API.REST;
import org.glassfish.jersey.jackson.JacksonFeature;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by Robin on 2015-11-29.
 * <p>
 * REST Client factory.
 */
class RestHelper {

    public static WebTarget getClient() {
        return ClientBuilder.newBuilder().register(JacksonFeature.class).build().target(REST.URL);
    }
}
