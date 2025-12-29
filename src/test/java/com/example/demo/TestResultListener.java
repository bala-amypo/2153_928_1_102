package com.example.demo;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;

public class TestResultListener implements ITestListener {

@Override
public void onStart(ITestContext context) {
System.out.println("\n=== Starting Test Suite ===");
}

@Override
public void onTestSuccess(ITestResult result) {
System.out.println("✓ " + result.getMethod().getMethodName() + "-PASS");
}

@Override
public void onTestFailure(ITestResult result) {
System.out.println("✗ " + result.getMethod().getMethodName());
if (result.getThrowable() != null) {
System.out.println(" Error: " + result.getThrowable().getMessage() + "-FAIL");
}
}

@Override
public void onTestSkipped(ITestResult result) {
System.out.println("↺ " + result.getMethod().getMethodName() + "-SKIP");
}

@Override
public void onFinish(ITestContext context) {
System.out.println("\n=== Test Suite Complete ===");
System.out.println("Total Tests: " + context.getAllTestMethods().length);
System.out.println("Passed: " + context.getPassedTests().size());
System.out.println("Failed: " + context.getFailedTests().size());
System.out.println("Skipped: " + context.getSkippedTests().size());

double score = (context.getPassedTests().size() * 100.0)
/ context.getAllTestMethods().length;

System.out.println("\n=== Test Results Summary ===");
System.out.println(context.getAllTestMethods().length + " Total");
System.out.println(context.getPassedTests().size() + " Passed");
System.out.println(context.getFailedTests().size() + " Failed");

}
}