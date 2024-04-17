int height = 8
int width = 32
int port = 0

ledPanel = new AddressableLED(port); // Set LED port
ledBuffer = new AddressableLEDBuffer(height*width); // Set LED buffer length

public static void init() {}
  ledPanel.setLength(ledBuffer.getLength()); // Set LED strip length

  ledPanel.setData(ledBuffer); // Set LED outut to LED buffer
  ledPanel.start(); // Start outputting to LEDs
}

public static void setPlateRGB(int[] color = new int[3]) {
  for(int i = 0, i < ledbuffer.getLength(), i++) {
    ledBuffer.setRGB(i, color[1], color[2], color[3]); // Loop through and set every LED to the color in the buffer
  }
  ledPanel.setData(ledBuffer); // Set the panel to the buffer
}

public static void setPlateHSV(int[] color = new int[3]) {
  for(int i = 0, i < ledbuffer.getLength(), i++) {
    ledBuffer.setHSV(i, color[1], color[2], color[3]); // Loop through and set every LED to the color in the buffer
  }
  ledPanel.setData(ledBuffer); // Set the panel to the buffer
}

private static void drawLineRGB(int x0, int y0, int x1, int y1, int[] color = new int[3]) {
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

private static void drawLineHSV(int x0, int y0, int x1, int y1, int[] color = new int[3]) {
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
