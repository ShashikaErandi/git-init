/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package communicationapp.Controller;

import communicationapp.DB.DBConnection;
import communicationapp.Model.LoginModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author BScIT
 */
public class LoginController {

    public static LoginModel login(String UserID, String pass) throws ClassNotFoundException, SQLException {
        String sql = "select* from userLogin where userID = '" + UserID + "'";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        ResultSet rst = stm.executeQuery(sql);
        if (rst.next()) {
            LoginModel lm = new LoginModel(rst.getString("userID"), rst.getString("password"), rst.getString("status"));
            return lm;
        } else {
            return null;
        }

    }

//    public static LoginModel forgetPass(String userName, String pass, String reEnter, String secNo) throws ClassNotFoundException, SQLException {
//        String sql = "select* from login where user_id = '" + userName + "'";
//        Connection conn = DBConnection.getDBConnection().getConnection();
//        Statement stm = conn.createStatement();
//        ResultSet rst = stm.executeQuery(sql);
//        if (rst.next()) {
//            LoginModel lm = new LoginModel(rst.getString("user_id"), rst.getString("password"), rst.getString("status"), rst.getString("security_no"));
//            return lm;
//        } else {
//            return null;
//        }
//    }

    public static int setPassword(LoginModel login) throws ClassNotFoundException, SQLException {
        String sql = "Insert into login values('"+login.getPassword()+")";
        Connection conn = DBConnection.getDBConnection().getConnection();
        Statement stm = conn.createStatement();
        int res = stm.executeUpdate(sql);
        return res;
    }

   

}
