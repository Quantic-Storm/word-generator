package structures;

public class Trigram implements Comparable{
	private String preffix;
	private char c;
	
	public Trigram(String preffix, char c) {
		if (preffix.length() != 2) throw new IllegalArgumentException("preffix must contain 2 characters");
		this.preffix = preffix;
		this.c = c;
	}
	
	public String getPreffix() {
		return preffix;
	}
	
	public char getC() {
		return c;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof Trigram) {
			return (((Trigram) o).c == c && ((Trigram) o).preffix.equals(preffix));
		}
		else return false;
	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Trigram) {
			int cond1 = ((Trigram)o).preffix.compareTo(preffix);
			if (cond1 == 0) {
				return ((Trigram)o).c - c;
			}
			else return cond1;
		}
		else return 0;
	}
}
