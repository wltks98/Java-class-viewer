import java.lang.reflect.*;

import java.util.*;
import java.util.Scanner;
import java.io.*;




 class token {

	
	
	
	static String p[]=new String[1000];
	static int token_number=0;
	
	public void tokentest(String s){
		
		
		
		String[] tokens = s.split("\\s+"); // "t|s" 하면 t와 s를 제외 \\)|\\(|
		
		
		
		for(int i=0; i<tokens.length; i++) {
		
		System.out.print(tokens[i]);
		
			p[i]=tokens[i];
			token_number+=1;
					
					
		}
		
		
		
	}
	
	
	
	
	
	
}
