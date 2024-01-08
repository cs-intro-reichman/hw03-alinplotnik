/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar1 {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
    static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) {
        int wantedYear = Integer.parseInt(args[0]);
	    int debugDaysCounter = 0; 
		int totalSundays = 0;

        while (year <= wantedYear) {
            
            advance();
            debugDaysCounter++;

            if ( year == wantedYear ){

            if (dayOfWeek == 1) {
                System.out.println(dayOfMonth + "/" + month + "/" + year + " Sunday");
				if ( dayOfMonth == 1 ){
                totalSundays++;
				}
            } else {
                System.out.println(dayOfMonth + "/" + month + "/" + year);
            }
        }
    }		
}
	 
	 private static void advance() {
        // Increase day of the week
        dayOfWeek = (dayOfWeek % 7) + 1;
        
        // Increase day of the month
        dayOfMonth = (dayOfMonth % nDaysInMonth) + 1;
        
        // Increase month of the year
        if (dayOfMonth == 1) {
            month = (month % 12) + 1;
            nDaysInMonth = nDaysInMonth(month, year);
        }
        
        // Increase year of the century
        if (month == 1 && dayOfMonth == 1) {
            year++;
        }
    } 
		 
    // Returns true if the given year is a leap year, false otherwise.
	public static boolean isLeapYear(int year) {
		return ((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0));
	}
	 
	// Returns the number of days in the given month and year.
	// April, June, September, and November have 30 days each.
	// February has 28 days in a common year, and 29 days in a leap year.
	// All the other months have 31 days.
	public static int nDaysInMonth(int month, int year) {
		if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        } else {
            return 31;
        }
   }
}