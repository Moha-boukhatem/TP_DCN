import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.*;

import java.io.IOException;
public class GUI {
	

	public static void main(String[] args) throws IOException {

		JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(null);
        
       
        BufferedImage img = ImageIO.read(new File(chooser.getSelectedFile().getAbsolutePath()));
        
		JFrame frame = new JFrame();
		frame.setTitle("DCN Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(Color.gray);
		frame.setResizable(false);
		frame.setSize(800,600);
        frame.setVisible(true);

		
		

	  	ImageIcon image = new ImageIcon(img);
		JLabel label = new JLabel(image);

	  	frame.add(label);
	  	frame.setVisible(true);
	}

}
