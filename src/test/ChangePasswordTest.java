package test;

import addstaff.StaffDao;
import changePassword.ChangePasswordDao;
import changePassword.ChangePasswordService;
import common.junitUtils.StaffTestDao;
import entity.Staff;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChangePasswordTest {

    private ChangePasswordDao changePasswordDao;
    private ChangePasswordService changePasswordService;
    private StaffTestDao staffTestDao;

    @Before
    public void initial(){
        changePasswordDao = new ChangePasswordDao();
        changePasswordService = new ChangePasswordService();
        staffTestDao = new StaffTestDao();
    }

    @Test
    public void testChangePassword(){


        int test1 = changePasswordService.changePassword("test2", "zXC1230.$", "123"); // length < 8
        int test2 = changePasswordService.changePassword("test2", "zXC1230.$", "123456789"); // don't contain uppercase and lowercase letter
        int test3 = changePasswordService.changePassword("test2", "zXC1230.$", "1234z6789"); // don't contain uppercase letter
        int test4 = changePasswordService.changePassword("test2", "zXC1230.$", "1234A6789"); // don't contain uppercase  letter
        int test5 = changePasswordService.changePassword("test2", "zXC1230.$", "123Az6789"); // don't contain special characters
        int test6 = changePasswordService.changePassword("test9", "zXC1230.$", "123Az6789.$"); // The fullName has not been registered
        int test7 = changePasswordService.changePassword("test9", "wqewrret", "123Az6789.$"); // The old password is incorrect
        int test8 = changePasswordService.changePassword("test2", "zXC1230.$", "123Az6789.$");
        Staff test9 = staffTestDao.getByName("test2");
        Assert.assertEquals(-2, test1);
        Assert.assertEquals(-2, test2);
        Assert.assertEquals(-2, test3);
        Assert.assertEquals(-2, test4);
        Assert.assertEquals(-2, test5);
        Assert.assertEquals(-2, test6);
        Assert.assertEquals(-2, test7);
        Assert.assertEquals(0, test8);
        Assert.assertEquals("123Az6789.$", test9.getPassword());
    }
}
