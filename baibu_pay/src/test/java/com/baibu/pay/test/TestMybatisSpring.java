package com.baibu.pay.test;

import com.baibu.pay.service.TestService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/6/28.
 */
@ContextConfiguration(locations ={"classpath:/spring-mybatis.xml"})
@RunWith(SpringJUnit4ClassRunner.class)		//表示继承了SpringJUnit4ClassRunner类
public class TestMybatisSpring {
    private static Logger logger = Logger.getLogger(TestMybatisSpring.class);

    @Resource
    private TestService testService;


    @Test
    public void test1() {
        String t = testService.testGetValue();
        System.out.println("output:"+t);
        logger.info("output："+t);

    }
}
