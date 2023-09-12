/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;

/**
 *
 * @author tyler
 */
public class Triger extends GameObject {
   Triger(int x, int y,int width,int height,int colMask){
       this.y=y;this.x=x;this.bBoxH=height;this.bBoxW=width;this.colMask=colMask;
       debug=true;
   }

    @Override
    void toDo(World w) {

    }
}
