package user;


import common.AbstractService;
import common.UtilService;
import common.UtilServiceImpl;
import enums.Messenger;

import java.util.*;
import java.util.stream.Collectors;

public class UserServiceImpl extends AbstractService<User> implements UserService {

    Map<String, User> users;
    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {
        this.users = new HashMap<>();
    }

    public static UserServiceImpl getInstance() {
        return instance;
    }


    @Override
    public String login(User user) {
        return users.getOrDefault(user.getUsername(),User.builder().password("").build())
                .getPassword().equals(user.getPassword())? "로그인 성공" : "로그인 실패";
    }

    @Override
    public Map<String, User> addUsers() {
        UtilService util = UtilServiceImpl.getInstance();
        for (int i = 0; i < 5; i++) {
            String username = util.createRandomUsername();
            users.put(username,
                    User.builder()
                            .username(username)
                            .password("123")
                            .confirmPassword("123")
                            .name(util.createRandomName())
                            .job(util.createRandomJob())
                            .build());
        }
        return users;
    }

    @Override
    public String findUserBYId(User user) {
        User userInMap = users.get(user.getUsername());
        String result ="";
        if (userInMap != null) {
            userInMap = users.get(user.getUsername());
            result = "사용중인 아이디입니다.";
        } else {
            result = "없는 아이디입니다.";
        }
        return result;
    }

    @Override
    public String updatePassword(User user) {
        User userInMap = users.get(user.getUsername());
        String result = "";
        if (userInMap != null) {
            userInMap.setPassword(user.getPassword());
            userInMap.setConfirmPassword(user.getPassword());
            result = "비밀번호 변경 성공!";
        } else {
            result = "없는 아이디입니다.";
        }
        return result;
    }



    @Override
    public List<?> findUserByName(String name) {
        return users
                .values()
                .stream()
                .filter(i->i.getName().equals(name))
                .collect((Collectors.toList()));
    }

    public Map<String, ?> findUserByNameFromMap(String name){
        return users
                .entrySet()
                .stream()
                .filter(i ->i.getKey().equals(name))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }
    @Override
    public List<?> findUserByJob(String job) {
                return users
                        .values()
                        .stream()
                        .filter(i->i.getJob().equals(job))
                        .collect((Collectors.toList()));
    }

    public Map<String, ?> findUserByJobFromMap(String job) {
        return users
                .entrySet()
                .stream()
                .filter(i->i.getKey().equals(job))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
    }

    @Override
    public Messenger save(User user) {

        users.put(user.getUsername(),user);
        return Messenger.SUCCESS;
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional findById(Long id) {
        return Optional.of(users.get(id));
    }

    @Override
    public String count() {
        return users.size()+"";
    }

    @Override
    public Optional<User> getOne(String id) {
        return Optional.of(users.get(id));
    }

    @Override
    public String delete(User user) {
        User userInMap = users.get(user.getUsername());
        String result = "";
        if (userInMap != null) {
            users.remove(userInMap.getUsername());
            result = "삭제완료";
        } else {
            result = "없는 아이디입니다.";
        }
        return result;
    }

    @Override
    public String deleteAll() {
        return null;
    }

    @Override
    public Boolean existsById(Long id) {
        return null;
    }
}
