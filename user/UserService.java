package user;

import java.util.List;
import java.util.Map;

public interface UserService {

    String login(User user);

    String addUsers();


    String updatePassword(User user);

    List<?> findUserByName(String name);

    List<?> findUserByJob(String job);


}

