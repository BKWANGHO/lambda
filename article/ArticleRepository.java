package article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    private Connection conn;

    private final static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private ArticleRepository() throws SQLException {
        this.conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing", "password");
    }
    public static ArticleRepository getInstance(){
        return instance;
    }

    public List<?> findAll() throws SQLException {
        String sql = "select * from articles";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        List<Article> ls = new ArrayList<>();
        if(rs.next()) {
            do {
                ls.add(Article.builder()
                                .id(rs.getLong("id"))
                                .title(rs.getString("Title"))
                                .content(rs.getString("content"))
                                .writer(rs.getString("Writer"))
                                .registerDate(rs.getString("register_date"))
                                .build());

            } while (rs.next());
        }else {
            System.out.println("데이터가 없습니다.");
        }
        rs.close();;
        pstmt.close();
        conn.close();

        return ls;
    }
}
