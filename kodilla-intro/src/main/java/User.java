public class User {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        User[] users = {
            new User("James", 23),
            new User("Michael", 47),
            new User("Robert", 11),
            new User("John", 32),
            new User("David", 5),
        };

        int sumOfAges = 0;

        for (int i = 0; i < 5; i++) {
            sumOfAges += users[i].age;
        }

        double averageAge = (double) sumOfAges / 5;

        for (int i = 0; i < 5; i++) {
            if ((double) users[i].age < averageAge) {
                System.out.println(users[i].name);
            }
        }
    }
}
