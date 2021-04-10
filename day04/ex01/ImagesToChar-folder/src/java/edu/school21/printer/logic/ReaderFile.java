package edu.school21.printer.logic;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;

public class ReaderFile {
  static public char[][] read() throws IOException {
    BufferedImage readerImage = ImageIO.read(ReaderFile.class.getClassLoader().getResourceAsStream("resources/it.bmp"));
    if (readerImage.getType() != BufferedImage.TYPE_BYTE_BINARY || readerImage.getColorModel().getPixelSize() != 1) {
      System.err.println("format doesn't match for print");
      System.exit(-1);
    }
    WritableRaster raster = readerImage.getRaster();
    int height = raster.getHeight();
    int width = raster.getWidth();
    int[] color = new int[1];
    char[][] map = new char[height][width];

    for (int i = raster.getMinY(); i < height; i++) {
      for (int j = raster.getMinX(); j < width; j++) {
        raster.getPixel(j, i, color);
        map[i][j] = (char) color[0];
      }
    }
    return map;
  }
}
