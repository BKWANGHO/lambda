package article;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {
    Connection connection;

    private static ArticleRepository instance;

    static {
        try {
            instance = new ArticleRepository();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private ArticleRepository() throws SQLException {
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/turingdb",
                "turing", "password");
    }
    public static ArticleRepository getInstance(){
        return instance;
    }

    public List<?> findArticles() throws SQLException {
        String sql = "select * from articles";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Article> list = new ArrayList<>();
        if(rs.next()) {
            do {
                list.add(Article.builder()
                                .id(rs.getLong("id"))
                                .title(rs.getString("Title"))
                                .content(rs.getString("content"))
                                .writer(rs.getString("Writer"))
                                .build());


//
////                System.out.printf(
//                        list.add("ID: %d\t Title : %s\t content: %s\t Writer: %s\n",
//                        rs.getInt("id"),
//                        rs.getString("Title"),
//                        rs.getString("content"),
//                        rs.getString("Writer")));

            } while (rs.next());
        }else {
            System.out.println("데이터가 없습니다.");
        }
        rs.close();;
        pstmt.close();
        connection.close();

        return list;
    }
}
