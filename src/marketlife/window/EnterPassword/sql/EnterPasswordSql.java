package marketlife.window.EnterPassword.sql;

/**
 * Created by coole on 15.02.2017.
 */
public class EnterPasswordSql {

    public String countusers(String login) {
        String s =
                "select \n" +
                "    count(*) as count_user \n" +
                "from(\n" +
                "    select \n" +
                "        users.id_user,\n" +
                "        users.flg_block,\n" +
                "        users.attempt,\n" +
                "        users.password,\n" +
                "        users.login\n" +
                "    from users\n" +
                ") where login = '" + login + "'";
        return s;
    }


}
