package pocketMon;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.*;
import javax.swing.table.TableRowSorter;

import java.util.ArrayList;
import java.util.List;






class LimitedDocument extends PlainDocument {
    private int limit;

    LimitedDocument(int limit) {
        super();
        this.limit = limit;
    }

    @Override
    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;

        if ((getLength() + str.length()) <= limit) {
            super.insertString(offset, str, attr);
        }
    }
}


class RoundedPanel extends JPanel
{
    private Color backgroundColor;
    private int cornerRadius = 15;
    public RoundedPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
    }
    public RoundedPanel(LayoutManager layout, int radius, Color bgColor) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
    }
    public RoundedPanel(int radius) {
        super();
        cornerRadius = radius;
        
    }
    public RoundedPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //Draws the rounded panel with borders.
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); 
        graphics.setColor(getForeground());
//        graphics.drawRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height); //paint border
//         
    }
}






class Mframe extends JFrame implements ActionListener {
	
	
	 private static final int MAX_FRAMES = 1; // Maximum number of frames allowed
	    public static int openFrameCount = 0;
	    public static DefaultTableModel model;
	    
	 
	//container
	Container c = getContentPane();
	//panels
	JPanel upPanel = new RoundedPanel(50,Color.white);
	JPanel lowPanel = new RoundedPanel(50,Color.white);
	JPanel tablePanel = new JPanel();
	//buttons
	JButton addButton = new JButton("+");
	JButton delButton = new JButton("-");
	
	JLabel blc = new JLabel("Balance:");
	JLabel budget = new JLabel("Budget:");
	JLabel expens = new JLabel("Expenses:");
	JLabel saving = new JLabel("Savings:");
	//JLabel detail = new JLabel("Details");
	JLabel background = new JLabel(new ImageIcon("/pocketMoneyManager/src/pocketMon/images/backdrop(main).png"));
	
	JLabel addbt = new JLabel();
	JLabel delbt = new JLabel();
	
	ImageIcon addIcon = new ImageIcon("/pocketMoneyManager/src/pocketMon/images/add.png");
	ImageIcon delIcon = new ImageIcon("/pocketMoneyManager/src/pocketMon/images/del.png");

