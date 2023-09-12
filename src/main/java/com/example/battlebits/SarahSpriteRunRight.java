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
public class SarahSpriteRunRight extends Sprite{
     SarahSpriteRunRight(int speed,boolean play){
        index.add(new Image("srr1.png"));
        index.add(new Image("srr2.png"));
        index.add(new Image("srr3.png"));
        index.add(new Image("srr4.png"));
        index.add(new Image("srr5.png"));
        index.add(new Image("srr6.png"));
        this.speed =speed;this.play=play;
    }
}
