package com.magicTiles;

import java.awt.*;

public class GameText {
    public void gameName(Graphics g) {
        g.setFont(new Font(Font.DIALOG_INPUT,Font.BOLD,90));
        g.setColor(new Color(0xFFFFFFFF, true));
        g.drawString("Magic",264,100);
        g.setColor(new Color(156, 112, 248, 255));
        g.drawString("Magic",260,100);
        g.setColor(new Color(0xFFFFFFFF, true));
        g.drawString("Tiles",264,190);
        g.setColor(new Color(156, 112, 248, 255));
        g.drawString("Tiles",260,190);
    }
    public void songText(Graphics g) {
        g.setColor(new Color(114, 222, 210, 255));
        g.setFont(new Font("monospaced Bold",Font.ITALIC,30));

        g.drawString("Someone you Loved",180,230);
        g.drawString("Memories",180,330);
        g.drawString("Play Date",180,430);
        g.drawString("Dance Monkey",180,530);
        g.drawString("Counting Stars",180,630);
    }
    public void difficultyText(Graphics g) {
        g.setFont(new Font("serif",Font.BOLD,20));

        g.setColor(new Color(0xFFD0FF00, true));
        g.drawString("Very Easy",400,280);

        g.setColor(Color.CYAN);
        g.drawString("Easy",400,380);

        g.setColor(new Color(0x099202));
        g.drawString("Medium",400,480);

        g.setColor(Color.blue);
        g.drawString("Hard",400,580);

        g.setColor(Color.red);
        g.drawString("Very Hard",400,680);
    }
    public void gameOver(Graphics g, int score) {
        g.setFont(new Font("serif",Font.BOLD,50));
        g.setColor(new Color(0xFFE600));
        g.drawString("Score: "+score,180,255);
        g.setColor(new Color(0x800000));
        g.drawString("Game Over",150,325);
        g.setColor(new Color(0x26FF00));
        g.drawString("Press Enter",160,400);
    }
    public void score(Graphics g,int score, String compliment, int complimentSize) {
        g.setColor(new Color(0xFFFFFF));
        g.setFont(new Font("serif",Font.BOLD,50));
        g.drawString(String.valueOf(score),300,70);
        if(compliment.equals("Perfect"))
            g.setColor(new Color(0x630061));
        else if(compliment.equals("Great"))
            g.setColor(new Color(0x001E99));
        else
            g.setColor(new Color(0x008787));
        g.setFont(new Font("serif",Font.BOLD,complimentSize));
        if(complimentSize == 50)
            g.drawString(compliment,280,120);
        else
            g.drawString(compliment,230,140);

    }
}
