/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 *
 * @author tyler
 */
public class Sprite{
    //image array
    ArrayList<Image> index = new ArrayList<Image>();
    //frames per image
    int speed=1;
    //animation playing
    boolean play =true;
    //curent frame
    int frame=0;
    int counter=0;
    Sprite(){

    }
     Sprite(int speed,boolean play){
        this.speed =speed;this.play=play;
    }
     void draw(GraphicsContext gc,int x,int y ){
         //animate
         if(counter>=speed){counter=0;frame+=1;}
         //loop
         if(frame>=index.size()){frame=0;}
         gc.drawImage(index.get(frame), x, y);
         counter+=1;
     }


}
