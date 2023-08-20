package Pattern;


import java.util.ArrayList;
import java.util.List;

/***

 Iterator 패턴은 컬렉션의 요소를 하나씩 접근하고 조작할 때 사용하는 디자인 패턴입니다.
 이 패턴을 사용하면 컬렉션의 내부를 숨기고 간편하게 요소에 접근할 수 있습니다.
 주로 hasNext()와 next() 메서드를 사용하여 반복 작업을 수행합니다. 이 패턴을 적용하면 코드가 더 간결해지고 유지 보수가 쉬워집니다.

 ***/

public class iteratorPattern {
    public static void main(String args[]){
        FruitCollection fruitStore = new FruitCollection();

        fruitStore.append(new Fruit("딸기"));
        fruitStore.append(new Fruit("수박"));
        fruitStore.append(new Fruit("참외"));
        fruitStore.append(new Fruit("메론"));

        for(int i=0; i<fruitStore.getLast(); i++){
            System.out.println(fruitStore.next().getName());
        }
    }

}


interface iterator<T>{
    boolean hasNext();
    T next();

}

class Fruit{
    private String name;

    Fruit(String name){
        this.name = name;
    }

    public String getName(){
        return(this.name);
    }
}

class FruitCollection implements iterator<Fruit>{
    private int index = 0;
    private int last = 0;
    private List<Fruit> fruitCollection;

    FruitCollection(){
        this.fruitCollection = new ArrayList<>();
    }

    public int getLast(){
        return this.last;
    }
    public void append(Fruit fruit){
        this.fruitCollection.add(fruit);
        this.last += 1;
    }


    @Override
    public boolean hasNext() {
        return this.index < this.last;
    }

    @Override
    public Fruit next() {
        if (hasNext()){
            return fruitCollection.get(index++);

        }
        return null;
    }
}
