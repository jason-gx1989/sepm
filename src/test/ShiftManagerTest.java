package test;

import addshiftManager.ShiftManagerService;
import addstaff.StaffService;
import entity.ShiftManager;
import org.junit.Before;
import org.junit.Test;

public class ShiftManagerTest {

    private ShiftManagerService shiftManagerService;


    @Before
    public void initial(){

        shiftManagerService = new ShiftManagerService();
    }

    @Test
    public void testCreateShiftManager(){

       shiftManagerService.addShiftManager("Junit1","123234","13567765785", "32354346@gmail.com");
    }
}
