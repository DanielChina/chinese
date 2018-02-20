package test.zx.chinese.data;
import java.util.Calendar;
/**
 * Created by THink on 2018/1/8.
 */
public class CalenderInfo {
    String getDateAndMon(){
        Calendar calendar1=Calendar.getInstance();
        Calendar calendar2=Calendar.getInstance();
        int month,day;
        month=calendar1.get(Calendar.MONTH)+1; //Jan is 0
        day=calendar1.get(Calendar.DAY_OF_MONTH);
        return (String.format("%02d",day)+"-"+String.format("%02d",month));
    }
    int getMon(){
        int month;
        Calendar calendar1=Calendar.getInstance();
        month=calendar1.get(Calendar.MONTH)+1; //Jan is 0
        return month;
    }
    int getYear(){
        Calendar calendar1=Calendar.getInstance();
        int year;
        year=calendar1.get(Calendar.YEAR);
        return year;
    }
    int getDate(){
        int date;
        Calendar calendar1=Calendar.getInstance();
        date=calendar1.get(Calendar.DAY_OF_MONTH);
        return date;
    }
    int checkGapFromTwoDate(int year,int mon,int date){
        Calendar calendar1=Calendar.getInstance();
        Calendar calendar2=Calendar.getInstance();
        int date2=getDate();
        int mon2=getMon();
        int year2=getYear();
        if(mon2>=mon)
            year=year2;
        else
            year=year2-1;
        calendar2.set(year2, mon2-1, date2);
        calendar1.set(year, mon-1, date);
        //转换为相对时间
        long t1 = calendar1.getTimeInMillis();
        long t2 = calendar2.getTimeInMillis();
        if(t1>t2)
            t1=0;
        //计算天数
        int gap=(int)(t2 - t1)/(24 * 60 * 60 * 1000);
        return gap;
    };
    int getDateFromString(String time){
       return Integer.valueOf(time.substring(0,2));  //字符串中截取数字
    }
    int getMonFromString(String time){
        return Integer.valueOf(time.substring(3,5));
    }
    boolean checkIfNewDate(String time){
        int newDate=getDate();
        int oldDate=getDateFromString(time);
        if(newDate!=oldDate){
            return true;
        }
        return false;
    }
}
