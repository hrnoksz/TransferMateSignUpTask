package com.transfermate.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    public static void captchaVerification(WebElement element) {
        String mathQuestionValue = Driver.getDriver().findElement(By.id("cal_captcha_f10_question")).getText().trim();

        if (mathQuestionValue.contains("+")) {
            String removeSpace = mathQuestionValue.replaceAll("\\s+", "");
            String[] partsOne = removeSpace.split("\\+");
            String part1 = partsOne[0];
            String part2 = partsOne[1];
            String[] parts1 = part2.split("\\=");
            String part11 = parts1[0];
            int sum = Integer.parseInt(part1) + Integer.parseInt(part11);
            WebElement captchaValue = Driver.getDriver().findElement(By.xpath("//input[@id='__calc_captcha_text']"));
           captchaValue.sendKeys("" + sum);
        } else {
            String removeSpace = mathQuestionValue.replaceAll("\\s+", "");
            String[] partsOne = removeSpace.split("\\-");
            String part1 = partsOne[0];
            String part2 = partsOne[1];
            String[] parts1 = part2.split("\\=");
            String part11 = parts1[0];
            int abs = Integer.parseInt(part1) - Integer.parseInt(part11);
            WebElement captchaValue = Driver.getDriver().findElement(By.xpath("//input[@id='__calc_captcha_text']"));
            captchaValue.sendKeys("" + abs);
        }

    }



}

