package Main;

import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Grayscale {
	public static void main(String args[])throws IOException{
	    BufferedImage img = null;
	    File f = null;

	    //lê a imagem
	    try{
	      f = new File("Cataratas.jpg");
	      img = ImageIO.read(f);
	    }catch(IOException e){
	      System.out.println(e);
	    }

	    //obtem largura e altura da imagem
	    int width = img.getWidth();
        int height = img.getHeight();

	    //converte para escala de cinza
	    for(int y = 0; y < height; y++){
	      for(int x = 0; x < width; x++){
	        int p = img.getRGB(x,y);

	        int a = (p>>24)&0xff;
	        int r = (p>>16)&0xff;
	        int g = (p>>8)&0xff;
	        int b = p&0xff;

	        //calculo
	        int avg = (r+g+b)/3;

	        //Encontrar a média dos valores de R, G e 
	        p = (a<<24) | (avg<<16) | (avg<<8) | avg;

	        img.setRGB(x, y, p);
	      }
	    }

	    //Gravar  imagem
	    try{
	      f = new File("Cataratas.png");
	      ImageIO.write(img, "jpg", f);
	    }catch(IOException e){
	      System.out.println(e);
	    }
	  }
}
