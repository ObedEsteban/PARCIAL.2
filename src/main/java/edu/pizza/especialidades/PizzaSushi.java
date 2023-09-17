package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaSushi extends Pizza {
    private String salmon;

    private double price = 0;

    public String getSalmon() {
        return salmon;
    }

    public void setSalmon(String salmon) {
        this.salmon = salmon;
    }

    public PizzaSushi(String name,  String salmon, double price, Topping... toppings) {
        super(name,  toppings);
        this.salmon = salmon;
        this.price = price;
    }
}
