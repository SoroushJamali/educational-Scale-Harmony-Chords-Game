//   Title: Game #3 - The Drag Game
//   Description: The Player tries to match chords concerning the given order of sequence. 
//   There are three difficulty selections available: Easy, Medium, and Hard.
//   In Easy mode, there will be three boxes that correspond to 3 possible chords. Medium 6 boxes and Hard nine boxes. 
//   The players have to arrange them in the correct order to pass the round. 
//   Total points calculated concerning each proper sequence player has completed.
//   When the Player fails to arrange them in a correct sequence, the game ends.

//----------------- 0. Libraries
import oscP5.*;
import netP5.*;
import controlP5.*;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
import gifAnimation.*;
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
void setup() {
  inc_easy [0] = 1;
  inc_med  [0] = 1;
  inc_hard [0] = 1;
  //fullScreen();

  size(1920, 1080);
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

void draw() {

  background(backgroundImage);

  if (gameStart != false) {
    if (diff_selection == "Easy" && gameEnd != true)
    { 
      String[] seqDisp = new String[3];
      seqDisp[0] = (shuffledSeq.get(0)).toString();
      seqDisp[1] = (shuffledSeq.get(1)).toString();
      seqDisp[2] = (shuffledSeq.get(2)).toString();
      textSize(32);
      fill(#35ea3f);
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
      fill(#35ea3f);
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
      fill(#35ea3f);
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
        fill(#38ebe8, 100);
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
      fill(#38ebe8);
      noStroke();
      rect(1175, 475, map(counter-timerStartTime, 0, timerMaxTime, 0, 400), 19 );
      noFill();
      stroke(#4d4d4d);
      rect(1175, 475, 400, 19);
      // Timer Progress bar configuration ---------------------------------------

      // Text for points earned in the current level (Mete) ---------------------
      /*textSize(21);
      text("Points: "+str(totalCorrect*100), 1175, 460);
      fill(#38ebe8, 100);*/


        textSize(21);
        text("Points: "+str(glbPoint), 1175, 435);
        fill(#38ebe8, 100);
      

      textSize(14);
      text("Complete the sequence before timer runs up!", 1325, 460);
      fill(#38ebe8, 100);
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
    fill(#38ebe8, 100);
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


void results () {



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
