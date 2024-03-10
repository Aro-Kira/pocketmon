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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;




	
class addFrame extends JFrame implements ActionListener, FocusListener{

	
	
	Container con = getContentPane();
	
	JLabel QDate = new JLabel("Date:");
	JLabel QName = new JLabel("Name:");
	JLabel QDes = new JLabel("Description:");
	JLabel QPrice = new JLabel("Price:");
	JLabel addlist = new JLabel("Add Item");
	
	
	JTextField txt_date = new JTextField("MM");
	JTextField txt_date1 = new JTextField("DD");
	JTextField txt_date2 = new JTextField("YYYY");
	
	JTextField txt_name = new JTextField("Set Name of the product");
	JTextArea txt_des = new JTextArea();
	JTextField txt_price = new JTextField("Set Price");
	
	Font f1 = new Font("Tahoma", Font.PLAIN,15);
	Font f2 = new Font("Tahoma", Font.BOLD,20);
	
	String[] list = {"Spend Money", "Save Money"};
	
	JComboBox<String> jcombo = new JComboBox<>(list);
	
	JButton Qadd = new JButton("Add");
	JButton back = new JButton("Back");
	
	int count;
	String WDate,WName,WDes;
	int WPrice;
	
	JLabel background = new JLabel(new ImageIcon("/pocketMoneyManager/src/pocketMon/images/backdrop.png"));
	
	addFrame()
	{
		
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
		
		
		con.add(Qadd);
		con.add(back);
		
		con.add(txt_date);//mm
		con.add(txt_date1);//dd
		con.add(txt_date2);//yyyy
		
		con.add(txt_name);
		con.add(txt_des);
		con.add(txt_price);
		
		con.add(jcombo);
	
		con.add(background); 
	}











	public void LocSize() {
		// TODO Auto-generated method stub
		QDate.setBounds(90,95, 150,30);
		QName.setBounds(90,125, 150,30);
		QDes.setBounds(185,185, 150,30);
		QPrice.setBounds(90,155, 150,30);
		addlist.setBounds(185,-10,100,100);
		
		txt_date.setBounds(155,100, 45,25);
		txt_date1.setBounds(205,100, 45,25);
		txt_date2.setBounds(260,100, 45,25);
		
		
		txt_name.setBounds(155,130, 150,25);
		txt_price.setBounds(155,160, 150,25);
		txt_des.setBounds(70,220, 300,220);
		
		jcombo.setBounds(155,65, 150,20);
		
		
		Qadd.setBounds(225,450,70,20);
		back.setBounds(300,450,70,20);
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
		 background.setSize(520,520);
		 
		 
		 QDate.setForeground(Color.black);
		 QName.setForeground(Color.black);
		 QDes.setForeground(Color.black);
		 QPrice.setForeground(Color.black);
		 addlist.setForeground(Color.black);
		 txt_name.setForeground(Color.gray);
		 txt_price.setForeground(Color.gray);
		 txt_date1.setForeground(Color.gray);
		 txt_date2.setForeground(Color.gray);
		 txt_date.setForeground(Color.gray);
		 
		 txt_des.setDocument(new LimitedDocument(300));
		 txt_des.setLineWrap(true);
		 txt_des.setWrapStyleWord(true);
		 txt_des.setOpaque(false); // Make the JTextArea transparent
		 txt_des.setBackground(new Color(0, 0, 0, 0)); // Set transparent background
		 txt_des.setBorder(BorderFactory.createCompoundBorder(
			    BorderFactory.createLineBorder(Color.GRAY), // Add a gray border
			    BorderFactory.createEmptyBorder(8, 8, 8, 8) // Add padding
			));
	}


