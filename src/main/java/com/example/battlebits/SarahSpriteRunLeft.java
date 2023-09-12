/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

import javafx.scene.image.Image;

/**
 *
 * @author tyler
 */
public class SarahSpriteRunLeft extends Sprite{
    SarahSpriteRunLeft(int speed,boolean play){
        index.add(new Image("S1.png"));
        index.add(new Image("S2.png"));
        index.add(new Image("S3.png"));
        index.add(new Image("s4.png"));
        index.add(new Image("s5.png"));
        index.add(new Image("s6.png"));
        this.speed =speed;this.play=play;
    }
}
