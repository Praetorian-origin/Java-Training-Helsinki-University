package validation;

public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        if(name.length() > 40) {
            throw new IllegalArgumentException("Name can't be longer than 40 characters");
        }
        if(age <0 || age >120) {
            throw new IllegalArgumentException("Age has to be between 0-120 years old");
        }
        this.name = name;   
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
