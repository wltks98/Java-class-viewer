import java.util.ArrayList;


class methodsave {
	
	protected ArrayList<methodsave> methodin;
	StringBuffer mbuffer;
	int start,end;
	ArrayList<String> use= new ArrayList<String>();
	
	public methodsave(String o) {
		
		start=0;
		end=0;
		
		for(int i=0; i<parsing.method_number; i++) {
			
			
			if (o.equals(parsing.m[i])) {
				
				for(int j=0; j<token.token_number; j++) {
					
					int index= token.p[j].indexOf(parsing.m[i]);
					
					if(index!=-1) {
						
						if(token.p[j-1].equals("class")) {
							
							continue;
						}
						else if(token.p[j-2].equals("public")||token.p[j-2].equals("private")||token.p[j-2].equals("protected")||
								token.p[j-1].equals("public")||token.p[j-1].equals("private")||token.p[j-1].equals("protected")) {
							
													//j-2는 다른 메소드안에 메소드 호출한거를 j-1은 생성자 전용
						
							for(int k=1; k<token.token_number-j; k++)
							{
								int index2=token.p[j+k].indexOf("{");
								int index3=token.p[j+k].indexOf("}");
								
								if(index2!=-1) {
									
									start=j+k+1;
									
								}
								
								else if(index3!=-1) {
									
									end=j+k-1;
									break;
									
								}
								
								
							}
						break;
						}
						
					}
					
					
					
				}
				break;
				
			}
		}
	}
			
	
	
	
		
		
	
		
	
	
	public void methodin() {
	
		mbuffer=new StringBuffer();
		for(int i=start; i<=end; i++) {
			
			
			
			mbuffer.append(token.p[i]+"\n");
			//System.out.println(token.p[i]);
	
	
		}
	
	}
	
	
	
	public void methoduse() {
		
		
		
		for(int i=0; i<parsing.field_number; i++) {
			
			
			int index =mbuffer.indexOf(parsing.ja[i]);
			
			if(index!=-1) {
			
			
			use.add(parsing.ja[i]);
			}
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
