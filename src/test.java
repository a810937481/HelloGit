import java.text.SimpleDateFormat;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        Date date1 = new Date(time);
        Date date2 = new Date(System.currentTimeMillis());
        System.out.println(format.format(date1));
        System.out.println(date2);
    }
}

//    Date d1 = new Date(System.currentTimeMillis()-1000);
//    Date d2 = new Date(System.currentTimeMillis());
//System.out.println(d1.compareTo(d2));
//        　　java util date 自带了compareTo 功能，可直接比较大小。
//
//        　　前者大于后者 返回大于0 反之小于0。