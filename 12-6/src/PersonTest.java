public class PersonTest {

    public static void main(String[] args) {
        Person person = new Person();
        person.setName("Harry Potter");
        person.setBirthdate("1980-07-31");

        System.out.println("Person:"+person.toString());
        System.out.println("Age:"+person.calculateAge());
    }
}
