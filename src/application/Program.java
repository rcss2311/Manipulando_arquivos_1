package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		
		String [] produtos = new String[] {"TV LED,1290.99,1","Video Game Chair,350.50,3","Iphone X,900.00,2","Samsung Galaxy 9,850.00,2"};
		String caminho = "c://WS-Eclipse//Itens_Vendidos.csv";
		boolean success = new File("c://WS-Eclipse" + "\\out").mkdir();
		String caminho2 = "c://WS-Eclipse//out//summary.csv";
		
		
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho))) {
			for(String p: produtos) {
				bw.write(p);
				bw.newLine();
			}
			
		}
		catch(IOException e){
			e.printStackTrace();
		} 
		
		try(BufferedReader br = new BufferedReader(new FileReader(caminho))){
			String lista = br.readLine();
			String[] vect;
			
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(caminho2))){
				
				while(lista != null) {
					vect = lista.split(",");
					String word1 = vect[0];
					String word2 = vect[1];
					String word3 = vect[2];
				
					double total = Double.parseDouble(word2)* Double.parseDouble(word3);
				
					bw.write(word1);
					bw.write(", ");
					bw.write(String.valueOf(total));
					bw.newLine();
				
					lista = br.readLine();
				}
				
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
