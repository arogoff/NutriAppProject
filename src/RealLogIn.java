package src;

import src.objs.User;
import src.utils.UserUtils;

public class RealLogIn implements LogIn{
    @Override
    // Return the User with the specified username
    public User authenticate(String username) {
        return UserUtils.getUser(username);
    }
}
