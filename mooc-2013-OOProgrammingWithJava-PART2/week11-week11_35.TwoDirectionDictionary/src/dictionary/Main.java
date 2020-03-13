package dictionary;

public class Main {

    public static void main(String[] args) {

        MindfulDictionary s = new MindfulDictionary("src/words.txt");
        s.load();
        System.out.println(s.translate("fine"));
        s.save();

//        MindfulDictionary s = new MindfulDictionary("src/words.txt");
//        s.add("fine", "bien");
//        s.load();
//        s.remove("below");
//        s.add("tieokone", "computer");
//        s.save();
    }
}
