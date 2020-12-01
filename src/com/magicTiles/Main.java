package com.magicTiles;

import javax.swing.*;
import java.util.Scanner;
public class Main {
        public static void main(String[] args) {
        JFrame frame = new JFrame();
        MainScreen mainScreen = new MainScreen();
        //GamePlay gamePlay = new GamePlay();
        frame.setBounds(400,10,600,750);
        frame.setTitle("Magic Tiles");
        frame.setResizable(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(mainScreen);
    }
}

