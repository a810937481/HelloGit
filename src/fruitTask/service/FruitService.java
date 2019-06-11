package fruitTask.service;

import fruitTask.domain.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitService {

    public List<Fruit> queryFruitList() {
        List<Fruit> fruitList = new ArrayList<>();
        Fruit apple = new Fruit("苹果", 19, "山东烟台");
        Fruit banana = new Fruit("香蕉", 5, "海南");
        Fruit pear = new Fruit("梨子", 8.5, "汤山");
        fruitList.add(apple);
        fruitList.add(banana);
        fruitList.add(pear);
        return fruitList;
    }

}
