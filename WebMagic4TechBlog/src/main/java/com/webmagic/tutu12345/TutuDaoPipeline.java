package com.webmagic.tutu12345;

import com.webmagic.util.DownloadImage;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.PageModelPipeline;

import java.util.List;

/**
 * Created by liqiliang on 2016/10/23 9:35.
 */
public class TutuDaoPipeline implements PageModelPipeline<TutuUser> {



    public TutuDaoPipeline() {
    }

    public void process(TutuUser tutuUser, Task task) {
        //page.getUrl()
        System.out.println("start saving.....");
        String title=tutuUser.getTitle();
        if (title.contains("(")){
            title=title.substring(0,title.lastIndexOf("("));
        }else {
            title=title.substring(0, title.indexOf("美女图片") - 3);
        }
        List<String> imgs=tutuUser.getImgs();
        for (String img:imgs) {
            try {
                DownloadImage.download(img,img.substring(img.lastIndexOf("/")),"D:\\webmagic\\"+title);
            } catch (Exception e) {
                System.out.println("download img fail."+img);
                e.printStackTrace();
            }
        }
        System.out.println("###保存成功###" + tutuUser.toString());
    }


}
