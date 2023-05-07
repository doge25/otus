package animals.birds;

import animals.AbsAnimal;

public class Duck extends AbsAnimal implements iFlying {

    public Duck() {
        fly();
    }

    public void fly() {
        System.out.println("Я лечу");
    }

    public void say() {
        System.out.println("Кря");
    }
}
