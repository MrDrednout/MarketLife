package marketlife.window.Users.sql;

/**
 * Created by coole on 18.02.2017.
 */
public class UsersSql {

    public String selectUsers() {
        String s =
                "select \n" +
                        "    id_user,\n" +
                        "    f,\n" +
                        "    i,\n" +
                        "    o,\n" +
                        "    login,\n" +
                        "    flg_block \n" +
                        "from users";
        return s;
    }
}
