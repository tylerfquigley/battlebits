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
public class SarahAnimation extends ArrayList<Sprite>{
      SarahSpriteRunLeft sarahRunLeft = new SarahSpriteRunLeft(10,true);
      SarahSpriteRunRight sarahRunRight = new SarahSpriteRunRight(10,true);
      SarahAnimation(){
          this.add(sarahRunLeft);
          this.add(sarahRunRight);
      }
}
