 class parsing{
	
	static String c[]=new String[1000];
	static String m[]=new String[1000];
	static String ja[]=new String[1000];
	static classsave [] list =new classsave[1000];
	static classsave [] mlist =new classsave[1000];
	static classsave [] flist =new classsave[1000];
	static int list_size;
	static int class_number; //Ŭ���� ����
	static int method_number; //�޼ҵ� ����
	static int field_number; //�ڷ� ����
	
	public void pclass(){ //Ŭ������ ����
		
		int j=0;
		
		for(int i=0; i<token.token_number;i++) {
		
			
			if(token.p[i].equals("class")) {
				
				
				c[j]=token.p[i+1];
				
				j++;
				class_number=j;
			}
			
		}
		
	}
	
	
	public void pmethod() { //�޼ҵ�� �ڷḦ ����
		
		int j=0;
		int k=0;
		int mn=0;	//�޼ҵ��� ����
		int fn=0;	//�ڷ��� ����
			
			
			for(int i=0; i<token.token_number;i++) {
			
				
				
				if(token.p[i].equals("public")||token.p[i].equals("private")||token.p[i].equals("protected")) {
					
					if(token.p[i+1].indexOf(parsing.c[0])!=-1) {
						
						m[j]=token.p[i+1]; //������
						String m1[]=m[j].split("\\("); //Mystack�ڿ� ���� (�� ������ ���� �۾�
						m[j]=m1[0];
						if(m1[1].equals(")"))
							m1[1]="";
						mlist[mn]=new classsave(m[j],"no",token.p[i],"("+m1[1]+")");
						mn++;
						j++;
						method_number=mn;
						list_size=mn+fn;
					}
					
					else if(token.p[i+2].indexOf("(")!=-1){
					
						
						m[j]=token.p[i+2];
						String m1[]=m[j].split("\\("); //Mystack�ڿ� ���� (�� ������ ���� �۾�
						m[j]=m1[0];
						if(m1[1].equals(")"))
							m1[1]="";
						mlist[mn]=new classsave(m[j],token.p[i+1],token.p[i],"("+m1[1]+")");
						mn++;
						j++;
						method_number=mn;
						list_size=mn+fn;
						
					}
					
					else if(token.p[i+1].indexOf("[")!=-1){
						
						ja[k]=token.p[i+2]; //�迭���ڷ�
						String j1[]=ja[k].split("\\;");
						ja[k]=j1[0];
						flist[fn]=new classsave(ja[k],token.p[i+1],token.p[i],"[] :"+token.p[i+1].replace("[]",""));
						fn++;
						k++;
						field_number=fn;
						list_size=mn+fn;
					}
					
					else  {
						ja[k]=token.p[i+2]; //�ڷ�
						String j1[]=ja[k].split("\\;");
						ja[k]=j1[0];
						flist[fn]=new classsave(ja[k],token.p[i+1],token.p[i]," :"+token.p[i+1]);
						fn++;
						k++;
						field_number=fn;
						list_size=mn+fn;
						
					}
					
					
					
					
					
						}
				
					
					
				}
				
			}
	
	
	
	
	
	
	
			
}
		
	