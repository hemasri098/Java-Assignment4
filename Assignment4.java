package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.text.*;

public class Assignment4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] t = br.readLine().split(" ");
        int testcases = Integer.parseInt(t[0]);

        Calendar firstCalendar = Calendar.getInstance();
        Calendar lastCalendar = Calendar.getInstance();
        SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
        Date startingDate, endingDate;


        for (int i = 0; i < testcases; i++) {

            String[] dates = br.readLine().split(" ");
            String[] firstDate = dates[0].split("-");
            String[] lastDate = dates[1].split("-");
            firstCalendar.set(Calendar.DATE, Integer.parseInt(firstDate[0]));
            firstCalendar.set(Calendar.MONTH, Integer.parseInt(firstDate[1]) - 1);
            firstCalendar.set(Calendar.YEAR, Integer.parseInt(firstDate[2]));
            lastCalendar.set(Calendar.DATE, Integer.parseInt(lastDate[0]));
            lastCalendar.set(Calendar.MONTH, Integer.parseInt(lastDate[1]) - 1);
            lastCalendar.set(Calendar.YEAR, Integer.parseInt(lastDate[2]));

            if (!firstCalendar.after(lastCalendar)) {
                firstCalendar.set(Calendar.YEAR, Integer.parseInt(lastDate[2]));
                firstCalendar.add(Calendar.DATE, -30);
                startingDate = firstCalendar.getTime();
                System.out.print(dateformat.format(startingDate) + " ");
                firstCalendar.add(firstCalendar.DATE, +60);
                if (lastCalendar.before(firstCalendar)) {
                    endingDate = lastCalendar.getTime();
                } else {
                    endingDate = firstCalendar.getTime();
                }
                System.out.println(dateformat.format(endingDate));
            }
            else {
                System.out.println("No range");
            }

        }
    }
}