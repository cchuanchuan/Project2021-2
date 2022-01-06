
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class RedBlackBSTTest {

    class Contact {
        // implement this class
        // add necessary instance variables
        // and constructor and accessors

        private String country;
        private String phone;

        public Contact(String country, String phone) {
            this.country = country;
            this.phone = phone;
        }

        /**
         * @return the country
         */
        public String getCountry() {
            return country;
        }

        /**
         * @return the phone
         */
        public String getPhone() {
            return phone;
        }

    }

    public static void main(String[] args) {
        RedBlackBST<String, Contact> redblackTree = new RedBlackBST<String, Contact>();
        Scanner input = null;
        try {
            input = new Scanner(Paths.get("example.txt"));
            while (input.hasNext()) {
                String country = input.next();
                String phone = input.next();
                String name = input.next();
                Contact contact = new RedBlackBSTTest().new Contact(country, phone);
                redblackTree.put(name, contact);

            }
            System.out.printf("Size of the Red Black Tree:%d%n", redblackTree.size());
            System.out.println("Red Black Tree keys in-order:");

            for (String s : redblackTree.keys()) {
                Contact contact = redblackTree.get(s);
                System.out.printf("%-20s %-10s %-15s%n", s,
                        contact.getCountry(),
                        contact.getPhone());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        input.close();
    }
}
