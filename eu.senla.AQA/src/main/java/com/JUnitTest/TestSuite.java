package com.JUnitTest;

import org.junit.jupiter.api.AfterAll;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import org.junit.platform.runner.JUnitPlatform;


@RunWith(JUnitPlatform.class)
@SelectClasses({MainTests.class, Tests.class})

public class TestSuite {






}
