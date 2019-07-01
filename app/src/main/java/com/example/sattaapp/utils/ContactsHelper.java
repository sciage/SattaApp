package com.example.sattaapp.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;

import timber.log.Timber;

public class ContactsHelper {

  public static ArrayList<String> readContacts(ContentResolver contentResolver) {
    long startTime;
    long endTime;
    ArrayList<String> contactsList = new ArrayList<>();
    startTime = System.currentTimeMillis();
    Timber.d(String.valueOf("CONTACTS-SYNC : START- TIME" + startTime));

    Cursor phones =
        contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null,
            null);
    if (phones != null) {
      while (phones.moveToNext()) {
        String phoneNumber =
            phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
        if (!contactsList.contains(RegexHandler.removeSpecialCharacters(phoneNumber))) {
          contactsList.add(RegexHandler.removeSpecialCharacters(phoneNumber));
        }
        Timber.d(String.valueOf(phoneNumber + " size: " + contactsList.size()));
      }
      phones.close();
      endTime = System.currentTimeMillis();
      Timber.d(String.valueOf("CONTACTS-SYNC : END- TIME : " + endTime));
      Timber.d(String.valueOf("CONTACTS-SYNC : START- TIME : " + startTime));
      Timber.d(String.valueOf("CONTACTS-SYNC : ELAPSED- TIME : " + (endTime - startTime) / 6000));
      return contactsList;
    }
    return contactsList;
  }
}