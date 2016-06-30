//package com.gentlemen.easybuy.service;
//
//import com.gentlemen.easybuy.entity.Category;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import java.util.List;
//
///**
// * Created by dengfei on 2016/6/30.
// */
//@RunWith(SpringJUnit4ClassRunner.class)
////配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，
//@ContextConfiguration(locations = {"classpath*:config/spring.xml"})
//public class CategotyServiceTest {
//
//        private CategoryServer categoryServer;
//
//        /**
//         * 这个before方法在所有的测试方法之前执行，并且只执行一次
//         * 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
//         * 比如在before方法里面初始化ApplicationContext和categoryService
//         */
//        @Before
//        public void before() throws Exception {
//            //使用"spring.xml"和"spring.xml"这两个配置文件创建Spring上下文
//            ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"config/spring.xml"});
//            //从Spring容器中根据bean的id取出我们要使用的categoryService对象
//            categoryServer = (CategoryServer) ac.getBean("categoryService");
//        }
//
//        @After
//        public void after() throws Exception {
//        }
//
//        /**
//         * Method: getCategorys()
//         */
//        @Test
//        public void testGetCategorys() throws Exception {
//          List<Category> categorys = categoryServer.getCategorys();
//          for(Category category : categorys){
//              System.out.println(category.getName());
//          }
//
//        }
//
//        /**
//         * Method: getAdminByName(String username)
//         */
//        @Test
//        public void testGetAdminByName() throws Exception {
//        }
//}
