package org.example.actions;

import org.example.locators.HomePageLocators;
import org.example.utils.HelperClass;
import org.openqa.selenium.support.PageFactory;

public class HomePageActions {

    HomePageLocators homePageLocators = null;

    public HomePageActions() {

        homePageLocators = new HomePageLocators();

        PageFactory.initElements(HelperClass.getDriver(), homePageLocators);

    }

//    Get the user name from Home Page
    public String getHomePageText() {
        return homePageLocators.homePageUserName.getText();
    }

}
