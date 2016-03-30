package com.javalibrary;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Joker
{
    private final List<String> jokesList = new ArrayList();
    private final String JOKE1 = "Q: What did the spider do on the computer?\nA: Made a website!";
    private final String JOKE2 = "Q: What did the computer do at lunchtime?\nA: Had a byte!";
    private final String JOKE3 = "Q: What does a baby computer call his father?\nA: Data!";
    private final String JOKE4 = "Q: Why did the computer keep sneezing?\nA: It had a virus!";
    private final String JOKE5 = "Q: What is a computer virus?\nA: A terminal illness!";
    private final String JOKE6 = "Q: Why was the computer cold?\nA: It left it's Windows open!";
    private final String JOKE7 = "Q: Why was there a bug in the computer?\nA: Because it was " +
            "looking for a byte to eat?";
    private final String JOKE8 = "Q: Why did the computer squeak?\nA: Because someone stepped on " +
            "it's mouse!";
    private final String JOKE9 = "Q: What do you get when you cross a computer and a life " +
            "guard?\nA: A screensaver!";
    private final String JOKE10 = "Q: Where do all the cool mice live?\nA: In their mousepads";
    private final String JOKE11 = "Q: What do you get when you cross a computer with an " +
            "elephant?\nA: Lots of memory!";

    public Joker()
    {
        jokesList.add(JOKE1);
        jokesList.add(JOKE2);
        jokesList.add(JOKE3);
        jokesList.add(JOKE4);
        jokesList.add(JOKE5);
        jokesList.add(JOKE6);
        jokesList.add(JOKE7);
        jokesList.add(JOKE8);
        jokesList.add(JOKE9);
        jokesList.add(JOKE10);
        jokesList.add(JOKE11);
    }

    public String getJoke()
    {
        int position = new Random().nextInt(jokesList.size());
        return jokesList.get(position);
    }
}