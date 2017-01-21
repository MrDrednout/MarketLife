package marketlife.start;

    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
/**
 * Created by Viktor on 05.01.2017.
 */
public class MySQLConnect {

    Connection c = null;
    SQLString s = new SQLString();

    public void SQLOpenConnect() throws SQLException {
        String url = s.sqlstring();
        String user = s.sqluser();
        String pass = s.sqlpassword();
        c = DriverManager.getConnection(url, user, pass);
        System.out.println("Connect open");
    }

    public void SQLCloseConnect() {
        try {
            if(c != null)
                c.close();
            System.out.println("Connect close");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet SQLQuery(String query) throws SQLException {
        ResultSet rs = null;
        System.out.println(query);
        if ( c == null) SQLOpenConnect();
        try{
            Statement st = c.createStatement();//Готовим запрос
            rs = st.executeQuery(query);
        } catch(Exception e){
            e.printStackTrace() ;
        }

        return rs;
    }

    public void SQLUpdate (String query) throws SQLException {
        Statement st = c.createStatement();//Готовим запрос
        st.executeUpdate(query);
    }

}
