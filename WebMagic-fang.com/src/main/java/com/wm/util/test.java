package com.wm.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by later on 2016/10/5.
 */
public class test {
    public static void main(String[] args){
        String t="<li><strong>建筑年代：</strong>2013-02-18</li>";
        System.out.print(t.substring(t.indexOf("建筑年代：</strong>")+14,t.indexOf("建筑年代：</strong>")+24));
        Pattern p = Pattern.compile("([\\s\\S]*)(n.*a.*m.*e:)([a-zA-Z]*)(,age:)([0-9]*)");
        Matcher m = p.matcher("mmmmmn a m&&e:vunv,age:20");
        while (m.find()) {
            System.out.println(m.group(3));
            System.out.println(m.group(5));
        }
    }
}
