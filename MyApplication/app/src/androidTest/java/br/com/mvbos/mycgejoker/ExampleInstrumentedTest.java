package br.com.mvbos.mycgejoker;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.mvbos.myjoker.backend.myApi.MyApi;
import br.com.mvbos.myjoker.backend.myApi.model.JokeBeanCollection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("br.com.mvbos.mycgejoker", appContext.getPackageName());
    }


    @Test
    public void loadingJokes() throws Exception {
        final Context appContext = InstrumentationRegistry.getTargetContext();

        final MyApi myApiService = EndpointsBuilder.createBuilder(appContext);

        final JokeBeanCollection collection = myApiService.listJokes().execute();

        assertTrue(!collection.isEmpty());
    }
}
