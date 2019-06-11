package p13.pojo;

public class Goods {

    private String goodsname;
    private double goodsprice;
    private int goodsnumber;

    public Goods(){}

    public Goods(String goodsname, double goodsprice, int goodsnumber){
        this.goodsname = goodsname;
        this.goodsprice = goodsprice;
        this.goodsnumber = goodsnumber;
    }

    public String getGoodsname() {
        return goodsname;
    }

    public void setGoodsname(String goodsname) {
        this.goodsname = goodsname;
    }

    public double getGoodsprice() {
        return goodsprice;
    }

    public void setGoodsprice(double goodsprice) {
        this.goodsprice = goodsprice;
    }

    public int getGoodsnumber() {
        return goodsnumber;
    }

    public void setGoodsnumber(int goodsnumber) {
        this.goodsnumber = goodsnumber;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsname='" + goodsname + '\'' +
                ", goodsprice=" + goodsprice +
                ", goodsnumber=" + goodsnumber +
                '}';
    }

}
