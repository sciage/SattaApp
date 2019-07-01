package com.example.sattaapp.utils;

import java.util.regex.Pattern;

public class RegexHandler {

  public static String removeSpecialCharacters(String string) {

    string = string.replaceAll("[^\\d.]", "");
    string = string.replaceAll("[^\\dA-Za-z ]", "").replaceAll("\\s+", "+");
    string = string.replaceAll("[-+^)(]*", "");
    string = string.replaceAll(" ", "");
    return string;
  }

  public static boolean isPhoneValid(String phone) {
    Pattern regex = Pattern.compile("[^A-Za-z0-9]");
    return regex.matcher(phone).matches();
  }
}
