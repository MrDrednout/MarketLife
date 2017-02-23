package marketlife.window.Users.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import marketlife.codesoftware.sql.SQLConnect;
import marketlife.window.Users.interfaces.WorkUsers;
import marketlife.window.Users.objects.UsersObject;
import marketlife.window.Users.sql.UsersSql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by coole on 22.02.2017.
 */
public class CollectionUsers implements WorkUsers {

    private ObservableList<UsersObject> usersObjects = FXCollections.observableArrayList();

    UsersSql sql = new UsersSql();

    @Override
    public void add(UsersObject usersObject) {
        usersObjects.add(usersObject);
    }

    @Override
    public void update(UsersObject usersObject) {

    }

    @Override
    public void block(UsersObject usersObject) {

    }

    public ObservableList<UsersObject> getUsersObjects() {
        return usersObjects;
    }

    public void fillingUsersList() throws SQLException {
        SQLConnect MS = new SQLConnect();
        ResultSet rs = MS.SQLQuery(sql.selectUsers());

        usersObjects.clear();

        while(rs.next()) {
            usersObjects.add(new UsersObject(rs.getInt("id_user"),
                            rs.getString("f"),
                            rs.getString("i"),
                            rs.getString("o"),
                            rs.getString("login"),
                            rs.getInt("flg_block")));
        }
    }
}
