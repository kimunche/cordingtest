import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] today = br.readLine().split(" ");
        String[] dday = br.readLine().split(" ");

        int todayYear = Integer.parseInt(today[0]);
        int todayMonth = Integer.parseInt(today[1]);
        int todayDay = Integer.parseInt(today[2]);
        int dDayYear = Integer.parseInt(dday[0]);
        int dDayMonth = Integer.parseInt(dday[1]);
        int dDayDay = Integer.parseInt(dday[2]);


        // 오늘부터 D-Day까지 일수 계산
        int daysBetween = calculateDaysBetween(todayYear, todayMonth, todayDay, dDayYear, dDayMonth, dDayDay);

        // 출력
        if (dDayYear - todayYear > 1000 || (dDayYear - todayYear == 1000 && dDayMonth > todayMonth )
        || (dDayYear - todayYear ==1000 && dDayMonth ==todayMonth && dDayDay >= todayDay)) {
            System.out.println("gg");
        }
        else {
            System.out.print("D-" + daysBetween);
        }


    }

    private static int calculateDaysBetween(int year1, int month1, int day1, int year2, int month2, int day2) {
        int totalDays1 = calculateTotalDays(year1, month1, day1);
        int totalDays2 = calculateTotalDays(year2, month2, day2);
        return totalDays2 - totalDays1;
    }

    private static int calculateTotalDays(int year, int month, int day) {
        int totalDays = 0;
        for (int i = 1; i < year; i++) {
            totalDays += isLeapYear(i) ? 366 : 365;
        }
        for (int i = 1; i < month; i++) {
            totalDays += getDaysInMonth(year, i);
        }
        totalDays += day;
        return totalDays;
    }

    private static int getDaysInMonth(int year, int month) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}

