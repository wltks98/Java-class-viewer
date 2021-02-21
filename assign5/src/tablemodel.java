import javax.swing.table.AbstractTableModel;

class TableModel extends AbstractTableModel{
		
	String[] columnName = {"Name", "Type", "Access"};
	
	Object[][] data= new Object[parsing.list_size][3];
		
	public TableModel() {
		
		
		for(int i=0; i<parsing.method_number; i++) {
			
			
			data[i][0]=parsing.mlist[i].name+"()";
			data[i][1]=parsing.mlist[i].type;
			data[i][2]=parsing.mlist[i].access;		
		
		}
		
		
		for(int i=0; i<parsing.field_number; i++) {
			
			
			data[i+parsing.method_number][0]= parsing.flist[i].name;
			data[i+parsing.method_number][1]=parsing.flist[i].type;
			data[i+parsing.method_number][2]=parsing.flist[i].access;		
		
		}
		
		
		
	
	}
	
	
	
		public int getColumnCount() {
			
			return columnName.length;
		}
		
		public int getRowCount() {
			
			return data.length;
		}
		
		public String getColumnName(int col) {
			
			return columnName[col];
		}
		public Object getValueAt(int row, int col) {
			
			return data[row][col];
		}
		
		public Class getColumnclass(int c) {
			
			return getValueAt(0,c).getClass();
		}
		
	}