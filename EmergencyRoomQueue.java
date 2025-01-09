import java.util.PriorityQueue;
import java.util.Scanner;

class Patient implements Comparable<Patient> {
    private String name;
    private int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    public String getName() {
        return name;
    }

    public int getSeverity() {
        return severity;
    }

    @Override
    public int compareTo(Patient other) {
        return Integer.compare(other.severity, this.severity);
    }

    @Override
    public String toString() {
        return "Patient: " + name + " | Severity: " + severity;
    }
}

public class EmergencyRoomQueue {
    public static void main(String[] args) {
        PriorityQueue<Patient> patientQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Emergency Room Queue Management System!");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Patient");
            System.out.println("2. View Next Patient");
            System.out.println("3. Attend Next Patient");
            System.out.println("4. View All Patients");
            System.out.println("5. Exit");
            System.out.println();
            System.out.print("Enter: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter severity level (1-10, 10 being the most severe): ");
                    int severity = scanner.nextInt();
                    patientQueue.offer(new Patient(name, severity));
                    System.out.println("Patient added successfully!");
                    break;
                case 2:
                    if (patientQueue.isEmpty()) {
                        System.out.println("No patients in the queue.");
                    } else {
                        System.out.println("Next Patient: " + patientQueue.peek());
                    }
                    break;
                case 3:
                    if (patientQueue.isEmpty()) {
                        System.out.println("No patients to attend.");
                    } else {
                        System.out.println("Attending Patient: " + patientQueue.poll());
                    }
                    break;
                case 4:
                    if (patientQueue.isEmpty()) {
                        System.out.println("No patients in the queue.");
                    } else {
                        System.out.println("All Patients:");
                        patientQueue.forEach(System.out::println);
                    }
                    break;
                case 5:
                    System.out.println("Exiting the Emergency Room Queue System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
