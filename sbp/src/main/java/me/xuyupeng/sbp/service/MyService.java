package me.xuyupeng.sbp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 一个简单的饿service bean
 *
 * @author xuyupeng
 * @date 2020/4/11 18:50
 */
@Slf4j
@Component
public class MyService implements ApplicationContextAware, ApplicationEventPublisherAware, EmbeddedValueResolverAware,
        EnvironmentAware, ResourceLoaderAware, BeanNameAware, BeanClassLoaderAware, BeanFactoryAware {
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        log.info("ApplicationContextAware");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        log.info("BeanClassLoaderAware");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        log.info("BeanFactoryAware");
    }

    @Override
    public void setBeanName(String s) {
        log.info("BeanNameAware");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        log.info("ApplicationEventPublisherAware");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        log.info("EmbeddedValueResolverAware");
    }

    @Override
    public void setEnvironment(Environment environment) {
        log.info("EnvironmentAware");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        log.info("ResourceLoaderAware");
    }
}