	public void actEvent() {
		// TODO Auto-generated method stub
		Qadd.addActionListener(this);
		back.addActionListener(this);
		 txt_date.addFocusListener(this);
	        txt_date1.addFocusListener(this);
	        txt_date2.addFocusListener(this);
	        txt_name.addFocusListener(this);
	        txt_price.addFocusListener(this);
	        
	        
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
	    public void focusGained(FocusEvent e) {
	        // Clear the text of the text field when it gains focus
	        if (e.getSource() instanceof JTextField) {
	            JTextField textField = (JTextField) e.getSource();
	            textField.setText("");
	            textField.setForeground(Color.black);
	        }
	    }

	    // Implement focusLost method from FocusListener interface
	    @Override
	    public void focusLost(FocusEvent e) {
	        // This method is not needed for this use case
	    }




	@Override
	public void actionPerformed(ActionEvent e)
	{
	
		// TODO Auto-generated method stub
			
			
		if (e.getSource() == Qadd) {
			
			
	       WName = txt_name.getText();
	      WDes = txt_des.getText();
	        String priceText = txt_price.getText().trim(); // Trim white spaces
//matching non digits characters
	        try {
	            int Qmonth = Integer.parseInt(txt_date.getText());
				 int Qday = Integer.parseInt(txt_date1.getText());
				 int Qyear = Integer.parseInt(txt_date2.getText());
	            WDate = Qmonth + "/" + Qday + "/" + Qyear;
	         
	        if (!priceText.isEmpty() && priceText.matches("^\\d+$")) {
	            int WPrice = Integer.parseInt(priceText);
	            String sel_item = (String) jcombo.getSelectedItem();
	          
	            	
	            	if (!WDate.isEmpty()&& !WName.isBlank() && !WDes.isBlank() && WPrice > 0) {
	                String formattedPrice = "$" + WPrice;
	                	if (sel_item.equalsIgnoreCase(list[0])) {
	                    Mframe.model.addRow(new Object[]{1, WDate, WName, WDes, list[0], formattedPrice});
	                	} else if (sel_item.equalsIgnoreCase(list[1])) {
	                    Mframe.model.addRow(new Object[]{0, WDate, WName, WDes, list[1], formattedPrice});
	                	}
	            	}else {
	                    JOptionPane.showMessageDialog(this, "Please fill all the fields and ensure the price is greater than 0.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
	                }
	            
	        
	        }else {
                JOptionPane.showMessageDialog(this, "Please fill all the fields and ensure the price is greater than 0.", "Invalid Entry", JOptionPane.ERROR_MESSAGE);
            }
	        }catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(this, "Please enter a valid date.", "Invalid Date", JOptionPane.ERROR_MESSAGE);
	        }
	        txt_date.setText("");
			txt_date1.setText("");
			txt_date2.setText("");
			txt_name.setText("");
			txt_des.setText("");
			txt_price.setText("");
			
			updateBalance();
	        	
	        }
	        
		
	        
		
		
		
		
			
		
			
			
		
			
		
		
	
		if(e.getSource()== back) {
			count = Mframe.openFrameCount--;
			this.dispose();
			
			
			
			
		}
			
			
			
			
			
			
		}
	
	
	
	public static void updateBalance() {
		  int expensesTotal = 0;
		    int savingsTotal = 0;
		    int b = 0;
		    System.out.println("Number of rows in the table: " + Mframe.table.getRowCount());
		    System.out.println("Number of columns in the table: " + Mframe.table.getColumnCount());

		    for (int i = 0; i < Mframe.model.getRowCount(); i++) {
		        if (i >= Mframe.table.getRowCount()) {
		            continue;
		        }
		        String sortValueString = Mframe.table.getValueAt(i, 0).toString();
		        String priceString = Mframe.table.getValueAt(i, 5).toString(); // Assuming the price is in column 5
		        
		        try {
		            int sortValue = Integer.parseInt(sortValueString);
		            int price = Integer.parseInt(priceString.replace("$", ""));
		            System.out.println("Row " + i + ", Sort Value: " + sortValue);
		            
		            if (sortValue == 1) { 
		                expensesTotal += price;
		            } else if (sortValue == 0) { 
		                savingsTotal += price;
		            }
		        } catch (NumberFormatException e) {
		            e.printStackTrace();
		            continue; 
		        }
		    }

		    String budgetText = Mframe.Qtxt_budget.getText().trim(); // Trim white spaces
		    if (!budgetText.isEmpty()) {
		        try {
		            b = Integer.parseInt(budgetText);
		        } catch (NumberFormatException e) {
		 
		            e.printStackTrace();
		        }
		    }

		    int balance = b - expensesTotal; // Calculate balance
		    Mframe.Qtxt_balance.setText(Integer.toString(balance));
		    Mframe.Qtxt_expens.setText(Integer.toString(expensesTotal));
		    Mframe.Qtxt_saving.setText(Integer.toString(savingsTotal));
		}
}

public class AddList {
	static int xx = 0;
	static int yy = 0;
	
	
	addFrame Qframe;




public void setVisible(boolean b) {
	// TODO Auto-generated method stub
	int szX = 440;
	int szY = 480;
	
	Qframe = new addFrame();
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
	Qframe.addMouseMotionListener(new MouseMotionListener()
		{

		@Override
		public void mouseDragged(MouseEvent e) 
		{
			// TODO Auto-generated method stub
			int x,y;
			x = e.getXOnScreen();
			y = e.getYOnScreen();
			Qframe.setLocation(x-xx,y-yy);
		
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{
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
	
	//end
	Qframe.setVisible(b);
}





}
