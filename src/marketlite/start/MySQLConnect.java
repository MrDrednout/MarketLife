package marketlite.start;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
/**
 * Created by Viktor on 05.01.2017.
 */
public class MySQLConnect {

    public Connection con = null;
    public Statement stmt = null;

    SQLString s = new SQLString();

    public ResultSet SQLConnect(String query) throws SQLException {
        String url = s.sqlstring();
        String user = s.sqluser();
        String pass = s.sqlpassword();
        ResultSet rs = null;

        con = DriverManager.getConnection(url, user, pass);
        stmt = con.createStatement();
        return stmt.executeQuery(query);
    }

    public void SQLUpdate(String query) throws SQLException {
        String url = s.sqlstring();
        String user = s.sqluser();
        String pass = s.sqlpassword();
        ResultSet rs = null;

        con = DriverManager.getConnection(url, user, pass);
        stmt = con.createStatement();
        stmt.executeUpdate(query);
    }
}
