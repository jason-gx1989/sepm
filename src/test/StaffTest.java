package test;

import addstaff.StaffService;
import common.utils.DBExecuteUtils;
import entity.Staff;
import entity.Staff;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StaffTest {

    private StaffService staffService;
    private Staff staff;


    @Before
    public void initial(){
        staffService = new StaffService();
        staff = new Staff();

    }

    @Test
    public void testCreateStaff(){

        staff.setFullName("test2");
        staff.setPassword("123234");
        staff.setMobileNumber("13567765785");
        staff.setEmail("32354346@gmail.com");
        staff.setPreferredName("alice");
        staff.setHomeAddress("wewqrwe");

        staffService.createStaff(staff.getFullName(),staff.getPassword(), staff.getMobileNumber(), staff.getEmail(),staff.getPreferredName(), staff.getHomeAddress());
        String sql = " select * from staff where mobileNumber  = " + staff.getMobileNumber();
        Staff rs = DBExecuteUtils.queryStaff(sql);

        Assert.assertEquals(staff.getFullName(), rs.getFullName());
        Assert.assertEquals(staff.getPassword(), rs.getPassword());
        Assert.assertEquals(staff.getMobileNumber(), rs.getMobileNumber());
        Assert.assertEquals(staff.getEmail(), rs.getEmail());
        Assert.assertEquals(staff.getPreferredName(), rs.getPreferredName());
        Assert.assertEquals(staff.getHomeAddress(), rs.getHomeAddress());


    }
}
