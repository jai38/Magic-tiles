package com.magicTiles;
public class ScoreCalculate {
    public String score (int place) {
        if(place >=330 && place <=370) {
            return "Perfect";
        }
        else if (place >= 300 && place < 320 || place > 360 && place <= 380) {
            return "Great";
        }
        else {
            return "Cool";
        }
    }
}
