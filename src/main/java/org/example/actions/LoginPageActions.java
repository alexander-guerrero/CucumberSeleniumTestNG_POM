package org.example.actions;

import org.example.locators.LoginPageLocators;
import org.example.utils.HelperClass;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {

    LoginPageLocators loginPageLocators = null;

    public LoginPageActions() {

        loginPageLocators = new LoginPageLocators();

        PageFactory.initElements(HelperClass.getDriver(), loginPageLocators);

    }

//    Get the error message when username is blank
    public String getMissingUsernameText() {
        return loginPageLocators.missingUsernameErrorMessage.getText();
    }

//    Get the Error Message
    public String getErrorMessage() {
        return loginPageLocators.errorMessage.getText();
    }

    public void login(String strUserName, String strPassword) {

//        Fill user name
        loginPageLocators.userName.sendKeys(strUserName);

//        Fill password
        loginPageLocators.password.sendKeys(strPassword);

//        Click Login button
        loginPageLocators.login.click();

    }

}
