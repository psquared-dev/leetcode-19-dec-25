package designpatterns;

import java.util.Arrays;
import java.util.List;

interface Coffee {
    String getDescription();
    int getCost();
}

class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }

    @Override
    public int getCost() {
        return 1;
    }
}

abstract class CoffeeDecorator implements Coffee {
    private final Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }

    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }

    @Override
    public int getCost() {
        return decoratedCoffee.getCost();
    }
}

class Milk extends CoffeeDecorator {
    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Milk";
    }

    @Override
    public int getCost() {
        return super.getCost() + 1;
    }
}

class Cream extends CoffeeDecorator {
    public Cream(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Cream";
    }

    @Override
    public int getCost() {
        return super.getCost() + 2;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
//        Coffee coffee = new SimpleCoffee();
//        coffee = new Milk(coffee);
//        coffee = new Cream(coffee);
//        System.out.println(coffee.getDescription());
//        System.out.println(coffee.getCost());

        String[] strings = {"one", "two"};
        List<String> list = Arrays.asList(strings);
        list.set(0, "qq");
        System.out.println(Arrays.toString(strings));
        System.out.println(list);



    }
}
