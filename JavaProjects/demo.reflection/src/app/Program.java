package app;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import in.conceptarchitect.animalkingdom.Animal;
import in.conceptarchitect.animalkingdom.Camel;
import in.conceptarchitect.animalkingdom.Cow;
import in.conceptarchitect.animalkingdom.Crocodile;
import in.conceptarchitect.animalkingdom.Dog;
import in.conceptarchitect.animalkingdom.Domestic;
import in.conceptarchitect.animalkingdom.Eagle;
import in.conceptarchitect.animalkingdom.Horse;
import in.conceptarchitect.animalkingdom.Hunter;
import in.conceptarchitect.animalkingdom.Parrot;
import in.conceptarchitect.animalkingdom.Rideable;
import in.conceptarchitect.animalkingdom.Snake;
import in.conceptarchitect.animalkingdom.Tiger;
import in.conceptarchitect.reflect.Reflect;

public class Program {

	public static void main(String[] args) throws Exception{
		//testTraditionalOO();
		
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		
		
		//Class<?> cls=Horse.class;
		
		System.out.println("Enter the class name:");
		String className= reader.readLine();
		
		if(!className.contains("."))
			className="in.conceptarchitect.animalkingdom."+className;
		
		Class<?> cls= Class.forName(className);
		
		//String str= Reflect.info(cls);
		
		//System.out.println(str);
		
		//Reflect.invokeAll(cls);
		
		//Reflect.invokeSpecialBehaviors(cls);
		
		Reflect.invokeSpeciality(cls);
		
		
	}

	private static void testTraditionalOO() {
		// TODO Auto-generated method stub
		//Animal animal=new Tiger();
		
		//System.out.println(animal.eat()); //invokes Cat.eat()--->Cat.hunt()
		
		Animal [] animals= {
			new Tiger(),
			new Horse(),
			new Camel(),
			new Dog(),
			new Parrot(),
			new Crocodile(),
			new Eagle(),
			new Snake(),
			new Cow()
		};
		
		for(Animal animal:animals) {
			
			if (animal instanceof Domestic){
				System.out.print("****\t");
			}
			
			System.out.println(animal);
			System.out.println(animal.eat());
			System.out.println(animal.move());
			
			if(animal instanceof Hunter) {
				Hunter h=(Hunter) animal;
				System.out.println(h.hunt());
			}
			
			if(animal instanceof Rideable) {
				Rideable r=(Rideable) animal;
				System.out.println(r.ride());
			}
			
			
			System.out.println(animal.die());
			System.out.println();
		}
	}

}
