package dev;

public class Main {
    public static void main(String[] args) {
        Hamburger hamburger = new Hamburger("basic", "sausage", 3.56, "white");
        double price = hamburger.itemizeHamburger();
        hamburger.addHamburgerAddition1("Tomato",0.27);
        hamburger.addHamburgerAddition2("lettuce",0.75);
        hamburger.addHamburgerAddition3("cheese",1.12);
        System.out.println("total price of burger is "+hamburger.itemizeHamburger());
        HealthyBurger healthyBurger = new HealthyBurger("bacon",5.67);
        healthyBurger.addHamburgerAddition1("egg",5.43);
        healthyBurger.addHealthyAddition1("lentils",3.41);
        System.out.println("Total Healthy burger price is "+healthyBurger.itemizeHamburger());

        DeluxeBurger db = new DeluxeBurger();
        db.addHamburgerAddition1("something",50.5);
        System.out.println("Total Deluxe burger price is "+db.itemizeHamburger());
    }
}
