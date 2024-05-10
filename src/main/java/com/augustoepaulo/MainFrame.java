package com.augustoepaulo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private JTextField pagesField;
    private JTextField capacityField;

    public MainFrame() {
        setTitle("Simulador de Substituição de Páginas");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));

        JLabel pagesLabel = new JLabel("Páginas (separadas por vírgula): ");
        pagesField = new JTextField();
        JLabel capacityLabel = new JLabel("Capacidade da Memória: ");
        capacityField = new JTextField();
        JButton executeButton = new JButton("Executar");
        executeButton.addActionListener(new ExecuteListener());

        panel.add(pagesLabel);
        panel.add(pagesField);
        panel.add(capacityLabel);
        panel.add(capacityField);
        panel.add(new JLabel()); // Espaço em branco
        panel.add(executeButton);

        add(panel);
        setVisible(true);
    }

    private class ExecuteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String pagesText = pagesField.getText();
            String capacityText = capacityField.getText();

            // Executar o simulador aqui
            int[] pages = parsePages(pagesText);
            int capacity = Integer.parseInt(capacityText);
            // Chamar o simulador com as páginas e a capacidade

            // Exibir os resultados em uma caixa de mensagem
            int fifoFaults = 0; // Substitua com o número real de falhas do FIFO
            int lruFaults = 0; // Substitua com o número real de falhas do LRU
            int clockFaults = 0; // Substitua com o número real de falhas do Clock
            int optimalFaults = 0; // Substitua com o número real de falhas do Ótimo

            String message = "Resultados do Simulador:\n\n" +
                    "FIFO: " + fifoFaults + " faltas de página\n" +
                    "LRU: " + lruFaults + " faltas de página\n" +
                    "Clock: " + clockFaults + " faltas de página\n" +
                    "Ótimo: " + optimalFaults + " faltas de página";

            JOptionPane.showMessageDialog(MainFrame.this, message);
        }

        private int[] parsePages(String pagesText) {
            String[] pageStrings = pagesText.split(",");
            int[] pages = new int[pageStrings.length];
            for (int i = 0; i < pageStrings.length; i++) {
                pages[i] = Integer.parseInt(pageStrings[i].trim());
            }
            return pages;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MainFrame();
            }
        });
    }
}
