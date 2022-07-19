package io.github.moaresoliveira;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class StickerGenerator {

    void createSticker(InputStream inputStream, String nomeArquivo) throws IOException {

        BufferedImage originalImage = ImageIO.read(inputStream);
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int newHeight = height + 200;
        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();

        graphics.drawImage(originalImage,0,0,null);

        Font font = new Font("Arial", Font.BOLD, 48);
        graphics.setFont(font);
        graphics.setColor(Color.ORANGE);
        graphics.drawString("TOPZERA", 100 ,newHeight - 100);

        ImageIO.write(newImage,"png",new File("saida/"+nomeArquivo+".png"));
    }

}
