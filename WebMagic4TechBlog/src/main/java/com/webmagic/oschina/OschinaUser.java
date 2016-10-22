package com.webmagic.oschina;

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

/**
 * Created by liqiliang on 2016/10/22 10:54.
 */

@TargetUrl("https://my.oschina.net/[u/]?[a-z0-9]+/blog/\\w+")
@HelpUrl("https://www.oschina.net/blog")
public class OschinaUser implements AfterExtractor {

    //标题
    @ExtractBy(value = "//div[@class='heading']/text()",notNull = true)
    private String title;

    //阅读数
    @ExtractBy(value = "//li[@class='read']/span[@id='read']/text()",notNull = false)
    private String count;

    //文章内容
    @ExtractBy(value = "//div[@id='blogBody']",notNull = true)//如果里面内容还有节点的，不能使用text(),会获取不到内容
    private String content;

    //原文URL TODO 没写好的xpath一定要把notNull set为false，设为true的话，他一直不match，一直没数据，就会一直不触发那个pipeline
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/div[@class='stat']/a[3]/span/text()",notNull = false)
    private String fromUrl;

    //评论数
    @ExtractBy(value = "//li[@class='comment']/a/span[@id='comment']/text()",notNull = false)
    private String commentCount;

    //标签 TODO
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[2]/td/text()",notNull = false)
    private String tags;

    //分类 TODO
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[3]/td/text()",notNull = false)
    private String category;


    public void afterProcess(Page page) {
        setFromUrl(String.valueOf(page.getUrl()));
        System.out.println("URL::"+page.getUrl());
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public static void main(String[] args) throws JMException {

        Spider spider = OOSpider.create(
                Site.me().setRetryTimes(3).setSleepTime(1000),
                new OschinaDaoPipeline(), OschinaUser.class)
                .addUrl("https://my.oschina.net/u/2249566/blog/758673").thread(5);//https://my.oschina.net/u/2249566/blog/758673
        SpiderMonitor.instance().register(spider);
        spider.start();
    }
}
