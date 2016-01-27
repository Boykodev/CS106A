/*
 * File: NameSurferEntry.java
 * --------------------------
 * This class represents a single entry in the database.  Each
 * NameSurferEntry contains a name and a list giving the popularity
 * of that name for each decade stretching back to 1900.
 */

import acm.util.*;
import java.util.*;

public class NameSurferEntry implements NameSurferConstants {

/* Constructor: NameSurferEntry(line) */
/**
 * Creates a new NameSurferEntry from a data line as it appears
 * in the data file.  Each line begins with the name, which is
 * followed by integers giving the rank of that name for each
 * decade.
 */
	public NameSurferEntry(String line) {
		//entry = new HashMap<String, ArrayList<Integer>>();
		parseLine(line);
	}

	/** Parses line to name and ranks*/
	private void parseLine(String line) {
		StringTokenizer token = new StringTokenizer(line);
		ranks = new ArrayList<Integer>();
		name = token.nextToken();
		while (token.hasMoreTokens()) {
			String rank = token.nextToken();
			ranks.add(Integer.parseInt(rank));
		}
	}

/* Method: getName() */
/**
 * Returns the name associated with this entry.
 */
	public String getName() {
		return name;
	}

/* Method: getRank(decade) */
/**
 * Returns the rank associated with an entry for a particular
 * decade.  The decade value is an integer indicating how many
 * decades have passed since the first year in the database,
 * which is given by the constant START_DECADE.  If a name does
 * not appear in a decade, the rank value is 0.
 */
	public int getRank(int decade) {
		if (decade > ranks.size() - 1) {
			return 0;
		}
		return ranks.get(decade);
	}

/* Method: toString() */
/**
 * Returns a string that makes it easy to see the value of a
 * NameSurferEntry.
 */
	public String toString() {
		// You need to turn this stub into a real implementation //
		String entry = "" + name + ": [";
		Iterator<Integer> it = ranks.iterator();
		while (it.hasNext()) {
			entry += it.next() + ((it.hasNext()) ? " " : "");
		}
		entry += "]";
		return entry;
	}
	
	private String name;
	private ArrayList<Integer> ranks;
}