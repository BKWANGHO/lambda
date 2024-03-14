package menu;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuController {

    private static MenuController instance = new MenuController();
    private MenuService service;
    private MenuController() {
        this.service = MenuServiceImpl.getInstance();
    }

    public static MenuController getInstance() {
        return instance;
    }


    public String printMain(Scanner sc) throws SQLException {
        return service.printMain(new Menu.MenuBuilder()
                .category(sc.next())
                .build());

    }


}
