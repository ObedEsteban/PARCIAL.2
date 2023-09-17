package edu.pizza;

import edu.pizza.base.Pizza;
import edu.pizza.base.Topping;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.util.ArrayList;
import java.util.List;

public class frmPizza {
    private JPanel jpanelPrincipal;
    private JComboBox comboBoxToppings;
    private JTextField textPizza;
    private JButton btnAddIngrediente;
    private JLabel lblTotal;
    private JList lista1;
    private JButton btnPreparar;

    private double totalPago = 0;

    private  DefaultListModel modeloLista = new DefaultListModel();


    private List<Topping> ingredientes = new ArrayList<>();

    public JPanel getJpanelPrincipal() {
        return jpanelPrincipal;
    }

    public frmPizza() {
        cargarToppings();
        btnAddIngrediente.addComponentListener(new ComponentAdapter() {
        });
        btnAddIngrediente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Topping ingrediente = (Topping) comboBoxToppings.getSelectedItem();
                modeloLista.addElement(ingrediente.toString());
                lista1.setModel(modeloLista);
                totalPago += ingrediente.getPrecio();

                lblTotal.setText(String.valueOf(totalPago));
            }
        });
    }

    //public String toString() {
      //  return "Pizza{" + "name='" + name + '\'' + ", price=" + ", toppings=" + toppings + '}';

    private void cargarToppings(){
        ingredientes.add(new Topping("Champiñones", 1.10));
        ingredientes.add(new Topping("Mozzarella", 1.11));
        ingredientes.add(new Topping("Cebolla", 5.06));
        ingredientes.add(new Topping("Tomate", 6.06));
        ingredientes.add(new Topping("Pepperoni", 6.06));
        ingredientes.add(new Topping("Jamon", 6.06));

        DefaultComboBoxModel model = new DefaultComboBoxModel(ingredientes.toArray());
        comboBoxToppings.setModel(model);
    }
}
