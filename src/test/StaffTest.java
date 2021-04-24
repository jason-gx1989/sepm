package test;

import addstaff.StaffService;
import entity.Staff;
import org.junit.Before;
import org.junit.Test;

public class StaffTest {

    private StaffService staffService;


    @Before
    public void initial(){
        staffService = new StaffService();

    }

    @Test
    public void testCreateStaff(){
    	
    	 staffService.createStaff("JUnit1", "1234", "12345576", "121234455@163.com", "alice", "ewwqrwr");
    	

       // int wwer = staffService.createStaff("JUnit1", "1234", "12345576", "121234455@163.com", "alice", "ewwqrwr");

    }
}
