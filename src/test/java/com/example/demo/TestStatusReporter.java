package com.example.demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestStatusReporter implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        // Do nothing at start
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("✓ " + testName + " - PASS");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("✗ " + testName + " - FAIL");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        System.out.println("- " + testName + " - SKIP");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("\n=== Starting Test Suite ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("\n=== Test Suite Complete ===");
        int total = context.getAllTestMethods().length;
        int passed = context.getPassedTests().size();
        int failed = context.getFailedTests().size();
        int skipped = context.getSkippedTests().size();
        
        System.out.println("Total Tests: " + total);
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);
        System.out.println("Skipped: " + skipped);
    }
}