package menu;

import com.turing.api.enums.Messenger;

import java.sql.SQLException;
import java.util.List;

public class MenuServiceImpl implements MenuService {
    private static MenuService instance = new MenuServiceImpl();
    MenuRepository repository;
    private MenuServiceImpl() {
        this.repository = MenuRepository.getInstance();
    }

    public static MenuService getInstance() {
        return instance;
    }


    @Override
    public String printMain(Menu menu) throws SQLException {
        return repository.printMain(menu);
    }

    @Override
    public void createMenus() throws SQLException {
        repository.createMenus();
    }

    @Override
    public void insertMenus() throws SQLException {
        String[] categories = {"navigate", "user", "account", "article", "board", "soccer"};
        String[][] menus = {{"x", "usr", "acc", "cwl", "art", "bbs","scc"},
                {"x", "mk", "joi", "log", "cat :", "ch-pw", "rm",
                        "ls-a", "ls-n", "ls-job", "cnt"},
                {"x", "mk", "touch", "with", "depo", "bal", "rm", "cat", "ls-a"},
                {"x", "mk"},
                {"x", "mk"},
                {"x", "mk"},
        };

        for(int i = 0; i < menus.length; i++)
            for(int j = 0; j < menus[i].length; j++)
                repository.insertMenus(Menu.builder().category(categories[i]).item(menus[i][j]).build());
    }

    @Override
    public void deleteMenus() throws SQLException {
        repository.deleteMenus();
    }
    @Override
    public Messenger returnMessenger() throws SQLException {
        return repository.returnMessenger();
    }

    @Override
    public Menu returnOneMenu() throws SQLException {
        return repository.returnOneMenu();
    }

    @Override
    public List<?> returnAllMenus() throws SQLException {
        return repository.returnAllMenus();
    }

}
