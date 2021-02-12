package creational.prototype;

import java.util.Date;

public class PrototypeTest {

    public static void main(String[] args) {

        Approver manager = new Approver("Johny", "manager");
        LeaveApplication sickLeave =
                new LeaveApplication("Fever", new Date(2007, 3, 20), new Date(2007, 3, 22), manager);
        System.out.println(sickLeave);

        LeaveApplication casualLeave = sickLeave.clone();
        casualLeave.setReason("Vacation");
        casualLeave.setStartDate(new Date(2007, 10, 10));
        casualLeave.setEndDate(new Date(2007, 10, 20));
        System.out.println(casualLeave);
    }
}