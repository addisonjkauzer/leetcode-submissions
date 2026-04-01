abstract class Coffee {
    public abstract double getCost();
}

class SimpleCoffee extends Coffee {
    @Override
    public double getCost() {
        return 1.1;
    }
}

abstract class CoffeeDecorator extends Coffee {
    protected Coffee decoratedCoffee;

    public CoffeeDecorator(Coffee coffee) {
        this.decoratedCoffee = coffee;
    }

    public double getCost() {
        return decoratedCoffee.getCost();
    }
}

class MilkDecorator extends CoffeeDecorator {

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    public double getCost() {
        return 0.5 + this.decoratedCoffee.getCost();
    }
}

class SugarDecorator extends CoffeeDecorator {
    
    public SugarDecorator(Coffee coffee) {
        super(coffee);
    }

    public double getCost() {
        return 0.2 + this.decoratedCoffee.getCost();
    }
}

class CreamDecorator extends CoffeeDecorator {
    
    public CreamDecorator(Coffee coffee) {
        super(coffee);
    }

    public double getCost() {
        return 0.7 + this.decoratedCoffee.getCost();
    }
}
