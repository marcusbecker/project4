package br.com.mvbos.myjokerlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_library);

        Intent i = getIntent();
        String joke = i.getStringExtra(JokeConstants.JOKE);
        if (joke != null || !joke.isEmpty()) {
            ((TextView) findViewById(R.id.txJoke)).setText(joke);
        }
    }
}
