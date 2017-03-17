package br.com.mvbos.myjoker;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import br.com.mvbos.myjokes.backend.myApi.MyApi;
import br.com.mvbos.myjokes.backend.myApi.model.JokeBean;
import br.com.mvbos.myjokes.backend.myApi.model.JokeBeanCollection;

/**
 * Created by Marcus Becker on 13/03/2017.
 */

class EndpointsAsyncTask extends AsyncTask<Context, Void, List<JokeBean>> {
    private static MyApi myApiService = null;
    private Context context;

    @Override
    protected List<JokeBean> doInBackground(Context... params) {

        context = params[0];

        if (myApiService == null) {
            myApiService = EndpointsBuilder.createBuilder(context);
        }

        try {
            final JokeBeanCollection collection = myApiService.listJokes().execute();
            return collection.getItems();

        } catch (IOException e) {
            e.printStackTrace();
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    protected void onPostExecute(List<JokeBean> result) {
        String[] items = new String[result.size()];

        int i = 0;
        for (JokeBean j : result) {
            items[i++] = j.getJoke();
        }

        final ListView listView = (ListView) ((Activity) context).findViewById(R.id.lv_jokes);
        final ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, items);

        listView.setAdapter(itemsAdapter);
    }
}