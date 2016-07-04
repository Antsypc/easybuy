package com.gentlemen.easybuy.service; 

import com.gentlemen.easybuy.entity.User;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/** 
 * UserService Tester. 
 * 
 * @author <Authors name> 
 * @since <pre>Jun 30, 2016</pre> 
 * @version 1.0 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/spring/spring.xml"})
public class UserServiceTest { 

    private UserService userService;
    @Before
    public void before() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"config/spring/spring.xml"});
        userService = (UserService) ac.getBean("userService");
    } 

    @After
    public void after() throws Exception { 
    } 

    /** 
     * Method: getUserById(int id) 
     */ 
    @Test
    public void testGetUserById() throws Exception {
        System.out.println(userService.getUserById(1));
        System.out.println(userService.getUserById(3));
    }
    
    /** 
     * Method: getUserByName(String username) 
     */ 
    @Test
    public void testGetUserByName() throws Exception {
        System.out.println(userService.getUserByName("小明"));
    } 
    
    /** 
     * Method: addUser(User user) 
     */ 
    @Test
    public void testAddUser() throws Exception {
//        User user = new User();
//        user.setUsername("test001");
//        user.setPassword("123456");
//        user.setPhone("12312345678");
//        user.setAddress("test Address");
//        userService.addUser(user);
    } 
    
    /** 
     * Method: updateUser(User user) 
     */ 
    @Test
    public void testUpdateUser() throws Exception {
        User user = userService.getUserById(1);
        user.setPhone("0123456789");
        userService.updateUser(user);

        user.setUsername("test001");
        user.setPassword(null);
        user.setPhone("");
        user.setAddress("test Address22");
        System.out.println(userService.updateUser(user));


    } 
    
    
} 
