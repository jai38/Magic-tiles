package com.magicTiles;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
public class MainScreen extends JPanel implements KeyListener, ActionListener {
    private Timer time;
    private int delay = 15;
    private boolean play = false;
    private boolean over = false;
    Random rand = new Random();
    private int[] backBallX = new int[40];
    private int[] backBallY = new int[40];
    private boolean check = true;
    private final int MISTAKE = 50;
    private final int bottomBond = 440;
    private int x = 0;
    private int score = 0;
    private int foulY = 0;
    private int foulPlace;
    private int totalTiles = 0;
    private int move = 1;
    private int selectRectY=200;
    private int speed = 5;
    private  boolean go = false;
    private boolean key[] = new boolean[5];
    private boolean tilesCheck[] = new boolean[5];
    private boolean checkTilesProduce[] = new boolean[5];
    private int tilesY[] = new int[5];
    private String compliment = "";
    private int complimentSize = 50;
    private boolean foul = false;
    private boolean startSong = false;
    private boolean audioStatus = false;
    private boolean backgroundAudioStatus = false;
    Audio1 audio1;
    Audio2 audio2;
    Audio3 audio3;
    Audio4 audio4;
    Audio5 audio5;
    BackgroundAudio backgroundAudio;
    BufferedImage song1 = null;
    BufferedImage song2 = null;
    BufferedImage song3 = null;
    BufferedImage song4 = null;
    BufferedImage song5 = null;
    BufferedImage iconImage = null;
    public MainScreen (){
        initialValues();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay,this);
        time.start();
    }
    public void initialValues() {
        compliment = "";
        totalTiles = 0;
        score = 0;
        delay = 15;
        play = false;
        over = false;
        check = true;
        x = 0;
        move = 1;
        selectRectY=200;
        go = false;
        foulY = 0;
        audioStatus = false;
        startSong = false;
        backgroundAudioStatus = false;
        foul = false;
        song1 = null;
        song2 = null;
        song3 = null;
        song4 = null;
        song5 = null;
        for(int i = 0; i < 5; i++) {
            key[i] = false;
            tilesCheck[i] = false;
            checkTilesProduce[i] = false;
            tilesY[i] = -150;
        }
        for (int i = 0; i < 40; i++) {
            backBallX[i]=rand.nextInt(550);
            backBallY[i]=rand.nextInt(700);
        }
    }
    public void paint (Graphics graphics) {
        //BackGround
        backGround(graphics);
        backBalls(graphics);
        //name
        GameText gameText = new GameText();
        gameText.gameName(graphics);
        //icon
        icon(graphics);
        //song
        //playDate, danceMonkey, memories, countingStars, someoneYouLoved.
        drawSongImage(graphics);
        getSongImage(check);
        check=false;
        //songName
        gameText.songText(graphics);
        //difficulty
        gameText.difficultyText(graphics);
        //playButtonIn
        Button button = new Button();
        button.drawCircle(graphics,move);
        //buttonTriangleIn
        button.drawTriangle(graphics,move);
        Song1 song1 = new Song1();
        if(!go && !backgroundAudioStatus) {
            backgroundAudio = new BackgroundAudio();
            backgroundAudio.playAudio();
            backgroundAudioStatus = true;
        }
        if(go) {
            backgroundAudio.stopAudio();
        }
        if(move==1) {
            speed = 5;
            if (startSong) {
                audio1 = new Audio1();
                audio1.playAudio();
                audioStatus = true;
                startSong = false;
            }
            if (over && audioStatus) {
                audio1.stopAudio();
                audioStatus = false;
            }
        }
        if(move==2) {
            speed = 6;
            if (startSong) {
                audio2 = new Audio2();
                audio2.playAudio();
                audioStatus = true;
                startSong = false;
            }
            if (over && audioStatus) {
                audio2.stopAudio();
                audioStatus = false;
            }
        }
        if(move==3) {
            speed = 7;
            if (startSong) {
                audio3 = new Audio3();
                audio3.playAudio();
                audioStatus = true;
                startSong = false;
            }
            if (over && audioStatus) {
                audio3.stopAudio();
                audioStatus = false;
            }
        }
        if(move==4) {
            speed = 9;
            if (startSong) {
                audio4 = new Audio4();
                audio4.playAudio();
                audioStatus = true;
                startSong = false;
            }
            if (over && audioStatus) {
                audio4.stopAudio();
                audioStatus = false;
            }
        }
        if(move==5) {
            speed = 11;
            if (startSong) {
                audio5 = new Audio5();
                audio5.playAudio();
                audioStatus = true;
                startSong = false;
            }
            if (over && audioStatus) {
                audio5.stopAudio();
                audioStatus = false;
            }
        }
        if(go) {
            song1.gameInBackGround(graphics);
            button.gameButton(graphics,key);
            if(!over) {
                Tiles tiles = new Tiles();
                tiles.drawTiles(graphics, tilesCheck, tilesY, play);
                GameText gameText1 = new GameText();
                gameText1.score(graphics,score,compliment,complimentSize);
            }
        }
        if(foul) {
            Tiles tiles = new Tiles();
                tiles.drawFoul(graphics, foulPlace, foulY);
        }
        if(over) {
            GameText gameTextOver = new GameText();
            gameTextOver.gameOver(graphics, score);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            foul = false;
        }
        graphics.dispose();
        repaint();
    }

    public void backGround(Graphics g) {
        g.setColor(new Color(0, 0, 0, 255));
        g.fillRect(0,0,600,750);
        g.setColor(new Color(255, 255, 255, 163));
        g.draw3DRect(0,selectRectY,580,100,true);
    }
    private void backBalls(Graphics g) {
        g.setColor(new Color(255, 255, 255, 131));
        for(int i = 0; i < 40; i++) {
            g.fillOval(backBallX[i], backBallY[i], 10, 10);
        }
    }
    public void getSongImage (boolean check) {
        if(check) {
            try {
                song1 = ImageIO.read(new File("Images/someoneYouLoved.jpg"));
                song2 = ImageIO.read(new File("Images/memories.jpg"));
                song3 = ImageIO.read(new File("Images/playDate.jpg"));
                song4 = ImageIO.read(new File("Images/danceMonkey.jpg"));
                song5 = ImageIO.read(new File("Images/countingStars.jpg"));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void drawSongImage (Graphics g) {
        g.drawImage(song1,20,210,150,80,this);
        g.drawImage(song2,20,310,150,80,this);
        g.drawImage(song3,20,410,150,80,this);
        g.drawImage(song4,20,510,150,80,this);
        g.drawImage(song5,20,610,150,80,this);
    }
    public void icon (Graphics g) {
        if(check)
        try {
            iconImage = ImageIO.read(new File("Images/icon2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(iconImage,20,10,200,190,this);

    }
    public void tilesProduce () {
        totalTiles++;
        x = rand.nextInt(4);
            tilesCheck[x] = true;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 40; i++) {
            backBallY[i]-=1;
            if(backBallY[i]==0) {
                backBallY[i] = 700;
                backBallX[i] = rand.nextInt(550);
            }
        }
        if(tilesCheck[0]) {
            tilesY[0]+=speed;
        }
        if(tilesCheck[1]) {
            tilesY[1]+=speed;
        }
        if(tilesCheck[2]) {
            tilesY[2]+=speed;
        }
        if(tilesCheck[3]) {
            tilesY[3]+=speed;
        }
        if(tilesY[0]>=80 && !checkTilesProduce[0]) {
            tilesProduce();
            checkTilesProduce[0] = true;
        }
        if(tilesY[1]>=80 && !checkTilesProduce[1]) {
            tilesProduce();
            checkTilesProduce[1] = true;
        }
        if(tilesY[2]>=80 && !checkTilesProduce[2]) {
            tilesProduce();
            checkTilesProduce[2] = true;
        }
        if(tilesY[3]>=80 && !checkTilesProduce[3]) {
            tilesProduce();
            checkTilesProduce[3] = true;
        }
        if(tilesY[0]>=bottomBond) {
            over = true;
            play = false;
            tilesCheck[0]=false;
        }
        if(tilesY[1]>=bottomBond) {
            over = true;
            play=false;
            tilesCheck[1]=false;
        }
        if(tilesY[2]>=bottomBond) {
            over = true;
            play=false;
            tilesCheck[2]=false;
        }
        if(tilesY[3]>=bottomBond) {
            over = true;
            play = false;
            tilesCheck[3]=false;
        }
    }
    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            move+=1;
            selectRectY+=100;
            if(move==6)
                move=1;
            if(selectRectY==700)
                selectRectY=200;
        }
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            move-=1;
            selectRectY-=100;
            if(move==0)
                move=5;
            if(selectRectY==100)
                selectRectY=600;
        }
        if(go && e.getKeyCode() == KeyEvent.VK_S) {
            play = true;
            if(!audioStatus)
            startSong = true;
            tilesProduce();
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            go = true;
        }
        if(over && e.getKeyCode() == KeyEvent.VK_ENTER) {
            initialValues();
        }
        if(e.getKeyCode() == KeyEvent.VK_A && !over) {
            complimentSize = 80;
            if(tilesY[0]<tilesY[1] - MISTAKE || tilesY[0]<tilesY[2] - MISTAKE || tilesY[0]<tilesY[3] - MISTAKE) {
                over = true;
                foul = true;
                foulPlace = 0;
                foulY = sortTilesY(tilesY);
            }
            key[0] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_S && !over) {
            complimentSize = 80;
            if(tilesY[1]<tilesY[0] - MISTAKE || tilesY[1]<tilesY[2] - MISTAKE || tilesY[1]<tilesY[3] - MISTAKE) {
                over = true;
                foul = true;
                foulPlace = 1;
                foulY = sortTilesY(tilesY);
            }
            key[1] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_J && !over) {
            complimentSize = 80;
            if(tilesY[2]<tilesY[0] - MISTAKE || tilesY[2]<tilesY[1] - MISTAKE || tilesY[2]<tilesY[3] - MISTAKE ) {
                over = true;
                foul = true;
                foulPlace = 2;
                foulY = sortTilesY(tilesY);
            }
            key[2] = true;
        }
        if(e.getKeyCode() == KeyEvent.VK_K && !over) {
            complimentSize = 80;
            if(tilesY[3]<tilesY[0] - MISTAKE || tilesY[3]<tilesY[1] - MISTAKE || tilesY[3]<tilesY[2] - MISTAKE) {
                over = true;
                foul = true;
                foulPlace = 3;
                foulY = sortTilesY(tilesY);
            }
            key[3] = true;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_A) {
            complimentSize = 50;
            key[0] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_S) {
            complimentSize = 50;
            key[1] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_J) {
            complimentSize = 50;
            key[2] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_K) {
            complimentSize = 50;
            key[3] = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_A && tilesCheck[0] && tilesY[0]>200) {
            ScoreCalculate scoreCalculate = new ScoreCalculate();
            compliment = scoreCalculate.score(tilesY[0]);
            if(compliment.equals("Perfect"))
                score += 3;
            else if(compliment.equals("Great"))
                score += 2;
            else
                score +=1;
            key[0] = false;
            tilesCheck[0] = false;
            checkTilesProduce[0] = false;
            tilesY[0] = -150;
            tilesProduce();
        }
        if(e.getKeyCode() == KeyEvent.VK_S && tilesCheck[1] && tilesY[1]>200) {
            ScoreCalculate scoreCalculate = new ScoreCalculate();
            compliment = scoreCalculate.score(tilesY[1]);
            if(compliment.equals("Perfect"))
                score += 3;
            else if(compliment.equals("Great"))
                score += 2;
            else
                score += 1;
            key[1] = false;
            tilesCheck[1] = false;
            checkTilesProduce[1] = false;
            tilesY[1] = -150;
            tilesProduce();
        }
        if(e.getKeyCode() == KeyEvent.VK_J && tilesCheck[2] && tilesY[2]>200) {
            ScoreCalculate scoreCalculate = new ScoreCalculate();
            compliment = scoreCalculate.score(tilesY[2]);
            if(compliment.equals("Perfect"))
                score += 3;
            else if(compliment.equals("Great"))
                score += 2;
            else
                score += 1;
            key[2] = false;
            tilesCheck[2] = false;
            checkTilesProduce[2] = false;
            tilesY[2] = -150;
            tilesProduce();
        }
        if(e.getKeyCode() == KeyEvent.VK_K && tilesCheck[3] && tilesY[3]>200) {
            ScoreCalculate scoreCalculate = new ScoreCalculate();
            compliment = scoreCalculate.score(tilesY[3]);
            if(compliment.equals("Perfect"))
                score += 3;
            else if(compliment.equals("Great"))
                score += 2;
            else
                score += 1;
            key[3] = false;
            tilesCheck[3] = false;
            checkTilesProduce[3] = false;
            tilesY[3] = -150;
            tilesProduce();
        }
    }
    public int sortTilesY (int[] tilesY) {
        int[] sort = new int[4];
        for(int i = 0; i < 4; i++) {
            sort[i] = tilesY[i];
        }
        Arrays.sort(sort);
        return sort[3];
    }

}
