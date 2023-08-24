package Patterns;

/***
 * visitor 패턴은 solid 원칙중 ocp를 지키기 위한 패턴이다.
 * 클래스는 확장에는 열려있고, 수정에는 닫혀있어야 한다는 원칙인데 만약 새로운 기능을 추가하고자 하면 불가피하게 코드를 수정할 수 밖에 없다.
 * visitor 패턴은 새로운 기능을 추가하고 싶은 경우에 기존 클래스의 코드를 수정하지 않고 메서드를 추가하는 방식을 제시한다.
 *
 * 방문자 패턴에는 visitor 객체와 element 객체 두 가지가 나온다. element 객체는 기존에 존재하는 클래스, 즉 새로운 메서드를 추가하고자 하는 클래스이고
 * visitor 객체는 element 객체에게 책임을 위임받아 메서드를 작성하게 될 클래스이다.
 * 쉽게 말하자면 element에 추가하고싶은 메서드를 element에 직접 추가하는게 아니라 visitor 클래스에 추가하는 방식이다.
 *
 * 하지만 방문자 패턴을 사용하면 캡슐화가 약해지게 되는데, element 객체의 책임을 visitor가 지게되다보니, element의 속성에 직접 방문하게 된다.
 * 따라서 캡슐화를 최대한 유지하기 위해 다음과 같은 방법이 권장된다.
 *
 * 1. element 객체의 속성을 직접 접근하는 메서드는 지양해야하며,
 * 2. 피치 못하게 element 객체의 속성을 변경해야하는 경우엔 객체를 복사하여 새로운 객체에 작업을 수행하는게 권장된다.
 *
 */


import java.util.ArrayList;
import java.util.List;

public class VisitorPattern{

    public static void main(String args[]){
        Bag bag = new Bag();

        bag.item_list.add(new Item("지갑",1));
        bag.item_list.add(new Item("에어팟",1));
        bag.item_list.add(new Item("전공책",2));


        for (int i=0; i<bag.item_list.size() ; i++){
            bag.item_list.get(i).accept(bag);
        }
    }


}


interface Visitor{
    public void visit(Item item);
}

interface Element{
    public void accept(Visitor visitor);
}

class Bag implements Visitor{
    public List<Item> item_list = new ArrayList<Item>();

    public void visit(Item item){
            System.out.println("가방속에 "+item.name +" 가(이)  " + item.num + "개 들어있습니다." );
    }
}

class Item implements Element{
    public String name;
    public int num;

    public Item(String name, int num){
        this.name = name;
        this.num = num;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
