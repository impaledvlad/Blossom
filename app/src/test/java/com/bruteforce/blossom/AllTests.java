package com.bruteforce.blossom;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import bruteforce.objects.Account;
import bruteforce.objects.Plant;
import bruteforce.objects.Task;

import com.bruteforce.blossom.objects.AccountTest;
import com.bruteforce.blossom.objects.PlantTest;
import com.bruteforce.blossom.objects.TaskTest;

/**
 Class: AllTests
 Author: Triet Nguyen
 Purpose: This class executes all object test class automatically.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        AccountTest.class,
        PlantTest.class,
        TaskTest.class
})



public class AllTests {
}

