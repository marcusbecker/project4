/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package br.com.mvbos.myjoker.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import java.util.ArrayList;
import java.util.List;

/**
 * An endpoint class we are exposing
 */
@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.myjoker.mvbos.com.br",
                ownerName = "backend.myjoker.mvbos.com.br",
                packagePath = ""
        )
)
public class MyEndpoint {

    @ApiMethod(name = "listJokes")
    public List<JokeBean> listJokes() {
        JokeBean bean;
        List<JokeBean> response = new ArrayList<>(5);

        bean = new JokeBean();
        bean.setJoke("Na aula de quimica o professor pergunta: - Quais as principais reacoes do alcool? O aluno responde: - Chorar pela ex, achar que esta rico, ficar valente e pegar mulher feia ... Professor: - Tirou 10!");
        response.add(bean);

        bean = new JokeBean();
        bean.setJoke("Na delegacia... Seu delegado meu marido saiu de casa ontem a noite, disse que ia comprar arroz e ate agora nao voltou. O que eu faco doutor? - Sei la, faz macarrao!");
        response.add(bean);

        bean = new JokeBean();
        bean.setJoke("It is hard to explain puns to kleptomaniacs because they always take things literally.");
        response.add(bean);

        return response;
    }

}
