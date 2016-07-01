package com.gentlemen.easybuy.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gentlemen.easybuy.entity.Goods;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by dengfei on 2016/6/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//配置了@ContextConfiguration注解并使用该注解的locations属性指明spring和配置文件之后，
@ContextConfiguration(locations = {"classpath*:config/spring.xml"})
public class GoodsServiceTest {

    private GoodsService goodsService;

    /**
     * 这个before方法在所有的测试方法之前执行，并且只执行一次
     * 所有做Junit单元测试时一些初始化工作可以在这个方法里面进行
     * 比如在before方法里面初始化ApplicationContext和categoryService
     */
    @Before
    public void before() throws Exception {
        //使用"spring.xml"和"spring.xml"这两个配置文件创建Spring上下文
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String[]{"config/spring.xml"});
        //从Spring容器中根据bean的id取出我们要使用的categoryService对象
        goodsService = (GoodsService) ac.getBean("goodsService");
    }

    @After
    public void after() throws Exception {
    }

    /**
     * Method: getGoodsByCategory(String)
     */
    @Test
    public void testGetGoodsByCategory() throws Exception {
        List<Goods> goods = goodsService.getGoodsByCategory("com");
        for(Goods good : goods){
            System.out.println(good.getName());
        }

    }

    /**
     * Method: findGoodsByName(String )
     */
    @Test
    public void testFindGoodsByName() throws Exception {
        List<Goods> goodses = goodsService.findGoodsByName("A");
        for(Goods goods : goodses)
            System.out.println(goods.getName());
    }

    /**
     * Mathod: orderGoodsByPrice()
     */
    @Test
    public void testOrderGoodsByPrice() throws Exception {
        List<Goods> goodses = goodsService.orderGoodsByPrice();
        for(Goods goods : goodses)
            System.out.println(goods.getName());
    }

    @Test
    public void testGetGoodsSnap() throws JsonProcessingException {
        List<Goods> list = goodsService.getGoodsSnap();
        System.out.println(list.size());
        String json = "goodsInfo" + new ObjectMapper().writeValueAsString(list);
        System.out.println(json);
    }
}
