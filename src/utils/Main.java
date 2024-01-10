package utils;

import structures.Model;

public class Main {
	public static void main(String[] args) {
		Model m = Parser.trainModel(Parser.parseFile("liste_francais.txt"));
		for (int n = 0; n < 200; n++) {
			for (int i = 0; i < 1; i++) {
				String newWord = new String("$$");
				while (newWord.charAt(newWord.length() - 1) != '#') {
					int len = newWord.length();
					newWord += m.generateNext(newWord.substring(len - 2, len));
				}
				newWord = newWord.replace("$", "");
				newWord = newWord.replace("#", "");

				// if (newWord.length() < 10)
				System.out.println(newWord);
			}
		}

	}
}
