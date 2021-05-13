

String[] checkerArr = new String[3];
int fasele = 20;
boolean levelFlag = false;


void gameStart_easy(String[] WHITE)
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
void gameStart_med(String[] WHITE) {
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

void gameStart_hard(String[] WHITE) {

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


void updates_easy () {

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

void updates_med () {

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

void updates_hard () {

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
void pos_easy() {

  int boxes = 3;
  int[][] pos_chords=new int[mood][2] ;
  int[][] pos_boxes=new int[boxes][2] ;
  int[]dist= new int[mood];
  int[] o= new int[mood];

  for (int i = 0; i < boxes; i++) {
    pos_boxes[i][0]= int(boxesbtns_easy[i].getPosition()[0])+100;
    pos_boxes[i][1]= int(boxesbtns_easy[i].getPosition()[1])+100;
  }
  for (int i = 0; i < mood; i++) {
    pos_chords[i][0]= int(btns_easy[i].getPosition()[0])+wg;
    pos_chords[i][1]= int(btns_easy[i].getPosition()[1])+hg;
  }

  int ii=0;
  if (keyPressed) {
    if (key == 'r' ) {
      inc_easy[ii]=0;
    }
  }

  for (int j = 0; j < mood; j++) { 
    for ( ii= 0; ii < boxes; ii++) {
      dist[j]=int( sqrt(  pow(int((pos_chords[j][0]- pos_boxes[ii][0])), 2)  +  pow(int((pos_chords[j][1]- pos_boxes[ii][1])), 2) ) );
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
void pos_med() {

  int boxes = 6;
  int[][] pos_chords=new int[mood][2] ;
  int[][] pos_boxes=new int[boxes][2] ;
  int[]dist= new int[mood];
  int[] o= new int[mood];

  for (int i = 0; i < boxes; i++) {
    pos_boxes[i][0]= int(boxesbtns_med[i].getPosition()[0])+100;
    pos_boxes[i][1]= int(boxesbtns_med[i].getPosition()[1])+100;
  }
  for (int i = 0; i < mood; i++) {
    pos_chords[i][0]= int(btns_med[i].getPosition()[0])+wg;
    pos_chords[i][1]= int(btns_med[i].getPosition()[1])+hg;
  }

  int ii=0;
  if (keyPressed) {
    if (key == 'r' ) {
      inc_med[ii]=0;
    }
  }

  for (int j = 0; j < mood; j++) { 
    for ( ii= 0; ii < boxes; ii++) {
      dist[j]=int( sqrt(  pow(int((pos_chords[j][0]- pos_boxes[ii][0])), 2)  +  pow(int((pos_chords[j][1]- pos_boxes[ii][1])), 2) ) );
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
void pos_hard() {

  int boxes = 9;
  int[][] pos_chords=new int[mood][2] ;
  int[][] pos_boxes=new int[boxes][2] ;
  int[]dist= new int[mood];
  int[] o= new int[mood];

  for (int i = 0; i < boxes; i++) {
    pos_boxes[i][0]= int(boxesbtns_hard[i].getPosition()[0])+100;
    pos_boxes[i][1]= int(boxesbtns_hard[i].getPosition()[1])+100;
  }
  for (int i = 0; i < mood; i++) {
    pos_chords[i][0]= int(btns_hard[i].getPosition()[0])+wg;
    pos_chords[i][1]= int(btns_hard[i].getPosition()[1])+hg;
  }

  int ii=0;
  if (keyPressed) {
    if (key == 'r' ) {
      inc_hard[ii]=0;
    }
  }

  for (int j = 0; j < mood; j++) { 
    for ( ii= 0; ii < boxes; ii++) {
      dist[j]=int( sqrt(  pow(int((pos_chords[j][0]- pos_boxes[ii][0])), 2)  +  pow(int((pos_chords[j][1]- pos_boxes[ii][1])), 2) ) );
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
