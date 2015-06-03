package spring.core;

import org.junit.Test;
import org.springframework.core.ResolvableType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by dc on 2015/6/3.
 */
public class ResolvableTest {
    private HashMap<Integer,List<String>> myMap;
    @Test
    public void testExample() throws NoSuchFieldException {
        final ResolvableType myMap = ResolvableType.forField(getClass().getDeclaredField("myMap"));
        myMap.getSuperType();
        myMap.asMap();
        myMap.getGeneric(0).resolve();
        myMap.getGeneric(1).resolve();
        myMap.getGeneric(1);
        myMap.resolveGeneric(1,0);
    }

}
