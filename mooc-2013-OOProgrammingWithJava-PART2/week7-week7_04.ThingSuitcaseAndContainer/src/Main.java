
public class Main {

    public static void addSuitcasesFullOfBricks(Container container) {
        for (int i = 1; i <= 100; i++) {
            Suitcase suitcase = new Suitcase(i);
            suitcase.addThing(new Thing("Brick", i));
            container.addSuitcase(suitcase);
        }
    }

    public static void main(String[] args) {

        // use this main class to test your program!
//
//        Thing book = new Thing("Happiness in three steps", 2);
//        Thing mobile = new Thing("Nokia 3210", 1);
//        Thing brick = new Thing("Brick", 4);
//
//        Suitcase suitcase = new Suitcase(5);
//        System.out.println(suitcase);
//
//        suitcase.addThing(book);
//        System.out.println(suitcase);
//
//        suitcase.addThing(mobile);
//        System.out.println(suitcase);
//
//        suitcase.addThing(brick);
//        System.out.println(suitcase);
//        Thing book = new Thing("Happiness in Three Steps", 2);
//        Thing mobile = new Thing("Nokia 3210", 1);
//        Thing brick = new Thing("Brick", 4);
//
//        Suitcase suitcase = new Suitcase(10);
//        suitcase.addThing(book);
//        suitcase.addThing(mobile);
//        suitcase.addThing(brick);
//
//        Thing heaviest = suitcase.heaviestThing();
//        System.out.println("The heaviest thing: " + heaviest);
//
//        Suitcase suitcase2 = new Suitcase(10);
//        Thing t = suitcase2.heaviestThing();
//        System.out.println("The heaviest thing: " + t);
//        Container container = new Container(1000);
//        addSuitcasesFullOfBricks(container);
//        System.out.println(container);
        Suitcase s = new Suitcase(10);
        s.addThing(new Thing("brick", 1));
        s.printThings();
        System.out.println(s.toString());
        
        
    }

}
