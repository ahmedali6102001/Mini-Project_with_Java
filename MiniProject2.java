package miniproject2;
import java.util.Scanner;
public class MiniProject2 {
    public static void main(String[] args) {
        Reservation obj = new Reservation();
    }
}
interface Airport {
    public void setAvailableTrips(String availableTrips[]);
    public String[] getAvailableTrips();
}
interface Flight extends Airport {
    public void setTo(String to);
    public void setFrom(String from);
    public void setTakeOff(double takeOff);
    public void setArrival(double arrival);
    public void setTripNum(double tripNum);
    public void setPlaneNum(double planeNum);
    public void setCapacity(int capacity);
    public void setTripCost(double tripCost);
    public String getTo();
    public String getFrom();
    public double getTakeOff();
    public double getArrival();
    public double getTripNum();
    public double getPlaneNum();
    public int getCapacity();
    public double getTripCost();
}
interface ScheduledFlight extends Flight {
    public String getDate();
    public void setDate(String date);
}
interface Person {
    public void setName(String name);
    public void setAddress(String address);
    public String getName();
    public String getAddress();
}
interface Passenger extends Person {
    public void setPassNum(double passNum);
    public double getPassNum();
}
class Reservation implements Passenger, ScheduledFlight {
    Scanner in = new Scanner(System.in);
    private String to, from, name, date, address, day;
    private int capacity;
    private double takeOff, arrival, tripNum, planeNum, tripCost, passNum;
    private final String availableTripsfrom[] = {"Egypt", "Morocco", "Saudi Arabia", "Germany", "Spain", "France", "USA", "Kuwait", "England", "Norway", "Sweden", "Canada"};
    private String[] availableTrips;
    private static int ticketNum = 0;
    public Reservation() {
        int x, y, choose;
        do {
            System.out.println("Ticket : 1\t\t End : 2");
            System.out.print("enter your choose : ");
            choose=in.nextInt();
            System.out.println();
            if(choose!=1){
                if(choose==2){continue;}
                else{
                    System.out.println("Wrong choose...try again\n");
                    continue;
                }
            }
            System.out.println("\t\t Welcome To Our Airport System");
            System.out.print("Please Enter your Name : ");
            
            String n = in.nextLine();
            n = in.nextLine();
            this.setName(n);
            System.out.print("Please Enter your Address : ");
            n = in.nextLine();
            this.setAddress(n);
            do {
                do {
                    System.out.println("\nplease enter the country that you want travell from");
                    for (int i = 0; i < availableTripsfrom.length; i++) {
                        System.out.print((i + 1) + " : " + availableTripsfrom[i] + "\t");
                        if (i == 0) {
                            continue;
                        }
                        if (i % 3 == 0) {
                            System.out.println();
                        }
                    }
                    System.out.print("\nyour choose : ");
                    x = in.nextInt();
                    if (x <= 0 || x > 12) {
                        System.out.println("Wrong choose...try again\n");
                    }
                } while (x <= 0 || x > 12);
                do {
                    System.out.println("\nplease enter the country that you want travell to");
                    for (int i = 0; i < availableTripsfrom.length; i++) {

                        System.out.print((i + 1) + " : " + availableTripsfrom[i] + "\t");
                        if (i == 0) {
                            continue;
                        }
                        if (i % 3 == 0) {
                            System.out.println();
                        }
                    }
                    System.out.print("\nyour choose : ");
                    y = in.nextInt();
                    if (y <= 0 || y > 12) {
                        System.out.println("Wrong choose...try again\n");
                    }
                } while (y <= 0 || y > 12);
                if (x == y) {
                    System.out.println("Can't travell to and from the same country...try again\n\n");
                }
            } while (x == y);
            this.setTo(availableTripsfrom[y - 1]);
            this.setFrom(availableTripsfrom[x - 1]);
            this.setDate(this.randomDate());
            this.setTakeOff(this.randomTakeOff());
            this.setArrival(this.randomArrival(this.takeOff));
            this.setTripNum(this.randomTripNum());
            this.setTripCost(this.randomTripCost());
            this.setPlaneNum(this.randomPlaneNum());
            this.setCapacity(this.defaultCapacity());
            this.setPassNum(this.randomPassNum());
            this.setDay();
            this.ticketNum++;
            this.printTicket();
        } while (choose != 2);
    }
    public void printTicket() {
        System.out.println("*******************************************");
        System.out.println("*******************************************");
        System.out.println("\t\t Ticket");
        System.out.println("Name : " + this.getName());
        System.out.println("Passenger Number : " + this.setPassNum());
        System.out.println("Address : " + this.getAddress());
        System.out.println("to : " + this.getTo());
        System.out.println("from : " + this.getFrom());
        System.out.println("Cost : " + this.getTripCost()+"$");
        System.out.println("Trip Number : " + this.getTripNum());
        System.out.println("TakeOff Time : " + this.getTakeOff());
        System.out.println("Arrival Time : " + this.getArrival());
        System.out.println("Date : " + this.getDate());
        System.out.println("Day : " + this.getDay());
        System.out.println("Plane Number : " + this.getPlaneNum());
        System.out.println("Plane Capacity : " + this.getCapacity());
        System.out.println("Ticket Number: " + this.getTicketNum());
        System.out.println("*******************************************");
        System.out.println("*******************************************");
    }
    public String getDay() {
        return day;
    }
    public void setDay() {
        String arr[] = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int i = (int) ((Math.round((Math.random() * ((30 - 0) + 1)) + 0))) % arr.length;
        this.day = arr[i];
    }
    public static int getTicketNum() {
        return ticketNum;
    }
    public String[] getAvailableTrips() {
        return availableTrips;
    }
    public void setAvailableTrips(String[] availableTrips) {
        this.availableTrips = availableTrips;
    }
    public String getTo() {
        return to;
    }
    public void setTo(String to) {
        this.to = to;
    }
    public String getFrom() {
        return from;
    }
    public void setFrom(String from) {
        this.from = from;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public double getTakeOff() {
        return takeOff;
    }
    public void setTakeOff(double takeOff) {
        this.takeOff = takeOff;
    }
    public double getArrival() {
        return arrival;
    }
    public void setArrival(double arrival) {
        this.arrival = arrival;
    }
    public double getTripNum() {
        return tripNum;
    }
    public void setTripNum(double tripNum) {
        this.tripNum = tripNum;
    }
    public double getPlaneNum() {
        return planeNum;
    }
    public void setPlaneNum(double planeNum) {
        this.planeNum = planeNum;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public double setPassNum() {
        return passNum;
    }
    public void setPassNum(double passNum) {
        this.passNum = passNum;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public double getTripCost() {
        return tripCost;
    }
    public void setTripCost(double tripCost) {
        this.tripCost = tripCost;
    }
    public String randomDate() {
        return Math.round((Math.random() * ((30 - 0) + 1)) + 0) + "-Dec-2022";
    }
    public double randomTakeOff() {
        return Math.round((Math.random() * ((24 - 0) + 1)) + 0);
    }
    public double randomArrival(double takeOff) {
        double arrival = Math.round(takeOff + ((Math.random() * ((5 - 0) + 1)) + 0));
        if (arrival > 24) {
            arrival -= 24;
        }
        return arrival;
    }
    public double randomTripNum() {
        return Math.round((Math.random() * ((300 - 200) + 1)) + 200);
    }
    public double randomPlaneNum() {
        return Math.round((Math.random() * ((2000 - 1000) + 1)) + 1000);
    }
    public int defaultCapacity() {
        return 500;
    }
    public double randomPassNum() {
        return Math.round((Math.random() * ((500 - 0) + 1)) + 0);
    }
    public double randomTripCost() {
        return Math.round((Math.random() * ((800 - 300) + 1)) + 300);
    }
    public double getPassNum() {
        return this.passNum;
    }
}