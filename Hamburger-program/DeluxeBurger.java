package dev;

public class DeluxeBurger extends Hamburger {
    public DeluxeBurger() {
        super("Deluxe", "Sausage and bacon", 14.54, "white");
        super.addHamburgerAddition1("chips",2.75);
        super.addHamburgerAddition2("Drink",1.81);
    }

    @Override
    public void addHamburgerAddition1(String name,double price){
        System.out.println("cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition2(String name,double price){
        System.out.println("cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition3(String name,double price){
        System.out.println("cannot add additional items to deluxe burger");
    }

    @Override
    public void addHamburgerAddition4(String name,double price){
        System.out.println("cannot add additional items to deluxe burger");
    }

}
