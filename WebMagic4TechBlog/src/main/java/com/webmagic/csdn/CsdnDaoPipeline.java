package com.webmagic.csdn;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

/**
 * Created by lisiyuan on 2016/9/3 9:35.
 */
public class CsdnDaoPipeline implements PageModelPipeline<CsdnUser> {



    public CsdnDaoPipeline() {
    }

    public void process(CsdnUser oschinaUser, Task task) {
        //page.getUrl()
        task.getSite();
        System.out.println("获取到的结果："+oschinaUser.getTitle()+"  "+oschinaUser.getCount()+" 评论数："+oschinaUser.getCommentCount()+" site:"+task.getSite());
//        CsdnDao oschinaDao = new CsdnDaoImpl();
//        int row = oschinaDao.saveUser(oschinaUser);
        System.out.println("###保存成功###" + oschinaUser.toString());
    }


}
