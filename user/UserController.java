package user;


import enums.Messenger;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UserController {
    UserServiceImpl service;

    public UserController() {
        this.service = UserServiceImpl.getInstance();
    }

    public Messenger join(Scanner sc) {

        return service.save(User.builder()
                .username(sc.next())
                .password(sc.next())
                .confirmPassword(sc.next())
                .name(sc.next())
                .personId(sc.nextInt())
                .phoneNumber(sc.nextInt())
                .address(sc.next())
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

    public String findUserBYId(Scanner sc) {
        return service.findUserBYId(User.builder()
                .username(sc.next())
                .build()
        );
    }
    public Map<String, ?> addUsers() {
        return service.addUsers();
    }
    public String updatePassword(Scanner sc) {

        return service.updatePassword(User.builder()
                .username(sc.next())
                .password(sc.next())
                .confirmPassword(sc.next())
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

    public String countUser() {
        return service.count();
    }
}
