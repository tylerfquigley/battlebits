/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

import com.example.battlebits.Input;

import java.util.ArrayList;

/**
 *
 * @author tyler
 */
public class Player extends GameObject{
        int health=100;
        float grav=.5f;
        float hsp=0;
        float hsp_cap=8;
        float vsp=0;
        float pvsp=0;
        float phsp=0;
        float evsp=0;
        float ehsp=0;
        float friction=.8f;
        boolean grounded = false;
        Input input;
    Player(){

    }
      Player(float x,float y,int bBoxW,int bBoxH,ArrayList<Sprite> sprite,boolean debug,Input input){
         this.x=x;this.y=y;this.bBoxH=bBoxH;this.bBoxW=bBoxW;this.debug=debug;this.input=input;
         this.sprite =sprite;
    }
    Player(float x,float y,int bBoxW,int bBoxH){
        this.x=x;this.y=y;this.bBoxH=bBoxH;this.bBoxW=bBoxW;
    }
     Player(float x,float y,int bBoxW,int bBoxH,boolean debug){
         this.x=x;this.y=y;this.bBoxH=bBoxH;this.bBoxW=bBoxW;this.debug=debug;
    }

    @Override
    void toDo(World w) {
         //reset external forces
      ehsp=0;
      evsp=0;
      //check if inside object
      for(int i=0;i<w.size();i++){
          if (w.get(i).colMask==1){
              if (Collision.point_collision(x-bBoxW/2, y-bBoxH/2, w.get(i))){while(Collision.point_collision(x-bBoxW/2, y-bBoxH/2, w.get(i))){x+=1;}}
              if (Collision.point_collision(x-bBoxW/2, y+bBoxH/2, w.get(i))){while(Collision.point_collision(x-bBoxW/2, y+bBoxH/2, w.get(i))){x+=1;}}
              if (Collision.point_collision(x+bBoxW/2, y-bBoxH/2, w.get(i))){while(Collision.point_collision(x+bBoxW/2, y-bBoxH/2, w.get(i))){x-=1;}}
              if (Collision.point_collision(x+bBoxW/2, y+bBoxH/2, w.get(i))){while(Collision.point_collision(x+bBoxW/2, y+bBoxH/2, w.get(i))){x-=1;}}
          }
      }
      //check if grounded
      grounded =false;
      for(int i =0;i<w.size();i++){
          if(((w.get(i).colMask==1)||(w.get(i).colMask==2))&&(y+bBoxH/2<w.get(i).y-w.get(i).bBoxH/2)&&pvsp==0){
          if (Collision.object_collision(this, w.get(i), 0, 1-w.get(i).vsp)){grounded=true;
          if(w.get(i).colMask==2){ehsp=w.get(i).hsp;evsp=w.get(i).vsp;}
          }
          }
      }
      //apply grav
      if(!grounded){pvsp+=grav;}
      //apply player movement
      //left right
      if(input.right){phsp+=1;}
      if(input.left){phsp-=1;}
      if(phsp>hsp_cap){phsp=hsp_cap;}
      if(phsp<-hsp_cap){phsp=-hsp_cap;}
      //stop
      if((!input.left&&!input.right)||(input.left&&input.right)){phsp*=friction;}
      //jump
      if(input.jump&&grounded){pvsp-=10;}
      //get external speeds
      //add internal and external speeds
      vsp=(pvsp+evsp);
      hsp=(ehsp+phsp);
      //collision y
      //ground
      for(int i= 0;i<w.size();i++){
         if(w.get(i).colMask==1){
         if (Collision.object_collision(this, w.get(i), 0,Math.round(vsp+(vsp/Math.abs(vsp)/2)))){
         y=Math.round(y-(vsp/Math.abs(vsp)/2));
         if (Math.round(vsp+(vsp/Math.abs(vsp)/2))!=0) {int c=0;while(!Collision.object_collision(this, w.get(i), 0,Math.round(vsp+(vsp/Math.abs(vsp)/2))/Math.abs(Math.round(vsp+(vsp/Math.abs(vsp)/2))))&&c<200){y+=vsp/Math.abs(vsp);c+=1;}}
         vsp=0;
         pvsp=0;
         break;
         };
         }
    }
      //moveing platform
       //y
      for(int i= 0;i<w.size();i++){
         if((w.get(i).colMask==2)&&(y+bBoxH/2<(w.get(i).y-w.get(i).bBoxH/2))){
         if (Collision.object_collision(this, w.get(i), 0,Math.round(-w.get(i).vsp+vsp+.5))){
         y=Math.round(y-.5);
         while(!Collision.object_collision(this, w.get(i), 0, 1-w.get(i).vsp)){y+=1;}
        if(vsp>w.get(i).vsp) {vsp=w.get(i).vsp;
         pvsp=0;
         evsp=w.get(i).vsp;}
         break;
         };
         }
    }

      //collision x

      for(int j= 0;j<w.size();j++){
         if(w.get(j).colMask==1){
         if (Collision.object_collision(this, w.get(j),Math.round(hsp+(hsp/Math.abs(hsp)/2)),0)){
          x=Math.round(x-(hsp/Math.abs(hsp)/2));
        if (Math.round(hsp+(hsp/Math.abs(hsp)/2))!=0) {int c=0;while(!Collision.object_collision(this, w.get(j), Math.round(hsp+(hsp/Math.abs(hsp)/2))/Math.abs(Math.round(hsp+(hsp/Math.abs(hsp)/2))),0)&&c<200){x+=hsp/Math.abs(hsp);c+=1;}}
         hsp=0;
         phsp=0;
         ehsp=0;
         break;
         };
         }
    }
      //1=run left 0=run rigth
      //handle sprite transistions
      if(input.right){curentSprite=1;}
      if(input.left){curentSprite=0;}
      //apply movment
      x+=hsp;
      y+=vsp;
    }
}
