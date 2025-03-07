package employee.repository;

import common.ErrorCode;
import employee.vo.EmployeeVo;
import exception.EmployeeException;
import object.ObjectIo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class EmployeeUpdateRepoImp implements EmployeeUpdateRepo{
    Connection connection = ObjectIo.getConnection();
    CallableStatement cs = null;

    @Override

    public void update(EmployeeVo employeeVo) throws EmployeeException {

        String sql = "{ CALL EmployeeUpdate(?, ?, ?, ?, ?, ?, ?, ?, ?) }";

        try {
            cs = connection.prepareCall(sql);
            cs.setString(1, "employee");
            cs.setString(2, employeeVo.getName());
            cs.setInt(3, employeeVo.getEnteryear());
            cs.setInt(4, employeeVo.getEntermonth());
            cs.setInt(5, employeeVo.getEnterday());
            cs.setString(6, employeeVo.getRole());
            cs.setInt(7, employeeVo.getSecno());
            cs.setInt(8, employeeVo.getSalary());
            cs.setInt(9, employeeVo.getEno());

            cs.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            throw new EmployeeException(ErrorCode.DB_UPDATE_ERROR);
        } finally {
            try {
                if (cs != null) cs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
