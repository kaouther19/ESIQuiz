package examination;

import java.io.Serializable;

public class Proposition implements Serializable
{
    private String proposition;
    private boolean correct;
    public Proposition(String proposition,boolean valeurV)
    {
         this.proposition=proposition;
         this.correct=valeurV;
    }
    public boolean equals(Object o)
    {
    		if (((Proposition)o).getProposition().compareTo(proposition)==0) return true;
    		else return false;
    }
	
	public boolean isCorrect() {
		return correct;
	}
	public String getProposition() {
		return proposition;
	}
	
}
