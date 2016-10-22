package com.webmagic.oschina;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by liqiliang on 2016/10/23 9:35.
 */
public class OschinaDaoPipeline implements PageModelPipeline<OschinaUser> {



    public OschinaDaoPipeline() {
    }

    public void process(OschinaUser oschinaUser, Task task) {
        //page.getUrl()
        System.out.println("获取到的结果："+oschinaUser.getTitle()+"  "+oschinaUser.getCount()+" 评论数："+oschinaUser.getCommentCount());
//        OschinaDao oschinaDao = new OschinaDaoImpl();
//        int row = oschinaDao.saveUser(oschinaUser);
        System.out.println("###保存成功###" + oschinaUser.toString());
    }


}
