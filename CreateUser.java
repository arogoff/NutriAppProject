package src;

import src.objs.User;

public interface CreateUser {
    User authenticate(String username, String passwordHash, String firstName, String lastName, String dailyTarget, String height, String weight, String birthDate);
}
