/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.dnbitstudio.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.javalibrary.Joker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.dnbitstudio.com",
                ownerName = "backend.builditbigger.dnbitstudio.com",
                packagePath = ""
        )
)
public class MyEndpoint
{
    /**
     * A simple endpoint method to retrieve a joke
     */
    @ApiMethod(name = "retrieveJoke")
    public MyBean retrieveJoke()
    {
        MyBean response = new MyBean();
        Joker joker = new Joker();
        String joke = joker.getJoke();
        response.setData(joke);

        return response;
    }
}