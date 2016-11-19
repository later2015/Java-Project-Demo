package com.webmagic.tutu12345;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.monitor.SpiderMonitor;

import javax.management.JMException;
import java.util.List;

/**
 * Created by liqiliang on 2016/10/22 10:54.
 */

@TargetUrl({"http://www.tutu12345.net/a/cn/AISS/[a-z0-9]+/[a-z0-9]+/[a-z0-9_]+.html"})
@HelpUrl("http://www.tutu12345.net/")
public class TutuUser implements AfterExtractor {

    //标题
    @ExtractBy(value = "//p/img/@src",notNull = true)
    private List<String> imgs;

    //阅读数
    @ExtractBy(value = "//li[@class='read']/span[@id='read']/text()",notNull = false)
    private String count;

    //文章内容
    @ExtractBy(value = "//title/text()",notNull = false)//如果里面内容还有节点的，不能使用text(),会获取不到内容
    private String title;

    //原文URL TODO 没写好的xpath一定要把notNull set为false，设为true的话，他一直不match，一直没数据，就会一直不触发那个pipeline
    private String fromUrl;

    //评论数
    @ExtractBy(value = "//li[@class='comment']/a/span[@id='comment']/text()",notNull = false)
    private String commentCount;

    //标签
    @ExtractBy(value = "//div[@class='tags']/span[@class='tag' and @id='tag'][1]/a/text()",notNull = false)
    private String tags1;
    @ExtractBy(value = "//div[@class='tags']/span[@class='tag' and @id='tag'][2]/a/text()",notNull = false)
    private String tags2;
    @ExtractBy(value = "//div[@class='tags']/span[@class='tag' and @id='tag'][3]/a/text()",notNull = false)
    private String tags3;
    @ExtractBy(value = "//div[@class='tags']/span[@class='tag' and @id='tag'][4]/a/text()",notNull = false)
    private String tags4;
    //分类
    @ExtractBy(value = "//li[@class='classify']/span[@id='classify']/a/text()",notNull = false)
    private String category;


    public void afterProcess(Page page) {
        setFromUrl(String.valueOf(page.getUrl()));
        System.out.println("URL::"+page.getUrl());
    }


    public List<String> getImgs() {
        return imgs;
    }

    public void setImgs(List<String> imgs) {
        this.imgs = imgs;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFromUrl() {
        return fromUrl;
    }

    public void setFromUrl(String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public String getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(String commentCount) {
        this.commentCount = commentCount;
    }

    public String getTags1() {
        return tags1;
    }

    public void setTags1(String tags1) {
        this.tags1 = tags1;
    }

    public String getTags2() {
        return tags2;
    }

    public void setTags2(String tags2) {
        this.tags2 = tags2;
    }

    public String getTags3() {
        return tags3;
    }

    public void setTags3(String tags3) {
        this.tags3 = tags3;
    }

    public String getTags4() {
        return tags4;
    }

    public void setTags4(String tags4) {
        this.tags4 = tags4;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public static void main(String[] args) throws JMException {

        Spider spider = OOSpider.create(
                Site.me().setRetryTimes(10).setSleepTime(100000),
                new TutuDaoPipeline(), TutuUser.class)
                .addUrl("http://www.tutu12345.net/a/cn/AISS/2016/0703/20991.html").thread(10);//https://my.oschina.net/u/2249566/blog/758673
        SpiderMonitor.instance().register(spider);
        spider.start();
    }
}
