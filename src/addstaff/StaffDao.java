package addstaff;

import common.utils.DBExecuteUtils;
import common.utils.Utils;
import entity.Staff;
import java.text.SimpleDateFormat;
/**
 * Staff database table operation class
 */
public class StaffDao {

    /**
     * create a staff in database
     * @param staff staff entity
     * @return Rows affected by update Operation, -1 for failure, 1 for success
     */
	public int createStaff(Staff staff){


        String sql = "INSERT INTO Staff(fullName, password, isPasswordUpdated, mobileNumber, email, createTime, " +
                "workHourLimit, preferredName, homeAddress) VALUES " + "('"+ staff.getFullName()
                + "','" + staff.getPassword() + "','" + staff.getIsPasswordUpdated() + "','" + staff.getMobileNumber()
                + "','" + staff.getEmail() + "','" + Utils.getCurrentTime() +  "','" + staff.getWorkHourLimit() + "','"
                + staff.getPreferredName() + "','" + staff.getHomeAddress() +"')";

        return DBExecuteUtils.update(sql);

    }
}
