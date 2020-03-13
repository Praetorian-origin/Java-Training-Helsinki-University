
public class Main {

    public static boolean isAWeekDay(String string) {
        return string.matches("mon|tue|wed|thu|fri|sat|sun");

    }

    public static boolean allVowels(String string) {
        return string.matches("[a,e,i,o,u,y,ä,ö]*");
    }

    public static boolean clockTime(String string) {
       return string.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");
//        String[] split = string.split(":");
//        if (split.length != 3) {
//            return false;
//        }
//        try {
//
//            if (!(Integer.parseInt(split[0]) < 24 && split[0].length() == 2)) {
//                return false;
//            }
//
//            if (!(Integer.parseInt(split[1]) < 60 && split[1].length() == 2)) {
//                
//                return false;
//            }
//            if (!(Integer.parseInt(split[2]) < 60 && split[2].length() == 2)) {
//                return false;
//            }
//        } catch (NumberFormatException e) {
//            System.out.println(e.getMessage());
//            return false;
//        }
//        return true;
    }

    public static void main(String[] args) {
        // write test code here
        // System.out.println(isAWeekDay(""));
        // System.out.println(allVowels("eayo"));
        System.out.println(clockTime("24:09:31"));
        

    }
}
