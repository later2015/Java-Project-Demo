package com.webmagic.iteye;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by liqiliang on 2016/10/23 9:35.
 */
public class IteyeDaoPipeline implements PageModelPipeline<IteyeUser> {



    public IteyeDaoPipeline() {
    }

    public void process(IteyeUser oschinaUser, Task task) {
        //page.getUrl()
        oschinaUser.setCount(oschinaUser.getCount().replace("浏览","").trim());
        System.out.println("获取到的结果："+oschinaUser.getTitle()+"  "+oschinaUser.getCount()+" 评论数："+oschinaUser.getCommentCount());

//        OschinaDao oschinaDao = new OschinaDaoImpl();
//        int row = oschinaDao.saveUser(oschinaUser);
        System.out.println("###保存成功###" + oschinaUser.toString());
    }


}
