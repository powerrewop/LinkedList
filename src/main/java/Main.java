import nay.kirill.generics.linkedList.LinkedList;

public class Main {
    public static void main(String[] args){

        Cl1 cl1 = new Cl1();
        cl1.test = "1";
        Cl1 cl2 = new Cl1();
        cl2.test = "2";
        Cl1 cl3 = new Cl1();
        cl3.test = "3";

        LinkedList<Cl1> ls1 = new LinkedList<>();

        ls1.add(cl1);
        ls1.add(cl2);
        ls1.add(cl3);

        Cl2 cl12 = new Cl2();
        cl12.test = "4";
        Cl2 cl22 = new Cl2();
        cl22.test = "5";
        Cl2 cl32 = new Cl2();
        cl32.test = "6";

        LinkedList<Cl2> ls2 = new LinkedList<>();

        ls2.add(cl12);
        ls2.add(cl22);
        ls2.add(cl32);

        ls1.printAll();

        ls1.addAll(ls2);

        ls1.printAll();
    }
}

class Cl1{
    public String test;
    @Override
    public String toString(){

        return this.test;
    }
}

class Cl2 extends Cl1{}