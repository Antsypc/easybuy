package com.gentlemen.easybuy.service; 

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentlemen.easybuy.entity.Orders;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/** 
 * OrdersService Tester. 
 * 
 * @author <Authors name> 
 * @since <pre>Jul 1, 2016</pre> 
 * @version 1.0 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:config/spring/spring.xml"})
public class OrdersServiceTest {

    private OrdersService ordersService;

    @Before
    public void before() throws Exception {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"config/spring/spring.xml"});
        ordersService = (OrdersService) ac.getBean("ordersService");
    }

    @After
    public void after() throws Exception { 
    } 

    /** 
     * Method: getOrdersByUId(@Param("userId") int userId) 
     */ 
    @Test
    public void testGetOrdersByUId() throws Exception { 
    } 
    
    /** 
     * Method: getCartByUId(@Param("userId") int userId) 
     */ 
    @Test
    public void testGetCartByUId() throws Exception { 
    } 
    
    /** 
     * Method: getAllOrders() 
     */ 
    @Test
    public void testGetAllOrders() throws Exception {
        List<Orders> list = ordersService.getAllOrders();
        System.out.println(new ObjectMapper().writeValueAsString(list));
    } 
    
    /** 
     * Method: addOrder(Orders orders) 
     */ 
    @Test
    public void testAddOrder() throws Exception {
        Orders orders = new Orders();
        orders.setGid(1);
        orders.setState(0);
        orders.setTime(new Timestamp(new Date().getTime()));
        orders.setSum(2);
        orders.setTotal(30);
        orders.setUid(1);
        ordersService.addOrder(orders);
        System.out.println(orders);
    }
    
    /** 
     * Method: payOrder(int id) 
     */ 
    @Test
    public void testPayOrder() throws Exception { 
    } 
    
    /** 
     * Method: cancelOrder(int id) 
     */ 
    @Test
    public void testCancelOrder() throws Exception { 
    } 
    
    /** 
     * Method: updateOrder(Orders orders) 
     */ 
    @Test
    public void testUpdateOrder() throws Exception { 
    } 
    
    
} 
