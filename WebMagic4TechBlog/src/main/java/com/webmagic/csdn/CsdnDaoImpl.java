package com.webmagic.csdn;

import com.webmagic.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisiyuan on 2016/9/3 10:02.
 */
public class CsdnDaoImpl implements CsdnDao {



    public int saveUser(CsdnUser user) {
        DBHelper dbhelper = new DBHelper();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into spider_oschina_user(name,focus,fans,integral,joindate,location,workunit,cityring,devplatform,domain)")
                .append(" VALUES (?,?,?,?,?,?,?,?,?,?) ");

        List<String> sqlValues = new ArrayList<String>();
        sqlValues.add(user.getTitle());
        sqlValues.add(user.getCount());
        sqlValues.add(user.getContent());
        sqlValues.add(user.getFromUrl());
        sqlValues.add(user.getCommentCount());
        sqlValues.add(user.getTags());
        sqlValues.add(user.getCategory());

        int result = dbhelper.executeUpdate(sql.toString(), sqlValues);
        return result;
    }
}
