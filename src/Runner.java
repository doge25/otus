import animals.AbsAnimal;
import data.AnimalTypeData;
import data.CommandsData;
import factories.AnimalFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

    private final static Scanner scanner = new Scanner(System.in);

    public static void main(String... args) {
        List<AbsAnimal> animals = new ArrayList<>();

        while (true) {
            String commandStr = "";
            do {
                System.out.println("Введите команду: add/list/exit");
                commandStr = scanner.next().toUpperCase().trim();
            } while (!commandStr.equals("ADD") && !commandStr.equals("LIST") && !commandStr.equals("EXIT"));

            CommandsData commandsData = CommandsData.valueOf(commandStr);
            switch (commandsData) {
                case ADD -> {
                    String animalTypeStr = "";
                    do {
                        System.out.println("Введите тип животного: cat/dog/duck");
                        animalTypeStr = scanner.next().toUpperCase().trim();
                    } while (!animalTypeStr.equals("CAT") && !animalTypeStr.equals("DOG") && !animalTypeStr.equals("DUCK"));

                    AnimalTypeData animalTypeData = AnimalTypeData.valueOf(animalTypeStr);
                    AnimalFactory animalFactory = new AnimalFactory();
                    AbsAnimal animal = fillAnimalData(animalFactory.create(animalTypeData));

                    animals.add(animal);
                }
                case LIST -> animals.forEach((AbsAnimal animal) -> System.out.println(animal.toString()));
                case EXIT -> System.exit(0);
            }
        }
    }

    private static AbsAnimal fillAnimalData(AbsAnimal animal) {
        System.out.println("Ввeдите имя животного:");
        String name = scanner.next();
        animal.setName(name);

        System.out.println("Ввeдите возраст животного:");
        String ageStr = scanner.next();
//        try {
//            ageStr = String.valueOf(Integer.parseInt(ageStr));
//        }
//        catch (NumberFormatException e)
//        {
        animal.setAge(Integer.parseInt(ageStr));

        System.out.println("Ввeдите вес животного:");
        String weightStr = scanner.next();
        animal.setWeight(Integer.parseInt(weightStr));

        System.out.println("Ввeдите цвет животного:");
        String color = scanner.next();
        animal.setColor(color);

        return animal;
    }
}