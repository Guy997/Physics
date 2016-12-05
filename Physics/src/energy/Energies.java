package energy;

import java.util.ArrayList;

public class Energies {
	
	public static ArrayList<Double> energies = new ArrayList<Double>();
	
	private static double mass_ = 277; //Mass in Kg
	private static double massKg_ = mass_ / 1000; //Mass you're converting to Kg
	
	private static double sPosCm_ = 0.0; //Change in position of the spring in centimeters
	private static double sPos_ = 3.56-2.35; //Change in position of the spring in meters
	private static double kSpring_ = 5.2; //Spring constant
	
	private static final boolean hasKE_ = true; //True if there is suspected KE
	private static final boolean hasUG_ = false; //True if there is suspected UG
	private static final boolean hasUS_ = false; //True if there is suspected US
	
	private static double TOTAL = 0; //Total energies.
	
	private static final double gravity_ = 9.8;
	private static double height_ = 27.2;
	
	public static double velocity_ = 0; //Velocity of the object
	
	private static double US_ = 0; //Spring Potential Energy
	private static double KE_ = 73837.12000000001-18730.740000000005; //Kinetic Energy
	public static double UG_ = 0; //Gravitational Potential Energy
	
	@SuppressWarnings("unused")
	
	public static boolean isUS(){
		if(hasUS_){
			return true;
		}
		if(kSpring_ != 0 && (sPosCm_ != 0 || sPos_ != 0)){
			if(sPos_ != 0){
				US_ = .5 * kSpring_ * sPos_ * sPos_;
				//energies.add(0, US_);
				return true;
			}
			if(kSpring_ != 0 && sPosCm_ != 0){
				sPos_ = sPosCm_/100;
				US_ = .5 * kSpring_ * sPos_ * sPos_;
				//energies.add(0, US_);
				return true;
			}
			return false;
		}
		return false;
	}
	@SuppressWarnings("unused")
	public static boolean isUG(){
		if(hasUG_){
			return true;
		}
		if(height_ != 0 && mass_ != 0){
			UG_ = mass_ * gravity_ * height_;
			return true;
		}
		return false;
	}
	@SuppressWarnings("unused")
	public static boolean isKE(){
		if(mass_ != 0 && velocity_ != 0){
			KE_ = mass_ * velocity_ * velocity_ * .5;
			//energies.add(2, KE_);
			//System.out.println(KE_);
			return true;
		}
		return false;
	}
	public static double solveKE(){
		if(mass_ != 0 && velocity_ != 0){
			KE_ = mass_ * velocity_ * velocity_ * .5;
			return KE_;
		}
		return KE_;
	}
	public static double solveUG(){
		if(mass_ != 0 && height_ != 0){
			UG_ = mass_ * gravity_ * height_;
			return UG_;
		}
		return UG_;
	}
	public static double solveUS(){
		if(sPosCm_ != 0){
			sPos_ = sPosCm_ / 100;
		}
		if(kSpring_ != 0 && sPos_ != 0){
			US_ = .5 * sPos_ * sPos_ * kSpring_;
			return US_;
		}
		return US_;
	}
	public static double findvel(){ //FIX
		if(hasKE_){
			if(mass_ != 0){
				velocity_ = Math.sqrt(2 * (KE_ / mass_));
				System.out.println(velocity_);
				return velocity_;
			}
		}
		return 0.0;
	}
	
	public static void solve(){
		TOTAL = KE_ + UG_ + US_;
		if(!hasKE_ && !hasUG_){
			System.out.println("US = " + solveUS());
		}
		if(!hasUG_ && !hasUS_){
			System.out.println("KE = " + solveKE());
			System.out.println(findvel());
		}
		if(!hasKE_ && !hasUS_){
			System.out.println("UG = " + solveUG());
		}
		if(isUG() && hasKE_){
			
		}
		if(isUG() && hasUS_){
			
		}
		if(isKE() && hasUS_){
			
		}
		if(isKE() && hasUG_){
			
		}
		if(isUS() && hasKE_){
			
		}
		if(isUS() && hasUG_){
			
		}
	}
		/*
		if(isUG()){
			TOTAL = UG_;
			if(isKE()){ //If UG and KE are there, find all components of US
				TOTAL = UG_ + KE_;
				
				if(kSpring_ != 0){
					sPos_ = Math.sqrt(US_ / kSpring_);
				}
				if(sPos_ != 0){
					kSpring_ = US_ / (sPos_ * sPos_);
				}
			}
			if(isUS()){ //If UG and US are there, find all components of KE
				KE_ = TOTAL - UG_;
				if(mass_ != 0){
					velocity_ = Math.sqrt(KE_ / mass_);
					System.out.println(velocity_);
				}
				if(velocity_ != 0){
					mass_ = KE_ / (velocity_ * velocity_);
				}
			}
			else{
				if(hasKE_){
					KE_ = TOTAL;
					velocity_ = Math.sqrt(KE_ / mass_);
					solve();
				}
				if(hasUS_){
					US_ = TOTAL;
					if(kSpring_ != 0){
						sPos_ = Math.sqrt(US_ / kSpring_);
					}
					if(sPos_ != 0){
						kSpring_ = US_ / (sPos_ * sPos_);
					}
					solve();
				}
				System.out.println("Just UG = " + UG_);
			}
		}
		if(isKE()){
			if(isUS()){
				if(kSpring_ != 0){
					sPos_ = Math.sqrt(US_ / kSpring_);
				}
				if(sPos_ != 0){
					kSpring_ = US_ / (sPos_ * sPos_);
				}
			}
			if(isUG()){
				height_ = UG_ / (mass_ * gravity_);
			}
			else{
				if(hasUS_){
					US_ = TOTAL;
					if(kSpring_ != 0){
						sPos_ = Math.sqrt(US_ / kSpring_);
					}
					if(sPos_ != 0){
						kSpring_ = US_ / (sPos_ * sPos_);
					}
					solve();
				}
				if(hasUG_){
					UG_ = TOTAL;
					height_ = UG_ / (mass_ * gravity_);
				}
				if(mass_ != 0){
					velocity_ = Math.sqrt((2 * KE_) / mass_);
				}
				System.out.println("Just KE = " + KE_);
			}
		}
		if(isUS()){
			if(isKE()){
				if(mass_ != 0){
					velocity_ = Math.sqrt((2 * KE_) / mass_);
				}
				if(velocity_ != 0){
					mass_ = (.5) * (KE_ / (velocity_ * velocity_));
				}
			}
			if(isUG()){
				if(mass_ != 0){
					height_ = UG_ / (mass_ * gravity_);
				}
				if(height_ != 0){
					mass_ = UG_ / (height_ * gravity_);
				}
			}
			else{
				if(hasKE_){
					KE_ = TOTAL;
					if(mass_ != 0){
						velocity_ = Math.sqrt(KE_ / mass_);
					}
					if(velocity_ != 0){
						mass_ = (.5) * (KE_ / (velocity_ * velocity_));
					}
					solve();
				}
				if(hasUG_){
					UG_ = TOTAL;
					if(mass_ != 0){
						height_ = UG_ / (mass_ * gravity_);
					}
					if(height_ != 0){
						mass_ = UG_ / (height_ * gravity_);
					}
				}
				System.out.println("Just US = " + US_);
			}
		
		}*/
}
