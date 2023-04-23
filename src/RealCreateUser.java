package src;

import src.objs.User;
import src.utils.UserUtils;

public class RealCreateUser implements CreateUser{
    @Override
    // Create & Return the user associated with the parameters.
    public User authenticate(String username, String passwordHash, String firstName, String lastName, String dailyTarget, String height, String weight, String birthDate, String gender) {
        return UserUtils.createUser(username, passwordHash, firstName, lastName, dailyTarget, height, weight, birthDate, gender );
    }
}
