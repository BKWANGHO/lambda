package menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public interface MenuService {
    String printMain(Menu menu) throws SQLException;


    void createMenus() throws SQLException;

    void insertMenus() throws SQLException;

    void deleteMenus() throws SQLException;

    Messenger returnMessenger() throws SQLException;

    Menu returnOneMenu() throws SQLException;

    List<?> returnAllMenus() throws SQLException;
}
