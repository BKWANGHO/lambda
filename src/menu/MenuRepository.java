package menu;

import com.turing.api.enums.Messenger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public String printMain(Menu menu) throws SQLException {
        String sql = "select item from menus where categories = '" + menu.getCategory()+"'";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        String categorym="";
        if (rs.next()) {
            do {
                categorym+=rs.getString("item")+"\n";
            } while (rs.next());
        } else {
            System.out.println("데이터 없음");
        }
        pstmt.close();
        return categorym;
    }

    public void createMenus() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS menus (\n" +
                "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                "    categories VARCHAR(20) NOT NULL,\n" +
                "    item VARCHAR(20) NOT NULL\n" +
                ");";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }


    public void insertMenus(Menu menu) throws SQLException {
        String sql = "INSERT INTO menus(categories,item) VALUES(?,?);";

        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, menu.getCategory());
        pstmt.setString(2, menu.getItem());
        pstmt.executeUpdate();

    }
    public void deleteMenus() throws SQLException {
        String sql = "DROP TABLE IF EXISTS menus;";
        pstmt = conn.prepareStatement(sql);
        pstmt.executeUpdate();
    }

    public Messenger returnMessenger() throws SQLException {
        String sql = "";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        return Messenger.SUCCESS;
    }

    public Menu returnOneMenu() throws SQLException {
        String sql = "";
        pstmt = conn.prepareStatement(sql);
        Menu menu = Menu.builder().build();
        return menu;
    }

    public List<?> returnAllMenus() throws SQLException {
        String sql = "select * from menus where categories = 'navigate'";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<Menu> ls = new ArrayList<>();

        if(rs.next()){
            do{
                Menu m = Menu.builder()
                        .item(rs.getString("item"))
                        .category(rs.getString("categories"))
                        .build();
                ls.add(m);
            }while(rs.next());
        }else {
            System.out.println("NO Data");
        }

        return ls;
    }
    /**
     * 공통 메뉴 명령어 정의
     * x means 'Exit'
     * mk means 'Create Table'
     * cat means 'Find The One'
     * touch means 'Insert One'
     * ch-* means 'Change What'
     * rm means 'Delete Row'
     * ls-a means 'All List'
     * ls-n means 'Find By Name'
     * ls-* means 'Something List'
     * cnt means 'Count'
     * 이 외에 일상적이 아닌 단어는 약어 사용
     * withdraw -> with
     * deposit -> depo
     * balance -> bal
     * */
}

