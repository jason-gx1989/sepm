package test;

import addshift.AddShiftService;
import addstaff.StaffService;
import common.utils.DBExecuteUtils;
import common.utils.Utils;
import entity.Shift;
import entity.Staff;
import handleShiftAllocation.handleShiftAllocationDao;
import handleShiftAllocation.handleShiftAllocationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

public class HandleShiftAllocationTest {

    private handleShiftAllocationService handleShiftAllocationService;
    private Shift shift;
    private int shiftId;



    @Before
    public void initial(){

        String location = "MD";
        AddShiftService addShiftService = new AddShiftService();
  //      addShiftService.addShift("2021-04-25 00:00:00", "2021-04-26 00:00:00", "5", location, "Pause");
        handleShiftAllocationService = new handleShiftAllocationService();
        ArrayList<Shift> shiftList = handleShiftAllocationService.getShiftList();
        shift = shiftList.get(0);
        shiftId = shift.getId();


    }

    @Test
    public void testAcceptShiftAllocation(){
        handleShiftAllocationService.AcceptAllocation(shiftId, shift.getStaffAllocated());
        shift = handleShiftAllocationService.getShift(shift.getId());
        Assert.assertEquals(shift.getStatus(), 2);


    }

    @Test
    public void testRejectShiftAllocation(){
        handleShiftAllocationService.RejectAllocation(shiftId, shift.getStaffAllocated());
        shift = handleShiftAllocationService.getShift(shift.getId());
        Assert.assertEquals(shift.getStatus(), 3);

    }


}
