import acm.program.*;
import acm.util.*;

/**
 *Simulates the sample that
 *contains radioactive material.
 */
public class RadioactiveDecay extends ConsoleProgram {
	
	public RadioactiveDecay() { this(1); }
	
	public RadioactiveDecay(int atoms) { this.atoms = atoms; }

	public void run() {
		RadioactiveDecay sample = new RadioactiveDecay(10000);
		sample.setConsole(this.getConsole());
		sample.decay();
	}
	
	private void decay() {
		println("There are " + atoms + " atoms initially.");
		int years = 0;
		while (atoms != 0) {
			for (int i = atoms; i > 0; i--) {
				if(rgen.nextBoolean()) atoms--;
			}
			years++;
			pause(500);
			println("There are " + atoms + " atoms at the end of year " + years);
		}
	}

	private RandomGenerator rgen = new RandomGenerator();
	private int atoms;
}
