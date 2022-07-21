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

    public void createSticker(InputStream inputStream, String nomeArquivo, String text) throws IOException {

        BufferedImage originalImage = ImageIO.read(inputStream);
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + ((height/100)*20) ;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();

        graphics.drawImage(originalImage,0,0,null);

        int blankSpace = (newHeight - height);
        Font fonte = new Font("Arial",Font.BOLD,48);
        graphics.setFont(fonte);
        graphics.setColor(Color.ORANGE);

//        FontMetrics metrics = graphics.getFontMetrics();
//        int stringWidth = metrics.stringWidth(text);
//        int marginLeft = percentOf(5, width);
//        int marginBottom = height + ((blankSpace - metrics.getHeight() )/ 2);
//        int fontSize = Long.valueOf(Math.round(percentOf(80, blankSpace)/1.17)).intValue();
//        if(stringWidth < width){
//            Font font = new Font("Arial",Font.BOLD,fontSize);
//            graphics.setFont(font);
//            graphics.drawString(text, marginLeft ,marginBottom);
//        }else{
//            System.out.println("Grande demais");
//            int sWidth = stringWidth;
//            int newFontSize = fontSize;
//            while(sWidth > width){
//                newFontSize -= 1;
//                graphics.setFont(new Font("Arial",Font.BOLD,newFontSize));
//                sWidth = graphics.getFontMetrics().stringWidth(text);
//            }
//            graphics.drawString(text, marginLeft ,marginBottom);
//        }



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
