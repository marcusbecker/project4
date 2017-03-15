package br.com.mvbos.myjoker.free;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import br.com.mvbos.myjoker.R;
import br.com.mvbos.myjokerlibrary.JokeConstants;
import br.com.mvbos.myjokerlibrary.JokeSupply;
import br.com.mvbos.myjokerlibrary.MainLibraryActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(this, getString(R.string.banner_ad_unit_id));

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);
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
