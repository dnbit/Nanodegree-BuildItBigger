package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.dnbitstudio.libraries.jokeandroidlibrary.JokerActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends ActionBarActivity implements MainActivityFragment
        .MainActivityFragmentCallback
{
    private InterstitialAd mInterstitialAd;
    private ProgressBar spinner;
    private Button button;
    private int noInterstitialAdCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

        mInterstitialAd.setAdListener(new AdListener()
        {
            @Override
            public void onAdClosed()
            {
                requestNewInterstitial();
                requestJoke();
            }
        });

        requestNewInterstitial();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void launchJokeFlow(Button button, ProgressBar spinner)
    {
        saveViewsReference(button, spinner);

        if (mInterstitialAd.isLoaded() && noInterstitialAdCount >= 3)
        {
            noInterstitialAdCount = 0;
            mInterstitialAd.show();
        }
        else
        {
            noInterstitialAdCount++;
            requestJoke();
        }
    }

    private void saveViewsReference(Button button, ProgressBar spinner)
    {
        this.button = button;
        this.spinner = spinner;
    }

    public void requestJoke()
    {
        swapVisibility(false);
        new EndpointAsyncTask(this).execute();
    }

    public void tellJoke(String result)
    {
        JokerActivity.launchActivity(this, result);
        swapVisibility(true);
    }

    public void swapVisibility(boolean visibleButton)
    {
        if (visibleButton)
        {
            button.setVisibility(View.VISIBLE);
            spinner.setVisibility(View.INVISIBLE);
        }
        else
        {
            button.setVisibility(View.INVISIBLE);
            spinner.setVisibility(View.VISIBLE);
        }
    }

    private void requestNewInterstitial()
    {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();

        mInterstitialAd.loadAd(adRequest);
    }
}