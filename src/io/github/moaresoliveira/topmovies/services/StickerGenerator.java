package io.github.moaresoliveira.topmovies.services;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class StickerGenerator {

    public void createSticker(InputStream inputStream, String nomeArquivo, Double rating) throws IOException {

        BufferedImage originalImage = ImageIO.read(inputStream);
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + ((height/100)*20) ;
        int starWidth = percentOf(95,width) / 10;
        int starHeight = Long.valueOf(Math.round(starWidth / 1.05)).intValue();
        BufferedImage star = resize(ImageIO.read(new File("star.png")),starWidth,starHeight);
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();

        graphics.drawImage(originalImage,0,0,null);

        int blankSpace = (newHeight - height);



        int marginLeft = percentOf(5, width);
        int marginBottom = height + ((blankSpace - starHeight )/ 2);
        for (int i = 0; i < rating; i++) {
            graphics.drawImage(star, marginLeft ,marginBottom,null);
            marginLeft += starWidth;
        }



        Path path = Path.of("saida/");

        if(!Files.exists(path)){
            Files.createDirectories(path);
        }
        File file = new File(path.toFile(),nomeArquivo+".png");
        ImageIO.write(newImage,"png",file);
    }

    private static BufferedImage resize(BufferedImage img, int newW, int newH) {
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }

    private int percentOf(int percent, int target){
        return (target / 100) * percent;
    }

}
