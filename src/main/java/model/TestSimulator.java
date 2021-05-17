package model;

public class TestSimulator {

	public static void main(String[] args) {
		
		Simulator sim = new Simulator();
		sim.init();
		
		sim.run();
		
		System.out.println();
		System.out.println("Pazienti trattati " + sim.getPatientsTreated());
		System.out.println("Pazienti morti " + sim.getPatientsDead());
	}
}