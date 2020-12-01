package com.magicTiles;

import javax.swing.*;
import java.awt.*;

public class Button {
    public void drawCircle (Graphics g, int move) {
        if(move!=1) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(504, 234, 41, 41);
            g.setColor((Color.green));
            g.fillOval(500, 230, 40, 40);
        }
        if(move==1) {
            g.setColor((Color.red));
            g.fillOval(504, 234, 40, 40);
        }
        if(move!=2) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(504, 334, 41, 41);
            g.setColor((Color.green));
            g.fillOval(500, 330, 40, 40);
        }
        if(move==2) {
            g.setColor((Color.red));
            g.fillOval(504, 334, 40, 40);
        }
        if(move!=3) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(504, 434, 41, 41);
            g.setColor((Color.green));
            g.fillOval(500, 430, 40, 40);
        }
        if(move==3) {
            g.setColor((Color.red));
            g.fillOval(504, 434, 40, 40);
        }
        if(move!=4) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(504, 534, 41, 41);
            g.setColor((Color.green));
            g.fillOval(500, 530, 40, 40);
        }
        if(move==4) {
            g.setColor((Color.red));
            g.fillOval(504, 534, 40, 40);
        }
        if(move!=5) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(504, 634, 41, 41);
            g.setColor((Color.green));
            g.fillOval(500, 630, 40, 40);
        }
        if(move==5) {
            g.setColor((Color.red));
            g.fillOval(504, 634, 40, 40);
        }
    }
    public void drawTriangle(Graphics g, int move) {
        //g.setColor(new Color(0xB3FFFFFF, true));
        //g.fillPolygon(new int[]{513,513,533}, new int[]{242,262,252},3);
        g.setColor(Color.blue);
        if(move==1) {
            g.setColor(Color.BLACK);
            g.fillPolygon(new int[]{514,514,534}, new int[]{245,265,255},3);
        }
        if(move!=1) {
            g.setColor(Color.blue);
            g.fillPolygon(new int[]{510, 510, 530}, new int[]{241, 261, 251}, 3);
        }
        if(move==2) {
            g.setColor(Color.BLACK);
            g.fillPolygon(new int[]{514,514,534}, new int[]{345,365,355},3);
        }
        if(move!=2) {
            g.setColor(Color.blue);
            g.fillPolygon(new int[]{510, 510, 530}, new int[]{341, 361, 351}, 3);
        }
        if(move==3) {
            g.setColor(Color.BLACK);
            g.fillPolygon(new int[]{514,514,534}, new int[]{445,465,455},3);
        }
        if(move!=3) {
            g.setColor(Color.blue);
            g.fillPolygon(new int[]{510, 510, 530}, new int[]{441, 461, 451}, 3);
        }
        if(move==4) {
            g.setColor(Color.BLACK);
            g.fillPolygon(new int[]{514,514,534}, new int[]{545,565,555},3);
        }
        if(move!=4) {
            g.setColor(Color.blue);
            g.fillPolygon(new int[]{510, 510, 530}, new int[]{541, 561, 551}, 3);
        }
        if(move==5) {
            g.setColor(Color.BLACK);
            g.fillPolygon(new int[]{514,514,534}, new int[]{645,665,655},3);
        }
        if(move!=5) {
            g.setColor(Color.blue);
            g.fillPolygon(new int[]{510, 510, 530}, new int[]{641, 661, 651}, 3);
        }
    }
    public void gameButton (Graphics g, boolean[] key) {
        g.setFont(new Font("monospaced",Font.BOLD,50));
        if(!key[0]) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(45, 625, 60, 60);
            g.setColor((Color.green));
            g.fillOval(40, 620, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("A",57,665);
        }
        if(key[0]) {
            g.setColor((Color.red));
            g.fillOval(45, 625, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("A",62,670);
        }
        if(!key[1]) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(195, 625, 60, 60);
            g.setColor((Color.green));
            g.fillOval(190, 620, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("S",207,665);
        }
        if(key[1]) {
            g.setColor((Color.red));
            g.fillOval(195, 625, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("S",212,670);
        }
        if(!key[2]) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(345, 625, 60, 60);
            g.setColor((Color.green));
            g.fillOval(340, 620, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("J",357,665);
        }
        if(key[2]) {
            g.setColor((Color.red));
            g.fillOval(345, 625, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("J",362,670);
        }
        if(!key[3]) {
            g.setColor(new Color(0xFFFFFF));
            g.fillOval(495, 625, 60, 60);
            g.setColor((Color.green));
            g.fillOval(490, 620, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("K",507,665);
        }
        if(key[3]) {
            g.setColor((Color.red));
            g.fillOval(495, 625, 60, 60);
            g.setColor(Color.BLUE);
            g.drawString("K",512,670);
        }
    }
}
