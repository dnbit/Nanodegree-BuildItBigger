package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment
{
    private ProgressBar spinner;
    private Button button;

    public MainActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        spinner = (ProgressBar) root.findViewById(R.id.progressBar);
        button = (Button) root.findViewById(R.id.joke_btn);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ((MainActivity) getActivity()).retrieveJoke(button, spinner);
            }
        });

        return root;
    }

    public interface MainActivityFragmentCallback
    {
        void retrieveJoke(Button button, ProgressBar spinner);
    }
}