package marketlife.window.Users.objects;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by coole on 22.02.2017.
 */
public class UsersObject {

    private SimpleIntegerProperty id_user = new SimpleIntegerProperty();
    private SimpleStringProperty f = new SimpleStringProperty("");
    private SimpleStringProperty i = new SimpleStringProperty("");
    private SimpleStringProperty o = new SimpleStringProperty("");
    private SimpleStringProperty login = new SimpleStringProperty("");
    private SimpleIntegerProperty flg_block = new SimpleIntegerProperty();

    public UsersObject() {

    }

    public UsersObject(int id_user, String f, String i, String o, String login, int flg_block) {
        this.id_user = new SimpleIntegerProperty(id_user);
        this.f = new SimpleStringProperty(f);
        this.i = new SimpleStringProperty(i);
        this.o = new SimpleStringProperty(o);
        this.login = new SimpleStringProperty(login);
        this.flg_block = new SimpleIntegerProperty(flg_block);
    }

    public int getId_user() {
        return id_user.get();
    }

    public SimpleIntegerProperty id_userProperty() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user.set(id_user);
    }

    public String getF() {
        return f.get();
    }

    public SimpleStringProperty fProperty() {
        return f;
    }

    public void setF(String f) {
        this.f.set(f);
    }

    public String getI() {
        return i.get();
    }

    public SimpleStringProperty iProperty() {
        return i;
    }

    public void setI(String i) {
        this.i.set(i);
    }

    public String getO() {
        return o.get();
    }

    public SimpleStringProperty oProperty() {
        return o;
    }

    public void setO(String o) {
        this.o.set(o);
    }

    public String getLogin() {
        return login.get();
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public int getFlg_block() {
        return flg_block.get();
    }

    public SimpleIntegerProperty flg_blockProperty() {
        return flg_block;
    }

    public void setFlg_block(int flg_block) {
        this.flg_block.set(flg_block);
    }
}
