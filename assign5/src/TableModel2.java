import javax.swing.table.AbstractTableModel;

class TableModel2 extends AbstractTableModel{
		
	String[] columnName2 = {"Name", "Methods"};
	
	Object[][] fdata= new Object[1][2];
	
	StringBuffer buffer=new StringBuffer();
		
	public TableModel2(String s) {
		
		
		memberfield mf = new memberfield(s);
		
		for(String x:mf.usedmethod)
			buffer.append(x+", ");
		int x=buffer.length();
		
		buffer.delete(x-2,x); //마지막에 쉼표없애기 위해
		
		String eee=buffer+"";
		
		
		fdata[0][0]=s;
		fdata[0][1]=eee;
		
		
		
		
	
	}
	
	
	
		public int getColumnCount() {
			
			return columnName2.length;
		}
		
		public int getRowCount() {
			
			return fdata.length;
		}
		
		public String getColumnName(int col) {
			
			return columnName2[col];
		}
		public Object getValueAt(int row, int col) {
			
			return fdata[row][col];
		}
		
		public Class getColumnclass(int c) {
			
			return getValueAt(0,c).getClass();
		}
		
	}