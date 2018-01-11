package com.center.ropcenter.action;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class AppContext extends Context implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    /**
     * 获取指定id的bean对象
     * @param beanId
     * @return
     */
    public Object getBean(String beanId){
        return applicationContext.getBean(beanId);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public <T> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }
}
