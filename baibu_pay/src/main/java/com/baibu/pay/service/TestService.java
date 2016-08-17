package com.baibu.pay.service;

import com.baibu.pay.dao.TestDaoMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/6/28.
 */
@Service
public class TestService {
    private Logger log = Logger.getLogger( TestService.class);

    @Autowired
    @Qualifier("testDao")
    private TestDaoMapper testDao;

    public String testGetValue(){
        return testDao.selectTest().getA();
    }
}
