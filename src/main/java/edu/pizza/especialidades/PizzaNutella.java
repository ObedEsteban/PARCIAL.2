package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaNutella extends Pizza {
    private String nutella;

    private double price = 40.00;

    public String getNutella() {
        return nutella;
    }

    public void setNutella(String nutella) {
        this.nutella = nutella;
    }

    public PizzaNutella(String name,  String nutella, double price,  Topping... toppings) {
        super(name,  toppings);
        this.nutella = nutella;
        this.price = price;
    }



}
