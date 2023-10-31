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
}

class BusDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Bus> buses = new ArrayList<Bus>();

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
                System.out.println("Booking Confirmed........");
            }
        }
    }
}