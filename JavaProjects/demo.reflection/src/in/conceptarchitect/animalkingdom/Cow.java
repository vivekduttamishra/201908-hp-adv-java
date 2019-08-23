package in.conceptarchitect.animalkingdom;

@Speciality(name="provideMilk", requires = "eat")
public class Cow extends Mammal implements Domestic {

	@Override	
	public String eat() {
		
		return this+" is grass eater";
	}
	
	public String provideMilk() {
		return this+" provides milk";
	}
	
}
