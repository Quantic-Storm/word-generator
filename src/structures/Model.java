package structures;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Model {
	private TreeMap<Trigram, Integer> trigrams;
	private long tgCount;
	
	public Model() {
		trigrams = new TreeMap();
		tgCount = 0;
	}
	
	public void printTrigrams() {
		for (Trigram t : trigrams.keySet())
		System.out.println(trigrams.get(t));
	}
	
	public void addTrigram(Trigram t) {
		if (trigrams.putIfAbsent(t, 1) != null) {
			int k = trigrams.get(t);
			trigrams.put(t, ++k);
		}
		tgCount++;
	}
	
	public char generateNext(String before) {
		if (before.length() != 2) throw new IllegalArgumentException("this function takes only a 2 char long String in parameters");
		
		Map<Trigram, Integer> usefulData = new HashMap();
		int total = 0;
		for (Trigram t:trigrams.keySet()) {
			if (t.getPreffix().equals(before)) {
				usefulData.put(t, trigrams.get(t));
				total += trigrams.get(t);
			}
		}
		
		
		double rdm = Math.random();
		double sumP = 0D;
		for (Trigram t:usefulData.keySet()) {
			double p = (double) usefulData.get(t) / total;
			sumP+=p;
			if (rdm-p < 0) {
				return t.getC();
			}
			else rdm -= p;
		}
		
		
		return '#';
		
		
	}
	
}
