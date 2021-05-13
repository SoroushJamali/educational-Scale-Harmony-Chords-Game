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

Minim minim;
AudioSample mouseHooverFX;      

// Function to generate sound for Mouse Hoover Event
public void sndplayMouseHoover() {
  minim = new Minim(this);
  mouseHooverFX  = minim.loadSample("data/sounds/generalsounds/mouseHoover.mp3", 512);
  mouseHooverFX .trigger();
}
