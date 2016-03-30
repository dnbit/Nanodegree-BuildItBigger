package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.dnbitstudio.libraries.jokeandroidlibrary.JokerActivity;
import com.udacity.gradle.builditbigger.free.MainActivityFragment;


public class MainActivity extends ActionBarActivity implements MainActivityFragment
        .MainActivityFragmentCallback
{
    private ProgressBar spinner;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void retrieveJoke(Button button, ProgressBar spinner)
    {
        this.button = button;
        this.spinner = spinner;
        button.setVisibility(View.INVISIBLE);
        spinner.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute();
    }

    public void tellJoke(String result)
    {
        Intent intent = new Intent(this, JokerActivity.class);
        intent.putExtra(JokerActivity.JOKE_EXTRA_KEY, result);
        startActivity(intent);
        resetVisibility();
    }

    public void resetVisibility()
    {
        button.setVisibility(View.VISIBLE);
        spinner.setVisibility(View.INVISIBLE);
    }
}