package marketlife.window.Users.interfaces;

import marketlife.window.Users.objects.UsersObject;

/**
 * Created by coole on 22.02.2017.
 */
public interface WorkUsers {

    void add(UsersObject usersObject);

    void update(UsersObject usersObject);

    void block(UsersObject usersObject);
}
