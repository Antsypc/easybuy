package com.gentlemen.easybuy.service; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * AdminService Tester. 
 * 
 * @author <Authors name> 
 * @since <pre>Jun 29, 2016</pre> 
 * @version 1.0 
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，
@ContextConfiguration(locations = {"classpath*:config/spring.xml"})
public class AdminServiceTest { 

    private AdminService adminService;

    /**
     * 这个before方法在所有的测试方法之前执行，并且只执行一次
     * 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
     * 比如在before方法里面初始化ApplicationContext和userService
     */
    @Before
    public void before() throws Exception {
        //使用"spring.xml"和"spring.xml"这两个配置文件创建Spring上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"config/spring.xml"});
        //从Spring容器中根据bean的id取出我们要使用的userService对象
        adminService = (AdminService) ac.getBean("adminService");
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
     * Method: getAdminById(int id) 
     */ 
    @Test
    public void testGetAdminById() throws Exception {

        System.out.println(adminService.getAdminById(1));
        System.out.println(adminService.getAdminById(3));
    } 
    
    /** 
     * Method: getAdminByName(String username) 
     */ 
    @Test
    public void testGetAdminByName() throws Exception { 
    } 
    
    
} 
