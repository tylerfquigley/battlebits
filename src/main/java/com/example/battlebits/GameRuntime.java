/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author tyler
 */
public class GameRuntime implements Runnable{
  World w;
    boolean r=true;
    GameRuntime(World world){
        w=world;
    }
    @Override
    //game runtime for levle
    public void run() {
       long c = System.currentTimeMillis();
       long s = System.currentTimeMillis();
       while(r){
           c=System.currentTimeMillis();
           if((c-s)>(1000/w.frameRate)){
           c = System.currentTimeMillis();
           s = System.currentTimeMillis();
           w.run();

           }
       }
    }
}
