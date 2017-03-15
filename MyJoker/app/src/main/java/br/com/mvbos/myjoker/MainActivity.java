package br.com.mvbos.myjoker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import br.com.mvbos.myjokerlibrary.JokeConstants;
import br.com.mvbos.myjokerlibrary.JokeSupply;
import br.com.mvbos.myjokerlibrary.MainLibraryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showJoke(View view) {
        Intent i = new Intent(this, MainLibraryActivity.class);
        i.putExtra(JokeConstants.JOKE, getString(R.string.one_joke));

        startActivity(i);
    }

    public void listJokes(View view) {
    }

    public void pickJoke(View view) {
        JokeSupply js = new JokeSupply(MainActivity.this);

        final TextView text = (TextView) findViewById(R.id.txJoke);
        text.setText(js.getRamdomJoke());
    }
}
