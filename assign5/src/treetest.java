import java.util.*;


import javax.swing.*;

import javax.swing.event.*;

import javax.swing.tree.*;

 

	class SEmployee {

		protected String name, type, access;
		protected String inja;
		

	public SEmployee(String name, String type, String access, String inja) {

			this.name = name;

			this.type=type;

			this.access=access;

			this.inja=inja;

	}
	
	public String toString() {

			return name+inja;

	}

	
}
	
	
	
	class SEmployee2 {

		protected String name, type, access;
		protected String inja;
		

	public SEmployee2(String name, String type, String access, String inja) {

			this.name = name;

			this.type=type;

			this.access=access;

			this.inja=inja;

	}
	
	public String toString() {

			return name+inja;

	}
	
	

	

}
	
	
	
	
	
	
	class Dept {

		protected String name;

		protected ArrayList<SEmployee> member;
		
		protected ArrayList<SEmployee2> field;

 

			public Dept(String name) {

					this.name = name;

					member = new ArrayList<SEmployee>();
					field = new ArrayList<SEmployee2>();

			}

 

			public void add(SEmployee e) {

				member.add(e);

			}
			
			
			public void add(SEmployee2 e) {

				field.add(e);

			}
			
 

			public SEmployee get(int index) {
				
				
				
				return member.get(index);

			}
			
			public SEmployee2 get2(int index) {

				return field.get(index);

			}
			
			

 

			public int size() {

				return member.size()+field.size();

			}
			
			
			
			

			public int getIndexOf(SEmployee e) {

				for(int i=0; i < member.size(); i++) {

					SEmployee se = member.get(i);

					if(se == e) {

						return i;

					}

				}

				return -1;

			}
			
			public int getIndexOf(SEmployee2 e) {

				for(int i=0; i < field.size(); i++) {

					SEmployee2 se = field.get(i);

					if(se == e) {

						return i;

					}

				}

				return -1;

			}

 

			public String toString() {

				return name;

			}

 

		

}

	
	
	
	
	
	
	
	
	
	
		class Com {

				protected String name;

				protected Dept dev;

				public Com(String name) {

					this.name = name;

					dev = new Dept(parsing.c[0]); //추후수정

					

				}

				
				
				public Dept getDept(String name) {

					

						return dev;

					

				}

				
				public Dept getDept(int index) {

				

						return dev;

				}

 

				public int getIndexOf(Dept d) {

					if(d == dev)

						return 0;

					else

						return 1;

				}

				public String toString() {

					return name;

				}

}

 
		
		
		
		

		class CompanyTreeModel implements TreeModel {

			protected Com com;


			public CompanyTreeModel(Com c) {

				com = c;

			}

 

			public Object getChild(Object parent, int index) {

				if(parent instanceof Com) {

					Com c = (Com) parent;

					return c.getDept(index);

				} else if(parent instanceof Dept) {

					Dept d = (Dept) parent;

					if(index<parsing.method_number)
					return d.get(index);
					
					else
					return d.get2(index-parsing.method_number);

				}

				return null;

			}


			public int getChildCount(Object parent) {

				if(parent instanceof Com) {

					return 1;  //클래스의 갯수 나중에 수정할것

				} else if(parent instanceof Dept) {

					Dept d = (Dept)parent;

					return d.size(); //메소드+자료 갯수

				}

				return 0;

			}

			public int getIndexOfChild(Object parent, Object child) {

				if(parent instanceof Com) {

					Com c = (Com) parent;

					return c.getIndexOf((Dept)child);

				} else if(parent instanceof Dept) {

					Dept d = (Dept) parent;

					if(child instanceof SEmployee)
					return d.getIndexOf((SEmployee) child);
					
					else if(child instanceof SEmployee2)
						return d.getIndexOf((SEmployee2) child);

				}

				return -1;

			}


			public Object getRoot() {

				return com;

			}


			public boolean isLeaf(Object node) {

				if(node instanceof Com) {

					return false;

				} else if(node instanceof Dept) {

					return false;

				}

				return true;

			}


			public void addTreeModelListener(TreeModelListener l) { }

			public void removeTreeModelListener(TreeModelListener l) { }

			public void valueForPathChanged(TreePath path, Object newValue) { }

 

		}

		
		
/*
 * 		
 */
		
		
		
		
		
 
