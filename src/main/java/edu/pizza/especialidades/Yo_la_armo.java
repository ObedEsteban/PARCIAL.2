package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class Yo_la_armo extends Pizza {

    private double price = 0;
    public Yo_la_armo(String name, double price, Topping... toppings ) {
        super(name,  toppings);
        this.price = price;

    }
}