	// Resize the icons
	Image addImage = addIcon.getImage().getScaledInstance(32,32, Image.SCALE_SMOOTH);
	Image delImage = delIcon.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);

	// Create new ImageIcon objects with the resized images
	ImageIcon resizedAddIcon = new ImageIcon(addImage);
	ImageIcon resizedDelIcon = new ImageIcon(delImage);

	// Set the resized icons to the JLabels
	

	JLabel QDate = new JLabel("Date:");
	JLabel QName = new JLabel("Name:");
	JLabel QDes = new JLabel("Description:");
	JLabel QPrice = new JLabel("Price:");
	
	//text field
	public static JTextField Qtxt_balance = new JTextField("0");
	public static JTextField Qtxt_budget = new JTextField("0");
	public static JTextField Qtxt_expens = new JTextField("0");
	public static JTextField Qtxt_saving = new JTextField("0");
	JTextField Qtxt_date = new JTextField();
	JTextField Qtxt_name = new JTextField();
	JTextArea Qtxt_des = new JTextArea();
	JTextField Qtxt_price = new JTextField();
	//fonts
	Font f1 = new Font("Calibri", Font.PLAIN,17);
	Font f2 = new Font("Tahoma", Font.BOLD,20);
	
	
	//table
	 static JTable table;
	 
	 
	 //new frame
	 AddList QFrame;
	 
		 //menu bar
	    JMenuBar menuBar = new JMenuBar();

	    //menus
	    JMenu fileMenu = new JMenu("File");
	    JMenu helpMenu = new JMenu("Help");

	    //menu items
	    JMenuItem newItem = new JMenuItem("New");
	    JMenuItem openItem = new JMenuItem("Open");
	    JMenuItem saveItem = new JMenuItem("Save");
	    JMenuItem exitItem = new JMenuItem("Exit");
		
	    String[] list = {"All","Spend Money", "Save Money"};
	    
	    int[] intlist= {0,1};
	    JComboBox<String> jcombo = new JComboBox<>(list);
		
		
		TableRowSorter<DefaultTableModel> sorter ;
		 public static int row;

		 int selectedRow;
	       
		
	Mframe(){
		table();
		 addSorting();
		design();
		panelLayout();
		LocSize();
		CompToCon();
		actEvent();
		budget();

		 this.setJMenuBar(menuBar);
		
		
		 addFrame.updateBalance();
		 
		 
	}
	
	
	



	private void budget() {
		// TODO Auto-generated method stub
		
		
		Qtxt_budget.addKeyListener(new KeyAdapter() {
			@Override
            public void keyReleased(KeyEvent e) {
              
	
				String bd = Qtxt_budget.getText();
				
				if(!bd.isEmpty() && bd.matches("\\d+")) {
				addFrame.updateBalance();
	
            }
			}
		});
		
		
	}








	public void addSorting() {
	       
	        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
	        sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING)); 
	        sorter.setSortKeys(sortKeys);
	        sorter.sort(); 
	    }


	public void design() {
		// TODO Auto-generated method stub
		c.setBackground(Color.DARK_GRAY);
		upPanel.setOpaque(false);
		lowPanel.setOpaque(false);
		blc.setFont(f1);
		budget.setFont(f1);
		expens.setFont(f1);
		saving.setFont(f1);
		QDate.setFont(f1);
		QName.setFont(f1);
		QDes.setFont(f1);
		QPrice.setFont(f1);
		//detail.setFont(f2);
		//detail.setForeground(Color.WHITE);
		
		 QDate.setForeground(Color.BLACK);
		 QName.setForeground(Color.BLACK);
		 QDes.setForeground(Color.BLACK);
		 QPrice.setForeground(Color.BLACK);
		 blc.setForeground(Color.BLACK);
		 budget.setForeground(Color.BLACK);
		 expens.setForeground(Color.BLACK);
		 saving.setForeground(Color.BLACK);
		
		Qtxt_des.setDocument(new LimitedDocument(300));
		Qtxt_des.setLineWrap(true);
		Qtxt_des.setWrapStyleWord(true);
		
		Qtxt_des.setOpaque(false); // Make the JTextArea transparent
		Qtxt_des.setBackground(new Color(0, 0, 0, 0)); // Set transparent background
		Qtxt_des.setBorder(BorderFactory.createCompoundBorder(
		    BorderFactory.createLineBorder(Color.GRAY), // Add a gray border
		    BorderFactory.createEmptyBorder(8, 8, 8, 8) // Add padding
		));
		
			fileMenu.add(newItem);
	        fileMenu.add(openItem);
	        fileMenu.add(saveItem);
	        fileMenu.addSeparator(); // Separator between items
	        fileMenu.add(exitItem);
	        menuBar.add(fileMenu);
	        menuBar.setBackground(new Color(223,0,36));
	        fileMenu.setForeground(Color.white);
	       
	        
	      Qtxt_date.setEditable(false);
	      Qtxt_name.setEditable(false);
	      Qtxt_des.setEditable(false);
	      Qtxt_price.setEditable(false);
	      Qtxt_expens.setEditable(false);
	      Qtxt_saving.setEditable(false);
	      Qtxt_balance.setEditable(false);
	      
	      Qtxt_date.setFocusable(false);
	      Qtxt_name.setFocusable(false);
	      Qtxt_des.setFocusable(false);
	      Qtxt_price.setFocusable(false);
	      Qtxt_expens.setFocusable(false);
	      Qtxt_saving.setFocusable(false);
	      Qtxt_balance.setFocusable(false);
	      table.setFocusable(false);
	      
	      
	 	 table.getTableHeader().setResizingAllowed(true);
			table.getTableHeader().setReorderingAllowed(false);
			addbt.setIcon(resizedAddIcon);
			delbt.setIcon(resizedDelIcon);
			
			
			  background.setSize(1280,720);
	}
	
	
	
	
	public void table() {
		// TODO Auto-generated method stub
		
		
		String[] columnNames = {"Sort","Date","Name", "Description","Status", "Price"};
		 model = new DefaultTableModel(new Object[][] {}, columnNames);
		 table = new JTable(model);
	
		
			
		TableColumnModel columnModel = table.getColumnModel();
		
		//for sorting
		columnModel.getColumn(0).setPreferredWidth(10);
		
		
		
		
		  columnModel.getColumn(0).setMinWidth(0);
		  columnModel.getColumn(0).setMaxWidth(0);
		  columnModel.getColumn(0).setWidth(0);
		 
		 
		 
		
		
		columnModel.getColumn(1).setPreferredWidth(10);
		columnModel.getColumn(2).setPreferredWidth(10);
		columnModel.getColumn(3).setPreferredWidth(150);
		columnModel.getColumn(4).setPreferredWidth(10);
		columnModel.getColumn(5).setPreferredWidth(10);
		
		
		
		sorter = new TableRowSorter<>(model);
		  table.setRowSorter(sorter);
		  table.setBackground(Color.white);

		
		
	        
	        
		 ListSelectionModel selectionModel = table.getSelectionModel();
		 selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			
		  selectionModel.addListSelectionListener(new ListSelectionListener() {
	            @Override
	            public void valueChanged(ListSelectionEvent e) {
	                if (!e.getValueIsAdjusting()) {
	                	selectedRow = table.getSelectedRow();
	                    if (selectedRow != -1) { // If a row is selected
	                        Object sort = table.getValueAt(selectedRow, 0);
	                        Object Date = table.getValueAt(selectedRow, 1);
	                        Object Name = table.getValueAt(selectedRow, 2);
	                        Object Desc = table.getValueAt(selectedRow, 3);
	                        Object stats = table.getValueAt(selectedRow, 4);
	                        Object Price = table.getValueAt(selectedRow, 5);
	                       
	                   
	                        
	                        Qtxt_date.setText((String) Date);
	                        Qtxt_name.setText((String) Name);
	                        Qtxt_des.setText((String) Desc);
	                        Qtxt_price.setText((String) Price);
	                        
	                        
	                        //row select
	                        table.addMouseListener(new MouseAdapter() {
	                        	   @Override
	                        	  public void mouseClicked(MouseEvent e) {
	                        		  
	                        		   if (e.getClickCount() == 2) { // Double click
	                                    row = table.getSelectedRow();
	                                       if (row != -1) { 
	                                    	   if (openFrameCount < MAX_FRAMES) {
	                                    	   Object sort = table.getValueAt(row, 0);
	               	                        Object Date = table.getValueAt(row, 1);
	               	                        Object Name = table.getValueAt(row, 2);
	               	                        Object Desc = table.getValueAt(row, 3);
	               	                        Object stats = table.getValueAt(row, 4);
	               	                        Object Price = table.getValueAt(row, 5);
	               	                     String priceString = ((String) Price).replace("$", ""); 
	                                    	   EditList el = new EditList();
	                                    	   el.setVisible(true);
	                                    	   
	                                    	   String QDate = Date.toString();
	                                    	   
	                                    	   String[] parts = QDate.split("/");
	                                    	   
	                                    	   editFrame.txt_date.setText((String) parts[0]);
	                                    	   editFrame.txt_date1.setText((String) parts[1]);
	                                    	   editFrame.txt_date2.setText((String) parts[2]);
	                                    	   editFrame.txt_name.setText((String) Name);
	                                    	   editFrame.txt_des.setText((String) Desc);
	                                    	   editFrame.txt_price.setText(priceString);
	                                    	   
	                                    	   openFrameCount++;
	                                    	   }
	                                    	  }
	                                      
	                                   }
	                        		  
	                        	  }
	                      });
	                        
	                        
	                        
	                    }
	                }
	            }
	        });
		  
		 
	    
		 
		
		 
		  
			/*
			 * for (int i = 0; i < model.getRowCount(); i++) {
			 * 
			 * 
			 * Object priceValue = model.getValueAt(i, 5); String priceString =
			 * String.valueOf(priceValue); //String QpriceValue = ((String)
			 * priceValue).replace("$", ""); int int_priceValue =
			 * Integer.parseInt(priceString);
			 * 
			 * 
			 * 
			 * 
			 * Qtxt_balance.setText(priceString); }
			 */
		  
	
		  for (int columnIndex = 0; columnIndex < table.getColumnCount(); columnIndex++) {
		        TableColumn column = table.getColumnModel().getColumn(columnIndex);
		        column.setCellEditor(new TableCellEditor() {
		            @Override
		            public java.awt.Component getTableCellEditorComponent(javax.swing.JTable table, java.lang.Object value, boolean isSelected, int row, int column) {
		                return null;
		            }

		            @Override
		            public java.lang.Object getCellEditorValue() {
		                return null;
		            }

		            @Override
		            public boolean isCellEditable(java.util.EventObject anEvent) {
		                return false;
		            }

		            @Override
		            public boolean shouldSelectCell(java.util.EventObject anEvent) {
		                return false;
		            }

		            @Override
		            public boolean stopCellEditing() {
		                return false;
		            }

		            @Override
		            public void cancelCellEditing() {
		                // Do nothing
		            }

		            @Override
		            public void addCellEditorListener(javax.swing.event.CellEditorListener l) {
		                // Do nothing
		            }

		            @Override
		            public void removeCellEditorListener(javax.swing.event.CellEditorListener l) {
		                // Do nothing
		            }
		        });
		        
		    }
		  
		
		  
	}





	public void actEvent() {
		// TODO Auto-generated method stub
	
		addButton.addActionListener(this);
		jcombo.addActionListener(this);
		Qtxt_budget.addActionListener(this);
		delButton.addActionListener(this);
		saveItem.addActionListener(this);
		openItem.addActionListener(this);
		newItem.addActionListener(this);
		
		
		 addbt.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (openFrameCount < MAX_FRAMES) {
					  
					  QFrame = new AddList();
			            QFrame.setVisible(true);
			            openFrameCount++;
			           
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
		 
		 delbt.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub
					selectedRow = table.getSelectedRow();
			        if (selectedRow != -1) { // If a row is selected
			            int choice = JOptionPane.showConfirmDialog(
			                null,
			                "Are you sure you want to delete the selected row?",
			                "Delete Confirmation",
			                JOptionPane.YES_NO_OPTION,
			                JOptionPane.QUESTION_MESSAGE);

			            if (choice == JOptionPane.YES_OPTION) {
			                // Remove selected row from table
			                model.removeRow(selectedRow);
			                addFrame.updateBalance();
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
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
	
		c.add(delbt);
		c.add(addbt);
		//labels
		c.add(blc);
		c.add(budget);
		c.add(expens);
		c.add(saving);
	
		c.add(QDate);
		c.add(QName);
		c.add(QDes);
		c.add(QPrice);
		
		//txt_field
		c.add(Qtxt_balance);
		c.add(Qtxt_date);
		c.add(Qtxt_name);
		c.add(Qtxt_des);
		c.add(Qtxt_price);
		c.add(Qtxt_budget);
		c.add(Qtxt_expens);
		c.add(Qtxt_saving);
		
		//panel
		c.add(upPanel);
		c.add(lowPanel);
		c.add(tablePanel);
		
		//button
		
		
		
		
		
		//c.add(detail);
		
		c.add(jcombo);
		
		
		c.add(background); 
		
		
		
		
		
	}



	public void LocSize() {
		// TODO Auto-generated method stub
	
		//labels
		blc.setBounds(80,155,100,50);
		budget.setBounds(80,35,100,50);
		expens.setBounds(65,75,100,50);
		saving.setBounds(80,115,100,50);
		QDate.setBounds(92,225,100,50);
		QName.setBounds(85,250,100,50);
		QPrice.setBounds(92,275,100,50);
		QDes.setBounds(50,300,100,50);
		Qtxt_balance.setBounds(150,168,100,25);
		Qtxt_budget.setBounds(150,48,100,25);
		Qtxt_expens.setBounds(150,88,100,25);
		Qtxt_saving.setBounds(150,128,100,25);
		Qtxt_date.setBounds(150,240,100,20);
		Qtxt_name.setBounds(150,265,100,20);
		Qtxt_price.setBounds(150,290,100,20);
		Qtxt_des.setBounds(50,340,250,250);
		
		//detail.setBounds(20,175,100,50);
		
		upPanel.setBounds(25,25,300,190);
		lowPanel.setBounds(25,225,300,400);
		tablePanel.setBounds(425,100,800,525);
		addButton.setBounds(1080, 65, 50, 30);
		delButton.setBounds(1150, 65, 50, 30);
		addbt.setBounds(1125, 60, 32, 32);
		delbt.setBounds(1180, 60, 32, 32);
		
		jcombo.setBounds(425,70, 150,20);
		
		
	}





	public void panelLayout() {
		// TODO Auto-generated method stub
		
		c.setLayout(null);
		tablePanel.setLayout(new BorderLayout());
		tablePanel.add(new JScrollPane(table), BorderLayout.CENTER);
		
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == addButton) 	
		{
			
			if (openFrameCount < MAX_FRAMES) {
				  
				  QFrame = new AddList();
		            QFrame.setVisible(true);
		            openFrameCount++;
		           
            }
		}
		
		  if (e.getSource() == jcombo) {
		        String selectedItem = (String) jcombo.getSelectedItem();
		        RowFilter<DefaultTableModel, Object> rowFilter;
		        
		        if (selectedItem.equalsIgnoreCase(list[1])) {
		            rowFilter = RowFilter.regexFilter("^1$", 0); 
		           
		        } else  if (selectedItem.equalsIgnoreCase(list[2])){
		            rowFilter = RowFilter.regexFilter("^0$", 0);
		          
		        }else {
		        	 rowFilter = null;
		        	 
		        }
		        sorter.setRowFilter(rowFilter);
		        
		    }

		  if (e.getSource() == delButton) {
		        selectedRow = table.getSelectedRow();
		        if (selectedRow != -1) { // If a row is selected
		            int choice = JOptionPane.showConfirmDialog(
		                this,
		                "Are you sure you want to delete the selected row?",
		                "Delete Confirmation",
		                JOptionPane.YES_NO_OPTION,
		                JOptionPane.QUESTION_MESSAGE);

		            if (choice == JOptionPane.YES_OPTION) {
		                // Remove selected row from table
		                model.removeRow(selectedRow);
		                addFrame.updateBalance();
		            }
		        } else {
		            JOptionPane.showMessageDialog(null, "Please select a row to delete.");
		        }
		    }
				
				//MENU ITEM
				
				if(e.getSource() == saveItem) {
					 saveDataToFile(model);
					
				}
				if(e.getSource() == openItem) {
					
					   loadDataFromFile(model);
					   addFrame.updateBalance();
				}
				if(e.getSource() == newItem) {
					
				Qtxt_budget.setText("0");
			            Main_Frame.frame(); // Call the method in Main_Frame to create a new frame
			            addFrame.updateBalance();
				}
	    }
	
	private static void saveDataToFile(DefaultTableModel model) {
	    JFileChooser fileChooser = new JFileChooser();
	    fileChooser.setDialogTitle("Specify a file to save");
	    int userSelection = fileChooser.showSaveDialog(null);

	    if (userSelection == JFileChooser.APPROVE_OPTION) {
	        File fileToSave = fileChooser.getSelectedFile();
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
	            // Write data rows
	            for (int row = 0; row < model.getRowCount(); row++) {
	                for (int col = 0; col < model.getColumnCount(); col++) {
	                    writer.write(model.getValueAt(row, col).toString());
	                    if (col < model.getColumnCount() - 1) {
	                        writer.write(",");
	                    }
	                }
	                writer.newLine();
	            }
	            JOptionPane.showMessageDialog(null, "Data saved successfully!");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Error saving data to file!");
	        }
	    }
	    }

	 private static void loadDataFromFile(DefaultTableModel model) {
	        JFileChooser fileChooser = new JFileChooser();
	        fileChooser.setDialogTitle("Choose a file to open");
	        int userSelection = fileChooser.showOpenDialog(null);

	        if (userSelection == JFileChooser.APPROVE_OPTION) {
	            try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
	                model.setRowCount(0); // Clear existing table data
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    String[] rowData = line.split(",");
	                    model.addRow(rowData);
	                }
	                JOptionPane.showMessageDialog(null, "Data loaded successfully!");
	            } catch (IOException ex) {
	                ex.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error loading data from file!");
	            }
	        }
	    }

}




