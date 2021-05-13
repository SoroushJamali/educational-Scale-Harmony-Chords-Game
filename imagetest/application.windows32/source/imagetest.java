import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import gifAnimation.*; 
import ddf.minim.*; 
import java.util.Random; 
import java.util.Iterator; 
import java.util.Arrays; 
import java.util.concurrent.TimeUnit; 
import ddf.minim.spi.*; 
import ddf.minim.signals.*; 
import ddf.minim.*; 
import ddf.minim.analysis.*; 
import ddf.minim.ugens.*; 
import ddf.minim.effects.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class imagetest extends PApplet {



Gif mainLogo;
Gif menuSelection_1;
Gif menuSelection_2;
Gif menuSelection_3;

PImage glowImage;
PImage glowImage_2;
PImage glowImage_3;

AudioPlayer player;
boolean a = true;

// Text Font
PFont font;

public void setup() {

  minim = new Minim(this);
  
  background(0, 0, 0);

  // Text Font
  font = createFont("data/fonts/Ultra.otf", 90, true);

  // Logo GIF
  mainLogo = new Gif(this, "data/graphics/animatedlogo.gif");
  mainLogo.play();

  // Game - 1 - GIF
  menuSelection_1 = new Gif(this, "data/graphics/animatedmenu1.gif");
  menuSelection_1.play();

  // Game - 2 - GIF
  menuSelection_2 = new Gif(this, "data/graphics/animatedmenu2.gif");
  menuSelection_2.play();

  // Game - 3 - GIF
  menuSelection_3 = new Gif(this, "data/graphics/animatedmenu3.gif");
  menuSelection_3.play();

  // Main Theme Song
  player = minim.loadFile("data/sounds/soundtrack/maintheme.mp3");
  player.loop();
}

// Global Message variable that will be shown on "MouseOver Event"
String message = "PLAY";

// Global variable to control text size dynamically
int textCnt = 80;

// Global variable to control width dynamically
int dyWidth = 610;
int dyWidth_2 = 110;
int dyWidth_3 = -410;

// Flags to check if sounds are played once
Boolean stateFlag = false;
Boolean hooverFlag = false;
int state = 0 ;

public void draw() { 



  background(0, 0, 0);  
  stroke(56, 253, 250);
  noFill();
  rect(width/2 - 900, height/2 - 520, width - 100, height - 50);
  imageMode(CENTER);
  image(mainLogo, width/2, height/2 - 200);
  image(menuSelection_1, width/2 - 500, height/2 + 300);
  image(menuSelection_2, width/2, height/2 + 300);
  image(menuSelection_3, width/2 + 500, height/2 + 300);

  // Keep track of the mouse cords
  println (mouseX +"," + mouseY);

  // MouseOver Animation for Menu Icon - 1
  if ((mouseX >= 440 && mouseX <= 650) && (mouseY >= 750 && mouseY <= 950))
  {
    // Play Sound FX
    /*if (hooverFlag != true) 
     {
     print("HooverFlag == false");
     sndplayMouseHoover();
     }
     hooverFlag = true;
     stateFlag = true;*/

    // Image control for Menu Icon - 1
    imageMode(CENTER); 
    image(mainLogo, width/2, height/2 - 200); 
    print("MouseOver_1 = True!!");
    glowImage = menuSelection_1.get(0, 0, menuSelection_1.width, menuSelection_1.height);
    glowImage.filter(BLUR, 2);
    image(glowImage, width/2 - 500, height/2 + 300);
    // Text Control for Menu Icon - 1
    if (textCnt != 120) {
      textFont(font);
      textSize(textCnt++);
      text(message, width/2 - dyWidth++, height/2 + 300);  
      fill(255, 255, 255);
    }
    if (textCnt == 120)
    {
      textCnt = 80;
      dyWidth = 610;
    }

    if (mousePressed) {
      game1();
    }
  }
  // **************************************************************************************************************************
  // MouseOver Animation for Menu Icon - 2
  if ((mouseX >= 940  && mouseX <= 1150) && (mouseY >= 750  && mouseY <= 950))
  {
    hooverFlag = false;
    // Play Sound FX
    /*if ( hooverFlag != true) 
     {
     sndplayMouseHoover();
     }
     hooverFlag = true;*/
    // Image control for Menu Icon - 1
    imageMode(CENTER); 
    image(mainLogo, width/2, height/2 - 200); 
    print("MouseOver_2 = True!!");
    glowImage_2 = menuSelection_2.get(0, 0, menuSelection_2.width, menuSelection_2.height);
    glowImage_2.filter(BLUR, 2);
    image(glowImage_2, width/2, height/2 + 300);
    // Text Control for Menu Icon - 1
    if (textCnt != 120) {
      textFont(font);
      textSize(textCnt++);
      text(message, width/2 - dyWidth_2++, height/2 + 300);  
      fill(255, 255, 255);
    }
    if (textCnt == 120)
    {
      textCnt = 80;
      dyWidth_2 = 110;
    }

    if (mousePressed) {
      game2();
    }
  }
  // **************************************************************************************************************************
  // MouseOver Animation for Menu Icon - 3
  if ((mouseX >= 1440  && mouseX <= 1600) && (mouseY >= 750  && mouseY <= 950))
  {
    // Play Sound FX
    /*if ( hooverFlag != true) 
     {
     sndplayMouseHoover();
     hooverFlag = true;
     }*/
    // Image control for Menu Icon - 1
    imageMode(CENTER); 
    image(mainLogo, width/2, height/2 - 200); 
    print("MouseOver_3 = True!!");
    glowImage_3 = menuSelection_3.get(0, 0, menuSelection_3.width, menuSelection_3.height);
    glowImage_3.filter(BLUR, 2);
    image(glowImage_3, width/2 + 500, height/2 + 300);
    // Text Control for Menu Icon - 1
    if (textCnt != 120) {
      textFont(font);
      textSize(textCnt++);
      text(message, width/2 - dyWidth_3++, height/2 + 300);  
      fill(255, 255, 255);
    }
    if (textCnt == 120)
    {
      textCnt = 80;
      dyWidth_3 = -410;
    }

    if (mousePressed) {
      game3();
    }
  }
  // **************************************************************************************************************************
}

public void game1() {
  PrintWriter output=null;
  output = createWriter("myfile.bat");
  output.println("cd "+sketchPath("C:/Users/Metehan Pala/finalGameFolder/shootTheNote/application.windows64"));
  output.println("shootTheNote.exe");
  output.flush();
  output.close();  
  output=null;
  launch(sketchPath("")+"myfile.bat");
  println("Launched the Game!");
  exit();
}

public void game2() {
  PrintWriter output=null;
  output = createWriter("myfile.bat");
  output.println("cd "+sketchPath("C:/Users/Metehan Pala/finalGameFolder/keyp/application.windows64"));
  output.println("start keyp.exe");
  output.flush();
  output.close();  
  output=null;
  launch(sketchPath("")+"myfile.bat");
  println("Launched the Game!");
  exit();
}

public void game3() {
  PrintWriter output=null;
  output = createWriter("myfile.bat");
  output.println("cd "+sketchPath("C:/Users/Metehan Pala/finalGameFolder/drag4/application.windows32/"));
  output.println("start drag4.exe");
  output.flush();
  output.close();  
  output=null;
  launch(sketchPath("")+"myfile.bat");
  println("Launched the Game!");
  exit();
}












Minim minim;
AudioSample mouseHooverFX;      

// Function to generate sound for Mouse Hoover Event
public void sndplayMouseHoover() {
  minim = new Minim(this);
  mouseHooverFX  = minim.loadSample("data/sounds/generalsounds/mouseHoover.mp3", 512);
  mouseHooverFX .trigger();
}
  public void settings() {  fullScreen(); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "imagetest" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
