package Comun.Vista;

import Practica1.Vista.VistaGenetico;
import Practica2.Vista.VistaViajante;
import Practica3.Vista.VistaHormiga;

import javax.swing.*;
import java.awt.*;


public class VistaInicial extends JFrame{

    public VistaInicial() {
        setResizable(false);
        setTitle("Seleccion de Practica");
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.setBounds(100, 100, 382, 140);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel panelPrincipal = new JPanel();
        this.getContentPane().add(panelPrincipal, BorderLayout.CENTER);
        panelPrincipal.setLayout(null);

        JLabel lblTitulo;
        lblTitulo = new JLabel("Elije la practica que quieres ejecutar");
        lblTitulo.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(8, 16, 367, 24);
        panelPrincipal.add(lblTitulo);

        JPanel panelBtns = new JPanel();
        panelBtns.setBounds(8, 52, 367, 55);
        panelPrincipal.add(panelBtns);

        JButton btnP1 = new JButton("Practica 1");
        panelBtns.add(btnP1);
        btnP1.addActionListener(e -> {
            VistaGenetico frame = new VistaGenetico();
            frame.setVisible(true);
            setVisible(false);
        });

        JButton btnP2 = new JButton("Practica 2");
        panelBtns.add(btnP2);
        btnP2.addActionListener(e -> {
            VistaViajante frame = new VistaViajante();
            frame.setVisible(true);
            setVisible(false);
        });

        JButton btnP3 = new JButton("Practica 3");
        btnP3.setEnabled(true);
        panelBtns.add(btnP3);
        btnP3.addActionListener(e -> {
            VistaHormiga frame = new VistaHormiga();
            frame.setVisible(true);
            setVisible(false);
        });
    }
}
