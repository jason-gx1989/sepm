package addshiftManager;

import common.utils.DBExecuteUtils;
import common.utils.Utils;
import entity.ShiftManager;


/**
 * ShiftManagerDao database table operation class
 */
public class ShiftManagerDao {

    /**
     * create a shiftManager in database
     * @param shiftManager shiftManager entity
     * @return Rows affected by update Operation, -1 for failure, 1 for success
     */
    public int addShiftManager(ShiftManager shiftManager){


    	String sql = "INSERT INTO shiftManager(fullName, password, isPasswordUpdated, mobileNumber, email, createTime) VALUES "
                + "('"  + shiftManager.getFullName() + "','" + shiftManager.getPassword() + "','" + shiftManager.getIsPasswordUpdated()
                + "','" + shiftManager.getMobileNumber() + "','" + shiftManager.getEmail() + "','" + Utils.getCurrentTime() +"')";
        return DBExecuteUtils.update(sql);

    }
}
