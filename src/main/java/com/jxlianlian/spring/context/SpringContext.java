package com.jxlianlian.spring.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/* Spring中的bean如果实现 ApplicationContextAware 的话，spring会自动调用
 * setApplicationContext 接口，可以用来保存上下文
 */
@Component
public class SpringContext implements ApplicationContextAware {

  private static ApplicationContext applicationContext; // Spring应用上下文环境

  /*
   * 实现了ApplicationContextAware 接口，必须实现该方法；
   * 通过传递applicationContext参数初始化成员变量applicationContext
   */
  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    this.applicationContext = applicationContext;
  }

  public static ApplicationContext getApplicationContext() {
    return applicationContext;
  }

  @SuppressWarnings("unchecked")
  public static <T> T getBean(String name) throws BeansException {
    return (T) applicationContext.getBean(name);
  }
}
