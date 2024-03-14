package menu;

import java.sql.SQLException;

public class MenuController {

    private static MenuController instance = new MenuController();
    private MenuService service;
    private MenuController() {
        this.service = MenuServiceImpl.getInstance();
    }

    public static MenuController getInstance() {
        return instance;
    }


    public String printMain() throws SQLException {
        return service.printMain();
    }
}
