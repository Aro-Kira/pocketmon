package pocketMon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


class LoginUi extends JFrame implements ActionListener{
	
	
	Container con = getContentPane();	
	 JLabel QStart = new JLabel(new ImageIcon("/pocketMoneyManager/src/pocketMon/images/login-design(start).png"));
	JLabel background = new JLabel(new ImageIcon("/pocketMoneyManager/src/pocketMon/images/login-design.png"));
	JLabel x = new JLabel("<html><u>Exit</u></html>");
	Main_Frame new_Frame;
	Font f1 = new Font("Tahoma", Font.PLAIN,15);
	
	LoginUi()
	{
		design();
		panelLayout();
		LocSize();
		CompToCon();
		actEvent();
		
		
	}
	
		public void design() {
		// TODO Auto-generated method stub
			
			
		x.setFont(f1);
		x.setForeground(Color.WHITE);
			
		
	}

		public void LocSize() {
		// TODO Auto-generated method stub
			  QStart.setBounds(160, 250, 100, 65);
			  x.setBounds(200, 300, 100, 50);
	}
	
		public void actEvent() {
		// TODO Auto-generated method stub
		QStart.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
				new_Frame = new Main_Frame();
				new_Frame.setVisible(true);
				dispose();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		x.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				 int choice = JOptionPane.showConfirmDialog(x,
	                        "Are you sure you want to exit?", "Exit Confirmation",
	                        JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				 
				 if (choice == JOptionPane.YES_OPTION) {
	                    System.exit(0);
	                    
				 }
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}});
		
	}


		public void CompToCon() {
		// TODO Auto-generated method stub
		con.add(QStart);
		con.add(x);
		con.add(background); 
        background.setSize(420,520);
		 
	}


		

		public void panelLayout() {
		// TODO Auto-generated method stub
		con.setLayout(null);
	}

		
		@Override
 		public void actionPerformed(ActionEvent e) 
 		{
 			// TODO Auto-generated method stub
	
	
 		}

	
}
public class Login_Frame
{
	static int xx = 0;
	static int yy = 0;

	
	public static void framePanel() {
		int szX = 420;
		int szY = 520;
		
		ImageIcon icon = new ImageIcon("/pocketMoneyManager/src/pocketMon/images/dollawise.png");
		Image image = icon.getImage();
		LoginUi frame = new LoginUi();
		frame.setIconImage(image);
		frame.setSize(szX, szY);
		frame.setLocationRelativeTo(null);	
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.setShape(new RoundRectangle2D.Double(0, 0, szX, szY, 50, 50));
		frame.addMouseListener(new MouseListener() {
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				xx = e.getX();
				yy = e.getY();
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

		
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		frame.addMouseMotionListener(new MouseMotionListener()
			{

			@Override
			public void mouseDragged(MouseEvent e) 
			{
				// TODO Auto-generated method stub
				int x,y;
				x = e.getXOnScreen();
				y = e.getYOnScreen();
				frame.setLocation(x-xx,y-yy);
			
			}

			@Override
			public void mouseMoved(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			
		}); 
		
		
		frame.setVisible(true);
	}
	
	public static void main(String args[]) 
	{
		
		framePanel();
	}
}
	
	
	

