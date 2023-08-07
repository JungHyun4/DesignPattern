package SOLID_PRINCIPLE.DIP;

import java.util.ArrayList;

public class Zoo {
    public ArrayList<Animal> animals = new ArrayList<Animal>();

    public void AddAnimal(Animal animal){
        this.animals.add(animal);
    }

    public void PrintAnimals(){
        for(int i = 0 ; i < this.animals.size() ; i++){
            animals.get(i).bark();
        }
    }

    public static void main(String [] args){

        Zoo zoo = new Zoo();

        Cat c = new Cat();
        Dog d = new Dog();

        zoo.AddAnimal(c);
        zoo.AddAnimal(d);

        zoo.PrintAnimals();


    }
}
