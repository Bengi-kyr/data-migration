package org.lopez.springboot.mybatis.conf;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextRegister implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (null == ApplicationContextRegister.applicationContext)
            ApplicationContextRegister.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    public static void printAllBeans() {
        String[] beans =
            ApplicationContextRegister.getApplicationContext().getBeanDefinitionNames();
        for (String beanName : beans) {
            Class<?> beanType =
                ApplicationContextRegister.getApplicationContext().getType(beanName);
            System.out.println("BeanName:" + beanName);
            System.out.println("Bean的类型：" + beanType);
            System.out.println("Bean所在的包：" + beanType.getPackage());
            System.out.println(
                "Bean：" + ApplicationContextRegister.getApplicationContext().getBean(beanName));
        }
    }
}
