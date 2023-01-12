import java.awt.Image;
import java.util.Random;
import processing.core.PApplet;
import processing.core.PImage;

public class WisconsinPrairie {

  private static PApplet processing; // PApplet object that represents the graphic interface fo the
                                     // WisconsinPrairie application
  private static PImage backgroundImage; // PImage object that represents the background image
  private static Cow[] cows; // array storing the current cows present in the Prairie
  private static Random randGen; // Generator of random numbers

  public static void main(String[] args) {
    Utility.startApplication();
  }

  /**
   * Defines the initial environmental properties of the application
   * 
   * @param processingObj represents a reference to the graphical interface of the application
   */
  public static void setup(PApplet processingObj) {
    processing = processingObj;
    backgroundImage = processing.loadImage("images/background.png");
    cows = new Cow[10];
    randGen = new Random();
  }

  /**
   * Draws and updates the application display window. This callback method called in an infinite
   * loop.
   */
  public static void draw() {
    processing.image(backgroundImage, processing.width / 2, processing.height / 2);
    for (int i = 0; i < cows.length; i++) {
      if (cows[i] != null) {
        cows[i].draw();
      }
    }
  }

  /**
   * Checks if the mouse is over a given cow whose reference is provided as input parameter
   * 
   * @param cow reference to a given cow object
   * @return true if the mouse is over the given cow object (i.e. over the image of the cow), false
   *         otherwise
   */
  public static boolean isMouseOver(Cow cow) {
    boolean inFrame = false;
    float mouseX = processing.mouseX;
    float mouseY = processing.mouseY;
    if (cow == null)
      return false;
    int width = cow.getImage().width / 2;
    float widthMin = cow.getPositionX() - width;
    float widthMax = cow.getPositionX() + width;
    float height = cow.getImage().height / 2;
    float heightMin = cow.getPositionY() - height;
    float heightMax = cow.getPositionY() + height;
    if (mouseX >= widthMin && mouseX <= widthMax) {
      if (mouseY >= heightMin && mouseY <= heightMax) {
        inFrame = true;
      }
    }
    return inFrame;
  }

  /**
   * Callback method called each time the user presses the mouse
   */
  public static void mousePressed() {
    boolean checkCow = true;
    int i = 0;
    while (checkCow && i < cows.length) {
      if (isMouseOver(cows[i])) {
        cows[i].setDragging(true);
        checkCow = false;
      } else {
        i++;
      }
    }
  }

  /**
   * Callback method called each time the mouse is released
   */
  public static void mouseReleased() {
    for (int i = 0; i < cows.length; i++) {
      if (cows[i] != null) {
        cows[i].setDragging(false);
      }
    }
  }

  /**
   * Callback method called each time the user presses a key
   */
  public static void keyPressed() {
    if (processing.key == 'c' || processing.key == 'C') {
      for (int i = 0; i < cows.length; i++) {
        if (cows[i] == null) {
          cows[i] = new Cow(processing, (float) randGen.nextInt(processing.width),
            (float) randGen.nextInt(processing.height));
          break;
        }
      }
    }
    if (processing.key == 'd' || processing.key == 'D') {
      for (int i = 0; i < cows.length; i++) {
        if (isMouseOver(cows[i])) {
          cows[i] = null;
          break;
        }
      }
    }
  }
}
