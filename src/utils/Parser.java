package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import structures.Model;
import structures.Trigram;

public class Parser {
	
	public static List<String> parseFile(String filepath){
		try(BufferedReader input = new BufferedReader(new FileReader(new File(filepath)))){
			List<String> words = new ArrayList();
			String word = input.readLine();
			
			while (word != null) {
				word = "$$"+ word + "#";	// $ -> before word start, # -> after word end
				//word = word.replace("-", "");
				word = word.replace("�", "");
				//word = word.replace("�", "c");
				//word = word.replace('�', 'e');
				//word = word.replace('�', 'e');
				//word = word.replace('�', 'e');
				//word = word.replace('�', 'e');
				//word = word.replace('�', 'i');
				//word = word.replace('�', 'i');
				//word = word.replace('�', 'a');
				//word = word.replace('�', 'a');
				//word = word.replace('�', 'u');
				//word = word.replace('�', 'u');
				word = word.replace('�', 'u');
				word = word.replace('�', 'o');
				//word = word.replace('�', 'o');
				
				if (!(word.charAt(2) >= 'A' && word.charAt(2) <= 'Z'))
					words.add(word);
				word = input.readLine();
			}
			
			return words;
			
		} catch (FileNotFoundException e) {
			System.out.println("file cannot be found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("error while trying to reach file");
			e.printStackTrace();
		}
		return null;
	}
	
	public static Model trainModel(List<String> words) {
		Model mod = new Model();
		for (String str:words) {
			for (int i = 0; i < str.length()-2; i++) {
				Trigram t = new Trigram(""+str.charAt(i)+str.charAt(i+1), str.charAt(i+2));
				mod.addTrigram(t);
			}
		}
		return mod;
	}

}
