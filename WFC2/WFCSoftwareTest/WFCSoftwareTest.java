package WFCSoftwareTest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class WFCSoftwareTest {
    // Map to store the fitness lessons and their prices
    private static Map<String, Integer> lessonPrices = new HashMap<>();
    // Map to store the fitness lessons and their ratings
    private static Map<String, Integer> lessonRatings = new HashMap<>();
    // Map to store the fitness lessons and the number of customers

    @SuppressWarnings("unused")
    private static Map<String, Integer> lessonCustomers = new HashMap<>();
    // List to store the booked lessons
    private static ArrayList<String> bookedLessons = new ArrayList<>();

    @Test
    public void testLessonPrices() {
        // Test that the lessonPrices map is initialized correctly
        lessonPrices.put("Yoga", 10);
        lessonPrices.put("Pilates", 15);
        lessonPrices.put("Zumba", 20);
        lessonPrices.put("Aerobics", 25);
        assertEquals((Object)10, lessonPrices.get("Yoga"));
        assertEquals((Object)15, lessonPrices.get("Pilates"));
        assertEquals((Object)20, lessonPrices.get("Zumba"));
        assertEquals((Object)25, lessonPrices.get("Aerobics"));
    }
    

    @Test
    public void testLessonRatings() {
        // Test that the lessonRatings map is initialized correctly
        lessonRatings.put("Yoga", 3);
        lessonRatings.put("Pilates", 4);
        lessonRatings.put("Zumba", 5);
        lessonRatings.put("Aerobics", 2);
        assertEquals((Integer)3, lessonRatings.get("Yoga"));
        assertEquals((Integer)4, lessonRatings.get("Pilates"));
        assertEquals((Integer)5, lessonRatings.get("Zumba"));
        assertEquals((Integer)2, lessonRatings.get("Aerobics"));
    }
    

    @Test
    public void testLessonCustomers() {
        // Create a new HashMap to hold the customer counts for each lesson
        HashMap<String, Integer> lessonCustomers = new HashMap<String, Integer>();
    
        // Initialize the lessonCustomers map with default values of 0
        lessonCustomers.put("Yoga", 0);
        lessonCustomers.put("Pilates", 0);
        lessonCustomers.put("Zumba", 0);
        lessonCustomers.put("Aerobics", 0);
    
        // Assert that each value in the map is initialized to 0
        assertEquals(Integer.valueOf(0), lessonCustomers.get("Yoga"));
        assertEquals(Integer.valueOf(0), lessonCustomers.get("Pilates"));
        assertEquals(Integer.valueOf(0), lessonCustomers.get("Zumba"));
        assertEquals(Integer.valueOf(0), lessonCustomers.get("Aerobics"));
    }
    
    

    @Test
    public void testBookedLessons() {
        // Test that the bookedLessons list is initialized correctly
        assertTrue(bookedLessons.isEmpty());
        bookedLessons.add("Yoga");
        assertFalse(bookedLessons.isEmpty());
        assertEquals("Yoga", bookedLessons.get(0));
    }

    public class WFCSoftwareTestB {
        private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        private final InputStream inputStream = new ByteArrayInputStream("Yoga\n5\n".getBytes());
    
        @Before
        public void setUpStreams() {
            System.setOut(new PrintStream(outputStream));
            System.setIn(inputStream);
        }
    
        @Test
        public void testPrintTimetable() {
            WFCSoftware.printTimetable();
            String expectedOutput = "Saturday\nYoga (10)\nPilates (15)\nSunday\nZumba (20)\nAerobics (25)\n";
            Assert.assertEquals(expectedOutput, outputStream.toString());
        }
    
        @Test
        public void testPrintReports() {
            WFCSoftware.printReports();
            String expectedOutput = "Number of customers per lesson:\nYoga: 0\nPilates: 0\nZumba: 0\nAerobics: 0\n" +
                    "Average rating of each lesson:\nYoga: 0.0\nPilates: 0.0\nZumba: 0.0\nAerobics: 0.0\n" +
                    "Fitness lessons with highest income: Aerobics\n";
            Assert.assertEquals(expectedOutput, outputStream.toString());
        }
    
        @Test
        public void testMain() {
            WFCSoftware.main(new String[]{});
    
            String expectedOutput = "Saturday\nYoga (10)\nPilates (15)\nSunday\nZumba (20)\nAerobics (25)\n" +
                    "Please enter the name of the lesson you would like to book:\n" +
                    "Lesson booked successfully!\nPlease rate the lesson (1-5):\n" +
                    "Number of customers per lesson:\nYoga: 1\nPilates: 0\nZumba: 0\nAerobics: 0\n" +
                    "Average rating of each lesson:\nYoga: 5.0\nPilates: 0.0\nZumba: 0.0\nAerobics: 0.0\n" +
                    "Fitness lessons with highest income: Yoga\n";
            Assert.assertEquals(expectedOutput, outputStream.toString());
        }
    }
    
    
    

    
}