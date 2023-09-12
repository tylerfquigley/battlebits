/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

import java.util.ArrayList;
import javafx.scene.image.Image;

/**
 *
 * @author tyler
 */
public class BeerAnimation extends ArrayList<Sprite> {
    BeerAnimation(){
        Sprite beer1 = new Sprite(0,false);
        beer1.index.add(new Image("beer.png"));
        this.add(beer1);
    }
}
