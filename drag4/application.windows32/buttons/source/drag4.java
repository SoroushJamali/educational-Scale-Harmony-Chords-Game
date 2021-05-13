import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import oscP5.*; 
import netP5.*; 
import controlP5.*; 
import java.util.List; 
import java.util.ArrayList; 
import java.io.*; 
import java.util.*; 
import gifAnimation.*; 
import java.util.ArrayList; 
import java.util.Random; 
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

public class drag4 extends PApplet {

//   Title: Game #3 - The Drag Game
//   Description: The Player tries to match chords concerning the given order of sequence. 
//   There are three difficulty selections available: Easy, Medium, and Hard.
//   In Easy mode, there will be three boxes that correspond to 3 possible chords. Medium 6 boxes and Hard nine boxes. 
//   The players have to arrange them in the correct order to pass the round. 
//   Total points calculated concerning each proper sequence player has completed.
//   When the Player fails to arrange them in a correct sequence, the game ends.

//----------------- 0. Libraries








ControlP5 cp5;
ControlP5 cp5_button;
//----------------- 

//----------------- 1. Globals for Chord Sequence Generator
public static ArrayList<Integer> randSeq = new ArrayList<Integer>();
public static ArrayList<Integer> shuffledSeq = new ArrayList<Integer>();
//----------------- 

//----------------- 2. Globals
int sum = 0;
boolean[] res_easy = new boolean [3];

boolean[] res_med = new boolean [6];
boolean[] res_hard = new boolean [9];
int mood;  // 4 | 8
int numRows;
int numColumns = 1;
int xg = 275, yg = xg + 55, wg = width, hg = height, offg = 2, grid = 9, many = grid;  // GRID DESIGN
int boxes_easy = 3;
int boxes_med = 6;
int boxes_hard = 9;
int[] inc_easy = new int[3];
int[] inc_med = new int[6];
int[] inc_hard = new int[9];
int delta = 10;
int pointX, pointY;
String[] WHITE_HARD = new String[9];
String[] WHITE_MED = new String[6];
String[] WHITE_EASY = new String[3];
String note_selection;
String diff_selection;
String scal_selection;
Bang[] btns_easy = new Bang[3];
Bang[] btns_med = new Bang[6];
Bang[] btns_hard = new Bang[9];
Bang[] boxesbtns_easy = new Bang[3];
Bang[] boxesbtns_med = new Bang[6];
Bang[] boxesbtns_hard = new Bang[9];
// 2.1 Buttons ----
// Difficulty Selection
Button EASY;
Button MEDIUM;
Button HARD;
// Root Note Selection
Button but_C;
Button but_Cs;
Button but_D;
Button but_Ds;
Button but_E;
Button but_F;
Button but_Fs;
Button but_G;
Button but_Gs;
Button but_A;
Button but_As;
Button but_B;
// Scale Selection
Button major;
Button minor;
Button dorian;
Button locrian;
Button phrygian;
Button lydian;
Button mixolydian;
Button aeolian;
// Start the Game Button
Button START;
Button playAgain;
// 2.2 Blur -------
PShader blur;
// 2.3 BG Image ---
PImage backgroundImage;
// 2.3 Game Start -
boolean gameStart = false;
//----------------- 

//-----------------  3. Boxes Optimizaiton
int Bxg = 775, Byg =175, Bwg = width, Bhg = height, Boffg =30, Bgrid = 3, Bmany = Bgrid; 
char BOXY[] = {'B'};
String str2 = new String(BOXY);
String ss2 = str2.substring(0);
//----------------- 

// Thread for sound generation (Mete)
soundThread sound_t;

// Variables to control timers
boolean timer_state = false;
// Timer Globals (Mete)
int timerStartTime; 
int counter; 
int timerMaxTime; 
boolean timerDone; 
boolean timerShowFlag = false;
boolean gameEnd = false;
int tutorialStartTime; 
int tutorialCounter; 
int tutorialMaxTime; 
boolean tutorialDone = false; 
boolean tutorialShowFlag = false;
int gameScore = 0;
boolean correctFlag = false;
boolean wrongFlag = false;
int totalCorrect = 0;
boolean on = false;
boolean butFlag = false;

// Global Variable to measure total melody play time
int mPlayElapsed;
boolean correctDisp = false;

// Variables to control timing of certain events "Correct", "Wrong" (Mete)
int startTime;
int lastTime;
final int displayDuration = 5; // 5s

// GIF Objects for Animations (Mete)
Gif checkmark;
Gif wrong;

// Tutorial Glass Panel (Mete)
PImage glassPanel;

// Global Point Variable
int glbPoint = 0;

//-----------------  4. Setup
public void setup() {
  inc_easy [0] = 1;
  inc_med  [0] = 1;
  inc_hard [0] = 1;
  //fullScreen();

  
  // Load Background Image
  backgroundImage = loadImage("images/background.png");
  glassPanel = loadImage("images/glassPanel.png");
  // Button Object
  cp5_button = new ControlP5(this);

  // Buttons Configuration ------------------
  // Difficulty Buttons -------------------
  EASY = cp5_button.addButton("easy")
    .setSwitch(false)
    .setPosition(width/2 - 250, 600)
    .setWidth(150)
    .setHeight(75)
    .activateBy(ControlP5.RELEASE)
    .setImages(loadImage("buttons/diffButtons/easy-inactive.png"), loadImage("buttons/diffButtons/easy-active.png"), loadImage("buttons/diffButtons/easy-pressed.png"))
    .updateSize();


  MEDIUM = cp5_button.addButton("medium")
    .setSwitch(false)
    .setPosition(width/2 - 75, 600)
    .setWidth(150)
    .setHeight(75)
    .setImages(loadImage("buttons/diffButtons/medium-inactive.png"), loadImage("buttons/diffButtons/medium-active.png"), loadImage("buttons/diffButtons/medium-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  HARD = cp5_button.addButton("hard")
    .setSwitch(false)
    .setPosition(width/2 + 100, 600)
    .setWidth(150)
    .setHeight(75)
    .setImages(loadImage("buttons/diffButtons/hard-inactive.png"), loadImage("buttons/diffButtons/hard-active.png"), loadImage("buttons/diffButtons/hard-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);
  // Difficulty Buttons -------------------

  START = cp5_button.addButton("play") // There's already a function named start() in default Processing lib. so we should have a function named with something else.
    .setSwitch(false)
    .setPosition(width/2 -75, 700)
    .setWidth(150)
    .setHeight(75)
    .setImages(loadImage("buttons/diffButtons/play-inactive.png"), loadImage("buttons/diffButtons/play-active.png"), loadImage("buttons/diffButtons/play-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  playAgain = cp5_button.addButton("playAgain") // There's already a function named start() in default Processing lib. so we should have a function named with something else.
    .setSwitch(false)
    .setPosition(width/2 -75, 700)
    .setWidth(150)
    .setHeight(75)
    .setImages(loadImage("buttons/diffButtons/play-inactive.png"), loadImage("buttons/diffButtons/play-active.png"), loadImage("buttons/diffButtons/play-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  playAgain.hide(); // Hide PlayAgain at the setup

  // Note Buttons -------------------------
  but_C = cp5_button.addButton("C")
    .setSwitch(false)
    .setPosition(525, 350)
    .activateBy(ControlP5.RELEASE)
    .setImages(loadImage("buttons/noteButtons/C-inactive.png"), loadImage("buttons/noteButtons/C-active.png"), loadImage("buttons/noteButtons/C-pressed.png"))
    .updateSize();

  but_Cs = cp5_button.addButton("Cs")
    .setSwitch(false)
    .setPosition(600, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/Cs-inactive.png"), loadImage("buttons/noteButtons/Cs-active.png"), loadImage("buttons/noteButtons/Cs-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_D = cp5_button.addButton("D")
    .setSwitch(false)
    .setPosition(675, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/D-inactive.png"), loadImage("buttons/noteButtons/D-active.png"), loadImage("buttons/noteButtons/D-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_Ds = cp5_button.addButton("Ds")
    .setSwitch(false)
    .setPosition(750, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/Ds-inactive.png"), loadImage("buttons/noteButtons/Ds-active.png"), loadImage("buttons/noteButtons/Ds-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_E = cp5_button.addButton("E")
    .setSwitch(false)
    .setPosition(825, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/E-inactive.png"), loadImage("buttons/noteButtons/E-active.png"), loadImage("buttons/noteButtons/E-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_F = cp5_button.addButton("F")
    .setSwitch(false)
    .setPosition(900, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/F-inactive.png"), loadImage("buttons/noteButtons/F-active.png"), loadImage("buttons/noteButtons/F-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_Fs = cp5_button.addButton("Fs")
    .setSwitch(false)
    .setPosition(975, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/Fs-inactive.png"), loadImage("buttons/noteButtons/Fs-active.png"), loadImage("buttons/noteButtons/Fs-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_G = cp5_button.addButton("G")
    .setSwitch(false)
    .setPosition(1050, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/G-inactive.png"), loadImage("buttons/noteButtons/G-active.png"), loadImage("buttons/noteButtons/G-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_Gs = cp5_button.addButton("Gs")
    .setSwitch(false)
    .setPosition(1125, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/Gs-inactive.png"), loadImage("buttons/noteButtons/Gs-active.png"), loadImage("buttons/noteButtons/Gs-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_A = cp5_button.addButton("A")
    .setSwitch(false)
    .setPosition(1200, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/A-inactive.png"), loadImage("buttons/noteButtons/A-active.png"), loadImage("buttons/noteButtons/A-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_As = cp5_button.addButton("As")
    .setSwitch(false)
    .setPosition(1275, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/As-inactive.png"), loadImage("buttons/noteButtons/As-active.png"), loadImage("buttons/noteButtons/As-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  but_B = cp5_button.addButton("B")
    .setSwitch(false)
    .setPosition(1350, 350)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/noteButtons/B-inactive.png"), loadImage("buttons/noteButtons/B-active.png"), loadImage("buttons/noteButtons/B-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);
  // Note Buttons -------------------------

  // Scale Buttons ------------------------
  major = cp5_button.addButton("Major")
    .setSwitch(false)
    .setPosition(width/2 - 475, 450)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/scaleButtons/major-inactive.png"), loadImage("buttons/scaleButtons/major-active.png"), loadImage("buttons/scaleButtons/major-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  minor = cp5_button.addButton("Minor")
    .setSwitch(false)
    .setPosition(width/2 - 350, 450)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/scaleButtons/minor-inactive.png"), loadImage("buttons/scaleButtons/minor-active.png"), loadImage("buttons/scaleButtons/minor-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  dorian = cp5_button.addButton("Dorian")
    .setSwitch(false)
    .setPosition(width/2 - 225, 450)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/scaleButtons/dorian-inactive.png"), loadImage("buttons/scaleButtons/dorian-active.png"), loadImage("buttons/scaleButtons/dorian-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  locrian = cp5_button.addButton("Locrian")
    .setSwitch(false)
    .setPosition(width/2 - 100, 450)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/scaleButtons/locrian-inactive.png"), loadImage("buttons/scaleButtons/locrian-active.png"), loadImage("buttons/scaleButtons/locrian-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  phrygian = cp5_button.addButton("Phrygian")
    .setSwitch(false)
    .setPosition(width/2 + 25, 450)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/scaleButtons/phrygian-inactive.png"), loadImage("buttons/scaleButtons/phrygian-active.png"), loadImage("buttons/scaleButtons/phrygian-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  lydian = cp5_button.addButton("Lydian")
    .setSwitch(false)
    .setPosition(width/2 + 150, 450)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/scaleButtons/lydian-inactive.png"), loadImage("buttons/scaleButtons/lydian-active.png"), loadImage("buttons/scaleButtons/lydian-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  mixolydian = cp5_button.addButton("Mixolydian")
    .setSwitch(false)
    .setPosition(width/2 + 275, 450)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/scaleButtons/mixolydian-inactive.png"), loadImage("buttons/scaleButtons/mixolydian-active.png"), loadImage("buttons/scaleButtons/mixolydian-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);

  aeolian = cp5_button.addButton("Aeolian")
    .setSwitch(false)
    .setPosition(width/2 + 400, 450)
    .setWidth(76)
    .setHeight(50)
    .setImages(loadImage("buttons/scaleButtons/aeolian-inactive.png"), loadImage("buttons/scaleButtons/aeolian-active.png"), loadImage("buttons/scaleButtons/aeolian-pressed.png"))
    .updateSize()
    .activateBy(ControlP5.RELEASE);
  // Scale Buttons ------------------------

  // Buttons Configuration ------------------
}

public void draw() {

  background(backgroundImage);

  if (gameStart != false) {
    if (diff_selection == "Easy" && gameEnd != true)
    { 
      String[] seqDisp = new String[3];
      seqDisp[0] = (shuffledSeq.get(0)).toString();
      seqDisp[1] = (shuffledSeq.get(1)).toString();
      seqDisp[2] = (shuffledSeq.get(2)).toString();
      textSize(32);
      fill(0xff35ea3f);
      text("Match the sequence: " +seqDisp[0]+ "-" +seqDisp[1]+ "-" +seqDisp[2], 765, 315);
      pos_easy();
      updates_easy();
      //gameChecker();
    }
    if (diff_selection == "Medium" && gameEnd != true)
    { 
      String[] seqDisp = new String[6];
      seqDisp[0] = (shuffledSeq.get(0)).toString();
      seqDisp[1] = (shuffledSeq.get(1)).toString();
      seqDisp[2] = (shuffledSeq.get(2)).toString();
      seqDisp[3] = (shuffledSeq.get(3)).toString();
      seqDisp[4] = (shuffledSeq.get(4)).toString();
      seqDisp[5] = (shuffledSeq.get(5)).toString();
      textSize(32);
      fill(0xff35ea3f);
      text("Match the sequence: " +seqDisp[0]+ "-" +seqDisp[1]+ "-" +seqDisp[2]+ "-" +seqDisp[3]+ "-" +seqDisp[4]+ "-" +seqDisp[5], 765, 315);
      pos_med();
      updates_med();
    }
    if (diff_selection == "Hard" && gameEnd != true)
    { 
      String[] seqDisp = new String[9];
      seqDisp[0] = (shuffledSeq.get(0)).toString();
      seqDisp[1] = (shuffledSeq.get(1)).toString();
      seqDisp[2] = (shuffledSeq.get(2)).toString();
      seqDisp[3] = (shuffledSeq.get(3)).toString();
      seqDisp[4] = (shuffledSeq.get(4)).toString();
      seqDisp[5] = (shuffledSeq.get(5)).toString();
      seqDisp[6] = (shuffledSeq.get(6)).toString();
      seqDisp[7] = (shuffledSeq.get(7)).toString();
      seqDisp[8] = (shuffledSeq.get(8)).toString();
      textSize(32);
      fill(0xff35ea3f);
      text("Match the sequence: " +seqDisp[0]+ "-" +seqDisp[1]+ "-" +seqDisp[2]+ "-" +seqDisp[3]+ "-" +seqDisp[4]+ "-" +seqDisp[5]+ "-" +seqDisp[6]+ "-" +seqDisp[7]+ "-" +seqDisp[8], 765, 215);
      pos_hard();
      updates_hard();
    }

    // Checkmark and Wrong Note Display Animations (Mete) ------------------------

    // Timer for Tutorial Sequence (Mete)
    if (tutorialShowFlag) {
      if (tutorialCounter-tutorialStartTime < tutorialMaxTime) {
        tutorialCounter=millis();
        // Tutorial Message display
        image(glassPanel, 1175, 370);  // Display at full opacity
        textSize(28);
        text("             Listen the melody,\n      and when timer shows up\n    match them in correct order!", 1175, 425);
        fill(0xff38ebe8, 100);
      } else { // Check the flag If tutorial timer is up.
        tutorialDone=true;
        timerShowFlag = true;
        // Timer Configuration (Mete) 
        counter = 0; 
        timerStartTime= millis(); 
        timerDone=false;
        tutorialShowFlag = false;
      }
    }
    // Timer for Tutorial Sequence (Mete) ---------------------------------------

    // Timer Progress Bar (Mete) ------------------------------------------------
    // If "Play" Button is pressed show Timer progress bar
    if (timerShowFlag && timerDone != true) {
      if (counter-timerStartTime < timerMaxTime) {
        counter=millis();
      } else { // If Time is up check the flag
        timerDone=true;
      }
      // Timer Progress bar configuration ---------------------------------------
      fill(0xff38ebe8);
      noStroke();
      rect(1175, 475, map(counter-timerStartTime, 0, timerMaxTime, 0, 400), 19 );
      noFill();
      stroke(0xff4d4d4d);
      rect(1175, 475, 400, 19);
      // Timer Progress bar configuration ---------------------------------------

      // Text for points earned in the current level (Mete) ---------------------
      /*textSize(21);
      text("Points: "+str(totalCorrect*100), 1175, 460);
      fill(#38ebe8, 100);*/


        textSize(21);
        text("Points: "+str(glbPoint), 1175, 435);
        fill(0xff38ebe8, 100);
      

      textSize(14);
      text("Complete the sequence before timer runs up!", 1325, 460);
      fill(0xff38ebe8, 100);
    }

    on = true;

    // Checkmark and Wrong Note Display Animations (Mete)
    if (correctFlag) {
      if (on) {
        if (millis() - startTime < 2500)
        { 
          if (diff_selection =="Easy")
          {
            for (int i=0; i<btns_easy.length; i++)
            {
              btns_easy[i].hide();
              boxesbtns_easy[i].hide();
            }
          }
          if (diff_selection =="Medium")
          {
            for (int i=0; i<btns_med.length; i++)
            {
              btns_med[i].hide();
              boxesbtns_med[i].hide();
            }
          }
          if (diff_selection =="Hard")
          {
            for (int i=0; i<btns_hard.length; i++)
            {
              btns_hard[i].hide();
              boxesbtns_hard[i].hide();
            }
          }
          wrongFlag = false;
          rect(width/2 - 800, height/2 - 275, 1600, 500);
          fill(color(random(255), random(255), random(255)));
          textSize(256); 
          fill(255, 100);
          text("YOU WIN!", width/2 - 600, height/2 + 50 );
          rect(width/2 - 800, height/2 - 275, 1600, 500);
          fill(color(random(255), random(255), random(255)));
        } else
        {
          startLevel();
          on = false;
          correctFlag = false;
        }
      }
    }

    if (wrongFlag) {
      if (on) {
        if (millis() - startTime < 2500)
        { 
          correctFlag = false;
          image(wrong, width/2 - 115, height/2 + 245);
        } else
        {
          on = false;
          wrongFlag = false;
        }
      }
    }


    // Check point status (Mete)
    if (tutorialShowFlag != true && timerDone != true) {
      pointChecker();
    }
    // Text for points earned in the current level (Mete) ---------------------

    if (gameStart) {
      posCorrectChecker();
    } // This has be to inside Game Start condition otherwise program will display error.
  }
}

public void pointChecker() // Function to control win/loss conditions and levels (Mete)
{

  if (!levelFlag && timerDone == true)
  { // If earned point is below 50, user has option to restart game with new setup
    textSize(64); 
    text("YOU LOST!", 775, 305);
    fill(0xff38ebe8, 100);
    playAgain.show(); // If User lost the game show "Play Again" Button
  } else if (levelFlag)
  { // If User earns at least 50 points he/she wins the game and proceeds to the next level
    glbPoint = 100 + glbPoint;
    totalCorrect = totalCorrect + 1;
    timerShowFlag = false;
    timerDone = true;
    gameEnd = true;
    correctFlag = true;
    startTime = millis();
    correctDisp = false;
  }
}

public void startLevel()
{
  if (diff_selection == "Easy")
  {
    WHITE_EASY = new String[WHITE_EASY.length]; // Clear melody array for next use
  }
  if (diff_selection == "Medium")
  {
    WHITE_MED = new String[WHITE_MED.length]; // Clear melody array for next use
  }
  if (diff_selection == "Hard")
  {
    WHITE_HARD = new String[WHITE_HARD.length]; // Clear melody array for next use
  }
  // Total Game Score
  redraw();
  gameStart = false;
  sound_t.quit();
  glbPoint = totalCorrect*100 + glbPoint;
  play();
}


public void results () {



  int l1 = randSeq.size();
  if (diff_selection == "Easy" && !correctFlag) {
    for (int i = 0; i < l1; i = i+1) {

      if (randSeq.get(i) == shuffledSeq.get( inc_easy[i] ) ) {
        if (res_easy[i] == false)
        {
          println("Box[", +i, "]", "is", res_easy[i]);
          res_easy[i]=true;
        }
      }
      if ((res_easy[0] && res_easy[1] && res_easy[2]) && correctFlag != true) {
        totalCorrect++;
        correctFlag = true;
        //gameStart = false;
        println("All boxes are true!");
      }
    }
  }

  if (diff_selection == "Medium" && !correctFlag) {
    for (int i = 0; i < l1; i = i+1) {
      if (shuffledSeq.get(i) == randSeq.get( inc_med[i])  ) {
        res_med[i]=true;
      }
      if (randSeq.get(i) == shuffledSeq.get( inc_med[i] )  ) {
        res_med[i]=true;
      }
      if (res_med[0] && res_med[1] && res_med[2]&& res_med[3]&& res_med[4]&& res_med[5] && !correctFlag) {
        totalCorrect++;
        correctFlag = true;
        println("True");
      }
    }
  }

  if (diff_selection == "Hard" && !correctFlag) {
    for (int i = 0; i < l1; i = i+1) {
      if (shuffledSeq.get(i) == randSeq.get( inc_hard[i]) ) {
        res_hard[i]=true;
      }  
      if (randSeq.get(i) == shuffledSeq.get( inc_hard[i] )  ) {
        res_hard[i]=true;
      }
      if (res_hard[0] && res_hard[1] && res_hard[2] && res_hard[3] && res_hard[4] && res_hard[5]&&res_hard[6] && res_hard[7] && res_hard[8] && !correctFlag) {
        totalCorrect++;
        correctFlag = true;
        println("True");
      }
    }
  }
}
//  Title: Game #3 - The Drag Game
//  Window: Button Functions are stored hereç
int yolo=0;

// Difficulty Control Buttons --------------------------
public void easy() {
  diff_selection = "Easy";
  mood = 3;
  redraw();
  EASY.hide();
  MEDIUM.hide();
  HARD.hide();
}

public void medium() {
  diff_selection = "Medium";
  mood = 6;
  redraw();
  EASY.hide();
  MEDIUM.hide();
  HARD.hide();
}

public void hard() {
  diff_selection = "Hard";
  mood = 9;
  redraw();
  EASY.hide();
  MEDIUM.hide();
  HARD.hide();
}
// Difficulty Control Buttons --------------------------

// Root Note Selection ---------------------------------
public void C() {
  note_selection = "C";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void Cs() {
  note_selection = "C#";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void D() {
  note_selection = "D";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void Ds() {
  note_selection = "D#";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void E() {
  note_selection = "E";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void F() {
  note_selection = "F";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void Fs() {
  note_selection = "F#";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void G() {
  note_selection = "G";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void Gs() {
  note_selection = "G#";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void A() {
  note_selection = "A";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void As() {
  note_selection = "A#";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
public void B() {
  note_selection= "B";
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
}
// Root Note Selection ---------------------------------

// Scale Selection -------------------------------------
public void Major() {
  scal_selection = "Major";
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
}
public void Minor() {
  scal_selection = "Minor";
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
}
public void Dorian() {
  scal_selection = "Dorian";
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
}
public void Locrian() {
  scal_selection = "Locrian";
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
}
public void Phrygian() {
  scal_selection = "Phrygian";
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
}
public void Lydian() {
  scal_selection = "Lydian";
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
}
public void Mixolydian() {
  scal_selection = "Mixolydian";
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
}
public void Aeolian() {
  scal_selection = "Aeolian";
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
}
// Scale Selection -------------------------------------

// Start the Game --------------------------------------
public void play() {
  levelFlag = false;
  // Timer State
  timer_state = false;

  // Sound Minim Objects for Playback
  Minim minim = new Minim(this);
  AudioPlayer C4 = minim.loadFile( "sounds/piano/C.wav" );
  AudioPlayer Cs4 = minim.loadFile( "sounds/piano/Cs.wav" );
  AudioPlayer D4 = minim.loadFile( "sounds/piano/D.wav" );
  AudioPlayer Ds4 = minim.loadFile( "sounds/piano/Ds.wav" );
  AudioPlayer F4 = minim.loadFile( "sounds/piano/F.wav" );
  AudioPlayer Fs4 = minim.loadFile( "sounds/piano/Fs.wav" );
  AudioPlayer E4 = minim.loadFile( "sounds/piano/E.wav" );
  AudioPlayer G4 = minim.loadFile( "sounds/piano/G.wav" );
  AudioPlayer Gs4 = minim.loadFile( "sounds/piano/Gs.wav" );
  AudioPlayer A4 = minim.loadFile( "sounds/piano/A.wav" );
  AudioPlayer As4 = minim.loadFile( "sounds/piano/As.wav" );
  AudioPlayer B4 = minim.loadFile( "sounds/piano/B.wav" );

  // Hide Buttons
  EASY.hide();
  MEDIUM.hide();
  HARD.hide();
  START.hide();
  major.hide();
  minor.hide();
  dorian.hide();
  locrian.hide();
  phrygian.hide();
  lydian.hide();
  mixolydian.hide();
  aeolian.hide();
  but_C.hide();
  but_Cs.hide();
  but_D.hide();
  but_Ds.hide();
  but_E.hide();
  but_F.hide();
  but_Fs.hide();
  but_G.hide();
  but_Gs.hide();
  but_A.hide();
  but_As.hide();
  but_B.hide();
  // ----------

  // Hide remaining buttons
  EASY.hide();
  MEDIUM.hide();
  HARD.hide();
  START.hide();
  butFlag = false;
  correctFlag = false;

  // Clear Arrays
  gameEnd = false;
  randSeq.clear();
  shuffledSeq.clear();
  btns_easy = new Bang[3];
  btns_med = new Bang[6];
  btns_hard = new Bang[9];
  boxesbtns_easy = new Bang[3];
  boxesbtns_med = new Bang[6];
  boxesbtns_hard = new Bang[9];
  inc_easy = new int[3];
  inc_med = new int[6];
  inc_hard = new int[9];
  // Print-Out User Selections to the Console
  println("Scale Selection:", scal_selection);
  println("Note Selection:", note_selection);
  println("Note Selection:", diff_selection);

  // Tutorial Timer
  tutorialCounter = 0;
  tutorialStartTime= millis(); 
  tutorialDone=false;
  tutorialShowFlag = true;
  // Start the Game in Easy mode

  if (diff_selection == "Easy") {
    // Generate Random Chord Sequence
    WHITE_EASY = generateChordSequence(note_selection, scal_selection, diff_selection);

      // Tutorial Timer Configuration (Mete) - Play Sequence to the User

      tutorialMaxTime = 5000; // 5 Seconds for Chords replay
      timerMaxTime= 15000; // User has 15 seconds to match chords correctly
      shuffledSeq = (ArrayList<Integer>)randSeq.clone();
      println("Sequence:", randSeq); // Original Sequence (Ground Truth)
      shuffle(shuffledSeq); // Generate Randomized Sequence --> Player will match chords corresponding to this.
      println("Sequence after Shuffle:", randSeq);
      println("Randomized Chord Sequence:", shuffledSeq); // shuffledSeq is the Shuffled one which user has to complete.

      // Play the Sequence
      sound_t = new soundThread( minim, C4, Cs4, D4, Ds4, F4, Fs4, E4, G4, Gs4, A4, As4, B4, WHITE_EASY);
      sound_t.start();
      sound_t.playNow();
      gameStart_easy(WHITE_EASY);
      
      // Box Update and Position Functions
      updates_easy();
      pos_easy();
      gameStart = true;
    
   
  }
  // Start the Game in Medium mode
  if (diff_selection == "Medium") {
    // if(yolo==0)
    // Generate Random Chord Sequence
    WHITE_MED = generateChordSequence(note_selection, scal_selection, diff_selection);

    tutorialMaxTime = 15000; // The Chord Play session will be 15 seconds
    timerMaxTime= 25000; // User has 25 Seconds to Match Chords correctly

    shuffledSeq = (ArrayList<Integer>)randSeq.clone();
    println("Sequence:", randSeq); // Original Sequence (Ground Truth)
    shuffle(shuffledSeq); // Generate Randomized Sequence --> Player will match chords corresponding to this.
    println("Sequence after Shuffle:", randSeq);
    println("Randomized Chord Sequence:", shuffledSeq); // shuffledSeq is the Shuffled one which user has to complete.
    gameStart_med(WHITE_MED);

    // Play the Sequence
    sound_t = new soundThread( minim, C4, Cs4, D4, Ds4, F4, Fs4, E4, G4, Gs4, A4, As4, B4, WHITE_MED);
    sound_t.start();
    sound_t.playNow();

    // Box Update and Position Functions
    updates_med();
    pos_med();
    gameStart = true;
  }
  // Start the Game in Hard mode
  if (diff_selection == "Hard") {

    // Generate Random Chord Sequence
    WHITE_HARD = generateChordSequence(note_selection, scal_selection, diff_selection);

    tutorialMaxTime = 25000; // The Chord Play session will be 25 seconds
    timerMaxTime= 40000; // User has 25 Seconds to Match Chords correctly
    shuffledSeq = (ArrayList<Integer>)randSeq.clone();
    println("Sequence:", randSeq); // Original Sequence (Ground Truth)
    shuffle(shuffledSeq); // Generate Randomized Sequence --> Player will match chords corresponding to this.
    println("Sequence after Shuffle:", randSeq);
    println("Randomized Chord Sequence:", shuffledSeq); // shuffledSeq is the Shuffled one which user has to complete.
    gameStart_hard(WHITE_HARD); 

    // Play the Sequence
    sound_t = new soundThread( minim, C4, Cs4, D4, Ds4, F4, Fs4, E4, G4, Gs4, A4, As4, B4, WHITE_HARD);
    sound_t.start();
    sound_t.playNow();

    // Box Update and Position Functions
    updates_hard();
    pos_hard();
    gameStart = true;
  }
  background(color(20, 200, random(225, 250)));
}
// Start the Game --------------------------------------

public void playAgain() // Button to restart game (Mete)
{
  // Clear Arrays
  randSeq.clear();
  shuffledSeq.clear();

  // Initialize for re-start
  timerDone = false;
  tutorialDone = false;
  timerShowFlag = false;
  tutorialShowFlag = false;
  totalCorrect = 0;
  note_selection = null;
  scal_selection = null;
  diff_selection = null;
  butFlag = true;

  if (diff_selection == "Easy")
  {
    WHITE_EASY = new String[WHITE_EASY.length]; // Clear melody array for next use
  }
  if (diff_selection == "Medium")
  {
    WHITE_MED = new String[WHITE_MED.length]; // Clear melody array for next use
  }
  if (diff_selection == "Hard")
  {
    WHITE_HARD = new String[WHITE_HARD.length]; // Clear melody array for next use
  }

  playAgain.hide();
  START.hide();
  but_C.show();
  but_Cs.show();
  but_D.show();
  but_Ds.show();
  but_E.show();
  but_F.show();
  but_Fs.show();
  but_G.show();
  but_Gs.show();
  but_A.show();
  but_As.show();
  but_B.show();
}
//  Title: Game #3 - The Drag Game
//  Window: Chord Generator
//  Description: Automatic Chord seqeuence generation process is done here.

// Libraries
 // import the ArrayList class


// Chord Generation Function
public static String[] generateChordSequence(String noteKey, String scale, String diff) {
  // KEY = C, SCALE = MAJOR (START)
  // Scale selection: "C"

  // Variable Definitions for Chord Generation
  int max = 6;
  int min = 1;
  int[] TempSwitchHolder = new int[9];

  // Declaring Random object r
  Random r = new Random();

  // Difficulty Control
  int diffLevel = 0;
  if (diff=="Easy") {
    diffLevel = 3;
  }
  if (diff=="Medium") {
    diffLevel = 6;
  }
  if (diff=="Hard") {
    diffLevel = 9;
  }


  int[] notes_v = new int[4];
  ArrayList<String> progression = new ArrayList<String>();
  notes_v[0] = 1;
  notes_v[1] = 4;
  notes_v[2] = 5;
  notes_v[3] = 2;

  if (noteKey == "C" && scale =="Major") {  
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // CM
        print("Pushed C-Maj 1 into Progression[", i, "]\n");
        randSeq.add(1); // Add Chord Number to the Arraylist
        progression.add("CM");

        break;
      case 2: // Dm
        print("Pushed D-Min 2 into Progression[", i, "]\n");
        progression.add("Dm");
        randSeq.add(2);  // Add Chord Number to the Arraylist
        break;
      case 3: // Em
        print("Pushed E-Min 3 into Progression[", i, "]\n");
        progression.add("Em");
        randSeq.add(3); // Add Chord Number to the Arraylist
        break;
      case 4: // FM
        print("Pushed F-Maj 4 into Progression[", i, "]\n");
        progression.add("FM");
        randSeq.add(4); // Add Chord Number to the Arraylist
        break;
      case 5: // GM
        print("Pushed G-Maj 5 into Progression[", i, "]\n");
        progression.add("GM");
        randSeq.add(5); // Add Chord Number to the Arraylist
        break;
      case 6: // Am
        print("Pushed A-Min 6 into Progression[", i, "]\n");
        progression.add("Am");
        randSeq.add(6); // Add Chord Number to the Arraylist
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 


    // KEY = C, SCALE = MAJOR (END)
  } // KEY = C, SCALE = MINOR (START)
  else if (noteKey == "C" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: //Csus2 
        randSeq.add(1);
        progression.add("Csus");
        break;
      case 2: //G7sus
        randSeq.add(2);
        progression.add("Fm");        
        break;
      case 3: //D7sus
        randSeq.add(3);
        progression.add("D#M");
        break;
      case 4: //Fsus2
        randSeq.add(4);
        progression.add("Fsus");
        break;
      case 5: //GM
        randSeq.add(5);
        progression.add("GM");
        break;
      case 6: //G#M
        randSeq.add(6);
        progression.add("G#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    // KEY = C, SCALE = MINOR (END)
  }  // KEY = C#, SCALE = MAJOR (START)
  else if (noteKey == "C#" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // C#M
        randSeq.add(1);
        progression.add("C#M");
        break;
      case 2: // D#m
        randSeq.add(2);
        progression.add("D#m");
        break;
      case 3: // Fm
        randSeq.add(3);
        progression.add("Fm");
        break;
      case 4: // F#
        randSeq.add(4);
        progression.add("F#M");
        break;
      case 5: // G#M
        randSeq.add(5);
        progression.add("G#M");
        break;
      case 6: // A#m
        randSeq.add(6);
        progression.add("A#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    // KEY = C#, SCALE = MAJOR (END)
  }  // KEY = C#, SCALE = MINOR (START)
  else if (noteKey == "C#" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // C#m
        randSeq.add(1);
        progression.add("C#m");
        break;
      case 2: // DM
        randSeq.add(2);
        progression.add("DM");
        break;
      case 3: // EM
        randSeq.add(3);
        progression.add("EM");
        break;
      case 4: // F#m
        randSeq.add(4);
        progression.add("F#m");
        break;
      case 5: // G#M
        randSeq.add(5);
        progression.add("G#M");
        break;
      case 6: // AM
        randSeq.add(6);
        progression.add("AM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "D" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // DM
        randSeq.add(1);
        progression.add("DM");
        break;
      case 2: // Em
        randSeq.add(2);
        progression.add("Em");
        break;
      case 3: // F#m
        randSeq.add(3);
        progression.add("F#m");
        break;
      case 4: // GM
        randSeq.add(4);
        progression.add("GM");
        break;
      case 5: // AM
        randSeq.add(5);
        progression.add("AM");
        break;
      case 6: // Bm
        randSeq.add(6);
        progression.add("Bm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "D" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Dm
        randSeq.add(1);
        progression.add("Dm");
        break;
      case 2: // Gm
        randSeq.add(2);
        progression.add("Edim");
        break;
      case 3: // FM
        randSeq.add(3);
        progression.add("FM");
        break;
      case 4: // Gm
        randSeq.add(4);
        progression.add("Gm");
        break;
      case 5: // AM
        randSeq.add(5);
        progression.add("AM");
        break;
      case 6: // F#
        randSeq.add(6);
        progression.add("BM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "D#" && scale =="Major") { //D# MIDI EKLE
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: 
        randSeq.add(1);
        progression.add("D#M");
        break;
      case 2: 
        randSeq.add(2);
        progression.add("Fm");
        break;
      case 3: 
        randSeq.add(3);
        progression.add("Gm");
        break;
      case 4: 
        randSeq.add(4);
        progression.add("G#M");
        break;
      case 5: 
        randSeq.add(5);
        progression.add("Cm");
        break;
      case 6: 
        randSeq.add(6);
        progression.add("Do");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "D#" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: 
        randSeq.add(1);
        progression.add("D#m");
        break;
      case 2: 
        randSeq.add(2);
        progression.add("Fo");
        break;
      case 3: 
        randSeq.add(3);
        progression.add("F#M");
        break;
      case 4: 
        randSeq.add(4);
        progression.add("G#m");
        break;
      case 5: 
        randSeq.add(5);
        progression.add("A#m");
        break;
      case 6: 
        randSeq.add(6);
        progression.add("BM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "E" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1:// EM
        randSeq.add(1);
        progression.add("EM");
        break;
      case 2: // F#m
        randSeq.add(2);
        progression.add("F#m");
        break;
      case 3: // G#M
        randSeq.add(3);
        progression.add("G#M");
        break;
      case 4: // AM
        randSeq.add(4);
        progression.add("AM");
        break;
      case 5: // BM
        randSeq.add(5);
        progression.add("BM");
        break;
      case 6: // C#m
        randSeq.add(6);
        progression.add("C#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "E" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Em
        randSeq.add(1);
        progression.add("Em");
        break;
      case 2: // Am6
        randSeq.add(2);
        progression.add("Am");
        break;
      case 3: // GM
        randSeq.add(3);
        progression.add("GM");
        break;
      case 4: // Am
        randSeq.add(4);
        progression.add("Am");
        break;
      case 5: // BM
        randSeq.add(5);
        progression.add("BM");
        break;
      case 6: // CM
        randSeq.add(6);
        progression.add("CM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "F" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // FM
        randSeq.add(1);
        progression.add("FM");
        break;
      case 2: // Gm
        randSeq.add(2);
        progression.add("Gm");
        break;
      case 3: // Am
        randSeq.add(3);
        progression.add("Am");
        break;
      case 4: // F#
        randSeq.add(4);
        progression.add("CM");
        break;
      case 5: // CM
        randSeq.add(5);
        progression.add("CM");
        break;
      case 6: // Dm
        randSeq.add(6);
        progression.add("Dm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "F" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Fm
        randSeq.add(1);
        progression.add("Fm");
        break;
      case 2: // F#m6
        randSeq.add(2);
        progression.add("A#m");
        break;
      case 3: // G#
        randSeq.add(3);
        progression.add("G#");
        break;
      case 4: // F#m
        randSeq.add(4);
        progression.add("F#m");
        break;
      case 5: // CM
        randSeq.add(5);
        progression.add("CM");
        break;
      case 6: // Db
        randSeq.add(6);
        progression.add("Db");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "F#" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // F#M
        randSeq.add(1);
        progression.add("F#M");
        break;
      case 2: // G#m
        randSeq.add(2);
        progression.add("G#m");
        break;
      case 3: // A#m
        randSeq.add(3);
        progression.add("A#m");
        break;
      case 4: // BM
        randSeq.add(4);
        progression.add("BM");
        break;
      case 5: // C#sus
        randSeq.add(5);
        progression.add("C#sus");
        break;
      case 6: // D#m
        randSeq.add(6);
        progression.add("D#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "F#" && scale =="Minor") {

    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // F#m
        randSeq.add(1);
        randSeq.add(1);
        progression.add("F#m");
        break;
      case 2: //Bm6
        randSeq.add(2);
        randSeq.add(2);
        progression.add("Bm");
        break;
      case 3: // AM
        randSeq.add(3);
        randSeq.add(3);
        progression.add("AM");
        break;
      case 4: // Bm
        randSeq.add(4);
        randSeq.add(4);
        progression.add("Bm");
        break;
      case 5:  // C#sus
        randSeq.add(5);
        randSeq.add(5);
        progression.add("C#sus");
        break;
      case 6: // DM
        randSeq.add(6);
        randSeq.add(6);
        progression.add("DM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "G" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // GM
        randSeq.add(1);
        progression.add("GM");
        break;
      case 2: // Am
        randSeq.add(2);
        progression.add("Am");
        break;
      case 3: // Bm
        randSeq.add(3);
        progression.add("Bm");
        break;
      case 4: // CM
        randSeq.add(4);
        progression.add("CM");
        break;
      case 5:  // DM
        randSeq.add(5);
        progression.add("DM");
        break;
      case 6: // Em
        randSeq.add(6);
        progression.add("Em");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "G" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Gm
        randSeq.add(1);
        progression.add("Gm");
        break;
      case 2: // Cm6
        randSeq.add(2);
        progression.add("Cm");
        break;
      case 3: // F#
        randSeq.add(3);
        progression.add("CM");
        break;
      case 4: // Cm
        randSeq.add(4);
        progression.add("Cm");
        break;
      case 5: // DM
        randSeq.add(5);
        progression.add("DM");
        break;
      case 6: // D#
        randSeq.add(6);
        progression.add("D#");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "G#" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // G#M
        randSeq.add(1);
        progression.add("G#M");
        break;
      case 2: // A#m
        randSeq.add(2);
        progression.add("A#m");
        break;
      case 3: // Cm
        randSeq.add(3);
        progression.add("Cm");
        break;
      case 4: // C#M
        randSeq.add(4);
        progression.add("C#M");
        break;
      case 5: // D#M
        randSeq.add(5);
        progression.add("D#M");
        break;
      case 6: // Fm
        randSeq.add(6);
        progression.add("Fm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  } else if (noteKey == "G#" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // G#m
        randSeq.add(1);
        progression.add("G#m");
        break;
      case 2: // C#m6
        randSeq.add(2);
        progression.add("C#m");
        break;
      case 3: // BM
        randSeq.add(3);
        progression.add("BM");
        break;
      case 4: // EM
        randSeq.add(4);
        progression.add("EM");
        break;
      case 5: // C#m
        randSeq.add(5);
        progression.add("C#m");
        break;
      case 6: // D#M
        randSeq.add(6);
        progression.add("D#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
  }  // KEY = C, SCALE = MINOR (END)
  else if (noteKey == "A" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // AM
        randSeq.add(1);
        progression.add("AM");
        break;
      case 2: // Bm
        randSeq.add(2);
        progression.add("Bm");
        break;
      case 3: // C#m
        randSeq.add(3);
        progression.add("C#m");
        break;
      case 4: // DM
        randSeq.add(4);
        progression.add("DM");
        break;
      case 5: // EM
        randSeq.add(5);
        progression.add("EM");
        break;
      case 6: // F#m
        randSeq.add(6);
        progression.add("F#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    // KEY = A, SCALE = MAJOR (END)
  }  // KEY = A, SCALE = MINOR (START)
  else if (noteKey == "A" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Am
        randSeq.add(1);
        progression.add("Am");
        break;
      case 2: // Dm6
        randSeq.add(2);
        progression.add("Dm");
        break;
      case 3: // CM
        randSeq.add(3);
        progression.add("CM");
        break;
      case 4: // Dm
        randSeq.add(4);
        progression.add("Dm");
        break;
      case 5: // EM
        randSeq.add(5);
        progression.add("EM");
        break;
      case 6: // FM
        randSeq.add(6);
        progression.add("FM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    // KEY = A, SCALE = MINOR (END)
  }  // KEY = A#, SCALE = MAJOR (START)
  else if (noteKey == "A#" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // F#
        randSeq.add(1);
        progression.add("CM");
        break;
      case 2: // Cm
        randSeq.add(2);
        progression.add("Cm");
        break;
      case 3: // Dm
        randSeq.add(3);
        progression.add("Dm");
        break;
      case 4: // D#
        randSeq.add(4);
        progression.add("D#M");
        break;
      case 5: // FM
        randSeq.add(5);
        progression.add("FM");
        break;
      case 6: // Gm
        randSeq.add(6);
        progression.add("Gm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    // KEY = A#, SCALE = MAJOR (END)
  }  // KEY = A#, SCALE = MINOR (START)
  else if (noteKey == "A#" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // F#m
        randSeq.add(1);
        progression.add("Cm");
        break;
      case 2: // D#m6
        randSeq.add(2);
        progression.add("D#m");
        break;
      case 3: // Db
        randSeq.add(3);
        progression.add("CM");
        break;
      case 4: // D#m
        randSeq.add(4);
        progression.add("D#m");
        break;
      case 5: // FM
        randSeq.add(5);
        progression.add("FM");
        break;
      case 6: // F#
        randSeq.add(6);
        progression.add("F#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    // KEY = A#, SCALE = MINOR (END)
  }  // KEY = B, SCALE = MAJOR (START)
  else if (noteKey == "B" && scale =="Major") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // BM
        randSeq.add(1);
        progression.add("BM");
        break;
      case 2: // C#m
        randSeq.add(2);
        progression.add("C#m");
        break;
      case 3: // D#m
        randSeq.add(3);
        progression.add("D#m");
        break;
      case 4: // EM
        randSeq.add(4);
        progression.add("EM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#M");
        break;
      case 6: // G#m
        randSeq.add(6);
        progression.add("G#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    // KEY = B, SCALE = MAJOR (END)
  }  // KEY = B, SCALE = MAJOR (START)
  else if (noteKey == "B" && scale =="Minor") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Bm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Em");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("DM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Em");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("GM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = MINOR (END)
  else if (noteKey == "C" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Cdim ---> C#o
        randSeq.add(1);
        progression.add("Co");
        break;
      case 2: //Daug -> D#m6
        randSeq.add(2);
        progression.add("C#aug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("D#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("FM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Ao");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = Turkish (END)
  else if (noteKey == "C#" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("C#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("D#m6");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Em");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("GM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("A#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = Turkish (END)
  else if (noteKey == "D" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Do");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("D#aug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Fm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("GM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("G#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Bo");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C#, SCALE = Turkish (END)
  else if (noteKey == "D#" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("D#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Eaug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("G#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("AM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Co");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D, SCALE = Turkish (END)
  else if (noteKey == "E" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Eo");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Faug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Gm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("AM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("A#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("C#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D#, SCALE = Turkish (END)
  else if (noteKey == "F" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Fo");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#aug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("G#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("A#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("BM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Do");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = E, SCALE = Turkish (END)
  else if (noteKey == "F#" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Gaug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Am");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("BM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("CM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("D#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F, SCALE = Turkish (END)
  else if (noteKey == "G" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Go");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("G#aug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("A#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("CM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("C#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Eo");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F#, SCALE = Turkish (END)
  else if (noteKey == "G#" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("G#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Aaug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Bm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("C#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("DM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Fo");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G, SCALE = Turkish(END)
  else if (noteKey == "A" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Ao");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("A#aug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Cm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("DM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("D#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G#, SCALE = Turkish (END)
  else if (noteKey == "A#" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("A#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Baug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("C#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("D#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("EM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Go");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A, SCALE = Turkish (END)
  else if (noteKey == "B" && scale =="Turkish") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Bo");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Caug");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Dm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("EM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("FM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("G#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A#, SCALE = TURKISH (END)
  else if (noteKey == "C" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Cdim ---> C#o
        randSeq.add(1);
        progression.add("Cm");
        break;
      case 2: //Daug -> D#m6
        randSeq.add(2);
        progression.add("Dm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("D#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("FM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Gm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Ao");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = Dorian (END)
  else if (noteKey == "C#" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("C#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("D#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("EM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("G#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("A#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C, SCALE = Dorian (END)
  else if (noteKey == "D" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Dm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Em");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("FM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("GM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Am");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Bo");
        break;
      }  // Switch End
      i++;
    }  // While loop end

    //midiWrite(progression);
  }  // KEY = C#, SCALE = Dorian (END)
  else if (noteKey == "D#" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("D#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Fm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("G#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Cm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Co");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D, SCALE = Dorian (END)
  else if (noteKey == "E" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Em");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("GM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("AM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Bm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("C#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D#, SCALE = Dorian (END)
  else if (noteKey == "F" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Fm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Gm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("G#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("CM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Cm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Do");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = E, SCALE = Dorian (END)
  else if (noteKey == "F#" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("G#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("AM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("BM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("C#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("D#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F, SCALE = Dorian (END)
  else if (noteKey == "G" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Gm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Am");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("CM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Dm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Eo");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F#, SCALE = Dorian (END)
  else if (noteKey == "G#" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("G#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("A#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("BM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("D#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Fo");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Fo");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G, SCALE = Dorian (END)
  else if (noteKey == "A" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Am");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Bm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("CM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("DM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Em");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G#, SCALE = Dorian (END)
  else if (noteKey == "A#" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Cm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("C#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("CM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("D#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Fm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Go");
        break;
      }  // Switch End
      i++;
    }  // While loop end

    //midiWrite(progression);
  }  // KEY = A, SCALE = Dorian (END)
  else if (noteKey == "B" && scale =="Dorian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Bm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("C#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("DM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("EM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("G#o");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A#, SCALE = Dorian (END)
  else if (noteKey == "C" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Cdim ---> C#o
        randSeq.add(1);
        progression.add("Cm");
        break;
      case 2: //Daug -> D#m6
        randSeq.add(2);
        progression.add("C#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("D#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Fm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Go");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("G#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C, SCALE = Phrygia (END)
  else if (noteKey == "C#" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("C#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("DM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("EM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("G#o");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("AM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C#, SCALE = Phrygia (END)
  else if (noteKey == "D" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Dm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("D#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("FM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Gm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Ao");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("CM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D, SCALE = Phrygia (END)
  else if (noteKey == "D#" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("D#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("EM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("G#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("A#o");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("BM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D#, SCALE = Phrygia (END)
  else if (noteKey == "E" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Em");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("FM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("GM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Am");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Bo");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("CM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = E, SCALE = Phrygia (END)
  else if (noteKey == "F" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Fm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("A#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Cm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Co");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("C#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F#, SCALE = Phrygia (END)
  else if (noteKey == "F#" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("GM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("AM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Bm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("C#o");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("DM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F#, SCALE = Phrygia (END)
  else if (noteKey == "G" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Gm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("G#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Cm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Do");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("D#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F, SCALE = Phrygia (END)
  else if (noteKey == "G#" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("G#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("AM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("BM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("C#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("D#o");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("EM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G#, SCALE = Phrygia (END)
  else if (noteKey == "A" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Am");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("CM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Dm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Eo");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("FM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A, SCALE = Phrygia (END)
  else if (noteKey == "A#" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("A#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("BM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("C#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("D#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Fo");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A#, SCALE = Phrygia (END)
  else if (noteKey == "B" && scale =="Phrygian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Bm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("CM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("DM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Em");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#o");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("GM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = Phrygia (END)
  else if (noteKey == "C" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Cdim ---> C#o
        randSeq.add(1);
        progression.add("CM");
        break;
      case 2: //Daug -> D#m6
        randSeq.add(2);
        progression.add("DM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Em");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#o");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("GM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Am");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C, SCALE = Lydian(END)
  else if (noteKey == "C#" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("DbM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("D#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Fm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Go");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("G#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C#, SCALE = Lydian (END)
  else if (noteKey == "D" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("DM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("EM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("G#o");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("AM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Bm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D, SCALE = Lydian (END)
  else if (noteKey == "D#" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("D#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("FM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Gm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Ao");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Cm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D#, SCALE = Lydian (END)
  else if (noteKey == "E" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("EM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("G#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("A#o");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("BM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("C#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = E, SCALE = Lydian (END)
  else if (noteKey == "F" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("FM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("GM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Am");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Bo");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("CM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Dm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F, SCALE = Lydian (END)
  else if (noteKey == "F#" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("G#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Co");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("DbM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("D#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F#, SCALE = Lydian (END)
  else if (noteKey == "G" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("GM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("AM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Bm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("C#o");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("DM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Em");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G, SCALE = Lydian (END)
  else if (noteKey == "G#" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("G#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Cm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Do");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("D#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Fm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G#, SCALE = Lydian (END)
  else if (noteKey == "A" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("AM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("BM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("C#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("D#o");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("EM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A, SCALE = Lydian (END)
  else if (noteKey == "A#" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("CM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Dm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Eo");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("FM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Gm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A#, SCALE = Lydian (END)
  else if (noteKey == "B" && scale =="Lydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("BM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("C#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("D#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("E#o");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("G#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = Lydian (END)
  else if (noteKey == "C" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Cdim ---> C#o
        randSeq.add(1);
        progression.add("CM");
        break;
      case 2: //Daug -> D#m6
        randSeq.add(2);
        progression.add("Dm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Eo");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("FM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Gm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Am");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C, SCALE = Mixolydian (END)
  else if (noteKey == "C#" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("C#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("D#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("E#o");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("G#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("A#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C#, SCALE = Mixolydian (END)
  else if (noteKey == "D" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("DM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Em");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#o");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("GM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Am");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Bm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D, SCALE = Mixolydian (END)
  else if (noteKey == "D#" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("D#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Fm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Go");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("G#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Cm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D#, SCALE = Mixolydian (END)
  else if (noteKey == "E" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("EM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("G#o");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("AM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Bm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("C#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = E, SCALE = Mixolydian (END)
  else if (noteKey == "F" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("FM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Gm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Ao");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Cm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Dm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F, SCALE = Mixolydian (END)
  else if (noteKey == "F#" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("G#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("A#o");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("BM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("C#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("D#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F#, SCALE = Mixolydian (END)
  else if (noteKey == "G" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("GM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Am");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Bo");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("CM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Dm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Em");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G, SCALE = Mixolydian (END)
  else if (noteKey == "G#" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("G#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Co");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("DbM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("D#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Fm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G#, SCALE = Mixolydian (END)
  else if (noteKey == "A" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("AM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Bm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("C#o");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("DM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Em");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A, SCALE = Mixolydian (END)
  else if (noteKey == "A#" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#M");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Cm");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Do");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("D#M");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Fm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("Gm");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A#, SCALE = Mixolydian (END)
  else if (noteKey == "B" && scale =="Mixolydian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("BM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("C#m");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("D#o");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("EM");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("G#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = Mixolydian (END)
  else if (noteKey == "C" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Cdim ---> C#o
        randSeq.add(1);
        progression.add("Cm");
        break;
      case 2: //Daug -> D#m6
        randSeq.add(2);
        progression.add("Do");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("D#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Fm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Gm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("G#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C, SCALE = Aeolian (END)
  else if (noteKey == "C#" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("C#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("D#o");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("EM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("G#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("AM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C#, SCALE = Aeolian (END)
  else if (noteKey == "D" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Dm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Eo");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("FM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Gm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Am");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D, SCALE = Aeolian (END)
  else if (noteKey == "D#" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("D#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Fo");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("G#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("A#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("BM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D#, SCALE = Aeolian (END)
  else if (noteKey == "E" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("eM");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#o");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("GM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Am");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Bm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("CM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = E, SCALE = Aeolian (END)
  else if (noteKey == "F" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Fm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Go");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("G#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Cm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("DbM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F, SCALE = Aeolian (END)
  else if (noteKey == "F#" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("G#o");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("AM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Bm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("C#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("DM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F#, SCALE = Aeolian (END)
  else if (noteKey == "G" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Gm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Ao");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Cm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Dm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("D#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G, SCALE = Aeolian (END)
  else if (noteKey == "G#" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("G#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("A#o");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("BM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("C#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("D#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("EM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G#, SCALE = Aeolian (END)
  else if (noteKey == "A" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Am");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Bo");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("CM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Do");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("EM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("FM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A, SCALE = Aeolian (END)
  else if (noteKey == "A#" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#m");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("Co");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("DbM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("D#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("Fm");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A#, SCALE = AeolianR (END)
  else if (noteKey == "B" && scale =="Aeolian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Bm");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("C#o");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("DM");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Em");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#m");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("GM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = Aeolian (END)
  else if (noteKey == "C" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Cdim ---> C#o
        randSeq.add(1);
        progression.add("Co");
        break;
      case 2: //Daug -> D#m6
        randSeq.add(2);
        progression.add("DbM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("D#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Fm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("G#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C, SCALE = Locrian (END)
  else if (noteKey == "C#" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("C#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("DM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Em");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("F#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("GM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("AM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = C#, SCALE = Locrian (END)
  else if (noteKey == "D" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Do");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("D#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Fm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Gm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("G#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D, SCALE = Locrian (END)
  else if (noteKey == "D#" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("D#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("EM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("G#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("AM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("BM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = D#, SCALE = Locrian (END)
  else if (noteKey == "E" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Eo");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("FM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Gm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Am");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("F#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("CM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = E, SCALE = Locrian (END)
  else if (noteKey == "F" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Fo");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("G#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("A#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("BM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("C#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F, SCALE =Locrian (END)
  else if (noteKey == "F#" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("F#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("GM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Am");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Bm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("CM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("DM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = F#, SCALE = Locrian (END)
  else if (noteKey == "G" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Go");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("G#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("F#M");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Cm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("DbM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("D#M");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G, SCALE = Locrian (END)
  else if (noteKey == "G#" && scale =="Locrian") {
    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("G#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("AM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Bm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("C#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("DM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("EM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = G#, SCALE = LocrianR (END)
  else if (noteKey == "A" && scale =="Locrian") {

    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Ao");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("F#M");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Cm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Dm");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("D#M");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("FM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A, SCALE = Locrian (END)
  else if (noteKey == "A#" && scale =="Locrian") {

    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("A#o");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("BM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("C#m");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("D#m");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("EM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("F#m");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = A#, SCALE = Locrian (END)
  else if (noteKey == "B" && scale =="Locrian") {

    int i = 0;  
    while (i < diffLevel) {
      // Random switch value generation block -----------------
      int temp_switch_value = r.nextInt((max - min) + 1) + min;
      TempSwitchHolder[i] = temp_switch_value;
      if (i != 0)
      {
        while (TempSwitchHolder[i-1] == temp_switch_value)
        {
          temp_switch_value = r.nextInt((max - min) + 1) + min;
        }
      }
      // ------------------------------------------------------
      switch (temp_switch_value) {
      case 1: // Bm
        randSeq.add(1);
        progression.add("Bo");
        break;
      case 2: // Em6
        randSeq.add(2);
        progression.add("CM");
        break;
      case 3: // DM
        randSeq.add(3);
        progression.add("Dm");
        break;
      case 4: // Em
        randSeq.add(4);
        progression.add("Em");
        break;
      case 5: // F#M
        randSeq.add(5);
        progression.add("FM");
        break;
      case 6: // GM
        randSeq.add(6);
        progression.add("GM");
        break;
      }  // Switch End
      i++;
    }  // While loop end
    String[] progressionArr = new String[progression.size()];
    progressionArr = progression.toArray(progressionArr); 
    return progressionArr;
    //midiWrite(progression);
  }  // KEY = B, SCALE = Locrian (END)

  String[] progressionArr = new String[progression.size()];
  progressionArr = progression.toArray(progressionArr); 
  return progressionArr;
}

public static<T> void shuffle(List<T> list)
{
  Random random = new Random();

  // start from the end of the list
  for (int i = list.size() - 1; i >= 1; i--)
  {
    // get a random index `j` such that `0 <= j <= i`
    int j = random.nextInt(i + 1);

    // swap element at i'th position in the list with the element at
    // randomly generated index `j`
    T obj = list.get(i);
    list.set(i, list.get(j));
    list.set(j, obj);
  }
}













public class soundThread extends Thread {
  String[] noteArr;

  Minim minim;
  AudioPlayer C4;
  AudioPlayer Cs4;
  AudioPlayer D4;
  AudioPlayer Ds4; 
  AudioPlayer F4; 
  AudioPlayer Fs4; 
  AudioPlayer E4; 
  AudioPlayer G4; 
  AudioPlayer Gs4; 
  AudioPlayer A4; 
  AudioPlayer As4; 
  AudioPlayer B4; 

  Random randTime = new Random();
  int r_time = 1000;
  boolean quit;
  boolean playNow;

  soundThread( Minim m, AudioPlayer c, AudioPlayer cs, AudioPlayer d, AudioPlayer ds, AudioPlayer f, AudioPlayer fs, AudioPlayer e, AudioPlayer g, AudioPlayer gs, 
    AudioPlayer a, AudioPlayer as, AudioPlayer b, String[] notes) {

    minim = m;
    C4 = c;
    Cs4 = cs;
    D4 = d;
    Ds4 = ds;
    F4 = f;
    Fs4 = fs;
    E4 = e;
    G4 = g;
    Gs4 = gs;
    A4 = a;
    As4 = as;
    B4 = b;

    noteArr = notes;

    quit    = false;
    playNow = false;
  }

  public void playNow() {
    playNow = true;
  }

  public void quit() {
    quit = true;
  }

  public void run() {
    r_time = 1500;
    while ( !quit ) {
      // Wait 10 ms, then check if there's a request to play
      try {
        Thread.sleep( 1000 );
      } 
      catch ( InterruptedException e ) {
        return;
      }
      // If we have to play the sound, do it!
      if (playNow) {
        int i = 0;
        while (i < noteArr.length)
        {
          switch(noteArr[i])
          {

          case "CM":
            playNow = false;
            println("Playing CM");
            C4.play();
            E4.play();
            G4.play();
            C4.rewind();
            E4.rewind();
            G4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Dm":
            playNow = false;
            println("Playing Dm");
            D4.play();
            F4.play();
            A4.play();
            D4.rewind();
            F4.rewind();
            A4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Em":
            playNow = false;
            println("Playing Em");
            E4.play();
            G4.play();
            B4.play();
            E4.rewind();
            G4.rewind();
            B4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "FM":
            playNow = false;
            println("Playing FM");
            F4.play();
            A4.play();
            C4.play();
            F4.rewind();
            A4.rewind();
            C4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "GM":
            playNow = false;
            println("Playing GM");
            G4.play();
            B4.play();
            D4.play();
            G4.rewind();
            B4.rewind();
            D4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Csus":
            playNow = false;
            println("Playing Am");
            A4.play();
            C4.play();
            E4.play();
            A4.rewind();
            C4.rewind();
            E4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Fm":
            playNow = false;
            println("Playing Am");
            C4.play();
            Ds4.play();
            G4.play();
            C4.rewind();
            Ds4.rewind();
            G4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "D#M":
            playNow = false;
            println("Playing Am");
            Ds4.play();
            G4.play();
            As4.play();
            D4.rewind();
            G4.rewind();
            As4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Fsus":
            playNow = false;
            println("Playing Am");
            F4.play();
            Gs4.play();
            C4.play();
            F4.rewind();
            Gs4.rewind();
            C4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "G#M":
            playNow = false;
            println("Playing Am");
            Gs4.play();
            C4.play();
            Ds4.play();
            G4.rewind();
            C4.rewind();
            Ds4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "C#M":
            playNow = false;
            println("Playing Am");
            A4.play();
            C4.play();
            E4.play();
            A4.rewind();
            C4.rewind();
            E4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "F#M":
            playNow = false;
            println("Playing Am");
            A4.play();
            C4.play();
            E4.play();
            A4.rewind();
            C4.rewind();
            E4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "A#m":
            playNow = false;
            println("Playing Am");
            A4.play();
            C4.play();
            E4.play();
            A4.rewind();
            C4.rewind();
            E4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Am":
            playNow = false;
            println("Playing Am");
            A4.play();
            C4.play();
            E4.play();
            A4.rewind();
            C4.rewind();
            E4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "D#m":
            playNow = false;
            println("Playing Am");
            Ds4.play();
            Fs4.play();
            As4.play();
            Ds4.rewind();
            Fs4.rewind();
            As4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "DM":
            playNow = false;
            println("Playing Am");
            Ds4.play();
            Fs4.play();
            A4.play();
            D4.rewind();
            Fs4.rewind();
            A4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "F#m":
            playNow = false;
            println("Playing Am");
            Fs4.play();
            Ds4.play();
            A4.play();
            Ds4.rewind();
            Fs4.rewind();
            A4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "AM":
            playNow = false;
            println("Playing Am");
            A4.play();
            Cs4.play();
            E4.play();
            A4.rewind();
            Cs4.rewind();
            A4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Bm":
            playNow = false;
            println("Playing Am");
            B4.play();
            D4.play();
            Fs4.play();
            B4.rewind();
            D4.rewind();
            Fs4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Edim":
            playNow = false;
            println("Playing Am");
            E4.play();
            G4.play();
            As4.play();
            E4.rewind();
            G4.rewind();
            As4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "EM":
            playNow = false;
            println("Playing Am");
            E4.play();
            Gs4.play();
            B4.play();
            E4.rewind();
            Gs4.rewind();
            B4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Fo":
            playNow = false;
            println("Playing Fo");
            F4.play();
            Gs4.play();
            B4.play();
            F4.rewind();
            Gs4.rewind();
            B4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "C#m":
            playNow = false;
            println("Playing C#m");
            Cs4.play();
            Gs4.play();
            E4.play();
            Cs4.rewind();
            Gs4.rewind();
            E4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Cm":
            playNow = false;
            println("Playing Am");
            Cs4.play();
            Gs4.play();
            E4.play();
            Cs4.rewind();
            Gs4.rewind();
            E4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "G#m":
            playNow = false;
            println("Playing G#m");
            Gs4.play();
            B4.play();
            D4.play();
            Gs4.rewind();
            B4.rewind();
            D4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "C#sus":
            playNow = false;
            println("Playing C#sus");
            Cs4.play();
            F4.play();
            Gs4.play();
            Cs4.rewind();
            F4.rewind();
            Gs4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Ao":
            playNow = false;
            println("Playing Ao");
            A4.play();
            C4.play();
            Ds4.play();
            A4.rewind();
            C4.rewind();
            Ds4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Co":
            playNow = false;
            println("Playing Co");
            C4.play();
            D4.play();
            Fs4.play();
            C4.rewind();
            D4.rewind();
            Fs4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "C#aug":
            playNow = false;
            println("Playing C#aug");
            Cs4.play();
            F4.play();
            A4.play();
            Cs4.rewind();
            F4.rewind();
            A4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "A#o":
            playNow = false;
            println("Playing A#o");
            As4.play();
            Cs4.play();
            E4.play();
            As4.rewind();
            Cs4.rewind();
            E4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Bo":
            playNow = false;
            println("Playing Bo");
            B4.play();
            D4.play();
            F4.play();
            B4.rewind();
            D4.rewind();
            F4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "C#o":
            playNow = false;
            println("Playing C#o");
            Cs4.play();
            E4.play();
            G4.play();
            Cs4.rewind();
            E4.rewind();
            G4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Do":
            playNow = false;
            println("Playing Do");
            D4.play();
            F4.play();
            Gs4.play();
            D4.rewind();
            F4.rewind();
            Gs4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "D#o":
            playNow = false;
            println("Playing Do");
            Ds4.play();
            Fs4.play();
            A4.play();
            D4.rewind();
            Fs4.rewind();
            A4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "Eo":
            playNow = false;
            println("Playing Do");
            E4.play();
            G4.play();
            C4.play();
            E4.rewind();
            G4.rewind();
            C4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "F#o":
            playNow = false;
            println("Playing F#o");
            Fs4.play();
            A4.play();
            C4.play();
            Fs4.rewind();
            A4.rewind();
            C4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "G#o":
            playNow = false;
            println("Playing F#o");
            Gs4.play();
            B4.play();
            D4.play();
            Gs4.rewind();
            B4.rewind();
            D4.rewind();
            if (diff_selection =="Easy") {
              btns_easy[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_easy[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Medium") {
              btns_med[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_med[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            if (diff_selection =="Hard") {
              btns_hard[i].setColorForeground(color(0, 200, 0));
              delay(r_time);
              btns_hard[i].setColorForeground(color(random(255), random(255), random(255)));
            }
            break;

          case "C#":
            playNow = false;
            Cs4.play();
            Cs4.rewind();
            // Randomly generate the note release time
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "D":
            playNow = false;
            println("Playing D");
            D4.play();
            D4.rewind();
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "D#":
            playNow = false;
            println("Playing D#");
            Ds4.play();
            Ds4.rewind();
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "F":
            playNow = false;
            println("Playing F");
            F4.play();
            F4.rewind();
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "F#":
            playNow = false;
            println("Playing F#");
            Fs4.play();
            Fs4.rewind();
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "E":
            playNow = false;
            E4.play();
            E4.rewind();
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "G":
            playNow = false;
            G4.play();
            G4.rewind();
            // Randomly generate the note release time
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "G#":
            playNow = false;
            Gs4.play();
            Gs4.rewind();
            // Randomly generate the note release time
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "A":
            playNow = false;
            A4.play();
            A4.rewind();
            // Randomly generate the note release time
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "A#":
            playNow = false;
            As4.play();
            As4.rewind();
            // Randomly generate the note release time
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;

          case "B":
            playNow = false;
            B4.play();
            B4.rewind();
            delay(r_time);
            // DO SOMETHING WITH CHORD BOXES
            break;
          }
          i++; // Iterate the Loop
        }
      }
      redraw();
      quit = true;
      // go back and wait again for 1 second...
    }
    print("Timer started, play the sequence!");
    timer_state = true;
  }
}


String[] checkerArr = new String[3];
int fasele = 20;
boolean levelFlag = false;


public void gameStart_easy(String[] WHITE)
{
  // Generate sequence in the start-up.
  print("Generated Progression: ");
  println(WHITE);

  // Convert randSeq ArrayList to Array
  Integer[] randSeqArr = randSeq.toArray(new Integer[randSeq.size()]);
  Integer[] shuffledSeqArr = shuffledSeq.toArray(new Integer[shuffledSeq.size()]);

  background(180);
  stroke(255);
  fill(0, 8);
  smooth();
  frameRate(30);

  //--------------------- Boxes
  cp5 = new ControlP5(this);
  for ( int k = 0; k < mood; k++ ) {
    int Bbx = Bxg+(k%Bgrid)*( Bwg+Boffg);
    int Bby = Byg+(floor(k/Bgrid))*(Bhg+Boffg); 
    // Stores boxes
    boxesbtns_easy[k] = cp5.addBang(str(k))
      .setColorForeground(color(230-255/17*(k+1))) // mouse over
      .setColorActive(color( 200, 0, 0))       // clicked ON
      .setId(shuffledSeqArr[k]) // Assigns ID from shuffledSeqArr to the Boxes
      .setLock(true)
      .setPosition(Bbx, 450+Bby)
      .setSize(100, 100)
      .setFont(createFont("arial", 20))
      .setMouseOver(true) 
      .setMoveable(true) 
      ;
    boxesbtns_easy[k].getCaptionLabel().getStyle().marginTop = 0;
    boxesbtns_easy[k].getCaptionLabel().getStyle().marginLeft = 2*Bwg/5;
  }
  //------------------ CHORDS
  cp5 = new ControlP5(this);
  for ( int i = 0; i < mood; i++ ) {
    int bx = 815+(i%grid)*( wg+offg);
    int by = 100+yg+(floor(i/grid))*(hg+offg);   
    btns_easy[i] = cp5.addBang(str(i*10) )
      .setColorForeground(color(random(255), random(255), random(255))) // mouse over
      .setColorActive(color(0, 200, 0))       // clicked ON
      .setId(randSeqArr[i]) // Assigns ID from randSeqArr
      .setPosition(bx, by)
      .setSize(75, 75)
      .setFont(createFont("arial", 20))
      .setMouseOver(true) 
      .setMoveable(true) 
      .setCaptionLabel(WHITE[i] )
      ;
    btns_easy[i].getCaptionLabel().toUpperCase(false);
    btns_easy[i].getCaptionLabel().getStyle().marginTop = -by/7;
    btns_easy[i].getCaptionLabel().getStyle().marginLeft = wg/5;
    checkerArr[i] = WHITE[i];

    //println("Box [1] ID:"+boxesbtns_easy[0].getId(),"Box [2] ID:"+boxesbtns_easy[1].getId(),"Box [3] ID:"+boxesbtns_easy[2].getId());
    //print("Chord [1] ID:"+btns_easy[0].getId(),"Chord [2] ID:"+btns_easy[1].getId(),"Chord [3] ID:"+btns_easy[2].getId());
  }
}

// Medium Difficulty
public void gameStart_med(String[] WHITE) {
  // Generate sequence in the start-up.
  print("Generated Progression: ");
  print(WHITE);

  // Convert randSeq ArrayList to Array
  Integer[] randSeqArr = randSeq.toArray(new Integer[randSeq.size()]);
  Integer[] shuffledSeqArr = shuffledSeq.toArray(new Integer[shuffledSeq.size()]);

  background(180);
  stroke(255);
  fill(0, 8);
  smooth();
  frameRate(30);

  //--------------------- Boxes
  cp5 = new ControlP5(this);
  for ( int k = 0; k < mood; k++ ) {
    int Bbx = Bxg+(k%Bgrid)*( Bwg+Boffg);
    int Bby = Byg+(floor(k/Bgrid))*(Bhg+Boffg); 
    // Stores boxes
    boxesbtns_med[k] = cp5.addBang(str(k))
      .setColorForeground(color(230-255/17*(k+1))) // mouse over
      .setColorActive(color( 200, 0, 0))       // clicked ON
      .setId(shuffledSeqArr[k]) 
      .setLock(true)
      .setPosition(Bbx, 400+Bby)
      .setSize(100, 100)
      .setFont(createFont("arial", 20))
      .setMouseOver(true) 
      .setMoveable(true) 
      ;
    boxesbtns_med[k].getCaptionLabel().getStyle().marginTop = 0;
    boxesbtns_med[k].getCaptionLabel().getStyle().marginLeft = 2*Bwg/5;
  }

  //------------------ CHORDS
  cp5 = new ControlP5(this);
  for ( int i = 0; i < mood; i++ ) {
    int bx = 660+(i%grid)*(wg+offg);
    int by = 50 + yg+(floor(i/grid))*(hg+offg);   
    btns_med[i] = cp5.addBang(str(i*10) )
      .setColorForeground(color(random(255), random(255), random(255))) // mouse over
      .setColorActive(color(0, 200, 0))       // clicked ON
      .setId(randSeqArr[i]) 
      .setPosition(bx, by)
      .setSize(75, 75)
      .setFont(createFont("arial", 20))
      .setMouseOver(true) 
      .setMoveable(true) 
      .setCaptionLabel(WHITE[i] )
      ;
    btns_med[i].getCaptionLabel().toUpperCase(false);
    btns_med[i].getCaptionLabel().getStyle().marginTop = -by/7;
    btns_med[i].getCaptionLabel().getStyle().marginLeft = wg/5;
  }
}

public void gameStart_hard(String[] WHITE) {

  // Generate sequence in the start-up.
  print("Generated Progression: ");
  print(WHITE);

  // Convert randSeq ArrayList to Array
  Integer[] randSeqArr = randSeq.toArray(new Integer[randSeq.size()]);
  Integer[] shuffledSeqArr = shuffledSeq.toArray(new Integer[shuffledSeq.size()]);

  background(180);
  stroke(255);
  fill(0, 8);
  smooth();
  frameRate(30);

  //--------------------- Boxes
  cp5 = new ControlP5(this);
  for ( int k = 0; k < mood; k++ ) {
    int Bbx = Bxg+(k%Bgrid)*( Bwg+Boffg);
    int Bby = Byg+(floor(k/Bgrid))*(Bhg+Boffg); 
    // Stores boxes
    boxesbtns_hard[k] = cp5.addBang(str(k))
      .setColorForeground(color(230-255/17*(k+1))) // mouse over
      .setColorActive(color( 200, 0, 0))       // clicked ON
      .setId(shuffledSeqArr[k]) 
      .setLock(true)
      .setPosition(Bbx, 300+Bby)
      .setSize(100, 100)
      .setFont(createFont("arial", 20))
      .setMouseOver(true) 
      .setMoveable(true) 
      ;
    boxesbtns_hard[k].getCaptionLabel().getStyle().marginTop = 0;
    boxesbtns_hard[k].getCaptionLabel().getStyle().marginLeft = 2*Bwg/5;
  }

  //------------------ CHORDS
  cp5 = new ControlP5(this);
  for ( int i = 0; i < mood; i++ ) {
    int bx = 525+(i%grid)*( wg+offg);
    int by = yg+(floor(i/grid))*(hg+offg);   
    btns_hard[i] = cp5.addBang(str(i*10) )
      .setColorForeground(color(random(255), random(255), random(255))) // mouse over
      .setColorActive(color(0, 200, 0))       // clicked ON
      .setId(randSeqArr[i]) 
      .setPosition(bx, by)
      .setSize(75, 75)
      .setFont(createFont("arial", 20))
      .setMouseOver(true) 
      .setMoveable(true) 
      .setCaptionLabel(WHITE[i] )
      ;
    btns_hard[i].getCaptionLabel().toUpperCase(false);
    btns_hard[i].getCaptionLabel().getStyle().marginTop = -by/7;
    btns_hard[i].getCaptionLabel().getStyle().marginLeft = wg/5;
  }
}


public void updates_easy () {

  // Chords Display
  fill(255);

  // Background Rectangle
  rect(width/5 + 400, 200 + yg/2, (mood)*(112+offg), hg*2, 18, 18, 18, 18);

  // Drag & Drop 
  for (int i = 0; i < mood; i++) {
    if (btns_easy[i].isActive() &&  mousePressed == true) { 
      btns_easy[i].lock();
      btns_easy[i].setPosition(mouseX-10, mouseY-10);
    }
    if (btns_easy[i].isLock()) {
      btns_easy[i].unlock();
    }
  }
}

public void updates_med () {

  // Chords Display
  fill(255);

  // Background Rectangle
  rect(width/5 + 225, height/2 - 200, (mood)*(112+offg), hg*3/2, 18, 18, 18, 18);

  // Drag & Drop 
  for (int i = 0; i < mood; i++) {
    if (btns_med[i].isActive() &&  mousePressed == true) {
      btns_med[i].lock();
      btns_med[i].setPosition(mouseX-10, mouseY-10);
    }
    if (btns_med[i].isLock()) {
      btns_med[i].unlock();
    }
  }
}

public void updates_hard () {

  // Chords Display
  fill(255);

  // Background Rectangle
  rect(width/5 + 70, height/2 - 250, (mood)*(112+offg), hg*3/2, 18, 18, 18, 18);

  // Drag & Drop 
  for (int i = 0; i < mood; i++) {
    if (btns_hard[i].isActive() &&  mousePressed == true) {
      btns_hard[i].lock();
      btns_hard[i].setPosition(mouseX-10, mouseY-10);
    }
    if (btns_hard[i].isLock()) {
      btns_hard[i].unlock();
    }
  }
}

//-----------------BOX
public void pos_easy() {

  int boxes = 3;
  int[][] pos_chords=new int[mood][2] ;
  int[][] pos_boxes=new int[boxes][2] ;
  int[]dist= new int[mood];
  int[] o= new int[mood];

  for (int i = 0; i < boxes; i++) {
    pos_boxes[i][0]= PApplet.parseInt(boxesbtns_easy[i].getPosition()[0])+100;
    pos_boxes[i][1]= PApplet.parseInt(boxesbtns_easy[i].getPosition()[1])+100;
  }
  for (int i = 0; i < mood; i++) {
    pos_chords[i][0]= PApplet.parseInt(btns_easy[i].getPosition()[0])+wg;
    pos_chords[i][1]= PApplet.parseInt(btns_easy[i].getPosition()[1])+hg;
  }

  int ii=0;
  if (keyPressed) {
    if (key == 'r' ) {
      inc_easy[ii]=0;
    }
  }

  for (int j = 0; j < mood; j++) { 
    for ( ii= 0; ii < boxes; ii++) {
      dist[j]=PApplet.parseInt( sqrt(  pow(PApplet.parseInt((pos_chords[j][0]- pos_boxes[ii][0])), 2)  +  pow(PApplet.parseInt((pos_chords[j][1]- pos_boxes[ii][1])), 2) ) );
      if (keyPressed) {
        if (key == 'r' ) {
          inc_easy[ii]=0;
        }
      }
      if (dist[j]<=fasele &&  mousePressed == false) {
        inc_easy[ii]=j;
      }
    }
  }
}

//-----------------BOX
public void pos_med() {

  int boxes = 6;
  int[][] pos_chords=new int[mood][2] ;
  int[][] pos_boxes=new int[boxes][2] ;
  int[]dist= new int[mood];
  int[] o= new int[mood];

  for (int i = 0; i < boxes; i++) {
    pos_boxes[i][0]= PApplet.parseInt(boxesbtns_med[i].getPosition()[0])+100;
    pos_boxes[i][1]= PApplet.parseInt(boxesbtns_med[i].getPosition()[1])+100;
  }
  for (int i = 0; i < mood; i++) {
    pos_chords[i][0]= PApplet.parseInt(btns_med[i].getPosition()[0])+wg;
    pos_chords[i][1]= PApplet.parseInt(btns_med[i].getPosition()[1])+hg;
  }

  int ii=0;
  if (keyPressed) {
    if (key == 'r' ) {
      inc_med[ii]=0;
    }
  }

  for (int j = 0; j < mood; j++) { 
    for ( ii= 0; ii < boxes; ii++) {
      dist[j]=PApplet.parseInt( sqrt(  pow(PApplet.parseInt((pos_chords[j][0]- pos_boxes[ii][0])), 2)  +  pow(PApplet.parseInt((pos_chords[j][1]- pos_boxes[ii][1])), 2) ) );
      if (keyPressed) {
        if (key == 'r' ) {
          inc_med[ii]=0;
        }
      }
      if (dist[j]<=fasele &&  mousePressed == false) {
        inc_med[ii]=j;
      }
    }
  }
}

//-----------------BOX
public void pos_hard() {

  int boxes = 9;
  int[][] pos_chords=new int[mood][2] ;
  int[][] pos_boxes=new int[boxes][2] ;
  int[]dist= new int[mood];
  int[] o= new int[mood];

  for (int i = 0; i < boxes; i++) {
    pos_boxes[i][0]= PApplet.parseInt(boxesbtns_hard[i].getPosition()[0])+100;
    pos_boxes[i][1]= PApplet.parseInt(boxesbtns_hard[i].getPosition()[1])+100;
  }
  for (int i = 0; i < mood; i++) {
    pos_chords[i][0]= PApplet.parseInt(btns_hard[i].getPosition()[0])+wg;
    pos_chords[i][1]= PApplet.parseInt(btns_hard[i].getPosition()[1])+hg;
  }

  int ii=0;
  if (keyPressed) {
    if (key == 'r' ) {
      inc_hard[ii]=0;
    }
  }

  for (int j = 0; j < mood; j++) { 
    for ( ii= 0; ii < boxes; ii++) {
      dist[j]=PApplet.parseInt( sqrt(  pow(PApplet.parseInt((pos_chords[j][0]- pos_boxes[ii][0])), 2)  +  pow(PApplet.parseInt((pos_chords[j][1]- pos_boxes[ii][1])), 2) ) );
      if (keyPressed) {
        if (key == 'r' ) {
          inc_hard[ii]=0;
        }
      }
      if (dist[j]<=fasele &&  mousePressed == false) {
        inc_hard[ii]=j;
      }
    }
  }
}

public void posCorrectChecker() {
  /*println("Box [1] ID:"+boxesbtns_easy[0].getId(), "Box [2] ID:"+boxesbtns_easy[1].getId(), "Box [3] ID:"+boxesbtns_easy[2].getId());
   print("Chord [1] ID:"+btns_easy[0].getId(), "Chord [2] ID:"+btns_easy[1].getId(), "Chord [3] ID:"+btns_easy[2].getId());
   int x_id = btns_easy[0].getId();
   println("ID of the Box:", x_id);*/
  // Global Flags for Chords, make it true If they're in the correct box!
  boolean tr0 = false;
  boolean tr1 = false;
  boolean tr2 = false;
  boolean tr3 = false;
  boolean tr4 = false;
  boolean tr5 = false;
  boolean tr6 = false;
  boolean tr7 = false;
  boolean tr8 = false;
  boolean tr9 = false;
  levelFlag = false;

  //println("Position X:", +btns_med[0].getPosition()[0], "Position Y:", +btns_med[0].getPosition()[1]);
  // If the Difficulty is selected as Easy
  if (diff_selection == "Easy") {

    for (int i = 0; i < 3; i++) {
      //println("Position X:", +btns_easy[i].getPosition()[0], "Position Y:", +btns_easy[i].getPosition()[1]);
      // First Box
      if ((btns_easy[i].getPosition()[0] <= 810 && btns_easy[i].getPosition()[0] >= 765) &&
        (btns_easy[i].getPosition()[1] <= 650 && btns_easy[i].getPosition()[1] >= 625) && (btns_easy[i].getId() == boxesbtns_easy[0].getId())) {
        tr0 = true;
      }
      // Second Box
      if ((btns_easy[i].getPosition()[0] <= 945 && btns_easy[i].getPosition()[0] >= 915) &&
        (btns_easy[i].getPosition()[1] <= 650 && btns_easy[i].getPosition()[1] >= 625) && (btns_easy[i].getId() == boxesbtns_easy[1].getId())) {
        tr1 = true;
      }
      // Third Box
      if ((btns_easy[i].getPosition()[0] <= 1065 && btns_easy[i].getPosition()[0] >= 1030) &&
        (btns_easy[i].getPosition()[1] <= 650 && btns_easy[i].getPosition()[1] >= 625) && (btns_easy[i].getId() == boxesbtns_easy[2].getId())) {
        tr2 = true;
      }
    }
    if (tr0&&tr1&&tr2)
    {
      println("LevelFlag =", levelFlag);
      levelFlag = true;
    }
    // If all chords are in correct place make global Flag True!
    /*if (levelFlag) {    
      println("Sequence is true!");
    }*/
    // If the Difficulty is selected as Medium
  } else if (diff_selection == "Medium") {

    for (int i = 0; i < 6; i++) {
      //println("Position X:", +btns_easy[i].getPosition()[0], "Position Y:", +btns_easy[i].getPosition()[1]);
      // First Box
      if ((btns_med[i].getPosition()[0] <= 810 && btns_med[i].getPosition()[0] >= 765) &&
        (btns_med[i].getPosition()[1] <= 600 && btns_med[i].getPosition()[1] >= 575) && (btns_med[i].getId() == boxesbtns_med[0].getId())) {
        tr0 = true;
      }
      // Second Box
      if ((btns_med[i].getPosition()[0] <= 945 && btns_med[i].getPosition()[0] >= 915) &&
        (btns_med[i].getPosition()[1] <= 600 && btns_med[i].getPosition()[1] >= 575) && (btns_med[i].getId() == boxesbtns_med[1].getId())) {
        tr1 = true;
      }
      // Third Box
      if ((btns_med[i].getPosition()[0] <= 1065 && btns_med[i].getPosition()[0] >= 1030) &&
        (btns_med[i].getPosition()[1] <= 600 && btns_med[i].getPosition()[1] >= 575) && (btns_med[i].getId() == boxesbtns_med[2].getId())) {
        tr2 = true;
      }
      // Fourth Box
      if ((btns_med[i].getPosition()[0] <= 810 && btns_med[i].getPosition()[0] >= 765) &&
        (btns_med[i].getPosition()[1] <= 728 && btns_med[i].getPosition()[1] >= 703) && (btns_med[i].getId() == boxesbtns_med[3].getId())) {
        tr3 = true;
      }
      // Fifth Box
      if ((btns_med[i].getPosition()[0] <= 945 && btns_med[i].getPosition()[0] >= 915) &&
        (btns_med[i].getPosition()[1] <= 728 && btns_med[i].getPosition()[1] >= 703) && (btns_med[i].getId() == boxesbtns_med[4].getId())) {
        tr4 = true;
      }
      // Sixth Box
      if ((btns_med[i].getPosition()[0] <= 1065 && btns_med[i].getPosition()[0] >= 1030) &&
        (btns_med[i].getPosition()[1] <= 728 && btns_med[i].getPosition()[1] >= 703) && (btns_med[i].getId() == boxesbtns_med[5].getId())) {
        tr5 = true;
      }
    }
    if (tr0&&tr1&&tr2&&tr3&&tr4&&tr5)
    {
      levelFlag = true;
    }
    // If all chords are in correct place make global Flag True!
    if (levelFlag) {    
      println("Sequence is true!");
    }
    // If the Difficulty is selected as Hard
  } else if (diff_selection == "Hard") {
    println("Position X:", +btns_hard[0].getPosition()[0], "Position Y:", +btns_hard[0].getPosition()[1]);
    for (int i = 0; i < 9; i++) {
      // First Box
      if ((btns_hard[i].getPosition()[0] <= 805 && btns_hard[i].getPosition()[0] >= 770) &&
        (btns_hard[i].getPosition()[1] <= 500 && btns_hard[i].getPosition()[1] >= 475) && (btns_hard[i].getId() == boxesbtns_hard[0].getId())) {
        tr0 = true;
        println("Tr0 true");
      }
      // Second Box
      if ((btns_hard[i].getPosition()[0] <= 928 && btns_hard[i].getPosition()[0] >= 902) &&
        (btns_hard[i].getPosition()[1] <= 500 && btns_hard[i].getPosition()[1] >= 475) && (btns_hard[i].getId() == boxesbtns_hard[1].getId())) {
        tr1 = true;
        println("Tr1 true");
      }
      // Third Box
      if ((btns_hard[i].getPosition()[0] <= 1058 && btns_hard[i].getPosition()[0] >= 1035) &&
        (btns_hard[i].getPosition()[1] <= 500 && btns_hard[i].getPosition()[1] >= 475) && (btns_hard[i].getId() == boxesbtns_hard[2].getId())) {
        tr2 = true;
        println("Tr2 true");
      }
      // Fourth Box
      if ((btns_hard[i].getPosition()[0] <= 805 && btns_hard[i].getPosition()[0] >= 770) &&
        (btns_hard[i].getPosition()[1] <= 635 && btns_hard[i].getPosition()[1] >= 605) && (btns_hard[i].getId() == boxesbtns_hard[3].getId())) {
        tr3 = true;
        println("Tr3 true");
      }
      // Fifth  Box
      if ((btns_hard[i].getPosition()[0] <= 928 && btns_hard[i].getPosition()[0] >= 902) &&
        (btns_hard[i].getPosition()[1] <= 635 && btns_hard[i].getPosition()[1] >= 605) && (btns_hard[i].getId() == boxesbtns_hard[4].getId())) {
        tr4 = true;
        println("Tr4 true");
      }
      // Sixth Box
      if ((btns_hard[i].getPosition()[0] <= 1065 && btns_hard[i].getPosition()[0] >= 1030) &&
        (btns_hard[i].getPosition()[1] <= 635 && btns_hard[i].getPosition()[1] >= 605) && (btns_hard[i].getId() == boxesbtns_hard[5].getId())) {
        tr5 = true;
        println("Tr5 true");
      }
      // Seventh Box
      if ((btns_hard[i].getPosition()[0] <= 810 && btns_hard[i].getPosition()[0] >= 765) &&
        (btns_hard[i].getPosition()[1] <= 760 && btns_hard[i].getPosition()[1] >= 737) && (btns_hard[i].getId() == boxesbtns_hard[6].getId())) {
        tr6 = true;
        println("Tr6 true");
      }
      // Eigth Box
      if ((btns_hard[i].getPosition()[0] <= 928 && btns_hard[i].getPosition()[0] >= 902) &&
        (btns_hard[i].getPosition()[1] <= 760 && btns_hard[i].getPosition()[1] >= 737) && (btns_hard[i].getId() == boxesbtns_hard[7].getId())) {
        tr7 = true;
        println("Tr7 true");
      }
      // Nineth Box
      if ((btns_hard[i].getPosition()[0] <= 1065 && btns_hard[i].getPosition()[0] >= 1030) &&
        (btns_hard[i].getPosition()[1] <= 760 && btns_hard[i].getPosition()[1] >= 737) && (btns_hard[i].getId() == boxesbtns_hard[8].getId())) {
        tr8 = true;
        println("Tr8 true");
      }
    }
    if (tr0&&tr1&&tr2&&tr3&&tr4&&tr5&&tr6&&tr7&&tr8)
    {
      levelFlag = true;
    }
    // If all chords are in correct place make global Flag True!
    if (levelFlag) {    
      println("Sequence is true!");
    }
  }
} // Function END 
  public void settings() {  size(1920, 1080); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "drag4" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
