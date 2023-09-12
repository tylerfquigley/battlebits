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
public class PlatformAnimation1 extends ArrayList<Sprite>{
    PlatformAnimation1(){
        Sprite s1 = new Sprite(0,false);
        s1.index.add(new Image("platform1.png"));
        this.add(s1);
    }
}
