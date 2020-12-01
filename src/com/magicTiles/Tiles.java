package com.magicTiles;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tiles extends JPanel {
    private int pos;
    Random random = new Random();
    public void drawTiles (Graphics g, boolean[] tilesCheck, int[] tilesY, boolean play) {
        g.setColor(Color.BLACK);
        if(!play) {
            g.fillRect(150,350,150,200);
            g.setColor(Color.white);
            g.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,30));
            g.drawString("Start",180,460);
        }
        if(tilesCheck[0]) {
            g.fillRect(0,tilesY[0],150,200);
        }
        if(tilesCheck[1]) {
            g.fillRect(150,tilesY[1],150,200);
        }
        if(tilesCheck[2]) {
            g.fillRect(300,tilesY[2],150,200);
        }
        if(tilesCheck[3]) {
            g.fillRect(450,tilesY[3],150,200);
        }
    }
    public void drawFoul(Graphics g, int foulPlace, int foulY) {
        g.setColor(Color.red);
        if(foulPlace == 0) {
            g.fillRect(0,foulY,150,200);
        }
        if(foulPlace == 1) {
            g.fillRect(150,foulY,150,200);
        }
        if(foulPlace == 2) {
            g.fillRect(300,foulY,150,200);
        }
        if(foulPlace == 3) {
            g.fillRect(450,foulY,150,200);
        }
    }
}
