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
public class Ground extends GameObject{

     Ground(){
        colMask =1;
    }
      Ground(float x,float y,int bBoxW,int bBoxH,ArrayList<Sprite> sprite,boolean debug){
         this.x=x;this.y=y;this.bBoxH=bBoxH;this.bBoxW=bBoxW;this.debug=debug;
         this.sprite =sprite; colMask =1;
    }
    Ground(float x,float y,int bBoxW,int bBoxH){
        this.x=x;this.y=y;this.bBoxH=bBoxH;this.bBoxW=bBoxW; colMask =1;
    }
     Ground(float x,float y,int bBoxW,int bBoxH,boolean debug){
         this.x=x;this.y=y;this.bBoxH=bBoxH;this.bBoxW=bBoxW;this.debug=debug; colMask =1;
    }

    @Override
    void toDo(World w) {

    }
}
