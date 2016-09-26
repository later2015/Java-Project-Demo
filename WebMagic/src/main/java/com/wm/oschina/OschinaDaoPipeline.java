package com.wm.oschina;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by lisiyuan on 2016/9/3 9:35.
 */
public class OschinaDaoPipeline implements PageModelPipeline<OschinaUser> {



    public OschinaDaoPipeline() {
    }

    public void process(OschinaUser oschinaUser, Task task) {
        OschinaDao oschinaDao = new OschinaDaoImpl();
        int row = oschinaDao.saveUser(oschinaUser);
        System.out.println("###保存成功###" + oschinaUser.toString());
    }


}
