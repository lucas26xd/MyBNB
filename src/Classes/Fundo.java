package Classes;


import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.TexturePaint;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Fundo extends javax.swing.JPanel{
    @Override
    public void paintComponent(Graphics g){
        try {
            BufferedImage b = ImageIO.read(getClass().getResourceAsStream("/Imagens/fundo.png"));
            Rectangle2D rect = new Rectangle(0, 0, this.getWidth(), this.getHeight());
            TexturePaint p = new TexturePaint(b, rect);
            Graphics2D g2 = (Graphics2D) g;
            g2.setPaint(p);
            g2.fillRect(0, 0, this.getWidth(), this.getHeight());
        } catch (IOException ex) {
            System.err.println("Erro ao colocar fundo! "+ex.getMessage());
        }
    }
}