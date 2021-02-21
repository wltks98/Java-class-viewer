import java.awt.*;

import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;


public class GUI extends JFrame implements ActionListener{

	JPanel p=new JPanel();
	JPanel p2=new JPanel();
	JPanel pan=new JPanel();
	
	private JTree  tree;
   
    private JTable table,table2;
   private TableModel model;
   private TableModel2 fmodel;
    
    private JMenuBar menuBar;  
   private JMenuItem open,exit;
   
   private String filename;
    
   protected JTextArea textArea, RtextArea;
   
	
	public GUI() {

        
     	setTitle("Class Viewer");
     	setSize(400,400);
     	
     	
     	menuBar=new JMenuBar();
     	JMenu menu=new JMenu("File");
     	open=new JMenuItem("Open");
     	menu.add(open);
     	open.addActionListener(this);
     	exit=new JMenuItem("Exit");
     	menu.add(exit);
     	exit.addActionListener(this);
     	menuBar.add(menu);
     	setJMenuBar(menuBar);
     	
  
     	
	       
     	setVisible(true);
	        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	        
	
	}
	
	
	public void setTree()
	{
		
			String[] tokens2 = filename.split("\\\\");
			String filename2=tokens2[tokens2.length-1];
				
				
		
		
			Com com = new Com(filename2); //수정필요



			Dept dev = com.getDept(parsing.c[0]); //수정필요

			for(int i=0; i<parsing.method_number; i++) {
				
				
				dev.add(new SEmployee(parsing.mlist[i].name,parsing.mlist[i].type,parsing.mlist[i].access,parsing.mlist[i].inja));
				
			}
			
			for(int i=0; i<parsing.field_number; i++) {
				
				
				dev.add(new SEmployee2(parsing.flist[i].name,parsing.flist[i].type,parsing.flist[i].access,parsing.flist[i].inja));
				
			}
			
			
			CompanyTreeModel model2 = new CompanyTreeModel(com);


			tree = new JTree(model2);

			tree.addTreeSelectionListener(new TreeSelectionListener() {

				public void valueChanged(TreeSelectionEvent e) {

					Object o = e.getPath().getLastPathComponent();
					model = new TableModel();
					
					
					
					
					
					//JScrollPane panet =new JScrollPane(table);  혹시몰라서 나둔거 그냥 지우셈
					//JScrollPane panea =new JScrollPane(RtextArea);

					if(o instanceof Dept) {

						 table = new JTable(model);
						
						
						p2.removeAll();
		        		p2.add(new JScrollPane(table));
		        		revalidate();
		        		pack();
		        		

					} else if(o instanceof SEmployee) {

						RtextArea=new JTextArea(11,20);
						
						textArea.setText(null); //textArea 초기화
						
						//textArea.append(((SEmployee)o).display());
						
						
						p2.removeAll();						
						p2.add(new JScrollPane(RtextArea));
						revalidate();	
						pack();
						
						
						
						//System.out.println(o.getClass().getName()); //지우셈
						
						
						methodsave save = new methodsave(((SEmployee)o).name);
						save.methodin();
						save.methoduse();
						
						textArea.append("Use"+"\n");
						for(String s:save.use)
						textArea.append(s+"\n");
						
						
						RtextArea.append(save.mbuffer+"");
											
						
						
					}
					
					else if(o instanceof SEmployee2) {

						fmodel= new TableModel2(((SEmployee2)o).name); //SEmployee2로써 o의 name을 가져오는것 즉
												
						
						textArea.setText(null);
						
						 table2 = new JTable(fmodel);
						
						
						p2.removeAll();
		        		p2.add(new JScrollPane(table2));
		        		revalidate();
		        		pack();
						
						
						
						
					}
					

					
					
					

				}

			});

	
	}
	

	public void actionPerformed(ActionEvent e) {
		
		Object source = e.getSource();
		
		if(e.getSource()==open) {
		JFileChooser chooser = new JFileChooser();
     	int r=chooser.showOpenDialog(this);
     	if(r==JFileChooser.APPROVE_OPTION) {
     		
     		filename = chooser.getSelectedFile().getAbsolutePath();
     		
     		ReadFileData RFD= new ReadFileData();     		
     		RFD.fileread(filename);
     		
     		
     		
     		textArea =new JTextArea(11,20);
         	
            pan.setLayout( new BorderLayout( ));
            p.setLayout(new BorderLayout( ));
            p2.setLayout(new BorderLayout( ));
            
            
            
            setTree( );
            pan.add(new JScrollPane(tree),BorderLayout.NORTH);
           pan.add(new JScrollPane(textArea),BorderLayout.SOUTH);
            
            getContentPane().add(pan,"West");
            
            
    		
    		getContentPane().add(p2,"East");
    		
    		
    	        add(p);     		
     		revalidate();
     		
     	}
     		
     		
     	}
		else if(e.getSource()==exit)
			System.exit(0);
		
		
	}
	
}













	
