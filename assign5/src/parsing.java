 class parsing{
	
	static String c[]=new String[1000];
	static String m[]=new String[1000];
	static String ja[]=new String[1000];
	static classsave [] list =new classsave[1000];
	static classsave [] mlist =new classsave[1000];
	static classsave [] flist =new classsave[1000];
	static int list_size;
	static int class_number; //클래스 갯수
	static int method_number; //메소드 갯수
	static int field_number; //자료 갯수
	
	public void pclass(){ //클래스를 나눔
		
		int j=0;
		
		for(int i=0; i<token.token_number;i++) {
		
			
			if(token.p[i].equals("class")) {
				
				
				c[j]=token.p[i+1];
				
				j++;
				class_number=j;
			}
			
		}
		
	}
	
	
	public void pmethod() { //메소드와 자료를 구분
		
		int j=0;
		int k=0;
		int mn=0;	//메소드의 갯수
		int fn=0;	//자료의 갯수
			
			
			for(int i=0; i<token.token_number;i++) {
			
				
				
				if(token.p[i].equals("public")||token.p[i].equals("private")||token.p[i].equals("protected")) {
					
					if(token.p[i+1].indexOf(parsing.c[0])!=-1) {
						
						m[j]=token.p[i+1]; //생성자
						String m1[]=m[j].split("\\("); //Mystack뒤에 붙은 (을 빼내기 위한 작업
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
						String m1[]=m[j].split("\\("); //Mystack뒤에 붙은 (을 빼내기 위한 작업
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
						
						ja[k]=token.p[i+2]; //배열형자료
						String j1[]=ja[k].split("\\;");
						ja[k]=j1[0];
						flist[fn]=new classsave(ja[k],token.p[i+1],token.p[i],"[] :"+token.p[i+1].replace("[]",""));
						fn++;
						k++;
						field_number=fn;
						list_size=mn+fn;
					}
					
					else  {
						ja[k]=token.p[i+2]; //자료
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
		
	