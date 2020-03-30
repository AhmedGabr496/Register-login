package com.phptravels.util;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;


public class WebListener implements WebDriverEventListener {


    public void beforeChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("Value of the:"+element.toString()+"before any changes");

    }

    public void afterChangeValueOf(WebElement element, WebDriver driver) {
        System.out.println("Value of the:"+element.toString()+"after changes");

    }

    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on "+element.toString());
    }

    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on "+element.toString());
    }

    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Navigating forward to next page");
    }

    public void afterNavigateForward(WebDriver driver) {
        System.out.println("Navigated successufly forward to next page");

    }
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println("Navigating back to previous page");
    }

    public void afterNavigateBack(WebDriver driver) {
        System.out.println("Navigated sucessufely back to previous page");
    }
    public void beforeNavigateTo(String URL, WebDriver driver) {
        System.out.println("Before Navigating to : '"+ URL +"'");
    }

    public void afterNavigateTo(String URL, WebDriver driver) {
        System.out.println("Navigated to : '"+URL+"'");
    }

    public void onException(Throwable error, WebDriver driver) {
        System.out.println("EXCEPTION OCCURED :" +error);
    }
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }


    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {

    }



    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void beforeSwitchToWindow(String s, WebDriver webDriver) {

    }

    public void afterSwitchToWindow(String s, WebDriver webDriver) {

    }

    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {

    }


    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {

    }

    public void beforeGetText(WebElement webElement, WebDriver webDriver) {

    }

    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {

    }
}
