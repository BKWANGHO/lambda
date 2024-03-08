
package user;

import article.Article;
import enums.Messenger;

import java.sql.*;
import java.util.*;
import java.util.stream.Stream;

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

    public String test() {
        return "UserRepository 연결";
    }

    public List<?> findUsers() throws SQLException {
        String sql = "select * from users";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        System.out.println("연결완료");
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
        rs.close();
        pstmt.close();
//        connection.close();


        return ls;
    }

    public User getuser(String id) {
//        User user =
        return null;
    }

    public String touchTable() throws SQLException {
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
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.executeUpdate();
//        connection.close();
        pstmt.close();
        return "회원테이블 생성 성공";
    }

    public String removeTable() throws SQLException {
        String sql = "DROP TABLE IF EXISTS Users;";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        connection.prepareStatement(sql);
        pstmt.executeUpdate();

//        connection.close();
        pstmt.close();
        return "회원테이블 삭제 성공";
    }

    public Messenger saveUsers(User user) throws SQLException {
        String sql = "insert into users(username, password, name"+
        ", phone, job, height,weight)" +
                "values (?,?,?,?,?,?,?)";
//        String sql = "insert into users(username, password, name" +
//                ", phone, job, height, weight) " +
//                "VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);

//        Stream.of(user).flatMap()

        pstmt.setString(1, user.getUsername());
        pstmt.setString(2, user.getPassword());
        pstmt.setString(3, user.getName());
        pstmt.setString(4, user.getPhone());
        pstmt.setString(5, user.getJob());
        pstmt.setDouble(6, user.getHeight());
        pstmt.setDouble(7, user.getWeight());

        pstmt.executeUpdate();
//        connection.close();
        pstmt.close();
        return Messenger.SUCCESS;
    }
}