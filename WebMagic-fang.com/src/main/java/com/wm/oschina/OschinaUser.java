package com.wm.oschina;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.AfterExtractor;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.ExtractByUrl;
import us.codecraft.webmagic.model.annotation.HelpUrl;
import us.codecraft.webmagic.model.annotation.TargetUrl;
import us.codecraft.webmagic.monitor.SpiderMonitor;

import javax.management.JMException;
import java.util.List;

/**
 * Created by lisiyuan on 2016/9/2 17:54.
 */
//@TargetUrl("http://my.oschina.net/\\w+")
@TargetUrl("http://www.zhihu.com/question/\\w+")
//@HelpUrl("http://www.zhihu.com/explore/\\w+")
public class OschinaUser implements AfterExtractor {

    @ExtractBy(value = "//div[@class='zm-votebar']//span[@class='count']/text()", notNull = true)
    private String name;

   // @ExtractByUrl("https://github\\.com/(\\w+)/.*")
   // private String author;

    //@ExtractBy("//div[@id='readme']/tidyText()")
    //private String readme;

    //名字
//    @ExtractBy(value = "//div[@class='user-info']/div[@class='name']/a[1]/text()",notNull = true)
//    private String name;

    //关注数
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/div[@class='stat']/a[1]/span/text()",notNull = false)
    private String focus;

    //粉丝数
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/div[@class='stat']/a[2]/span/text()",notNull = false)
    private String fans;

    //积分
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/div[@class='stat']/a[3]/span/text()",notNull = false)
    private String integral;

    //加入时间
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[1]/td/text()",notNull = false)
    private String joinDate;

    //所在地区
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[2]/td/text()",notNull = false)
    private String location;

    //工作单位
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[3]/td/text()",notNull = false)
    private String workUnit;

    //城市圈
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[4]/td/a/text()",notNull = false)
    private List<String> cityRing;

    //开发平台
//    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/ul/li[1]/p/text()",notNull = false)
    @ExtractByUrl("https://github\\.com/(\\w+)/.*")
    private String devPlatform;

    //专长领域
 //   @ExtractBy(value = "//div[@id='OSC_Content']/div/div/ul/li[2]/p/text()",notNull = false)
    @ExtractBy("//div[@id='readme']/tidyText()")
    private String domain;


    public void afterProcess(Page page) {
    }

    public List<String> getCityRing() {
        return cityRing;
    }

    public void setCityRing(List<String> cityRing) {
        this.cityRing = cityRing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getIntegral() {
        return integral;
    }

    public void setIntegral(String integral) {
        this.integral = integral;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    public String getDevPlatform() {
        return devPlatform;
    }

    public void setDevPlatform(String devPlatform) {
        this.devPlatform = devPlatform;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }


    public static void main(String[] args) throws JMException {

//        Spider spider = OOSpider.create(
//                Site.me().setRetryTimes(5).setSleepTime(1000),
//                new ConsolePageModelPipeline(), OschinaUser.class)
//                .addUrl("http://city.oschina.net/guangzhou").thread(5);

        Spider spider = OOSpider.create(
                Site.me().setRetryTimes(5).setSleepTime(1000),
                new OschinaDaoPipeline(), OschinaUser.class)
                .addUrl("http://www.zhihu.com/search?type=question&q=java").thread(5);
        SpiderMonitor.instance().register(spider);
        spider.start();
    }
}
