import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************************");
        System.out.println("Welcome to Student DataBase");
        System.out.println("***************************");
        System.out.println("Below are the Operations:");
        System.out.println("1. Add the Student Info");
        System.out.println("2. Display Student's detail");
        System.out.println("3. Add Student's Result Info");
        System.out.println("4. Display Result Info");
        System.out.println("5. Exit");
        System.out.print("Enter your choice:");
        int choice = sc.nextInt();

        switch (choice){
            case 1: {
                System.out.println("Enter the details of Student:");
                System.out.print("Roll Number:");
                int s_id = sc.nextInt();
                sc.nextLine();
                System.out.print("Name:");
                String s_name = sc.nextLine();
                System.out.print("Age:");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Course:");
                String course = sc.nextLine();
                Student student = new Student();
                student.setS_name(s_name);
                student.setS_id(s_id);
                student.setAge(age);
                student.setCourse(course);
                StudentDAO.addStudent(student);
                break;
            }
                case 2:{
                    Student student1 = new Student();
                    StudentDAO.getDetails(student1);
                    break;
            }
            case 3: {
                System.out.println("Enter result details of student:");
                System.out.print("Student's Roll Number: ");
                int s_id = sc.nextInt();

                double[] subjects = new double[5];
                for (int i = 0; i < 5; i++) {
                    System.out.print("Enter marks in Subject " + (i + 1) + ": ");
                    subjects[i] = sc.nextDouble();
                }
                Result result = new Result();
                result.setSid(s_id);
                result.setS1(subjects[0]);
                result.setS2(subjects[1]);
                result.setS3(subjects[2]);
                result.setS4(subjects[3]);
                result.setS5(subjects[4]);

                ResultDAO.addResults(result);
                break;
            }
            case 4: {
                ResultDAO.getResults();
                break;
            }
            default:
                System.out.println("Enter correct value");
        }


    }
}
