package pocketMon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;

class editFrame extends JFrame implements ActionListener {

	Container con = getContentPane();

	JLabel QDate = new JLabel("Date:");
	JLabel QName = new JLabel("Name:");
	JLabel QDes = new JLabel("Description:");
	JLabel QPrice = new JLabel("Price:");
	JLabel addlist = new JLabel("Edit Item");

	public static JTextField txt_date = new JTextField();
	public static JTextField txt_date1 = new JTextField();
	public static JTextField txt_date2 = new JTextField();
	public static JTextField txt_name = new JTextField();
	public static JTextArea txt_des = new JTextArea();
	public static JTextField txt_price = new JTextField();

	Font f1 = new Font("Tahoma", Font.PLAIN, 15);
	Font f2 = new Font("Tahoma", Font.BOLD, 20);

	String[] list = { "Spend Money", "Save Money" };

	 int[] intlist= {0,1};
	
	public JButton edit = new JButton("Edit");

	JComboBox<String> jcombo = new JComboBox<>(list);

	JButton back = new JButton("Back");

	int count;
	String WDate, WName, WPrice, WDes;
	
	JLabel background = new JLabel(new ImageIcon("/pocketMoneyManager/src/pocketMon/images/backdrop.png"));

	editFrame() {

		design();
		panelLayout();
		LocSize();
		CompToCon();
		actEvent();

	}

	public void CompToCon() {
		// TODO Auto-generated method stub
		con.add(QDate);
		con.add(QName);
		con.add(QDes);
		con.add(QPrice);
		con.add(addlist);

		con.add(edit);
		con.add(back);
		
		con.add(txt_date);
		con.add(txt_date1);
		con.add(txt_date2);
		con.add(txt_name);
		con.add(txt_des);
		con.add(txt_price);

		con.add(jcombo);
		con.add(background); 
	}

	public void LocSize() {
		// TODO Auto-generated method stub
		QDate.setBounds(90, 95, 150, 30);
		QName.setBounds(90, 125, 150, 30);
		QDes.setBounds(185, 185, 150, 30);
		QPrice.setBounds(90, 155, 150, 30);
		addlist.setBounds(185, -10, 100, 100);

		txt_date.setBounds(155,100, 45,25);
		txt_date1.setBounds(205,100, 45,25);
		txt_date2.setBounds(260,100, 45,25);
		
		txt_name.setBounds(155, 130, 150, 25);
		txt_price.setBounds(155, 160, 150, 25);
		txt_des.setBounds(70, 220, 300, 220);

		jcombo.setBounds(155, 65, 150, 20);

		edit.setBounds(225,450,70,20);
		back.setBounds(300, 450, 70, 20);
	}

	public void panelLayout() {
		// TODO Auto-generated method stub
		con.setLayout(null);
	}

	public void design() {
		// TODO Auto-generated method stub
		QDate.setFont(f1);
		QName.setFont(f1);
		QDes.setFont(f1);
		QPrice.setFont(f1);
		addlist.setFont(f2);
		 txt_des.setDocument(new LimitedDocument(300));
		 txt_des.setLineWrap(true);
		 txt_des.setWrapStyleWord(true);
		 txt_des.setOpaque(false); // Make the JTextArea transparent
		 txt_des.setBackground(new Color(0, 0, 0, 0)); // Set transparent background
		 txt_des.setBorder(BorderFactory.createCompoundBorder(
			    BorderFactory.createLineBorder(Color.GRAY), // Add a gray border
			    BorderFactory.createEmptyBorder(8, 8, 8, 8) // Add padding
			));
		 background.setSize(520,520);
	}

