import java.io.IOException;

class Animal {
    String name = "Animal";

    Animal(){
    	System.out.println("animal ctor");
    	printName();
    }
    
    void sound() {
        System.out.println("Some generic animal sound");
    }

    void printName() {
        System.out.println("Animal name: " + name);
    }
}

class Dog extends Animal {
    String name = "Dog";

    Dog(){
    	System.out.println("dog ctor");
    	printName();
    }
    
    void sound() {
        System.out.println("Bark");
    }

    void printName() {
        System.out.println("Dog name: " + name);
    }
}

class Cat extends Dog {
    String name = "Cat";

    Cat(){
    	System.out.println("cat ctor");
    	printName();
    }
    
    void sound() {    	
        System.out.println("Meow");
    }

    void printName() {    	
        System.out.println("Cat name: " + name);
    }
}

public class Test3 {
	
	public static void main(String[] args) throws IOException {
	
		Animal animal = new Cat();
		System.out.println(animal.name);
	}
}