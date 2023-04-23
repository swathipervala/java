package WFCSoftwareTest;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Weekend Fitness Club (WFC) requires software to manage bookings of group fitness lessons made by customers.
 * The club offers different fitness lessons on both Saturdays and Sundays with different prices. Each lesson 
 * can accommodate up to 5 customers, and there are 2 lessons per day on each weekend. Customers can view the 
 * timetable either by specifying the day or the fitness type. Customers can book as many lessons as they want 
 * but no duplicate booking is allowed, and they can change or cancel a booking provided that there are still 
 * spaces available. After each lesson, customers can write a review and provide a rating ranging from 1 to 5. 
 * The software must print reports containing the number of customers per lesson on each of the 8 days, along 
 * with the average rating of each lesson and the type of fitness lessons which generated the highest income. 
 * The deliverable includes designing 8 weekends of timetable covering at least 4 different types of fitness 
 * lessons with specified prices, and the final program should be self-contained without the need for an 
 * external database or security protocol.
 */
public class WFCSoftware {
    // Map to store the fitness lessons and their prices
    private static Map<String, Integer> lessonPrices = new HashMap<>();
    // Map to store the fitness lessons and their ratings
    private static Map<String, Integer> lessonRatings = new HashMap<>();
    // Map to store the fitness lessons and the number of customers
    private static Map<String, Integer> lessonCustomers = new HashMap<>();
    // List to store the booked lessons
    private static ArrayList<String> bookedLessons = new ArrayList<>();
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // Initialize the lessonPrices map
        lessonPrices.put("Yoga", 10);
        lessonPrices.put("Pilates", 15);
        lessonPrices.put("Zumba", 20);
        lessonPrices.put("Aerobics", 25);
        
        // Initialize the lessonRatings map
        lessonRatings.put("Yoga", 0);
        lessonRatings.put("Pilates", 0);
        lessonRatings.put("Zumba", 0);
        lessonRatings.put("Aerobics", 0);
        
        // Initialize the lessonCustomers map
        lessonCustomers.put("Yoga", 0);
        lessonCustomers.put("Pilates", 0);
        lessonCustomers.put("Zumba", 0);
        lessonCustomers.put("Aerobics", 0);
        
        try (// Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in)) {
            // Print the timetable
            printTimetable();
            
            // Prompt the user to book a lesson
            System.out.println("Please enter the name of the lesson you would like to book:");
            String lessonName = scanner.nextLine();
            
            // Check if the lesson is valid
            if (lessonPrices.containsKey(lessonName)) {
                // Check if the lesson is already booked
                if (bookedLessons.contains(lessonName)) {
                    System.out.println("Sorry, this lesson is already booked.");
                } else {
                    // Check if the lesson is full
                    if (lessonCustomers.get(lessonName) == 5) {
                        System.out.println("Sorry, this lesson is full.");
                    } else {
                        // Book the lesson
                        bookedLessons.add(lessonName);
                        int numCustomers = lessonCustomers.get(lessonName);
                        lessonCustomers.put(lessonName, numCustomers + 1);
                        System.out.println("Lesson booked successfully!");
                    }
                }
            } else {
                System.out.println("Sorry, this lesson is not available.");
            }
            
            // Prompt the user to rate the lesson
            System.out.println("Please rate the lesson (1-5):");
            int rating = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character
            
            // Update the rating
            final int totalRating = lessonRatings.get(lessonName);
            lessonRatings.put(lessonName, totalRating + rating);
        }
        
        // Print the reports
        printReports();
    }
    
    /**
     * Prints the timetable.
     */
    static void printTimetable() {
        System.out.println("Saturday");
        System.out.println("Yoga (10)");
        System.out.println("Pilates (15)");
        System.out.println("Sunday");
        System.out.println("Zumba (20)");
        System.out.println("Aerobics (25)");
    }
    
    /**
     * Prints the reports containing the number of customers per lesson on each of the 8 days, 
     * along with the average rating of each lesson and the type of fitness lessons which 
     * generated the highest income.
     */
    static void printReports() {
        // Print the number of customers per lesson
        System.out.println("Number of customers per lesson:");
        System.out.println("Yoga: " + lessonCustomers.get("Yoga"));
        System.out.println("Pilates: " + lessonCustomers.get("Pilates"));
        System.out.println("Zumba: " + lessonCustomers.get("Zumba"));
        System.out.println("Aerobics: " + lessonCustomers.get("Aerobics"));
        
        // Print the average rating of each lesson
        System.out.println("Average rating of each lesson:");
        // System.out.println("Yoga: " + lessonRatings.get("Yoga") / lessonCustomers.get("Yoga"));
        if (lessonCustomers.get("Yoga") > 0) {
            System.out.println("Yoga: " + lessonRatings.get("Yoga") / lessonCustomers.get("Yoga"));
        } else {
            System.out.println("Yoga: 0");
        }

        if (lessonCustomers.get("Pilates") > 0) {
            System.out.println("Pilates: " + lessonRatings.get("Pilates") / lessonCustomers.get("Pilates"));
        } else {
            System.out.println("Pilates: 0");
        }
        
        if (lessonCustomers.get("Zumba") > 0) {
            System.out.println("Zumba: " + lessonRatings.get("Zumba") / lessonCustomers.get("Zumba"));
        } else {
            System.out.println("Zumba: 0");
        }
        
        if (lessonCustomers.get("Aerobics") > 0) {
            System.out.println("Aerobics: " + lessonRatings.get("Aerobics") / lessonCustomers.get("Aerobics"));
        } else {
            System.out.println("Aerobics: 0");
        }        
        // System.out.println("Pilates: " + lessonRatings.get("Pilates") / lessonCustomers.get("Pilates"));
        // System.out.println("Zumba: " + lessonRatings.get("Zumba") / lessonCustomers.get("Zumba"));
        // System.out.println("Aerobics: " + lessonRatings.get("Aerobics") / lessonCustomers.get("Aerobics"));
        
        // Find the type of fitness lesson which generated the highest income
        int maxIncome = 0;
        String highestIncomeLesson = "";
        for (String lesson : lessonPrices.keySet()) {
            int income = lessonPrices.get(lesson) * lessonCustomers.get(lesson);
            if (income > maxIncome) {
                maxIncome = income;
                highestIncomeLesson = lesson;
            }
        }
        System.out.println("The type of fitness lesson which generated the highest income is " + highestIncomeLesson);
    }
}

