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

  void run() {
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
