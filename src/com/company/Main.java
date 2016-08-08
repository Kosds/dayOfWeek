package com.company;

public class Main {
    static class myDate {
        public int day;
        public int month;
        public int year;
        public myDate(int day, int month, int year){
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }
    static myDate parse(String date){
        int firstDot = date.indexOf('.'),
            secondDot = date.indexOf('.', firstDot+1),
            day = new Integer(date.substring(0,firstDot)),
            month = new Integer(date.substring(firstDot+1,secondDot)),
            year = new Integer(date.substring(secondDot+1));
        return new myDate(day,month,year);
    }
    static int getCodeOfMonth(int month){
        if(month == 4 || month ==7){
            return 0;
        } else if(month == 1 || month == 10){
            return 1;
        } else if(month == 5){
            return 2;
        } else if(month == 8){
            return 3;
        } else if(month == 2 || month == 3 || month == 11){
            return 4;
        } else if(month == 6){
            return 5;
        } else if(month == 12 || month == 9){
            return 6;
        } else return -1;
    }
    static int getCodeOfYear(int year){
        int codeOfCentury = (3 - ((year / 100) % 4)) * 2;
        return (codeOfCentury + year % 100 + (year % 100) / 4) % 7;
    }
    static int dayOfWeek(String stringDate){
        myDate date = parse(stringDate);
        int codeOfMonth = getCodeOfMonth(date.month),
            codeOfYear = getCodeOfYear(date.year);
        return (date.day + codeOfMonth + codeOfYear - 2) % 7 + 1;
    }
    public static void main(String[] args) {
	    System.out.println(dayOfWeek("21.09.451"));
    }
}
