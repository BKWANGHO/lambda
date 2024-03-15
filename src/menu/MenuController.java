package menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuController {

    private static MenuController instance = new MenuController();
    private MenuService service;
    private MenuController() {
        this.service = MenuServiceImpl.getInstance();
    }

    public static MenuController getInstance() {
        return instance;
    }


    public String printMain(String table) throws SQLException {
        return service.printMain(new Menu.MenuBuilder()
                .category(table)
                .build());
    }


    public void createMenus() throws SQLException {
         service.createMenus();
    }

    public void insertMenus() throws SQLException {
       service.insertMenus();
    }

    public void deleteMenus() throws SQLException {
        service.deleteMenus();
    }

    public Messenger returnMessenger() throws SQLException {
        return service.returnMessenger();
    }

    public Menu returnOneMenu() throws SQLException {
        return service.returnOneMenu();
    }

    public List<?> returnAllMenus() throws SQLException {
        return service.returnAllMenus();

    }
}
