package edu.pizza;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;
import edu.pizza.especialidades.PizzaNutella;
import edu.pizza.especialidades.PizzaSushi;
import edu.pizza.especialidades.Yo_la_armo;
import edu.pizza.especialidades.PizzaItaliana;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class form4  {
    private JPanel PanelPrincipal;
    private JComboBox comboBoxPizzas;
    private JTextField textPizza;
    private JButton btnAddPizza;
    private JLabel lblTotal;
    private JList list1;
    private JButton btnPreparar;
    private JRadioButton radioButtonSmall;
    private JComboBox comboBoxToppings;
    private JList list2;
    private JRadioButton radioButtonMedium;
    private JRadioButton radioButtonLarge;
    private ButtonGroup radioButtonGroup;
    private JButton btnquitar;
    private JLabel lblMessage;
    private JLabel lblMessage2;
    private JLabel lblMessage3;
    private JLabel lblMessage4;
    private JButton btnAddIngrediente;

    public Container getPanelPrincipal() {
        return PanelPrincipal;
    }

    private DefaultListModel modeloLista = new DefaultListModel();

    private List<Topping> ingredientes = new ArrayList<>();
    private List<Topping> ingredientesAgregados = new ArrayList<>();

    private double totalPago = 0;
    double precioPizza = 1.0;
    public form4() {
        cargarToppings();
        btnAddPizza.addActionListener(e -> {
            Topping pizzas = (Topping) comboBoxPizzas.getSelectedItem();
            modeloLista.addElement(pizzas.toString());
            list1.setModel(modeloLista);
            totalPago += pizzas.getPrecio();
            lblTotal.setText(String.valueOf(totalPago));
            PizzaNutella pizzaNutella = new PizzaNutella("Pizza de Nutella", "Nutella", 40.00);
            comboBoxPizzas.addItem(pizzaNutella);
        });
        cargarPizzas();
        btnAddIngrediente.addActionListener(e -> {
            if (!modeloLista.isEmpty()) {
                Topping ingrediente = (Topping) comboBoxToppings.getSelectedItem();
                modeloLista.addElement(ingrediente.toString());
                list1.setModel(modeloLista);
                totalPago += ingrediente.getPrecio();
                lblTotal.setText(String.valueOf(totalPago));
                ingredientesAgregados.add(ingrediente);
            } else {
                JOptionPane.showMessageDialog(null, "Agrega una pizza antes de añadir ingredientes.");
            }
        });

        btnPreparar.addActionListener(e -> {
            String nombrePizza = lblMessage.getName();
            if (ingredientesAgregados.isEmpty() || comboBoxPizzas.getSelectedItem() == null || radioButtonGroup.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Asegúrate de agregar una pizza, ingredientes y seleccionar el tamaño antes de preparar.");
            } else {

                Pizza pizzaSeleccionada = (Pizza) comboBoxPizzas.getSelectedItem();

                Pizza pizza = new Pizza(nombrePizza);

                for (Topping ingrediente : ingredientesAgregados) {
                    pizza.addTopping(ingrediente);
                }

                lblMessage.setText("Preparing..... ");
                lblMessage2.setText("Añadiendo Ingredientes que seleccionó: ");
                lblMessage3.setText("Pizza Seleccionada: " + pizzaSeleccionada.toString());


                for (Topping topping : ingredientesAgregados) {
                    String ingredienteMensaje = "- " + topping.getNombre();
                    lblMessage2.setText(lblMessage2.getText() + "\n" + ingredienteMensaje);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }


                lblMessage4.setText("Total a pagar: " + totalPago);
            }
        });
        btnquitar.addActionListener(e -> {

            modeloLista.removeAllElements();


            totalPago = 0;


            lblTotal.setText(String.valueOf(totalPago));
        });

        radioButtonGroup = new ButtonGroup();
        radioButtonGroup.add(radioButtonSmall);
        radioButtonGroup.add(radioButtonMedium);
        radioButtonGroup.add(radioButtonLarge);

        radioButtonSmall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (precioPizza != 1.0) {
                    totalPago /= precioPizza;
                    precioPizza = 1.0;
                    lblTotal.setText(String.valueOf(totalPago));
                }
            }
        });
        radioButtonMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (precioPizza != 1.2) {
                    if (precioPizza != 1.0) {

                        totalPago /= precioPizza;
                    }
                    precioPizza = 1.2;
                    totalPago *= precioPizza;
                    lblTotal.setText(String.valueOf(totalPago));
                }
            }
        });

        radioButtonLarge.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (precioPizza != 1.35) {
                    if (precioPizza != 1.0) {

                        totalPago /= precioPizza;
                    }
                    precioPizza = 1.35;
                    totalPago *= precioPizza;
                    lblTotal.setText(String.valueOf(totalPago));
                }
            }
        });
    };
    private void cargarToppings() {
        ingredientes.add(new Topping("Pepperoni", 1.99));
        ingredientes.add(new Topping("Champiñones", 4.99));
        ingredientes.add(new Topping("Mozzarella", 7.00));
        ingredientes.add(new Topping("Cebolla", 2.99));
        ingredientes.add(new Topping("Tomate", 5.00));

        for (Topping topping : ingredientes) {
            comboBoxToppings.addItem(topping);
        }
    }
    private void cargarPizzas() {
        PizzaItaliana pizzaItaliana = new PizzaItaliana("Pizza Italiana", "Tomate", 40.00);
        PizzaNutella pizzaNutella = new PizzaNutella("Pizza de Nutella", "Nutella", 40.00);
        PizzaSushi pizzaSushi = new PizzaSushi("Pizza de Sushi", "Sushi", 40.00);
        Yo_la_armo yo_la_armo = new Yo_la_armo("Pizza de Yo la Armo", 40.00);

        comboBoxPizzas.addItem(pizzaItaliana);
        comboBoxPizzas.addItem(pizzaNutella);
        comboBoxPizzas.addItem(pizzaSushi);
        comboBoxPizzas.addItem(yo_la_armo);
    }
}
