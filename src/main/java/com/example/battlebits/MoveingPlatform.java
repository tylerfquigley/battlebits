/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

import java.util.ArrayList;

/**
 *
 * @author tyler
 */
public class MoveingPlatform extends GameObject{


    MoveingPlatform(int x, int y,int width,int height,float hsp,float vsp,ArrayList<Sprite> animation){
        this.x=x;this.y=y;this.bBoxW=width;this.bBoxH=height;this.hsp=hsp;this.vsp=vsp;this.sprite=animation;colMask=2;
    }

    @Override
    void toDo(World w) {
        //check for triger
        for(int i=0;i<w.size();i++){
            //check if is tiger
            if(w.get(i).colMask==5){
        if(Collision.object_collision(this, w.get(i),hsp, vsp)){
        hsp*=-1;
        vsp*=-1;
        }
            }
        }
      x+=hsp;
      y+=vsp;
    }

}
