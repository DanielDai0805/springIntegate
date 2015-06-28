package jdk.I18n;

import com.sun.imageio.plugins.common.I18N;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by dc on 2015/6/26.
 */
public class I18NSample {
    public static void main(String[] args) {
        String language;
        String country;
        if(args.length!=2){
            language = new String("en");
            country = new String("US");
        } else {
            language = new String(args[0]);
            country = new String(args[1]);
         }
        Locale currentLocal;
        ResourceBundle message;

        currentLocal = new Locale(language,country);

        /**
         * 注意资源文件的位置
         * */
        ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", currentLocal, I18NSample.class.getClassLoader());
        System.out.println(messages.getString("greetings"));
        System.out.println(messages.getString("inquiry"));
        System.out.println(messages.getString("farewell"));

    }
}
