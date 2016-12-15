package com.wm.fang;

import com.wm.util.DBHelper;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by later on 2016/11/22.
 */
public class DataSearch {
    public static void main(String[] args){
        try {
            String name="新月明珠花园";//"鸣翠苑";//"翠拥华庭";//"美心花园";
            List<HashMap> fang=findByName(name,"fang");
            List<HashMap> fang1=findByName(name,"fang1");
            List<HashMap> fang2=findByName(name,"fang2");

            System.out.println("houseName:"+fang.get(0).get("houseName")+" 价格："+fang.get(0).get("price")+" 日期："+fang.get(0).get("logDate")+" 地区："+fang.get(0).get("city")+fang.get(0).get("cityarea")+"在售："+fang.get(0).get("houseTotal"));
            System.out.println("houseName:"+fang1.get(0).get("houseName")+" 价格："+fang1.get(0).get("price")+" 日期："+fang1.get(0).get("logDate")+" 地区："+fang1.get(0).get("city")+fang1.get(0).get("cityarea")+"在售："+fang1.get(0).get("houseTotal"));
            System.out.println("houseName:"+fang2.get(0).get("houseName")+" 价格："+fang2.get(0).get("price")+" 日期："+fang2.get(0).get("logDate")+" 地区："+fang2.get(0).get("city")+fang2.get(0).get("cityarea")+"在售："+fang2.get(0).get("houseTotal"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //根据小区名查询
    public static List<HashMap> findByName(String name, String tableName) throws SQLException {
        DBHelper dbhelper = new DBHelper();
        String sql="select * from "+tableName+" where houseName like '%' ? '%'";
        //String sql="select houseName from fang where city = ?";
        List<String> sqlValues = new ArrayList<String>();
        sqlValues.add(name);
        ResultSet rs = dbhelper.executeQuery(sql,sqlValues);
        List<HashMap> result=new ArrayList<HashMap>();
        while (rs.next()){
            //System.out.println("rows:");
            HashMap<String,String> row=new HashMap<String, String>();
            row.put("houseName",rs.getString("houseName"));
            row.put("price",rs.getString("price"));
            row.put("logDate",rs.getString("logDate"));
            row.put("city",rs.getString("city"));
            row.put("cityarea",rs.getString("cityarea"));
            row.put("houseTotal",rs.getInt("house1")+rs.getInt("house2")+rs.getInt("house3")+rs.getInt("house4")+rs.getInt("house5")+"");
            result.add(row);
        }
        return result;
    }
}
