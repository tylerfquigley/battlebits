/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

import java.util.ArrayList;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * @author tyler
 */
public class World extends ArrayList<GameObject>{
    //in meters
    //32 pixles = 1 meter default
    float width=100;
    float height=100;
    GraphicsContext gc;
    float frameRate =60;
     boolean r =true;
    World(float width,float height,int framRate,GraphicsContext gc){
     this.width=width;this.height=height;this.frameRate=frameRate;this.gc=gc;
    }

    void run(){


           //iterate through objects in world
           for(int i=0;i<this.size();i++){this.get(i).run(gc,this);}
    }
}
