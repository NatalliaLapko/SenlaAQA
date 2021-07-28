package test.java;

import org.openqa.selenium.WebDriver;

public class Main {

  public static void main (String[] args){

      String email = "test_user@gmail.com";
      String password = "Abc123qwe*";
      Test test = new Test();
      test.logIn(email,password);
      test.CreateNewAddress();
      test.EditAddress();
      test.DeleteAddress();
      test.LogOut();



  }

}
