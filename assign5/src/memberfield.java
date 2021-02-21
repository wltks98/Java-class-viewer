import java.util.ArrayList;


class memberfield {
	
	
	StringBuffer fbuffer;
	int start,end;
	ArrayList<StringBuffer> fuse= new ArrayList<StringBuffer>();
	ArrayList<String> usedmethod ;
	String fieldname;
	
	public memberfield(String o) {
		
		fieldname=o;
		start=0;
		end=0;
		usedmethod = new ArrayList<String>();
		
		for(int i=0; i<parsing.method_number; i++) {
			
			
			
				
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
							
						
							fieldin();
							fuse.add(fbuffer);
							findfield(parsing.m[i],i);
							
							
							
						}
						
					}
					
					
					
				}
				
				
			}
		}
	
			
	
	
	
	
	public void fieldin() {
	
		fbuffer=new StringBuffer();
		for(int i=start; i<=end; i++) {
			
			
			
			fbuffer.append(token.p[i]+"\n");
			//System.out.println(token.p[i]);
	
	
		}
	
	}
	
	
	public void findfield(String methodname,int i) {
		
	
		String s=""+fuse.get(i);
		
		int index=s.indexOf(fieldname);
		
		if(index!=-1) {
			
			usedmethod.add(methodname);
		
		
		
		}
		
		
		
		
	}
	
	
	
	
		
		
	
	
	
}
	
	
