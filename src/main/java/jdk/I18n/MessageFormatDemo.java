package jdk.I18n;

import java.text.MessageFormat;

/**
 * Created by dc on 2015/6/26.
 */
public class MessageFormatDemo {
    public static void main(String[] args) {
        String text = "hello {0},you are great {1}";
        MessageFormat mf = new MessageFormat(text);
        final String format = mf.format(new Object[]{"google", "company"});
        System.err.println(format);
    }
}
