package menu;

import java.sql.*;
import java.util.stream.Stream;

public class MenuRepository {
    private static MenuRepository instance;

    {
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

    public String printMain(Menu menu) throws SQLException {
        String sql = "select *, category from " + menu.getCategory();
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        String categorym="";
        if (rs.next()) {
            do {

                categorym+=rs.getString("item")+"\t";
            } while (rs.next());
        } else {
            System.out.println("데이터 없음");
        }
        pstmt.close();
        return categorym;
    }
}

