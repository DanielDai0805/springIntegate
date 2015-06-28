package jdk.I18n.format;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by dc on 2015/6/28.
 */
public class MessageFormatDemo {
    static  void displayMessage(Locale currentLocale) {

        System.out.println("currentLocale = " + currentLocale.toString());
        System.out.println();

        ResourceBundle messages =
                ResourceBundle.getBundle("MessageBundle", currentLocale);

        Object[] messageArguments = {
                messages.getString("planet"),
                new Integer(7),
                new Date()
        };

        MessageFormat formatter = new MessageFormat("");
        formatter.setLocale(currentLocale);

        formatter.applyPattern(messages.getString("template"));
        String output = formatter.format(messageArguments);

        System.out.println(output);

    }

    static public void main(String[] args) {
        displayMessage(new Locale("en", "US"));
        System.out.println();
        displayMessage(new Locale("de", "DE"));
    }
}
