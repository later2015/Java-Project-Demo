package com.webmagic.sysuhiker;

import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.List;

/**
 * Created by liqiliang on 2016/10/23 9:35.
 */
public class SysuhikerDaoPipeline implements PageModelPipeline<SysuhikerUser> {



    public SysuhikerDaoPipeline() {
    }

    public void process(SysuhikerUser SysuhikerUser, Task task) {
        //page.getUrl()
        System.out.println("start saving.....");
        List<String> imgs=SysuhikerUser.getImg();
        for (String img:imgs) {
            try {
                DownloadImage.download(img,img.substring(img.lastIndexOf("/")),"D:\\webmagic\\");
            } catch (Exception e) {
                System.out.println("download img fail."+img);
                e.printStackTrace();
            }
        }
//        SysuhikerDao SysuhikerDao = new SysuhikerDaoImpl();
//        int row = SysuhikerDao.saveUser(SysuhikerUser);
        System.out.println("###保存成功###" + SysuhikerUser.toString());
    }


}
