package Comun.Vista;

import Practica1.Vista.VistaGenetico;
import Practica2.Vista.VistaViajante;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class VistaInicial extends JFrame{

    private JButton btnP1;
    private JButton btnP2;
    private JButton btnP3;

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

        btnP1 = new JButton("Practica 1");
        panelBtns.add(btnP1);
        btnP1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaGenetico frame = new VistaGenetico();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        btnP2 = new JButton("Practica 2");
        panelBtns.add(btnP2);
        btnP2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                VistaViajante frame = new VistaViajante();
                frame.setVisible(true);
                setVisible(false);
            }
        });

        btnP3 = new JButton("Practica 3");
        btnP3.setEnabled(false);
        panelBtns.add(btnP3);
    }
}
