package geeksforgeeksZoho;

public class CalendarSum {

    public static void main(String[] args) {
        // Given information
        int startingDayOfWeek = 1; // 1 corresponds to Tuesday
        int targetDayNumber = 220;

        // Calculate the day of the week for the 220th day
        int dayOfWeek = findDayOfWeek(startingDayOfWeek, targetDayNumber);

        // Convert the numeric representation of the day to a string
        String dayOfWeekString = convertToDayString(dayOfWeek);

        // Output the result
        System.out.println("The day of the week for the 220th day is: " + dayOfWeekString);
    }

    // Method to find the day of the week for a given day number
    private static int findDayOfWeek(int startingDay, int targetDayNumber) {
        return (targetDayNumber) % 7;
    }

    // Method to convert numeric representation of the day to a string
    private static String convertToDayString(int dayOfWeek) {
        switch (dayOfWeek) {
            case 0:
                return "Sunday";
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            default:
                return "Invalid day";
        }
    }
}
