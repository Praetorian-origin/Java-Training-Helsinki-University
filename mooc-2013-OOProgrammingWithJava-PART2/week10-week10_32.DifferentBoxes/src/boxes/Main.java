package boxes;

public class Main {

    public static void main(String[] args) {
        // Test your program here
        MaxWeightBox coffeeBox = new MaxWeightBox(10);
        coffeeBox.add(new Thing("Saludo", 5));
        coffeeBox.add(new Thing("Pirkka", 5));
        coffeeBox.add(new Thing("Kopi Luwak", 5));

        System.out.println(coffeeBox.isInTheBox(new Thing("Saludo")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Pirkka")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Kopi Luwak")));



        Box box = new OneThingBox();
        box.add(new Thing("a", 1));
        box.add(new Thing("b", 2));
        box.add(new Thing("c", 2));
        box.isInTheBox(new Thing("a"));
    }
}
