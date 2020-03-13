
import java.util.ArrayList;
import java.util.Collections;


public class Main {


    public static void main(String[] args){
        ArrayList<Student> students = new ArrayList<Student>();
        Student first = new Student("jamo");
        students.add(first);
        Student second = new Student("jamo1");
        students.add(second);
         Student third = new Student("amo1");
         students.add(third);
        System.out.println(first.compareTo(second));
        Collections.sort(students);
        for (Student student : students) {
            System.out.println(student);
        }
       
    }
}
