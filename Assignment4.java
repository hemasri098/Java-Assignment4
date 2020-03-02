package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.Year;
import java.util.*;
import java.text.*;
import java.util.logging.Logger;

public class KYCForm {
    // setting date for the date in the of string using calendar class
    public static Calendar getDate(String []date) {
        Calendar setDate = Calendar.getInstance();
        setDate.set(Calendar.DATE, Integer.parseInt(date[0]));
        setDate.set(Calendar.MONTH, Integer.parseInt(date[1]) - 1);
        setDate.set(Calendar.YEAR, Integer.parseInt(date[2]));
        return setDate;
    }
    // checking whether signup date is not after current date
    public static boolean isAfter(Calendar signupDate, Calendar currentDate) {
        if (!signupDate.after(currentDate))
            return true;
        return false;
    }
    // checking whether current date is before signup date
    public static boolean isBefore(Calendar signupDate, Calendar currentDate) {
        if (currentDate.before(signupDate))
            return true;
        return false;
    }
    //returns starting date in the range
    public static Date getStartDate(Calendar signupDate, String []current) {
        Date startingDate;
        signupDate.set(Calendar.YEAR, Integer.parseInt(current[2]));  // setting signup year as current year
        signupDate.add(Calendar.DATE, -30);
        startingDate = signupDate.getTime();
        return startingDate;
    }
    //returns ending date in the range
    public static Date getEndDate(Calendar signupDate, Calendar currentDate) {
        Date endingDate;
        signupDate.add(signupDate.DATE, +60);
        if (isBefore(signupDate, currentDate)) {
            endingDate = currentDate.getTime();
        }
        else {
            endingDate = signupDate.getTime();
        }
        return endingDate;
    }
    // returns range of dates if not no range
    public static String provideRange(String []dates) {
        String range = "";
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        Date startingDate, endingDate;
        String[] signup = dates[0].split("-");
        String[] current = dates[1].split("-");
        Calendar signupDate = getDate(signup);
        Calendar currentDate = getDate(current);

        if (isAfter(signupDate, currentDate)) {
            startingDate = getStartDate(signupDate, current);
            endingDate = getEndDate(signupDate, currentDate);
            range = dateformat.format(startingDate) + " " + dateformat.format(endingDate);
        }
        else {
            range = "No range";
        }
        return range;
    }

    public static void main(String[] args) throws IOException {
        TestKYCForm testKycForm = new TestKYCForm();
        testKycForm.test();                         // testing
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Logger LOGGER = Logger.getAnonymousLogger();
        String[] testcases = br.readLine().split(" ");
        int testcasesRange = Integer.parseInt(testcases[0]);
        for (int i = 0; i < testcasesRange; i++) {
            String[] dates = br.readLine().split(" ");
            LOGGER.info(provideRange(dates));       // printing range
        }
    }
}
