# LedPanelLib
A small library to control LED panels via the FIRST Robotics RoboRIO.<br>
Contains many useful functions including:
- Filing the entire panel withh a color
- Drawing colored lines from point to point

<!-- -->
  
To use, place the `Led.java` file wherever you want in your robot code file structure, and just import it into the files you want to use it in. Next, make sure you set the height, width, and port of the LED panel at the top of the `Led.java` file.<br>
Function list:<br>
```
init(); // Initializes the LED panel
setPlateRGB(intArray[]); // Fills the panel with a color. Takes a 3 element array of integers containing the red, green, and blue values from 0-255
setPlateHSV(intArray[]); // Does the same thing as setPlateRGB, but takes hue, saturation, and value instead
drawLineRGB(x0, y0, x1, y1, intArray[]); // Takes the endpoints of a line, and the RGB color value the same way as setPlateRGB
drawLineHSV(x0, y0, x1, y1, intArray[]); // Does the same thing as drawLineRGB, but takes hue, saturation, and value instead
rainbow(full, speed, x0, y0, x1, y1); // Draws rainbow effect on LED panel, see Led.java for documentation
```
