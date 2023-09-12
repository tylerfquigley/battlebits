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
public class BrickSprite extends Sprite{
    BrickSprite(int speed,boolean play){
        this.speed =speed;this.play=play;
        this.index.add(new Image("brick.png"));
    }
}
