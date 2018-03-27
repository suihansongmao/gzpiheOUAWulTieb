package com.zct.uitest.pc.framework;

import com.zct.uitest.pc.utils.Config;
import org.openqa.selenium.By;

public class ObjectMap {
    private Config config;

    public ObjectMap(String pathName) {
        config = new Config(pathName);
    }

    public By getLocator(String key) {
        String locator = config.getValue(key);
        String locatorArr[] = locator.split("\\{\\|}");
        String locatorType = locatorArr[0];
        String locatorValue = locatorArr[1];
        switch (locatorType.toLowerCase()) {
            case "id":
                return By.id(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "class":
                return By.className(locatorValue);
            case "classname":
                return By.className(locatorValue);
            case "tag":
                return By.className(locatorValue);
            case "tagname":
                return By.className(locatorValue);
            case "linktext":
                return By.linkText(locatorValue);
            case "link":
                return By.linkText(locatorValue);
            case "partiallinktext":
                return By.partialLinkText(locatorValue);
            case "cssselector":
                return By.cssSelector(locatorValue);
            case "css":
                return By.cssSelector(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
            default:
                // locatorType错误
                throw new RuntimeException("输入的 locator type 未在程序中被定义：" + locatorType);
        }
//        if(locatorType.toLowerCase().equals("id")) {
//            return By.id(locatorValue);
//        } else if(locatorType.toLowerCase().equals("name")) {
//            return By.name(locatorValue);
//        } else if((locatorType.toLowerCase().equals("classname"))||(locatorType.toLowerCase().equals("class"))) {
//            return By.className(locatorValue);
//        } else if((locatorType.toLowerCase().equals("tagname"))||(locatorType.toLowerCase().equals("tag"))) {
//            return By.className(locatorValue);
//        } else if((locatorType.toLowerCase().equals("linktext"))||(locatorType.toLowerCase().equals("link"))) {
//            return By.linkText(locatorValue);
//        } else if(locatorType.toLowerCase().equals("partiallinktext")) {
//            return By.partialLinkText(locatorValue);
//        } else if((locatorType.toLowerCase().equals("cssselector"))||(locatorType.toLowerCase().equals("css"))) {
//            return By.cssSelector(locatorValue);
//        } else if(locatorType.toLowerCase().equals("xpath")) {
//            return By.xpath(locatorValue);
//        } else {
//            // locatorType错误
//            throw new RuntimeException("输入的 locator type 未在程序中被定义：" + locatorType);
//        }
    }
}
