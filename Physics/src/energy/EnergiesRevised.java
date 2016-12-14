package energy;

public class EnergiesRevised {
	
	//Energies
	public static double UG_ = 0; //Modify
	public static double US_ = 0; //Modify
	public static double KE_ = 0; //Modify
	
	public EnergiesRevised(double energies , boolean hasKE, boolean hasUG, boolean hasUS,
			double m, double mKg, double v, double h, double kSpring, double x, double xCm){
		//Scanner s = new Scanner(System.in);
		solve(energies, hasKE, hasUG, hasUS, m, mKg, v, h, kSpring, x, xCm);
	}
	
	/**
	 * findUG is a method that outputs the Gravitational Potential
	 * Energy given Mass in kilograms and the Height.
	 * @param m = Mass in grams
	 * @param h = Height
	 * @param mKg = Mass in kilograms
	 * @return Gravitational Potential Energy
	 */
	public static double findUG(double m, double h, double mKg){
		if(m == 0){
			UG_ = mKg * h * 9.8;
			return UG_;
		}
		if(mKg == 0){
			mKg = m/1000;
			UG_ = mKg * h * 9.8;
			return UG_;
		}
		return UG_;
	}
	/**
	 * findUS is a method that outputs the Spring Potential Energy given
	 * Position and the Spring Constant.
	 * @param x = Position
	 * @param kSpring = Spring Constant
	 * @param xCm = Position in centimeters
	 * @return Spring Potential Energy
	 */
	public static double findUS(double x, double kSpring, double xCm){
		if(x == 0){
			x = xCm/100;
			US_ = .5 * kSpring * x * x;
			return US_;
		}
		if(xCm == 0){
			US_ = .5 * kSpring * x * x;
			return US_;
		}
		return US_;
	}
	/**
	 * findKE is a method that returns the Kinetic Energy
	 * of an object given Velocity and Mass in kilograms.
	 * @param v = Velocity meters per second
	 * @param m = Mass in grams
	 * @param mKg = Mass in kilograms
	 * @return Kinetic Energy
	 */
	public static double findKE(double v, double m, double mKg){
		if(m == 0){
			KE_ = v * v * mKg * .5;
			return KE_;
		}
		if(mKg == 0){
			mKg = m/1000;
			KE_ = v * v * mKg * .5;
			return KE_;
		}
		return KE_;
	}
	
	public static double findvel(double m, double mKg){
		double vel;
		if(m == 0){
			vel = Math.sqrt((KE_ * 2) / mKg);
			return vel;
		}
		if(mKg == 0){
			mKg = m/1000;
			vel = Math.sqrt((KE_ * 2) / mKg);
			return vel;
		}
		return 0.0;
	}
	
	public static double findKSpring(double x, double xCm){
		double kSpring;
		if(x == 0){
			x = xCm / 100;
			kSpring = (2 * US_) / (x * x);
			return kSpring;
		}
		if(xCm == 0){
			kSpring = (2 * US_) / (x * x);
			return kSpring;
		}
		return 0.0;
	}
	
	public static double findX(double kSpring){
		double x;
		x = Math.sqrt((US_ * 2) / kSpring);
		return x;
	}
	
	public static double findHeight(double m, double mKg){
		double h;
		if(m == 0){
			h = UG_ / (mKg * 9.8);
			return h;
		}
		if(mKg == 0){
			mKg = m / 1000;
			h = UG_ / (mKg * 9.8);
			return h;
		}
		return 0.0;
	}
	
	public static double findMass(double h, double v){
		double m;
		if(h == 0){
			m = UG_ / (h * 9.8);
			return m;
		}
		if(v == 0){
			m = (KE_ * 2) / (v * v);
			return m;
		}
		return 0.0;
	}
	
	public static void solve(double energies, boolean hasKE, boolean hasUG, boolean hasUS,
			double m, double mKg, double v, double h, double kSpring, double x, double xCm){
		
		if(energies == 1){
			if(hasKE){
				System.out.println("KE = " + findKE(v, m, mKg));
			}
			if(hasUG){
				System.out.println("UG = " + findUG(m, h, mKg));
			}
			if(hasUS){
				System.out.println("US = " + findUS(x, kSpring, xCm));
			}
		}
		if(energies == 2){
			if(hasKE && hasUG){
				findKE(v, m, mKg);
				findUG(m, h, mKg);
				if(KE_ == 0){
					KE_ = UG_;
					System.out.println("Velocity = " + findvel(m, mKg));
				}
				if(UG_ == 0){
					UG_ = KE_;
					System.out.println("Height = " + findHeight(m , mKg));
				}
				else{
					System.out.println("KE = " + KE_);
					System.out.println("UG = " + UG_);
				}
			}
			if(hasKE && hasUS){
				findKE(v, m, mKg);
				findUS(x, kSpring, xCm);
				if(KE_ == 0){
					KE_ = US_;
					System.out.println("Velocity = " + findvel(m, mKg));
				}
				if(US_ == 0){
					US_ = KE_;
					//Checking if there is already change in position
					if(findKSpring(x, xCm) == 0){
						System.out.println("Spring Position = " + findX(kSpring)); //Modify
					}
					//Checking if there is a spring constant
					if(findX(kSpring) == 0){
						System.out.println("Spring Constant = " + findKSpring(x, xCm)); //Modify
					}
				}
				else{
					System.out.println("KE = " + KE_);
					System.out.println("US = " + US_);
				}
			}
			if(hasUG && hasUS){
				findUS(x, kSpring, xCm);
				findUG(m, h, mKg);
				if(US_ == 0){
					US_ = UG_;
					if(findKSpring(x, xCm) == 0 || x == 0){ 
						System.out.println("Spring Position = " + findX(kSpring)); //Modify
					}
					//Checking if there is a spring constant
					if(findX(kSpring) == 0){
						System.out.println("Spring Constant = " + findKSpring(x, xCm)); //Modify
					}
				}
				if(UG_ == 0){
					UG_ = US_;
					System.out.println("Height = " + findHeight(m , mKg));
				}
				else{
					System.out.println("US = " + US_);
					System.out.println("UG = " + UG_);
				}
			}
		}
		if(energies == 3){
			if(hasKE && hasUG && hasUS){
				
			}
		}
	}
}
