package edu.pizza.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pizza extends Topping {
    private String name;
    private double preciopizza;

    private List<Topping> toppings = new ArrayList<>();

    public Pizza(String name,  Topping... toppings) {
        super(name, 40.00);
        this.name = name;

        for (Topping topping : toppings) {
            this.toppings.add(topping);
        }
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);
    }

    public void removeTopping(int index) {
        this.toppings.remove(index);
    }

    public List<Topping> getToppings() {

        return Collections.unmodifiableList(new ArrayList<>(toppings));
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return  name + toppings + "Q. " +  precio();
    }

    private String precio() {
        double precio = 40.00;
        for (Topping topping : toppings) {
            precio += topping.getPrecio();
        }
        return String.valueOf(precio);
    }

    public void prepare() {
        System.out.println("Preparing..... " + name);
        System.out.println("Adding toppings:");
        for (Topping topping : toppings) {
            System.out.println("- " + topping.getNombre());
            System.out.println("- " + topping.getPrecio());
            //put 1 second delay
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (topping.getIngredientes().size() > 0) {
                System.out.println("Ingredients:");
                for (String ingrediente : topping.getIngredientes()) {
                    System.out.println("- " + ingrediente);
                }
            }
        }

    }
}
