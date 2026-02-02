import java.util.Scanner;
import java.util.ArrayList;

public class StudentTracker {
    public static void main(String[] args) {
        // Point 5: Interface is console-based
        Scanner textInput = new Scanner(System.in);
        Scanner numInput = new Scanner(System.in);
        
        // Point 3: Use ArrayLists to store and manage data
        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> grades = new ArrayList<>();
        
        System.out.println("--- 🖥️ CodeAlpha Student Grade Management System ---");
        System.out.println("Follow the steps to input student data. Type 'done' to finish.");

        // Point 1: Build a program to input and manage student grades
        while (true) {
            System.out.print("\nEnter Student Name: ");
            String name = textInput.nextLine(); 
            
            if (name.equalsIgnoreCase("done")) {
                break; 
            }

            System.out.print("Enter " + name + "'s grade (0-100): ");
            
            if (numInput.hasNextInt()) {
                int score = numInput.nextInt();
                
                if (score >= 0 && score <= 100) {
                    names.add(name); // Managing data
                    grades.add(score); // Managing data
                } else {
                    System.out.println("⚠️ Please enter a grade between 0 and 100.");
                }
            } else {
                System.out.println("❌ Invalid input! Please enter a number.");
                numInput.next(); 
            }
        }

        // Point 4: Display a summary report of all students
        if (names.isEmpty()) {
            System.out.println("\nNo student records found.");
        } else {
            System.out.println("\n--- 📋 SUMMARY REPORT ---");
            int total = 0;
            
            // Point 2: Preparation for calculating highest and lowest
            int highest = grades.get(0);
            int lowest = grades.get(0);

            for (int i = 0; i < names.size(); i++) {
                int currentGrade = grades.get(i);
                System.out.println("Student: " + names.get(i) + " | Grade: " + currentGrade);
                
                total += currentGrade;
                
                // Point 2: Calculate highest score
                if (currentGrade > highest) {
                    highest = currentGrade;
                }
                // Point 2: Calculate lowest score
                if (currentGrade < lowest) {
                    lowest = currentGrade;
                }
            }

            // Point 2: Calculate average score
            double average = (double) total / grades.size();

            System.out.println("\n--- 📊 CALCULATED STATISTICS ---");
            System.out.println("Average Class Score: " + String.format("%.2f", average));
            System.out.println("Highest Score:       " + highest);
            System.out.println("Lowest Score:        " + lowest);
            System.out.println("--------------------------------");
        }
    }
}
