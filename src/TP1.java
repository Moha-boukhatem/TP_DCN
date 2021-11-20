import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;



public class TP1 extends JFrame{
    JButton button ;
    JLabel label,label2,label3,label4;
    
    BufferedImage bimgg;
    JTextField text1,champ1;
    JTextField text2,champ2;
    JTextField text3,champ3;
    
    int count = 0;

    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();

    public TP1(){
    button = new JButton("Parcourir une image");
    button.setBounds(350,150,300,100);
 
    add(button);
    
    
    button.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
        
        
          
          JFileChooser file = new JFileChooser();
          file.setCurrentDirectory(new File("."));
          String[] extensions = ImageIO.getReaderFileSuffixes();
          file.setFileFilter(new FileNameExtensionFilter("Image files", extensions));
          int result = file.showSaveDialog(null);
          
          if(result == JFileChooser.APPROVE_OPTION){
              File selectedFile = file.getSelectedFile();
              String path = selectedFile.getAbsolutePath();
              BufferedImage bimg;
			try {
				bimg = ImageIO.read(new File(path));
				BufferedImage bimgOriginale = ImageIO.read(new File(path));
				  int width          = bimg.getWidth();
	              int height         = bimg.getHeight();
	              label2 =  new JLabel("Title : " + selectedFile.getName());
	              label3 =  new JLabel("Width : "+width + " px, Height : "+height+" px.");
	              label4 =  new JLabel("0 pour <<  et  1 pour >>");

	              label = new JLabel();
	              label.setIcon(ResizeImage(path));
	              label2.setBounds(width+50,20,300,20);
	              label3.setBounds(width+50,40,300,40);
	              label4.setBounds(width+270,120,200,40);

	              text1 = new JTextField(2);
	              text2 = new JTextField(2);
	              text3 = new JTextField(2);
	              champ1 = new JTextField(1);
	              champ2 = new JTextField(1);
	              champ3 = new JTextField(1);

	              
	              text1.setBounds(width+50,80,180,40);
	              champ1.setBounds(width+230,80,30,40);

	              text2.setBounds(width+50,120,180,40);
	              champ2.setBounds(width+230,120,30,40);

	              text3.setBounds(width+50,160,180,40);
	              champ3.setBounds(width+230,160,30,40);

	              
	              button2 = new JButton("Modifier l'image");
	              button2.setBounds(width+50,200,300,40);
	              button3 = new JButton("L'originale");
	              button3.setBounds(width+50,240,300,40);
	              button4 = new JButton("Sauvegarder");
	              button4.setBounds(width+50,280,300,40);
	         
	              
	             
	              label.setBounds(10,10,width,height);
	             
	              button2.addActionListener(new ActionListener() {
	                  public void actionPerformed(ActionEvent e) {
	                	  
						try {
							bimgg = ImageIO.read(new File(path));
							for (int x = 0; x < width ;x++) {
		                          for (int y = 0; y < height; y++) {
		                          	 
		                          	//int p = bimgg.getRGB(x,y);          
		                          	
		                          	Color c = new Color(bimgg.getRGB(x, y));
		                          	int v1 = Integer.parseInt(text1.getText());
		                          	int v2 = Integer.parseInt(text2.getText());
		                          	int v3 = Integer.parseInt(text3.getText());
		                          	
		                          	int c1 = Integer.parseInt(champ1.getText());
		                          	int c2 = Integer.parseInt(champ1.getText());
		                          	int c3 = Integer.parseInt(champ1.getText());
		                          	int r,g,b;
		                          	
		                          	if (c1 == 0) {
			                          	 r = (c.getRed()<<v1)%255 ;

		                          	} else {
			                           r = (c.getRed()>>v1)%255 ;

		                          	}
		                        	if (c2 == 0) {
			                       	     g = (c.getGreen()<<v2)%255 ;

		                          	} else {
			                       	     g = (c.getGreen()>>v2)%255 ;

		                          	}
		                        	if (c3 == 0) {
			                       	     b = (c.getBlue()<<v3)%255 ;

		                          	} else {
			                       	     b = (c.getBlue()>>v3)%255 ;

		                          	}

				                  bimgg.setRGB(x,y,new Color(r,g,b).getRGB());

		                          }

		                      }   	    
							label.setIcon(new ImageIcon(bimgg));
							
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}

	                	  

	                      
	                  	
	                  }
	              });
	              
	              
	              button4.addActionListener(new ActionListener() {
	                  public void actionPerformed(ActionEvent e) {
	                	  count = count+1;
	              	    try {
	              	    	
							ImageIO.write(bimgg, "png", new File("/Users/book/Desktop/NewImage"+ count+".png") );
							
						} catch (IOException e1) {
							e1.printStackTrace();
						}
	                  }
	              });
	              button3.addActionListener(new ActionListener() {
	                  public void actionPerformed(ActionEvent e) {
	                  
	                  	label.setIcon(new ImageIcon(bimgOriginale));
	                  }
	              });
	              
	             
	              
	              add(label);
	              add(label2);
	              add(text1);
	              add(text2);
	              add(text3);
	              add(champ1);
	              add(champ2);
	              add(champ3);	           
	              add(label3);
	              add(label4);
	              add(button2);
	              add(button3);
	              add(button4);
	              
	              button.setVisible(false);

	              //button.setVisible(false);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
             
          }
          

          else if(result == JFileChooser.CANCEL_OPTION){
              System.out.println("Aucun fichier selectione");
          }
        }
    });
 
 
    
    setLayout(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setSize(1000,500);
    setVisible(true);
    }
     
     // Methode to resize imageIcon with the same size of a Jlabel
    public ImageIcon ResizeImage(String ImagePath)
    {
        ImageIcon MyImage = new ImageIcon(ImagePath);
        Image img = MyImage.getImage();
        Image newImg = img.getScaledInstance(img.getWidth(null), img.getHeight(null), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
       // ImageIcon image = new ImageIcon(img);
        return image;
    }
    
    public static void main(String[] args){
        new TP1();
    }
   }








