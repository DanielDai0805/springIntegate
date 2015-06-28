package jdk.I18n;

import org.junit.Test;

import java.util.Locale;

/**
 * Created by dc on 2015/6/28.
 */
public class LocaleCreationMethods {
    /**
     * javase 7
     */
    @Test
    public void testLocaleBuilder(){
        Locale locale = new Locale.Builder().setLanguage("fr").setRegion("CA").build();

        Locale dLocale = new Locale.Builder().setLanguage("ru").setScript("Cyrl").build();//jdk7
    }

    @Test
    public void testConstrunctor() throws Exception {
        Locale aLocale = new Locale("fr", "CA");
        Locale bLocale = new Locale("en", "US");
        Locale cLocale = new Locale("en", "GB");
        Locale dLocale = new Locale("ru");

    }

    @Test
    public void testLanguageTag() throws Exception {
        Locale aLocale = Locale.forLanguageTag("en-US");
        Locale bLocale = Locale.forLanguageTag("ja-JP-u-ca-japanese");
    }

}
