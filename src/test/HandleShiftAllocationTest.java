package test;

import entity.Shift;
import entity.Staff;
import handleShiftAllocation.handleShiftAllocationDao;
import handleShiftAllocation.handleShiftAllocationService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class HandleShiftAllocationTest {

    private handleShiftAllocationService handleShiftAllocationService;



    @Before
    public void initial(){
        handleShiftAllocationService = new handleShiftAllocationService();
    }

    @Test
    public void testAcceptShiftAllocation(){
        handleShiftAllocationService.AcceptAllocation(15, 9);
        ArrayList<Shift> staffList = handleShiftAllocationService.getStaffList();
        for (Shift shift : staffList) {
            if (shift.getId() == 9){
                Assert.assertEquals(shift.getStatus(), 2);
            }
        }

    }

    @Test
    public void testRejectShiftAllocation(){
        handleShiftAllocationService.RejectAllocation(15, 9);
        ArrayList<Shift> staffList = handleShiftAllocationService.getStaffList();
        for (Shift shift : staffList) {
            if (shift.getId() == 9){
                Assert.assertEquals(shift.getStatus(), 3);
            }
        }

    }


}
