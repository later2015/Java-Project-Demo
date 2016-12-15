package com.wm.oschina;


/**
 * Created by lisiyuan on 2016/8/23 15:16.
 */
public interface OschinaDao {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    public int saveUser(OschinaUser user);
}
