package com.turing.api.user;
import com.turing.api.common.AbstractService;
import com.turing.api.common.UtilServiceImpl;
import com.turing.api.enums.Messenger;

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
        return repository.saveUsers(user);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Messenger login(User user) throws SQLException {
//        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
//                .getPassword().equals(user.getPassword()) ? "로그인 성공" : "로그인 실패";
        return repository.login(user);
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
    public Messenger updatePassword(User user) {
        users.get(user.getUsername()).setPassword(user.getPassword());
//        users.get(com.turing.api.user.getUsername()).setPassword(com.turing.api.user.getPassword());
        return users.getOrDefault(user.getUsername(), User.builder().password("").build())
                .getPassword().isEmpty() ? Messenger.SUCCESS : Messenger.FAIL;
    }

    @Override
    public Messenger delete(User user) {
        users.remove(user.getUsername());
        return users.get(user.getUsername()).equals("")? Messenger.SUCCESS:Messenger.FAIL;
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
    public Messenger findUsers() throws SQLException {
        return repository.findUsers();
    }

    @Override
    public Messenger getUser(String id) throws SQLException {
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

    public Messenger touchTable() throws SQLException {
        return repository.touchTable();
    }

    @Override
    public Messenger removeTable() throws SQLException {
        return repository.removeTable();
    }
}
