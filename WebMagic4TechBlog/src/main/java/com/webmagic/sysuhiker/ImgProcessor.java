package com.webmagic.sysuhiker;

/**
 * Created by liqiliang <liqiliang@baibu.la> on 2016/11/18.
 */
import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.processor.PageProcessor;
import us.codecraft.webmagic.utils.UrlUtils;
import java.util.List;

public class ImgProcessor implements PageProcessor {

    private String urlPattern;

    private Site site;

    public ImgProcessor(String startUrl, String urlPattern) {
        this.site = Site.me().setDomain(UrlUtils.getDomain(startUrl));
        this.urlPattern= urlPattern;
    }

    @Override
    public void process(Page page) {

        //String imgRegex = "http://www.meizitu.com/wp-content/uploads/20[0-9]{2}[a-z]/[0-9]{1,4}/[0-9]{1,4}/[0-9a-z]{1,10}.jpg";
        String imgRegex = "http://mm.howkuai.com/wp-content/uploads/20[0-9]{2}[a-z]/08/25/limg.jpg";
        List<String> requests = page.getHtml().links().regex(urlPattern).all();
        page.addTargetRequests(requests);
        String imgHostFileName = page.getHtml().xpath("//title/text()").toString().replaceAll("[|\\pP‘’“”\\s(妹子图)]", "");
        List<String> listProcess = page.getHtml().$("div#picture").regex(imgRegex).all();
        //此处将标题一并抓取，之后提取出来作为文件名
        listProcess.add(0, imgHostFileName);
        page.putField("img", listProcess);

    }

    @Override
    public Site getSite() {
        return site;
    }
}