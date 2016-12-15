package com.wm.fang;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.model.AfterExtractor;
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
//@TargetUrl({"http://*.fang.com/","http://*.fang.com/esf/","http://jinxiuyinwan.fang.com/"})
@TargetUrl({"http://*.fang.com/","http://*.fang.com/esf/"})
@HelpUrl({"http://esf.gz.fang.com/housing/","http://esf.gz.fang.com/housing/*/"})
public class FangUser implements AfterExtractor {
    private static Site site = Site.me().setCycleRetryTimes(5).setRetryTimes(5).setSleepTime(500).setTimeOut(3 * 60 * 1000)
            .setUserAgent("Mozilla/5.0 (Windows NT 6.1; WOW64; rv:38.0) Gecko/20100101 Firefox/38.0")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
            .setCharset("UTF-8");
    //城市
    @ExtractBy(value = "//div[@id='esfbjxq_C02_15']//a[@id='esfbjxq_01']/text()",notNull = true)
    private String city;
    //区
    @ExtractBy(value = "//div[@id='esfbjxq_C02_15']//a[4]/text()",notNull = false)
    private String cityarea;
    //小区名
    @ExtractBy(value = "//div[@class='ceninfo_sq']//a[@id='xqw_B01_12']/text()",notNull = true)
    private String house;

    //价格
    @ExtractBy(value = "//div[@class='plptinfo_tip']//strong[@class='red']/text()", notNull = true)
    private String price;

    //建筑年代
    @ExtractBy(value = "//div[@class='plptinfo_list clearfix']/ul/li[1]/text()",notNull = false)
    private String startyear;

    //绿化率
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/div[@class='stat']/a[3]/span/text()",notNull = false)
    private String green;

    //容积率
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[1]/td/text()",notNull = false)
    private String contain;

    //物业费
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[2]/td/text()",notNull = false)
    private String monthprice;

    //区域
    @ExtractBy(value = "//div[@class='plptinfo_list clearfix']/ul/li[1]/text()",notNull = false)
    private String areas;

    //地址
    @ExtractBy(value = "//div[@id='OSC_Content']/div/div/table/tbody/tr[4]/td/a/text()",notNull = false)
    private String address;

    //在售一居室
    @ExtractBy(value = "//div[@class='house_class']/dl/dd/span[1]/a/text()",notNull = false)
    private String house1;
    //在售2居室
    @ExtractBy(value = "//div[@class='house_class']/dl/dd/span[2]/a/text()",notNull = false)
    private String house2;
    //在售3居室
    @ExtractBy(value = "//div[@class='house_class']/dl/dd/span[3]/a/text()",notNull = false)
    private String house3;
    //在售4居室
    @ExtractBy(value = "//div[@class='house_class']/dl/dd/span[4]/a/text()",notNull = false)
    private String house4;
    //在售5居室
    @ExtractBy(value = "//div[@class='house_class']/dl/dd/span[5]/a/text()",notNull = false)
    private String house5;
    //浏览次数
    @ExtractBy(value = "//div[@class='ceninfo_sq']//p[@class='W_total_sq']/span/text()",notNull = false)
    private String count;

    //detail
    @ExtractBy(value = "//div[@class='plptinfo_list clearfix']/ul",notNull = false)
    private String detail;
    private String totalhouse;

    public void afterProcess(Page page) {
    }

    public static Site getSite() {
        return site;
    }

    public static void setSite(Site site) {
        FangUser.site = site;
    }

    public String getTotalhouse() {
        return totalhouse;
    }

    public void setTotalhouse(String totalhouse) {
        this.totalhouse = totalhouse;
    }

    public String getCityarea() {
        return cityarea;
    }

    public void setCityarea(String cityarea) {
        this.cityarea = cityarea;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getStartyear() {
        return startyear;
    }

    public void setStartyear(String startyear) {
        this.startyear = startyear;
    }

    public String getGreen() {
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public String getMonthprice() {
        return monthprice;
    }

    public void setMonthprice(String monthprice) {
        this.monthprice = monthprice;
    }

    public String getAreas() {
        return areas;
    }

    public void setAreas(String areas) {
        this.areas = areas;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHouse1() {
        return house1;
    }

    public void setHouse1(String house1) {
        this.house1 = house1;
    }

    public String getHouse2() {
        return house2;
    }

    public void setHouse2(String house2) {
        this.house2 = house2;
    }

    public String getHouse3() {
        return house3;
    }

    public void setHouse3(String house3) {
        this.house3 = house3;
    }

    public String getHouse4() {
        return house4;
    }

    public void setHouse4(String house4) {
        this.house4 = house4;
    }

    public String getHouse5() {
        return house5;
    }

    public void setHouse5(String house5) {
        this.house5 = house5;
    }

    public static void main(String[] args) throws JMException {

//        Spider spider = OOSpider.create(
//                Site.me().setRetryTimes(5).setSleepTime(1000),
//                new ConsolePageModelPipeline(), FangUser.class)
//                .addUrl("http://city.oschina.net/guangzhou").thread(5);
        String url="http://jinxiubandao.fang.com/esf/";//
        String gzurl="http://fulindasha020.fang.com/";

        Spider spider = OOSpider.create(
                Site.me().setRetryTimes(11).setSleepTime(2000),
                new FangDaoPipeline(), FangUser.class)
                .addUrl(gzurl).thread(100);
        SpiderMonitor.instance().register(spider);
        spider.start();
    }
}
