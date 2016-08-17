package com.baibu.pay.dao;

import com.baibu.pay.domain.Test;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2016/6/28.
 */
@Repository("testDao")
public interface TestDaoMapper {
    //Test
    public Test selectTest();
}
