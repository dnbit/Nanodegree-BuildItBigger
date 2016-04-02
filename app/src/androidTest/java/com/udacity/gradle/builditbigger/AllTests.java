package com.udacity.gradle.builditbigger;

import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({EndpointAsyncTaskTest.class})
public class AllTests extends TestSuite
{
}
