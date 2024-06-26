int height = 8;
int width = 32;
int port = 0;
int rainbowHue = 0;
  
public ledPanel = new AddressableLED(port); // Set LED port
public ledBuffer = new AddressableLEDBuffer(height*width); // Set LED buffer length

public static void init() {}
  ledPanel.setLength(ledBuffer.getLength()); // Set LED strip length

  ledPanel.setData(ledBuffer); // Set LED outut to LED buffer
  ledPanel.start(); // Start outputting to LEDs
}

public static void setPlateRGB(int[] color) {
    for(int i = 0, i < ledbuffer.getLength(), i++) {
      ledBuffer.setRGB(i, color[1], color[2], color[3]); // Loop through and set every LED to the color in the buffer
    }
}

public static void setPlateHSV(int[] color) {
  for(int i = 0, i < ledbuffer.getLength(), i++) {
    ledBuffer.setHSV(i, color[1], color[2], color[3]); // Loop through and set every LED to the color in the buffer
  }
}

private static void drawLineRGB(int x0, int y0, int x1, int y1, int[] color) {
  double dx = Math.abs(x1 - x0);
  int sx = x0 < x1 ? 1 : -1;
  double dy = 0 - Math.abs(y1 - y0);
  int sy = y0 < y1 ? 1 : -1;
  double error = dx +dy;

  while (true) {
    int index = 0;
    if (x0 % 2 == 0) {
      index = x0 * height + y0;
    } else {
      index = (x0 + 1) * height - 1 - y;
    }
    ledBuffer.setRGB(index, color[1], color[2], color[3]);
    
    if (x0 == x1 && y0 == y1) {break}
    double e2 = 2 * error;
    if (e2 >= dy) {
      if (x0 == x1) {break}
      error = error + dy;
      x0 = x0 + sx;
    }
    if (e2 <= dx) {
      if (y0 == y1) {break}
      error = error + dx;
      y0 = y0 + sy;
    }
  }
}

private static void drawLineHSV(int x0, int y0, int x1, int y1, int[] color) {
  double dx = Math.abs(x1 - x0);
  int sx = x0 < x1 ? 1 : -1;
  double dy = 0 - Math.abs(y1 - y0);
  int sy = y0 < y1 ? 1 : -1;
  double error = dx +dy;

  while (true) {
    int index = 0;
    if (x0 % 2 == 0) {
      index = x0 * height + y0;
    } else {
      index = (x0 + 1) * height - 1 - y;
    }
    ledBuffer.setHSV(index, color[1], color[2], color[3]);
    
    if (x0 == x1 && y0 == y1) {break}
    double e2 = 2 * error;
    if (e2 >= dy) {
      if (x0 == x1) {break}
      error = error + dy;
      x0 = x0 + sx;
    }
    if (e2 <= dx) {
      if (y0 == y1) {break}
      error = error + dx;
      y0 = y0 + sy;
    }
  }
}

//@Param full    whether or not it fills the whole plate
//@Param speed   How fast the hue changes
//@Param x0      Starting x offset
//@Param y0      Top y offset
//@Param x1      Final X offset
//@Param y1      Bottom y offset
private static void rainbow(boolean full, int speed, int x0, int y0, int x1, int y1) {
  if (full) {
    for(int i = 0, i < ledbuffer.getLength(), i++) {
      ledBuffer.setHSV(i, whatever, 1, 1);
    }
  } else {
    for (var i = x0; i < x1; i++) {
      final var hue = (rainbowHue + (i * 180 / width)) % 180;
      drawLineHSV(i, y0, i, height - y1, hue, 255, 128);
    }
  }
  rainbowHue += speed;
  rainbowHue %= 180;
}


















