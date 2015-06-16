package spring.bean.bean.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dc on 2015/6/16.
 * link:http://www.mkyong.com/spring/spring-mapfactorybean-example/
 */
public class MapFactoryBeanTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/MapFactoryBeanTest.xml");

        Customer cust = (Customer)context.getBean("CustomerBean");
        System.out.println(cust.getMaps());
    }
}
