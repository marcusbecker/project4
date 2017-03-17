package br.com.mvbos.myjoker;

import android.content.Context;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

import br.com.mvbos.myjokes.backend.myApi.MyApi;

/**
 * Created by Marcus Becker on 14/03/2017.
 */

public class EndpointsBuilder {
    public static MyApi createBuilder(Context context) {
        MyApi.Builder builder = new MyApi.Builder(
                AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                .setRootUrl(context.getString(R.string.server_url))
                .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                    @Override
                    public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                        abstractGoogleClientRequest.setDisableGZipContent(true);
                    }
                });

        return builder.build();
    }
}
