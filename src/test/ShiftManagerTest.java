package test;

import addshiftManager.ShiftManagerDao;
import addshiftManager.ShiftManagerService;
import common.utils.DBExecuteUtils;
import entity.ShiftManager;
import entity.Staff;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ShiftManagerTest {

    private ShiftManagerService shiftManagerService;
    private ShiftManager shiftManager;


    @Before
    public void initial(){

        shiftManagerService = new ShiftManagerService();
        shiftManager = new ShiftManager();
    }

    @Test
    public void testCreateShiftManager() throws SQLException {

        shiftManager.setFullName("test2");
        shiftManager.setPassword("123234");
        shiftManager.setMobileNumber("13567765785");
        shiftManager.setEmail("32354346@gmail.com");

        shiftManagerService.addShiftManager(shiftManager.getFullName(),shiftManager.getPassword(), shiftManager.getMobileNumber(), shiftManager.getEmail());
        String sql = " select * from shiftManager where mobileNumber  = " + shiftManager.getMobileNumber();
        ShiftManager rs = DBExecuteUtils.queryShiftManager(sql);


        Assert.assertEquals(shiftManager.getFullName(), rs.getFullName());
        Assert.assertEquals(shiftManager.getPassword(), rs.getPassword());
        Assert.assertEquals(shiftManager.getMobileNumber(), rs.getMobileNumber());
        Assert.assertEquals(shiftManager.getEmail(), rs.getEmail());

    }
}