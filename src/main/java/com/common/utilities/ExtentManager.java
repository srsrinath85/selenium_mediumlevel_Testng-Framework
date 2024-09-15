package com.common.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class ExtentManager {



        private static ExtentReports extentReports;


                public static ExtentReports createExtentReports() throws IOException {
                    if (extentReports == null) {
                        extentReports = new ExtentReports();

                        // HTML Report Configuration
                        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("target/SparkReport/Spark.html");
                        htmlReporter.config().setReportName("Automation Test Report");
                        extentReports.attachReporter(htmlReporter);
                    }
                    return extentReports;
            }
    }


