
package user;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class UserRepository {

    Connection connection;
    private static UserRepository instance;

    static {
        try {
            instance = new UserRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private UserRepository() throws SQLException {
         this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                 "turing", "password");

    }
    public static UserRepository getInstance() {
        return instance;
    }
    public String test(){
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from board";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("연결완료");
        while ((rs.next())){
            System.out.printf("ID: %d\t Title : %s\t content: %s\t Writer: %s\n",
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4));

//        rs.next();
//        String name = rs.getString("name");
//        System.out.println(name);
        }

        rs.close();
        pstmt.close();
        connection.close();


    return null;
    }

    public User getuser(String id) {
//        User user =
        return null;
    }
}