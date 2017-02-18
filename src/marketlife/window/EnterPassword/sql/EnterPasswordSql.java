package marketlife.window.EnterPassword.sql;

/**
 * Created by coole on 15.02.2017.
 */
public class EnterPasswordSql {

    // поиск количества пользователей с данным логином.
    public String countUsers(String login) {
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

    // выгрузка данных по данному пользователю для последующей сверки введенных данных и хранящихся в БД
    public String importUsers(String login) {
        String s =
                "select " +
                        "id_user, " +
                        "flg_block, " +
                        "attempt, " +
                        "password, " +
                        "login " +
                "from USERS " +
                "where login = '"+login+"'";
        return s;
    }

    // сброс количества неуспешных попыток входа
    public String updateAttemtReset(int id_user) {
        String s = "UPDATE ML.USERS SET attempt = 0 WHERE id_user = " + id_user;
        return s;
    }

    // увеличение количество неуспешных попыток ввода на +1
    public String updateAttemtUp(int attempt, int id_user) {
        String s = "UPDATE ML.USERS SET attempt =" + ++attempt + " WHERE id_user = " + id_user;
        return s;
    }

    // блокиовка пользователей при достижении лимита неуспешных попыток входа
    public String updateBlockSet1 (int id_user) {
        String s = "UPDATE ML.USERS SET flg_block = 1 WHERE id_user = " + id_user;
        return s;
    }
}
