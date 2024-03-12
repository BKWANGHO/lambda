
package com.turing.api.user;

import com.turing.api.enums.Messenger;

import java.sql.*;
import java.util.*;

public class UserRepository {

    private Connection connection;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private static final UserRepository instance;

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
        this.pstmt = null;
        this.rs = null;
    }

    public static UserRepository getInstance() {
        return instance;
    }

    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from users";
        pstmt = connection.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<User> ls = new ArrayList<>();
        if (rs.next()) {
            do {
                ls.add(User.builder()
                        .id(rs.getInt("id"))
                        .username(rs.getString("username"))
                        .password(rs.getString("password"))
                        .name(rs.getString("name"))
                        .phone(rs.getString("phone"))
                        .job(rs.getString("job"))
                        .height(rs.getDouble("height"))
                        .weight(rs.getDouble("weight"))
                        .build());
            } while ((rs.next()));
        } else {
            System.out.println("데이터가 없습니다.");
        }
//        rs.next();
//        String name = rs.getString("name");
//        System.out.println(name);
        return ls;
    }

    public User getuser(String id) {
        return null;
    }

    public Messenger touchTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    username VARCHAR(20) NOT NULL UNIQUE,\n" +
                "    password VARCHAR(20) NOT NULL,\n" +
                "    name VARCHAR(20),\n" +
                "    phone VARCHAR(20),\n" +
                "    job VARCHAR(20),\n" +
                "    height VARCHAR(20),\n" +
                "    weight VARCHAR(20)\n" +
                ");";
        pstmt = connection.prepareStatement(sql);

        return (pstmt.executeUpdate() == 0) ? Messenger.SUCCESS : Messenger.FAIL;
    }

    public String removeTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS Users;";
        pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
        return "회원테이블 삭제 성공";
    }

    public Messenger saveUsers(User user) throws SQLException {
        String sql = "insert into users(username, password, name" +
                ", phone, job, height,weight)" +
                "values (?,?,?,?,?,?,?)";
        pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getJob());
        pstmt.setDouble(6, user.getHeight());
        pstmt.setDouble(7, user.getWeight());

        pstmt.executeUpdate();
        return Messenger.SUCCESS;
    }


}