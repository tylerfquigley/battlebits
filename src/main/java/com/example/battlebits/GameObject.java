/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author tyler
 */
public abstract class GameObject{
    //colMask codes 1=ground 2=1way 3=item
    int curentSprite=0;
    float x=0;
    float y=0;
    float hsp=0;
    float vsp=0;
    int bBoxW=25;
    int bBoxH=25;
    int colMask =0;
    boolean debug=false;
   ArrayList<Sprite> sprite = new ArrayList<Sprite>();
    GameObject(){

    }
      GameObject(float x,float y,int bBoxW,int bBoxH,ArrayList<Sprite> sprite,boolean debug){
         this.x=x;this.y=y;this.bBoxH= bBoxH;this.bBoxW=bBoxW;this.debug=debug;
         this.sprite =sprite;
    }
    GameObject(float x,float y,int bBoxW,int bBoxH){
        this.x=x;this.y=y;this.bBoxH=bBoxH;this.bBoxW=bBoxW;
    }
     GameObject(float x,float y,int bBoxW,int bBoxH,boolean debug){
         this.x=x;this.y=y;this.bBoxH=bBoxH;this.bBoxW=bBoxW;this.debug=debug;
    }
    void run(GraphicsContext gc,World w){
        toDo(w);

    }
    void draw(GraphicsContext gc){

        if (sprite.size()>0){sprite.get(curentSprite).draw(gc, (int) (x-bBoxW/2),(int) (y-bBoxH/2));}
        gc.setStroke(Color.AQUA);
        if (debug){gc.strokeRect(x-bBoxW/2, y-bBoxH/2, bBoxW, bBoxH);}
    }
    abstract void toDo(World w);
}
