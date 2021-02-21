import java.io.*;
import java.util.Scanner;




public class ReadFileData {

	
		int b=0;
		StringBuffer buffer= new StringBuffer();
		FileInputStream file =null;
		
		
		token tk2 =new token();
		
		
		
		public void fileread(String address) {
			
			
		
		try {
			
			file=new FileInputStream(address); //"src/MyStack.java" 
			b=file.read();
			
			while (b!=-1)
			{
				buffer.append((char)b);
				b=file.read();
				
			}
			
			
			
			
			tk2.tokentest(""+buffer);
			
			parsing ds2 = new parsing();
			
			ds2.pclass();
			
			ds2.pmethod();
			
			
			
		}
		catch (FileNotFoundException e) {
			
			System.out.println("Oops : FileNotFoundException");
			
			
			
		}
		catch (IOException e) {
			
			System.out.println("Input error");
			
		}
		

	}
}


