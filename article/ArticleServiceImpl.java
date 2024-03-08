package article;

import common.AbstractService;
import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ArticleServiceImpl extends AbstractService implements ArticleService{

    private ArticleRepository repository;
    private final static ArticleService instance = new ArticleServiceImpl();

    private ArticleServiceImpl() {
        this.repository = ArticleRepository.getInstance();
    }
    public static ArticleService getInstance(){
        return instance;
    }



    @Override
    public Messenger save(Object o) {
        return null;
    }

    @Override
    public List findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return Optional.empty();
    }

    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional getOne(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public String delete(Object o) {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
