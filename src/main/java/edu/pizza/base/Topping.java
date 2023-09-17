package edu.pizza.base;

import java.util.ArrayList;


public class Topping {

    private double precio;
    private String nombre;
    private ArrayList<String> ingredientes = new ArrayList<>();

    private ArrayList<String> pizzas = new ArrayList<>();
    public void agregarIngrediente(String ingrediente) {
        this.ingredientes.add(ingrediente);
    }
    double preciopizza = getPrecio();

    public Topping(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    @Override
    public String toString() {
        return  nombre + " Q." +  precio ;
    }

    public double getPrecio() {
        return precio;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(ArrayList<String> ingredientes) {
        this.ingredientes = ingredientes;
    }


}
