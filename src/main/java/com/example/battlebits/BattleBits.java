/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.battlebits;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.ArrayList;

/**
 *
 * @author tyler
 */
public class BattleBits extends Application {
      ToggleGroup g1 = new ToggleGroup();
            RadioButton b1 = new RadioButton();
            RadioButton b2 = new RadioButton();
            RadioButton b3 = new RadioButton();
            RadioButton b4 = new RadioButton();
    //important notes
    //Resolution == SNES
    //1080 X 1920 == 224 X 398  :1 pixle unit == 5 real pixles
    //draw each pixle as a square
    //sprires = array of 2d Color Arrays
    @Override
    public void start(Stage game) {
        //menue
        GridPane gp = new GridPane();
        Scene menue = new Scene(gp);
        game.setScene(menue);
        gp.setMaxWidth(400);
        gp.setMaxHeight(400);
        game.show();
       //add start button
       Button start = new Button("Start");
       ToggleGroup tg1 = new ToggleGroup();
       RadioButton gameSetup = new RadioButton();
       RadioButton create = new RadioButton();
       create.setToggleGroup(tg1);
       gameSetup.setToggleGroup(tg1);
       gp.setPadding(new Insets(10,10,10,10));
       gp.setHgap(10);
       gp.setVgap(10);
       gp.add(start, 50, 40);
       gp.add(gameSetup, 0, 2);
       gp.add(create, 2, 2);
        //real game
        start.setOnAction(new EventHandler<ActionEvent>() {

           @Override
           public void handle(ActionEvent event) {
     boolean build=create.isSelected();
       int world_width=1000;
       int world_height=600;
       Group g = new Group();
       Canvas c = new Canvas(world_width,world_height);
       Scene s= new Scene(g);
       GraphicsContext gc = c.getGraphicsContext2D();
       g.getChildren().add(c);
       game.setScene(s);
        if(build){
            //0=ground 1=moveing platform 2=convayor belt 3=falling platform 4=changing block
                int buildID =0;
            //initialize buttons for later use
            b1.setToggleGroup(g1);
            b2.setToggleGroup(g1);
            b3.setToggleGroup(g1);
            b4.setToggleGroup(g1);
            GridPane gp = new GridPane();
            g.getChildren().add(gp);
            gp.setHgap(10);
            gp.setVgap(10);
            gp.add(b1, 10, 0);
            gp.add(b2, 20, 0);
            gp.add(b3, 30, 0);
            gp.add(b4, 40, 0);
       }
       //create world
      World w1 = new World(world_width,world_height,60,gc);
      //create thread
      Thread t1 = new Thread(new GameRuntime(w1));
      t1.start();
      Input input1 = new Input();
      //add keyboard input
      s.setOnKeyPressed(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent e) {
               switch(e.getCode()){
                   case D: input1.right=true;break;
                   case A: input1.left=true;break;
                   case W: input1.jump=true;break;
                   case K: input1.shoot=true;break;
                   case M: input1.secondary=true;break;
               }
           }
       });
       s.setOnKeyReleased(new EventHandler<KeyEvent>() {
           @Override
           public void handle(KeyEvent e) {
               switch(e.getCode()){
                   case D: input1.right=false;break;
                   case A: input1.left=false;break;
                   case W: input1.jump=false;break;
                   case K: input1.shoot=false;break;
                   case M: input1.secondary=false;break;
               }
           }
       });

      s.setOnMouseClicked(new EventHandler<MouseEvent>() {
         @Override
         public void handle(MouseEvent m) {
             //snap to mouse position
            int mx=((int)(m.getX()/25))*25;
            int my=((int)(m.getY()/25))*25;;
             //if in build mode
            if (build){

            if (m.getButton()==m.getButton().PRIMARY){
            //create object
            //if ground is selected
            if (b1.isSelected()){w1.add(new Ground(mx,my,50,50,new BrickAnimation1(),true));}
            if (b2.isSelected()){w1.add(new MoveingPlatform(mx,my,100,25,3,0,new PlatformAnimation1()));}
            if (b3.isSelected()){w1.add(new Health(mx,my,new BeerAnimation()));}
            if(b4.isSelected()){w1.add(new Triger(mx,my,50,50,5));}

            }
            //delete object
            if (m.getButton()==m.getButton().SECONDARY){
            for(int i=0;i<w1.size();i++){
                if(Collision.point_collision(mx, my,w1.get(i))){w1.remove(i);}
            }
            }
            }
         }
     });
      //ground
      ArrayList<Sprite> groundAnimation1 = new ArrayList<Sprite>();
      groundAnimation1.add(new BrickSprite(0,false));
      //add objects
    Player p1 = new Player(100,50,50,100,new SarahAnimation(),true,input1);
    Ground g1 = new Ground(100,200,50,50,groundAnimation1,true);

      w1.add(p1);
      w1.add(g1);

        //creat GUI animation
       AnimationTimer a1 = new AnimationTimer() {
           @Override
           public void handle(long now) {
               gc.fillRect(0, 0,world_width*2, world_height*2);
                //draw grid
                if(build){
                gc.setStroke(Color.RED);
                for(int i=0;i<world_width;i+=25){gc.strokeLine(i, 0, i,world_height);}
                for(int j=0;j<world_height;j+=25){gc.strokeLine(0,j,world_width,j);}
                }
                for(int i=0;i<w1.size();i++){w1.get(i).draw(gc);}
           }
       };
       a1.start();
       //close thread on exit
         game.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                t1.stop();
            }
        });
            }
       });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
