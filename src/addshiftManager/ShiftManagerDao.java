package addshiftManager;

import common.utils.DBExecuteUtils;
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


        String sql = "INSERT INTO shiftManager(id, fullName, password, isPasswordUpdated, mobileNumber, email, createTime) VALUES "
                + "('" + shiftManager.getId() + "','" + shiftManager.getFullName() + "','" + shiftManager.getPassword() + "','" + shiftManager.getIsPasswordUpdated() 
                + "','" + shiftManager.getMobileNumber() + "','" + shiftManager.getEmail() + "','" + shiftManager.getCreateTIme() +"')";

        return DBExecuteUtils.update(sql);

    }
}
