/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package br.com.mvbos.myjokes.backend;


import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.ArrayList;
import java.util.List;

import br.com.mvbos.jjlib.TheJoker;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myjokes.mvbos.com.br",
                ownerName = "backend.myjokes.mvbos.com.br",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "listJokes")
    public List<JokeBean> listJokes() {

        JokeBean bean;

        final String[] jokes = TheJoker.listJokes();

        List<JokeBean> response = new ArrayList<>(jokes.length);

        for (String s : jokes) {
            bean = new JokeBean();
            bean.setJoke(s);
            response.add(bean);
        }

        return response;
    }

}
