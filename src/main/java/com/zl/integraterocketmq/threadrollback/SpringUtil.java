//package com.zl.integraterocketmq.threadrollback;
//
//import com.sf.vsolution.cszp.common.config.ApplicationContextRegister;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.annotation.Lazy;
//import org.springframework.stereotype.Component;
//
///**
// * @Author: zhouliang
// * @Date: 2019/6/4 20:59
// */
//@Component
//@Lazy(false)
//public class SpringUtil implements ApplicationContextAware {
//    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextRegister.class);
//    private static ApplicationContext APPLICATION_CONTEXT;
//
//    /**
//     * 设置spring上下文  *  * @param applicationContext spring上下文  * @throws BeansException
//     */
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//        LOGGER.debug("ApplicationContext registed-->{}", applicationContext);
//        APPLICATION_CONTEXT = applicationContext;
//    }
//
//    public static ApplicationContext getApplicationContext() {
//        return APPLICATION_CONTEXT;
//    }
//}
