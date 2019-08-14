//package com.zl.integraterocketmq.threadrollback;
//
//import com.sf.vsolution.cszp.resource.dao.CszpAddressManageMapper;
//import com.sf.vsolution.cszp.resource.pojo.entity.CszpAddressManage;
//import com.sf.vsolution.cszp.webapp.service.SpringUtil;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.jdbc.datasource.DataSourceTransactionManager;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.PlatformTransactionManager;
//import org.springframework.transaction.TransactionDefinition;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.support.DefaultTransactionDefinition;
//
//import java.util.Date;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
///**
// * @Author: zhouliang
// * @Date: 2019/6/4 20:48
// */
//@Service
//@Slf4j
//public class TestService {
//
//    @Autowired
//    private CszpAddressManageMapper cszpAddressManageMapper;
//
//    @Autowired
//    private DataSourceTransactionManager txManager;
//
//    @Autowired
//    private SpringUtil springUtil;
//
//    public void test() {
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        //第一种方式 springgetbean的方式注入txmanager
////        for (int i = 0; i < 10; i++) {
////            TestTask task = new TestTask(cszpAddressManageMapper, i);
////            executorService.execute(task);
////        }
//        //第二种autowired注入
//        for (int i = 0; i < 10; i++) {
//            Test1Task task1 = new Test1Task(txManager, cszpAddressManageMapper, i);
//            executorService.execute(task1);
//        }
//        executorService.shutdown();
//    }
//
//    private class TestTask implements Runnable {
//
//        private CszpAddressManageMapper cszpAddressManageMapper;
//        private int i;
//
//        TestTask(CszpAddressManageMapper cszpAddressManageMapper, int i) {
//            this.cszpAddressManageMapper = cszpAddressManageMapper;
//            this.i = i;
//        }
//
//        @Override
//        public void run() {
//            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//            ApplicationContext applicationContext = SpringUtil.getApplicationContext();
//            PlatformTransactionManager txManager = applicationContext.getBean(PlatformTransactionManager.class);
//            TransactionStatus status = txManager.getTransaction(def);
//
//            CszpAddressManage addressManage = new CszpAddressManage();
//            addressManage.setSendCompany("张三公司" + i);
//            addressManage.setStatus(Boolean.TRUE);
//            addressManage.setCreateTime(new Date());
//            try {
//                cszpAddressManageMapper.insertAddress(addressManage);
//                if (i == 2 || i == 4 || i == 6) {
//                    int a = 1 / 0;
//                    System.out.println(a);
//                }
//            } catch (Exception e) {
//                log.info("异常信息：" + e.toString());
//                // 回滚事务
//                txManager.rollback(status);
//                throw e;
//            }
//            // 提交事务
//            txManager.commit(status);
//        }
//    }
//
//    private class Test1Task implements Runnable {
//
//        private DataSourceTransactionManager txManager;
//        private CszpAddressManageMapper cszpAddressManageMapper;
//        private int i;
//
//        Test1Task(DataSourceTransactionManager txManager, CszpAddressManageMapper cszpAddressManageMapper, int i) {
//            this.txManager = txManager;
//            this.cszpAddressManageMapper = cszpAddressManageMapper;
//            this.i = i;
//        }
//
//        @Override
//        public void run() {
//            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
//            // 事物隔离级别，开启新事务
//            def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRES_NEW);
//            // 获得事务状态
//            TransactionStatus status = txManager.getTransaction(def);
//            CszpAddressManage addressManage = new CszpAddressManage();
//            addressManage.setSendCompany("张三公司" + i);
//            addressManage.setStatus(Boolean.TRUE);
//            addressManage.setCreateTime(new Date());
//            try {
//                cszpAddressManageMapper.insertAddress(addressManage);
//                if (i == 2 || i == 4 || i == 6) {
//                    int a = 1 / 0;
//                    System.out.println(a);
//                }
//            } catch (Exception e) {
//                log.info("异常信息：" + e.toString());
//                // 回滚事务
//                txManager.rollback(status);
//                throw e;
//            }
//            // 提交事务
//            txManager.commit(status);
//        }
//    }
//}
