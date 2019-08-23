package in.conceptarchitect.animalkingdom;


public class Horse extends Mammal implements Rideable,Domestic {

	
	int age;
	
	@Override
	public String eat() {
		
		return this+" is grass eater";
	}
	
	
	@SpecialBehavior
	public String ride() {
		return this+" is a great ancient ride";
	}
	
}
