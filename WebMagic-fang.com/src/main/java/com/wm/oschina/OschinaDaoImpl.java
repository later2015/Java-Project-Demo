package com.wm.oschina;

import com.wm.util.DBHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lisiyuan on 2016/9/3 10:02.
 */
public class OschinaDaoImpl implements OschinaDao {



    public int saveUser(OschinaUser user) {
        DBHelper dbhelper = new DBHelper();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into spider_oschina_user(name,focus,fans,integral,joindate,location,workunit,cityring,devplatform,domain)")
                .append(" VALUES (?,?,?,?,?,?,?,?,?,?) ");

        List<String> sqlValues = new ArrayList<String>();
        sqlValues.add(user.getName());
        sqlValues.add(user.getFocus());
        sqlValues.add(user.getFans());
        sqlValues.add(user.getIntegral());
        sqlValues.add(user.getJoinDate());
        sqlValues.add(user.getLocation());
        sqlValues.add(user.getWorkUnit());
        StringBuilder cityRingStrs = new StringBuilder();
        if(user.getCityRing()!=null){
            for (String str : user.getCityRing()){
                cityRingStrs.append(str);
            }
        }
        sqlValues.add(cityRingStrs.toString());
        sqlValues.add(user.getDevPlatform());
        sqlValues.add(user.getDomain());
        int result = dbhelper.executeUpdate(sql.toString(), sqlValues);
        return result;
    }
}
