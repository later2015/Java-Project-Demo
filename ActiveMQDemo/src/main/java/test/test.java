package test;

import java.math.BigDecimal;

/**
 * Created by liqiliang <liqiliang@baibu.la> on 2016/10/15.
 */
public class test {
    public static void main(String[] args){
        BigDecimal test1=new BigDecimal(0.23);
        BigDecimal test2=BigDecimal.valueOf(0.23);
        //BigDecimal test3=BigDecimal.valueOf();
        System.out.print("1:"+test1+" 2:"+test2);

    }
}
