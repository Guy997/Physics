package work;

public class Work {
	
	private static double work;
	
	public Work(double f, double d, double energy_init, double energy){
		solve(f, d, energy_init, energy);
	}
	
	static double findWorkForce(double f, double d){
		work = f * d;
		return work;
	}
	static double findWorkEnergy(double energy_init, double energy, double energyTotal){
		if(energyTotal != 0){
			work = energyTotal;
			return work;
		}
		else{
			energyTotal = energy - energy_init;
			work = energyTotal;
			return work;
		}
	}
	
	static double findEnergy(double f, double d, double energy, double energy_init, double energyTotal){
		
	}
	static double findForce(double d, double energy, double energy_init, double energyTotal){
		double force;
		findWorkEnergy(energy_init, energy, energyTotal);
		force = work / d;
		return force;
	}
	static double findDist(double energy_init, double energy, double energyTotal, double f){
		double dist;
		findWorkEnergy(energy_init, energy, energyTotal);
		dist = work / f;
		return dist;
	}
	public static void solve(double f, double d, double energy_init, double energy, double energyTotal){
		System.out.println("Work = " + findWorkForce(f, d));
		System.out.println("Work = " + findWorkEnergy(energy_init, energy, energyTotal));
		System.out.println("Distance = " + findDist(energy_init, energy, energyTotal, f));
		System.out.println("Force = " + findForce(d, energy, energy_init, energyTotal));
	}
	
}
