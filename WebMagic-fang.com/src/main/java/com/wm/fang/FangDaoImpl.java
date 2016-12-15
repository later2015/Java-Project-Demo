package com.wm.fang;

import com.wm.util.DBHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lisiyuan on 2016/9/3 10:02.
 */
public class FangDaoImpl implements FangDao {



    public int saveUser(FangUser user) {
        DBHelper dbhelper = new DBHelper();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into fang2(houseName,price,startyear,green,contain,monthprice,areas,address,house1,house2,house3,house4,house5,count,detail,totalhouse,city,cityarea,logDate)")
                .append(" VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate()) ");

        String d=user.getDetail();
        if (d.contains("建筑年代：</strong>"))
            user.setStartyear(d.substring(d.indexOf("建筑年代：</strong>")+14,d.indexOf("建筑年代：</strong>")+24));//建筑年代

        Pattern p = Pattern.compile("([\\s\\S]*)(容.*积.*率：</strong>)(.*)(</li>)([\\s\\S]*)");//容积率
        Matcher m = p.matcher(d);
        if (m.matches()){
            user.setContain(m.group(3));
        }

        Pattern pGreen = Pattern.compile("([\\s\\S]*)(绿.*化.*率：</strong>)(.*)(</li>)([\\s\\S]*)");//绿化率
        Matcher mGreen = pGreen.matcher(d);
        if (mGreen.matches()){
            user.setGreen(mGreen.group(3));
        }

        Pattern pMonthPrice = Pattern.compile("([\\s\\S]*)(物.*业.*费：</strong>)(.*)(</li>)([\\s\\S]*)");//物业费
        Matcher mMonthPrice = pMonthPrice.matcher(d);
        if (mMonthPrice.matches()){
            user.setMonthprice(mMonthPrice.group(3));
        }

        Pattern pAddress = Pattern.compile("([\\s\\S]*)(小区地址：</strong>)(.*)(<a class=\"link_map\")([\\s\\S]*)");//小区地址
        Matcher mAddress = pAddress.matcher(d);
        if (mAddress.matches()){
            user.setAddress(mAddress.group(3));
        }

        Pattern pTotal = Pattern.compile("([\\s\\S]*)(总.*户.*数：</strong>)(.*)(</li>)([\\s\\S]*)");//物业费
        Matcher mTotal = pTotal.matcher(d);
        if (mTotal.matches()){
            user.setTotalhouse(mTotal.group(3));
        }
        List<String> sqlValues = new ArrayList<String>();
        sqlValues.add(user.getHouse().replace("小区网",""));
        sqlValues.add(user.getPrice());
        sqlValues.add(user.getStartyear());
        sqlValues.add(user.getGreen());
        sqlValues.add(user.getContain());
        sqlValues.add(user.getMonthprice());
        sqlValues.add(user.getAreas());
        sqlValues.add(user.getAddress());
        String house1=user.getHouse1()==null?"0":user.getHouse1();
        sqlValues.add(house1.replace("套",""));
        sqlValues.add(user.getHouse2().replace("套",""));
        sqlValues.add(user.getHouse3().replace("套",""));
        sqlValues.add(user.getHouse4().replace("套",""));
        String house5=user.getHouse5()==null?"0":user.getHouse5();
        sqlValues.add(house5.replace("套",""));
        sqlValues.add(user.getCount());
        sqlValues.add(user.getDetail());
        String totalHouse=user.getTotalhouse()==null?"0":user.getTotalhouse();
        sqlValues.add(totalHouse.replace("户",""));//总户数
        sqlValues.add(user.getCity().replace("二手房",""));//城市
        sqlValues.add(user.getCityarea().replace("小区二手房",""));//区
        int result = dbhelper.executeUpdate(sql.toString(), sqlValues);
        return result;
    }
}
