package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.test.AndroidTestCase;

import org.mockito.Mockito;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class EndpointAsyncTaskTest extends AndroidTestCase
{
    public void testEndpointAsyncTask_Call_ReturnsString()
            throws InterruptedException, ExecutionException, TimeoutException
    {
        Context mockContext = Mockito.mock(MainActivity.class);
        EndpointAsyncTask task = new EndpointAsyncTask(mockContext);
        task.execute();
        String result = task.get(10, TimeUnit.SECONDS);
        assertNotNull(result);
    }
}
