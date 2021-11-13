/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author Azucena
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String ruta1 = "/Users/Martha Jazmin/Documents/NetBeansProjects/Segmentacion/src/main/java/img/Chrome.jpg";
        BufferedImage img1 = null;
        BufferedImage img2 = null;
        try {
            img1 = ImageIO.read(new File(ruta1));
            img2 = ImageIO.read(new File(ruta1));
            ImageIO.write(segmentacionBN(img1), "png", new File("/Users/Martha Jazmin/Documents/NetBeansProjects/Segmentacion/src/main/java/img/ImagenBN.png"));
            ImageIO.write(segmentacionRGB(img2), "png", new File("/Users/Martha Jazmin/Documents/NetBeansProjects/Segmentacion/src/main/java/img/ImagenRGB.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static BufferedImage segmentacionBN(BufferedImage img1) {
        Color negro = new Color(0, 0, 0);
        Color blanco = new Color(255, 255, 255);
        int rgbW = blanco.getRGB();
        int rgbB = negro.getRGB();

        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {

                int rgb = img1.getRGB(x, y);
                Color colorOrig = new Color(rgb);

                if (colorOrig.getRed() >= 200) {
                    img1.setRGB(x, y, rgbW);
                } else if (colorOrig.getGreen() >= 200) {
                    img1.setRGB(x, y, rgbW);
                } else if (colorOrig.getBlue() >= 200) {
                    img1.setRGB(x, y, rgbW);
                } else {
                    img1.setRGB(x, y, rgbB);
                }
            }
        }
        return img1;
    }

    public static BufferedImage segmentacionRGB(BufferedImage img2) {
        Color negro = new Color(0, 0, 0);
        int rgbB = negro.getRGB();
        //Color blanco = new Color(255,255,255);
        //int rgbW = blanco.getRGB();

        for (int x = 0; x < img2.getWidth(); x++) {
            for (int y = 0; y < img2.getHeight(); y++) {

                int rgb = img2.getRGB(x, y);
                Color colorOrig = new Color(rgb);

                if (colorOrig.getRed() >= 200) {
                    img2.setRGB(x, y, rgb);
                } else if (colorOrig.getGreen() >= 200) {
                    img2.setRGB(x, y, rgb);
                } else if (colorOrig.getBlue() >= 200) {
                    img2.setRGB(x, y, rgb);
                } else {
                    img2.setRGB(x, y, rgbB);
                }

            }
        }
        return img2;
    }
}
