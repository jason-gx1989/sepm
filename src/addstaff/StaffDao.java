package addstaff;

import common.utils.DBExecuteUtils;
import entity.Staff;

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
        String sql = "INSERT INTO Staff(id, fullName, password, isPasswordUpdated, mobileNumber, email, createTime, " +
                "workHourLimit, preferredName, homeAddress) VALUES " + "('" + staff.getId() + "','" + staff.getFullName()
                + "','" + staff.getPassword() + "','" + staff.getIsPasswordUpdated() + "','" + staff.getMobileNumber()
                + "','" + staff.getEmail() + "','" + staff.getCreateTIme() + "','" + staff.getWorkHourLimit() + "','"
                + staff.getPreferredName() + "','" + staff.getHomeAddress() +"')";

        return DBExecuteUtils.update(sql);

    }

}
