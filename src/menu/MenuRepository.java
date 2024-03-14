package menu;

import java.sql.*;
import java.util.stream.Stream;

public class MenuRepository {
    private static MenuRepository instance;

    static {
        try {
            instance = new MenuRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;
    private MenuRepository() throws SQLException {
        this.conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing", "password");
        this.pstmt = null;
        this.rs = null;
    }

    public static MenuRepository getInstance() {
        return instance;
    }





    public String printMain() throws SQLException {
        String sql = "SELECT item\n" +
                "from menus \n" +
                "WHERE category = 'main';";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        String print ="";
         while (rs.next()) {
             int i =1;
            print += (rs.getString(i)+"\t");
        }
        return print;
    }
}
