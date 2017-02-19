package marketlife.codesoftware.sql;

    import java.sql.*;
    import java.util.Locale;

/**
 * Created by Viktor on 05.01.2017.
 */
public class SQLConnect {

    public static Connection c = null;
    SQLString s = new SQLString();

    public void SQLOpenConnect() throws SQLException {
        Locale.setDefault(Locale.ENGLISH);
        SQLString connectString = new SQLString();

        String user = connectString.sqluser();//Логин пользователя
        String password = connectString.sqlpassword();//Пароль пользователя
        String url = connectString.sqlstring();//URL адрес
        String driver = "oracle.jdbc.driver.OracleDriver"; //Имя драйвера

        try {
            Class.forName(driver);//Регистрируем драйвер
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            c = DriverManager.getConnection(url, user, password);//Установка соединения с БД
            System.out.println("Connect open");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SQLCloseConnect() {
        try {
            if (c != null)
                c.close();
            System.out.println("Connect close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet SQLQuery(String query) throws SQLException {
        ResultSet rs = null;
        System.out.println(query);
        if (c == null) SQLOpenConnect();
        try {
            Statement st = c.createStatement();//Готовим запрос
            rs = st.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rs;
    }

    public void SQLUpdate(String query) throws SQLException {
        System.out.println(query);
        Statement st = c.createStatement();//Готовим запрос
        st.executeUpdate(query);
    }

    public void executeCreateUser(String f, String i, String o, String logg, String pass, int flg_block) {
        try {
            CallableStatement cstmt = c.prepareCall("begin ML.USER_CREATE (?, ?, ?, ?, ?, ?, ?); end;");
            cstmt.setString("F", f);
            cstmt.setString("I", i);
            cstmt.setString("O", o);
            cstmt.setString("LOGG", logg);
            cstmt.setString("PASS", pass);
            cstmt.setInt("FLG_BLOCK", flg_block);
            cstmt.registerOutParameter("WRONG", java.sql.Types.INTEGER);
            cstmt.execute();
            if (cstmt.getInt("WRONG") == 1)
                System.out.println("Такой пользователь уже существует. Придумайте другой пароль");
            else
                System.out.println("Пользователь успешно создан");
            cstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
