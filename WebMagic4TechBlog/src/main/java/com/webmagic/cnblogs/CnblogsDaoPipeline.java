package com.webmagic.cnblogs;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by liqiliang on 2016/10/23 9:35.
 */
public class CnblogsDaoPipeline implements PageModelPipeline<CnblogsUser> {



    public CnblogsDaoPipeline() {
    }

    public void process(CnblogsUser oschinaUser, Task task) {
        //page.getUrl()
        task.getSite();
        System.out.println("获取到的结果："+oschinaUser.getTitle()+"  "+oschinaUser.getCount()+" 评论数："+oschinaUser.getCommentCount()+" site:"+task.getSite());
//        CnblogsDao oschinaDao = new CnblogsDaoImpl();
//        int row = oschinaDao.saveUser(oschinaUser);
        System.out.println("###保存成功###" + oschinaUser.toString());
    }


}
