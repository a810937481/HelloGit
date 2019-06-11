package p13.converter;

import org.springframework.core.convert.converter.Converter;
import p13.pojo.Goods;

public class GoodsConverter implements Converter<String, Goods> {
    @Override
    public Goods convert(String s) {
        Goods goods = new Goods();
        String stringValues[] = s.split(",");
        if (stringValues != null && stringValues.length == 3){
            goods.setGoodsname(stringValues[0]);
            goods.setGoodsprice(Double.parseDouble(stringValues[1]));
            goods.setGoodsnumber(Integer.parseInt(stringValues[2]));
            return goods;
        }else {
            throw new IllegalArgumentException(
              String.format("类型转换失败，需要格式'apple,10.58,200',但格式是[%s]",s)
            );
        }
    }
}
