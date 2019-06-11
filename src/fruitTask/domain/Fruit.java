package fruitTask.domain;

public class Fruit {

    private String name;
    private double price;
    private String producing_area;

    public Fruit(){}

    public Fruit(String name, double price, String producing_area) {
        this.name = name;
        this.price = price;
        this.producing_area = producing_area;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProducing_area() {
        return producing_area;
    }

    public void setProducing_area(String producing_area) {
        this.producing_area = producing_area;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", producing_area='" + producing_area + '\'' +
                '}';
    }
}
