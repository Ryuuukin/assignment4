import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        KittenDorm dorm = new KittenDorm();
        List<Student> students = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Register a student");
            System.out.println("2. Add a stray kitten");
            System.out.println("3. Add a breeded kitten");
            System.out.println("4. Adopt a kitten");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student budget: ");
                    double studentBudget = scanner.nextDouble();
                    students.add(new Student(studentName, studentBudget));
                    break;
                case 2:
                    System.out.print("Enter stray kitten name: ");
                    String strayKittenName = scanner.nextLine();
                    dorm.publishKitten(new StrayKittenFactory().createKitten(strayKittenName));
                    break;
                case 3:
                    System.out.print("Enter breeded kitten name: ");
                    String breededKittenName = scanner.nextLine();
                    dorm.publishKitten(new BreededKittenFactory().createKitten(breededKittenName));
                    break;
                case 4:
                    System.out.print("Enter student name: ");
                    String studentNameToAdopt = scanner.nextLine();
                    System.out.print("Enter kitten name: ");
                    String kittenNameToAdopt = scanner.nextLine();

                    Student studentToAdopt = null;
                    for (Student student : students) {
                        if (student.getName().equals(studentNameToAdopt)) {
                            studentToAdopt = student;
                            break;
                        }
                    }

                    if (studentToAdopt == null) {
                        System.out.println("Student with name " + studentNameToAdopt + " not found.");
                    } else if (studentToAdopt.getAdoptedKitten() != null) {
                        System.out.println(studentNameToAdopt + " already has a kitten and cannot adopt another one.");
                    } else {
                        boolean kittenFound = false;
                        for (Kitten kitten : dorm.getKittens()) {
                            if (kitten instanceof StrayKitten && ((StrayKitten) kitten).getName().equals(kittenNameToAdopt)) {
                                studentToAdopt.update(kitten);
                                dorm.getKittens().remove(kitten);
                                kittenFound = true;
                                break;
                            }
                            if (kitten instanceof BreededKitten && ((BreededKitten) kitten).getName().equals(kittenNameToAdopt)) {
                                if (studentToAdopt.getBudget() >= 50000) {
                                    studentToAdopt.update(kitten);
                                    dorm.getKittens().remove(kitten);
                                    kittenFound = true;
                                } else {
                                    System.out.println(studentNameToAdopt + " doesn't have enough budget to buy the breeded kitten.");
                                    kittenFound = true;
                                }
                                break;
                            }
                        }

                        if (!kittenFound) {
                            System.out.println("Kitten with name " + kittenNameToAdopt + " not found or has already been adopted.");
                        }
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
            }
        }
    }
}