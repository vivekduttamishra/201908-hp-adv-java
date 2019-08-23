package in.conceptarchitect.animalkingdom;

public abstract class Bird extends Animal {
	@Override 
	public String move() {
		return fly();
	}
	
	@SpecialBehavior
	public String fly() {
		return this+" fly";
	}
}
