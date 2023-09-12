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
public class Health extends GameObject{

    Health(int x, int y,ArrayList<Sprite> sprite){
        this.sprite=sprite;
        this.x=x;
        this.y=y;
    }
    @Override
    void toDo(World w) {

    }

}
