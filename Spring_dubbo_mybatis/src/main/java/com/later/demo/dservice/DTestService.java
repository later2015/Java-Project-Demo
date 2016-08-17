package com.later.demo.dservice;

import com.alibaba.dubbo.config.annotation.Service;
import com.later.demo.dservice.api.DTest;
import com.later.demo.service.TestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2016/6/28.
 */
@Service(version = "0.1", protocol = "dubbo")
public class DTestService implements DTest{
    private Logger log = Logger.getLogger( DTestService.class);

    @Autowired
    private TestService testService;
    @Override
    public String getValue() {
        return testService.testGetValue();
    }
}
