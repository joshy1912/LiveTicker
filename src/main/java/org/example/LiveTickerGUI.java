package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;


public class LiveTickerGUI extends JFrame {
    private JLabel tickerLabel;
    private Timer tickerTimer;

    public LiveTickerGUI(){
        setTitle("Live Ticker");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tickerLabel = new JLabel("Live-Ticker: Warten auf Aktualiesierungen...");
        tickerLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(tickerLabel);

        tickerTimer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Simuliere eine Aktualisierung der Daten
                String newData = generateRanomData();
                tickerLabel.setText("Live-Ticker"+ newData);

            }
        });
        tickerTimer.start();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    private String generateRanomData(){
        Random random = new Random();
        int scoreTeamA = random.nextInt(1);
        int scoreTeamB = random.nextInt(1);
        return " Leibzig " + 1 + " - young Boys " + 1;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LiveTickerGUI();
            }
        });
    }
}