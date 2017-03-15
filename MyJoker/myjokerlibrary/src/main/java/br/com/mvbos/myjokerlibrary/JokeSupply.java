package br.com.mvbos.myjokerlibrary;

import android.content.Context;
import android.content.res.Resources;

import java.util.Random;

/**
 * Created by Marcus Becker on 08/03/2017.
 */

public class JokeSupply {

    private Context context;


    public JokeSupply(Context context) {
        this.context = context;
    }

    public String[] getJokes() {
        Resources res = context.getResources();
        String[] jokes = res.getStringArray(R.array.jokes);

        return jokes;
    }

    public String getRamdomJoke() {
        String[] jokes = getJokes();
        int rand = new Random().nextInt(jokes.length);

        return jokes[rand];
    }
}
