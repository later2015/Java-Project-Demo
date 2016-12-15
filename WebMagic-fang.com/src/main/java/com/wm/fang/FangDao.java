package com.wm.fang;


/**
 * Created by lisiyuan on 2016/8/23 15:16.
 */
public interface FangDao {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(FangUser user);
}
