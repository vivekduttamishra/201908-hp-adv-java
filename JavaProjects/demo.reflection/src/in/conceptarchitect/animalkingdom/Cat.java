package in.conceptarchitect.animalkingdom;

public 	abstract class Cat extends Mammal implements Hunter{

	@Override
	public String eat() {
		
		return this+" is flesheater: "+hunt();
	}
	@SpecialBehavior
	public String hunt() {
		return this+" is a great hunter";
	}
	
//	public String die() {
//		return "I won't die";
//	}
	
	
}
