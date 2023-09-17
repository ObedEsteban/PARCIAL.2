package edu.pizza.especialidades;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

public class PizzaCamarones extends Pizza {
    private String camarones;

    public String getCamarones() {
        return camarones;
    }

    public void setCamarones(String camarones) {
        this.camarones = camarones;
    }

    public PizzaCamarones(String name, String camarones, Topping... toppings) {
        super(name, toppings);
        this.camarones = camarones;
    }
}
