package com.mapsa.utils;

import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class I18n {
  private I18n() {
  }
  public static Map<String, String> getStrings(Locale locale) {
    String[] arr = {"home_page_title", "lis_page_title","menu_home_btn", "menu_studentlist_btn",
      "menu_register_student_btn", "menu_search_btn","name","id", "family", "age","sid",
      "list_tbl_head_action", "list_tbl_btn_edit","list_tbl_btn_delete","register_page_title",
    "register_page_btn_submit","search_page_title","search_page_btn","css_direction","url_suffix"};
    Map<String, String> messages = new TreeMap<>();
    ResourceBundle resourceBundle = ResourceBundle.getBundle("com.mapsa.messages", locale);
    for (String item : arr) {
      String out;
      out = new String(resourceBundle.getString(item));
//      out = new String(resourceBundle.getString(item).getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
      messages.put(item, out);
    }
    return messages;
  }
}
