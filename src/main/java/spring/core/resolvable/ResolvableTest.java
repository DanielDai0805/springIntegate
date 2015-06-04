package spring.core.resolvable;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dc on 2015/6/3.
 * link:    http://jinnianshilongnian.iteye.com/blog/1993608
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

    @Test
    public void testParameterizedTypeWithJavaSe() throws Exception {
        ParameterizedType parameterizedType = (ParameterizedType) ABService.class.getGenericInterfaces()[0];
        System.out.println(parameterizedType);
        System.out.println(parameterizedType.getActualTypeArguments()[0]);
        System.out.println(parameterizedType.getActualTypeArguments()[1]);
    }

    /**
     * Spring ResolvableType API提供更加简单易用的泛型操作支持
     * @throws Exception
     */
    @Test
    public void testResolvableWithSpring() throws Exception {
        ResolvableType resolvableType = ResolvableType.forClass(ABService.class);//通过如上API，可以得到类型的ResolvableType，如果类型被Spring AOP进行了CGLIB代理，请使用ClassUtils.getUserClass(ABService.class)得到原始类型
        Class<?> resolve = resolvableType.getInterfaces()[0].getGeneric(1).resolve();//泛型参数的第1个位置（从0开始）的类型信息
        System.out.println(resolve);

        ResolvableType resolvableTypeField = ResolvableType.forField(ReflectionUtils.findField(FieldClass.class,"cdService"));
        resolvableTypeField.getGeneric(0).resolve();//Service<C, D>的第0个位置上的泛型实参类型，即C

    }

    private class FieldClass{
        @Autowired
        private Service<ABCDClass.A, ABCDClass.B> abService;
        @Autowired
        private Service<ABCDClass.C, ABCDClass.D> cdService;

        private List<List<String>> list;

        private Map<String, Map<String, Integer>> map;

        private List<String>[] array;
    }
}
