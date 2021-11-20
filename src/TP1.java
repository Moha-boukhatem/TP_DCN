import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.*;
import java.io.File;
import java.awt.*;


public class TP1 {
	

	
	public static void main(String[] args) throws IOException {
		  
		 
		
		 
		BufferedImage img = ImageIO.read(new File("/Users/book/Downloads/PDFs/Voiture.png"));
		
		int width = img.getWidth();
		int height = img.getHeight();
		
		
		
		
		
		
		
		
		/*
		 * 
				Afficher les dimensions d'image		 
		 * 
		 */
		
	
		
		//System.out.print(width+" , "+height);
		
		/*
		 * 
		 		Accès aux pixels d’une image
		 * 
		 */
		/*
		
		int [] red  = new int [256];
		int [] green  = new int [256];
		int [] blue  = new int [256];

		
		
		for (int x = 0; x < width ;x++) {
            for (int y = 0; y < height; y++) {
            	 
            	int p = img.getRGB(x,y);          
            	
            	Color c = new Color(img.getRGB(x, y));
            	
            	red[c.getRed()] +=1 ;
            	green[c.getGreen()] +=1;
            	blue[c.getBlue()]+=1;

            	
            	*/
         	   	for (int x = 0; x < width ;x++) {
            for (int y = 0; y < height; y++) {
            	 
            	int p =img.getRGB(x,y);          
            	
            	Color c = new Color(img.getRGB(x, y));
            
            	int px;
            	
            
                	// px = (c.getRed()+c.getGreen()+c.getBlue())/3 ;

            
            	if (c.getRed()<=20 && c.getGreen()<20 &&  c.getBlue()<=20) {
            		
            		img.setRGB(x,y,new Color(c.getRed()+20, c.getGreen()+20, c.getBlue()+20).getRGB());
            	}


            }
        }
         	   	
         	   JFrame frame = new JFrame();
           	ImageIcon image = new ImageIcon(img);
           	JLabel label = new JLabel(image);

           		frame.add(label);
           		frame.setSize(width,height);
           		frame.setVisible(true);
       		
         	   	/*
       	   
        System.out.println(" Red : ");

		for (int x = 0; x < 256 ;x++) {
            System.out.println(x+"   "+red[x]);

        }
		
		System.out.println(" Green : ");

		for (int x = 0; x < 256 ;x++) {
            System.out.println(x+"   "+green[x]);

        }
		
		System.out.println(" Blue : ");

		for (int x = 0; x < 256 ;x++) {
            System.out.println(x+"   "+blue[x]);

        }
		
		
		
		for (int x = 0; x < width ;x++) {
            for (int y = 0; y < height; y++) {
            	 
            	int p =img.getRGB(x,y);          
            	
            	Color c = new Color(img.getRGB(x, y));
            
            	int px;
            	
            
                	 px = (c.getRed()+c.getGreen()+c.getBlue())/3 ;

            

            img.setRGB(x,y,new Color(px,px,px).getRGB());

            }

        }   
		
		
		
		
		int [] gray  = new int [256];
	


		
		
		for (int x = 0; x < width ;x++) {
            for (int y = 0; y < height; y++) {
            	 
            	int p = img.getRGB(x,y);          
            	
            	Color c = new Color(img.getRGB(x, y));
            	
            	//gray[p] +=1 ;
            	System.out.println(p);



            	
            	
         	   

            }
        }

		System.out.println(" Gray : ");
		for (int x = 0; x < 256 ;x++) {
            System.out.println(x+"   "+gray[x]);

        }
		*/
		
	
		
		  	
		
		  	
  	   
		 }
		
	    }
	

	