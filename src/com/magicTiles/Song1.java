package com.magicTiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Song1 extends JPanel implements KeyListener, ActionListener {
    public void gameInBackGround(Graphics g) {
        g.setColor(new Color(0x842EDC));
        g.fill3DRect(0,0,600,600,true);
        g.setColor(new Color(0xFFFFFF));
        g.drawLine(150,0,150,600);
        g.drawLine(300,0,300,600);
        g.drawLine(450,0,450,600);
        g.setColor(Color.BLACK);
        g.fill3DRect(0,600,600,150,true);
        g.setColor( new Color(0x34000000, true));
        g.fill3DRect(0,450,600,200,true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
