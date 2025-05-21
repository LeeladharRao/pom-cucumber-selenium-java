package com.org.hooks;

import com.org.constants.Constants;
import com.org.driver.DriverManager;
import com.org.utils.LogManager;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Hooks {

    TestContext testContext;

    public Hooks(TestContext context) {
        testContext = context;
    }

    @BeforeAll
    public static void before_all() {
        LogManager.info("==================== BEFORE ALL ====================");

        try {
            if (Constants.DELETE_TEMP_FOLDER.equals(Constants.YES)) {
                FileUtils.deleteDirectory(new File("target/allure-results"));
                LogManager.info("Deleted directory target/allure-results");
                FileUtils.deleteDirectory(new File("ExportData"));
                LogManager.info("Deleted directory ExportData");
            }
        } catch (IOException e) {
            LogManager.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Before
    public static void before(Scenario scenario) {
        LogManager.info("Executing Scenario Name: "+ scenario.getName());
        Constants.count_totalTCs = Constants.count_totalTCs + 1;

        String browserName = (System.getProperty("browser") != null && !System.getProperty("browser").isEmpty()) ? System.getProperty("browser")
                : Constants.BROWSER;
    }

    @After
    public static void after(Scenario scenario) {
        if (Status.PASSED.equals(scenario.getStatus())) {
            Constants.count_passedTCs = Constants.count_passedTCs + 1;
        }
        if (Status.FAILED.equals(scenario.getStatus())) {
            Constants.count_failedTCs = Constants.count_failedTCs + 1;
        }
        if (Status.SKIPPED.equals(scenario.getStatus())) {
            Constants.count_skippedTCs = Constants.count_skippedTCs + 1;
        }

        DriverManager.quit();
    }

    @AfterAll
    public static void after_all() {
        LogManager.info("==================== AFTER ALL ====================");
        LogManager.info("Count Total TCs: " + Constants.count_totalTCs);
        LogManager.info("Count PASSED TCs: " + Constants.count_passedTCs);
        LogManager.info("Count FAILED TCs: " + Constants.count_failedTCs);
        LogManager.info("Count SKIPPED TCs: " + Constants.count_skippedTCs);
    }
}
