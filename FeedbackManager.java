/* 
* Chase Batchelor
* CPSC-39
* Manages customer feedback by storing ratings in an ArrayList.
* Calculates and displays statistics such as total reviews and average rating.
*/

import java.util.ArrayList;

public class FeedbackManager {

    private static ArrayList<Integer> ratings = new ArrayList<>();

    public static void addRating(int rating) {
        ratings.add(rating);
    }

    /**
     * Algorithm: Average Calculation
     * - Iterates through ratings to compute mean score
     * - Time Complexity: O(n)
     */

    public static void displayStats() {
        if (ratings.size() == 0) {
            System.out.println("No feedback yet.");
            return;
        }

        int sum = 0;
        for (int r : ratings) {
            sum += r;
        }

        double avg = (double) sum / ratings.size();

        System.out.println("\n--- FEEDBACK STATS ---");
        System.out.println("Total Reviews: " + ratings.size());
        System.out.println("Average Rating: " + avg);
    }
}