public class Main_Frame {
	
	  private static Mframe frame;
	
	  
	public static void frame() {
		 if (frame != null) {
			 frame.dispose(); 
	        }
	frame = new Mframe();
	ImageIcon icon = new ImageIcon("/pocketMoneyManager/src/pocketMon/images/dollawise.png");
	Image image = icon.getImage();
	frame.setIconImage(image);
		frame.setTitle("DollaWise"); //DollaWise: Pocket Money Management
		frame.setLocation(320,200);
		frame.setSize(1280, 720);
		frame.setResizable(false);
		
		
		
		  frame.addWindowListener(new WindowAdapter() {
	            @Override
	            public void windowClosing(WindowEvent e) {
	                // Display a confirmation dialog before exiting
	                int choice = JOptionPane.showConfirmDialog(
	                        frame,
	                        "Are you sure you want to exit?",
	                        "Exit Confirmation",
	                        JOptionPane.YES_NO_OPTION,
	                        JOptionPane.QUESTION_MESSAGE);

	                if (choice == JOptionPane.YES_OPTION) {
	                    // Exit the application if the user confirms
	                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	                } else {
	                    // Do nothing if the user cancels
	                    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	                }
	            }
	        });
		
		//end
		frame.setVisible(true);
		
	
	}
	
	
	public static void main(String args[]) {
		
		
		frame();
		
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		if(b == true) {
		frame();
		}
	}
	
	
}

