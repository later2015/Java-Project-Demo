package com.wm.fang;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by lisiyuan on 2016/9/3 9:35.
 */
public class FangDaoPipeline implements PageModelPipeline<FangUser> {



    public FangDaoPipeline() {
    }

    public void process(FangUser fangUser, Task task) {
        FangDao fangDao = new FangDaoImpl();
        int row = fangDao.saveUser(fangUser);
        System.out.println("###保存成功###" + fangUser.toString());
    }


}
