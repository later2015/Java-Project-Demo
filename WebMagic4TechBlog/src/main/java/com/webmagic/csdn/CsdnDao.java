package com.webmagic.csdn;


/**
 * Created by lisiyuan on 2016/8/23 15:16.
 */
public interface CsdnDao {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(CsdnUser user);
}
