//  Title: Game #3 - The Drag Game
//  Window: Button Functions are stored hereç
int yolo=0;

// Difficulty Control Buttons --------------------------
void easy() {
  diff_selection = "Easy";
  mood = 3;
  redraw();
  EASY.hide();
  MEDIUM.hide();
  HARD.hide();
}

void medium() {
  diff_selection = "Medium";
  mood = 6;
  redraw();
  EASY.hide();
  MEDIUM.hide();
  HARD.hide();
}

void hard() {
  diff_selection = "Hard";
  mood = 9;
  redraw();
  EASY.hide();
  MEDIUM.hide();
  HARD.hide();
}
// Difficulty Control Buttons --------------------------

// Root Note Selection ---------------------------------
void C() {
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
void Cs() {
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
void D() {
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
void Ds() {
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
void E() {
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
void F() {
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
void Fs() {
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
void G() {
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
void Gs() {
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
void A() {
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
void As() {
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
void B() {
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
void Major() {
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
void Minor() {
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
void Dorian() {
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
void Locrian() {
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
void Phrygian() {
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
void Lydian() {
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
void Mixolydian() {
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
void Aeolian() {
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
void play() {
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
