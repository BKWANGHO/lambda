package user;


import enums.Messenger;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class UserController {
    UserServiceImpl service;

    public UserController() {
        this.service = UserServiceImpl.getInstance();
    }

    public Messenger join(Scanner sc) throws SQLException {

        return service.save(User.builder()
                .username(sc.next())
                .password(sc.next())
                .name(sc.next())
                .phone(sc.next())
                .job(sc.next())
                .height(sc.nextInt())
                .weight(sc.nextInt())
                .build());
    }

    public String login(Scanner sc) {
        return service.login(User.builder()
                .username(sc.next())
                .password(sc.next())
                        .build()
                );
    }

    public Optional<User> findUserBYId(Scanner sc) {
        return service.findById(Long.parseLong(sc.next()));
    }

    public String addUsers() {
        return service.addUsers();
    }


    public String updatePassword(Scanner sc) {


        return service.updatePassword(User.builder()
                .username(sc.next())
                .password(sc.next())
                .build()
        );
    }
    public String deleteUser(Scanner sc) {

        return service.delete(User.builder()
                .username(sc.next())
                .build()
        );
    }

    public List<?> getUserList() {

        return service.findAll();
    }

    public List<?> findUserByName(Scanner sc) {
        return service.findUserByName(sc.next());

    }


    public List<?> findUserByJob(Scanner sc) {
        return service.findUserByJob(sc.next());
    }
//    public Map<String,?> findUserByJob(Scanner sc) {
//        return service.findUserByJobFromMap(sc.next());
//    }
    public String countUser() {
        return service.count();
    }

    public Optional<User> getOne(Scanner sc) throws SQLException {
        return service.getOne(sc.next());
    }

    public String test() {
        return service.test();
    }

    public List<?> findUsers() throws SQLException {

        return service.findUsers();
    }

    public User getUser(Scanner sc) {

        return service.getUser(sc.next());
    }

    public Messenger touchTable() throws SQLException {
        return service.touchTable();
    }

    public String removeTable() throws SQLException {
        return service.removeTable();
    }
}
