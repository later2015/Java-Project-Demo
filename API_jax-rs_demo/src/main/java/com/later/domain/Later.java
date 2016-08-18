package com.later.domain;

/**
 * Created by later <later.h.p@qq.com> on 2016/8/18.
 */
public class Later {
    String title;
    String singer;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    @Override
    public String toString() {
        return "Later [title=" + title + ", singer=" + singer + "]";
    }

}
