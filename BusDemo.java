import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Bus {
    private int busNo;
    private boolean Ac;
    private int Capacity;

    Bus(int busNo,boolean Ac,int Capacity) {
        this.busNo = busNo;
        this.Ac = Ac;
        this.Capacity = Capacity;
    }

    public void setbusNo(int busNo) {
        this.busNo = busNo;
    }

    public int getbusNo() {
        return busNo;
    }

    public void setAC(boolean Ac) {
        this.Ac = Ac;
    }

    public boolean getAC() {
        return Ac;
    }

    public void setCapacity(int Capacity) {
        this.Capacity = Capacity;
    }

    public int getCapacity() {
        return Capacity;
    }

    public void displayBusInfo() {
        System.out.println("Bus No : " + busNo + " " + "AC Seats : " + Ac + " " + "Capcity Seats Available : " + Capacity);
    }
}

class Booking {
    String PassengerName;
    int busNo;
    Date date;

    Booking() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the Passenger Name : ");
        PassengerName = scan.nextLine();
        System.out.println();
        System.out.println("Enter the Bus No : ");
        busNo = scan.nextInt();
        System.out.println();
        System.out.println("Enter the Date U Wantr to Travel (dd-mm-yyyy) : ");
        String dateinput = scan.next();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        try {
            date = dateFormat.parse(dateinput);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

        public boolean Available(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
            int Capacity = 0;
            
            for (Bus bus : buses) {
                if (bus.getbusNo() == busNo) {
                    Capacity = bus.getCapacity();
                }
            }

            int booked = 0;

            for (Booking book : bookings) {
                if (book.busNo == busNo && book.date.equals(date)) {
                    booked++;
                }
            }
            return booked<Capacity ? true : false;
        }
    }

class BusDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Bus> buses = new ArrayList<Bus>();
        ArrayList<Booking> bookings = new ArrayList<Booking>();

        buses.add(new Bus(1, true, 1));
        buses.add(new Bus(2, false, 5));
        buses.add(new Bus(3, true, 2));

        for (Bus b : buses) {
            b.displayBusInfo();
        }


        int userOpt = 1;

        while (userOpt == 1) {
            System.out.println("Press 1 To Book and 2 To Exit.");
            userOpt = sc.nextInt();

            if (userOpt == 1) {
                Booking booking = new Booking();
                if (booking.Available(bookings,buses)) {
                    bookings.add(booking);
                    System.out.println("Thanks For Booking us Ur Booking is Confirmed.........");
                }
                else {
                    System.out.println("Sorry, Ur pick the date of the bus is very full so u can try another bus and we have more speciality....");
                }
            }
        }
    }
}