	public void actEvent() {
		// TODO Auto-generated method stub
		edit.addActionListener(this);
		back.addActionListener(this);
		
	        
	        
		 txt_date.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    // Move focus to the next text field
	                    txt_date1.requestFocus();
	                }
	            }
	        });
		 
	        txt_date1.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    // Move focus to the next text field
	                    txt_date2.requestFocus();
	                }
	            }
	        });
	        
	        txt_date2.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    // Move focus to the next text field
	                    txt_name.requestFocus();
	                }
	            }
	        });
	        
	        txt_name.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    // Move focus to the next text field
	                    txt_price.requestFocus();
	                }
	            }
	        });
	        
	        txt_price.addKeyListener(new KeyAdapter() {
	            @Override
	            public void keyPressed(KeyEvent e) {
	                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
	                    // Move focus to the next text field
	                    txt_des.requestFocus();
	                }
	            }
	        });
	        
	      
	      
	}
	
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/*
		 * if(e.getSource() == null) {
		 * 
		 * Mframe.Date = txt_date.getText(); Mframe.Name = txt_name.getText();
		 * Mframe.Des = txt_des.getText(); Mframe.Price = txt_price.getText();
		 * 
		 * 
		 * WDate = txt_date.getText(); WName = txt_name.getText(); WDes =
		 * txt_des.getText(); WPrice = txt_price.getText(); String sel_item = (String)
		 * jcombo.getSelectedItem(); if(!WDate.isBlank() && !WName.isBlank() &&
		 * !WDes.isBlank() && !WPrice.isBlank()) { if
		 * (sel_item.equalsIgnoreCase(list[0])) {
		 * 
		 * Mframe.model.addRow(new Object[] {1,WDate,WName,WDes,list[0],WPrice}); }else
		 * if (sel_item.equalsIgnoreCase(list[1])) {
		 * 
		 * Mframe.model.addRow(new Object[] {0,WDate,WName,WDes,list[1],WPrice});
		 * 
		 * }
		 * 
		 * }
		 * 
		 * txt_date.setText(""); txt_name.setText(""); txt_des.setText("");
		 * txt_price.setText(""); }
		 */
		if(e.getSource() == edit) {
		
		  int selectedRow = Mframe.row;
		  
		  
		  
		  if (selectedRow != -1) {
			  // Get data from text fields
	            
	            try {
		            int Qmonth = Integer.parseInt(txt_date.getText());
					 int Qday = Integer.parseInt(txt_date1.getText());
					 int Qyear = Integer.parseInt(txt_date2.getText());
					 String editedDate = Qmonth + "/" + Qday + "/" + Qyear;
	            
	            
	            String editedName = txt_name.getText();
	            String editedDes = txt_des.getText();
	            int editedPrice = Integer.parseInt(txt_price.getText().replace("$", ""));
	     
	            String selectedItem = (String) jcombo.getSelectedItem();
	            
	            // Update data in the JTable
	            
	            Mframe.table.setValueAt(editedDate, selectedRow, 1);
	            Mframe.table.setValueAt(editedName, selectedRow, 2);
	            Mframe.table.setValueAt(editedDes, selectedRow, 3);
	            Mframe.table.setValueAt(selectedItem, selectedRow, 4); 
	            Mframe.table.setValueAt("$"+editedPrice, selectedRow, 5);
	            
	            if(selectedItem.equalsIgnoreCase(list[0])) {
	    	    	
	    	    	Mframe.table.setValueAt(1, selectedRow, 0);
	    	    	
	    	    }else if(selectedItem.equalsIgnoreCase(list[1])) {
	    	    	
	    	    	Mframe.table.setValueAt(0, selectedRow, 0);
	    	    	
	    	    }
	            
	            Mframe.model.fireTableDataChanged();
	            
	            
	            }catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(this, "Please enter a valid date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
		        }  
	        } else {
	            JOptionPane.showMessageDialog(null, "Please select a row to edit.");
	        }
		  addFrame.updateBalance();
		  System.out.println(1);
}
		
		if (e.getSource() == back) {
			count = Mframe.openFrameCount--;
			this.dispose();

		}

	}

}

public class EditList {
	static int xx = 0;
	static int yy = 0;

	editFrame Qframe;

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		int szX = 440;
		int szY = 480;

		Qframe = new editFrame();
		ImageIcon icon = new ImageIcon("/pocketMoneyManager/src/pocketMon/images/dollawise.png");
		Image image = icon.getImage();
		Qframe.setIconImage(image);
		Qframe.setSize(szX, szY);
		Qframe.setResizable(false);
		Qframe.setLocationRelativeTo(null);
		Qframe.setTitle("Add List");
		Qframe.setUndecorated(true);
		Qframe.setShape(new RoundRectangle2D.Double(0, 0, szX, szY, 50, 50));

		Qframe.getContentPane().setBackground(Color.LIGHT_GRAY);

		Qframe.addMouseListener(new MouseListener() {
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
		Qframe.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				int x, y;
				x = e.getXOnScreen();
				y = e.getYOnScreen();
				Qframe.setLocation(x - xx, y - yy);

			}

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		  Qframe.addWindowListener(new WindowAdapter() {
	          @Override
	          public void windowClosing(WindowEvent e) {
	              // Display a confirmation dialog before exiting
	              int choice = JOptionPane.showConfirmDialog(
	                     Qframe,
	                      "Are you sure you want to exit?",
	                      "Exit Confirmation",
	                      JOptionPane.YES_NO_OPTION,
	                      JOptionPane.QUESTION_MESSAGE);

	              if (choice == JOptionPane.YES_OPTION) {
	                  // Exit the application if the user confirms
	                  Qframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	              } else {
	                  // Do nothing if the user cancels
	                  Qframe.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	              }
	          }
	      });
		
		// end
		Qframe.setVisible(b);
	}

}
