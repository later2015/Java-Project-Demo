package com.demo1984s.dubbo.provider.service;

import com.demo1984s.dubbo.api.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tangjun on 16/8/15.
 */
public class DemoServiceImpl implements DemoService {

    private static Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);

    @Override
    public String sayHello(String name) {
        logger.info("func[sayHello] name[{}] desc[call by client]", name);
        return "\n##############################\nDubbo say hello " + name + " to you! \n" +
                "##############################\n";
    }

}
