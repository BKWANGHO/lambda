package menu;

import java.sql.SQLException;

public class MenuServiceImpl implements MenuService {
    private static MenuService instance = new MenuServiceImpl();
    private MenuRepository repository;
    private MenuServiceImpl() {
        this.repository = MenuRepository.getInstance();
    }

    public static MenuService getInstance() {
        return instance;
    }


    @Override
    public String printMain() throws SQLException {
        return repository.printMain();
    }
}
