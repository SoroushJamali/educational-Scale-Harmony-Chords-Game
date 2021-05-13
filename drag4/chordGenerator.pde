//  Title: Game #3 - The Drag Game
//  Window: Chord Generator
//  Description: Automatic Chord seqeuence generation process is done here.

// Libraries
import java.util.ArrayList; // import the ArrayList class
import java.util.Random;

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
