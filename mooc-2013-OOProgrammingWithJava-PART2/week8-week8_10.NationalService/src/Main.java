
public class Main {

    public static void main(String[] args) {
        // Test your code here!

        MilitaryService militaryService = new MilitaryService(365);
        System.out.println(militaryService.getDaysLeft());
        militaryService.work();
        System.out.println(militaryService.getDaysLeft());

        CivilService cs = new CivilService();
        System.out.println(cs.getDaysLeft());
        cs.work();
        System.out.println(cs.getDaysLeft());

    }
}
