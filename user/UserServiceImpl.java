package user;


import account.Account;
import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import enums.Messenger;

import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    Map<String, User> users;
    UserRepository repository;
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
        this.repository = UserRepository.getInstance();
        this.users = new HashMap<>();
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Messenger save(User user) throws SQLException {

        users.put(user.getUsername(), user);
        return repository.saveUsers(user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword().equals(user.getPassword()) ? "로그인 성공" : "로그인 실패";
    }


    @Override
    public Optional<User> findById(Long id) {
        return Optional.of(users
                .values()
                .stream()
                .filter(i -> i.getId().equals(id))
                .collect(Collectors.toList()).get(0));

    }


    @Override
    public String updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());
//        users.get(user.getUsername()).setPassword(user.getPassword());
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword().isEmpty() ? "변경실패" : "변경완료";


    }

    @Override
    public String delete(User user) {
        users.remove(user.getUsername());
        return "삭제완료";
    }

    @Override
    public Boolean existsById(Long id) {
        return users.containsKey(id);
    }

    @Override
    public List<?> findUserByName(String name) {
        return users
                .values()
                .stream()
                .filter(i -> i.getName().equals(name))
                .collect((Collectors.toList()));
    }


    @Override
    public List<?> findUserByJob(String job) {
        return users
                .values()
                .stream()
                .filter(i -> i.getJob().equals(job))
                .collect((Collectors.toList()));
    }

    @Override
    public String test() {
        return repository.test();
    }

    @Override
    public List<?> findUsers() throws SQLException {
        return repository.findUsers();
    }

    @Override
    public User getUser(String id) {
        return repository.getuser(id);
    }

    public Map<String, ?> findUserByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i -> i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public String count() {
        return users.size() + "";
    }

    @Override
    public Optional<User> getOne(String id) throws SQLException {
        return Optional.of(users.get(id));
    }

    @Override
    public String addUsers() {

        IntStream.range(0, 5)
                .mapToObj(i -> UtilServiceImpl.getInstance().createRandomUsername())
                .forEach(i -> users.put(i, User.builder()
                        .username(i)
                        .password("1")
                        .name(UtilServiceImpl.getInstance().createRandomName())
                        .job(UtilServiceImpl.getInstance().createRandomJob())
                        .build()));

        return "5명 추가";
    }

    public String touchTable() throws SQLException {
        return repository.touchTable();
    }

    @Override
    public String removeTable() throws SQLException {
        return repository.removeTable();
    }
}
