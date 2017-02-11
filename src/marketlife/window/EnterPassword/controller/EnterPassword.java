package marketlife.window.EnterPassword.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import marketlife.window.ProductsList.controllers.ProductList;
import marketlife.codesoftware.MySQLConnect;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Viktor on 05.01.2017.
 */
public class EnterPassword {

    @FXML
    private Button button_entrance;

    @FXML
    private Button button_exit;

    @FXML
    private TextField text_login;

    @FXML
    private TextField text_password;

    MySQLConnect MS = new MySQLConnect();

    // Вывод окна о вводе неверного пароля
    public void wrong_pas() throws IOException {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Ooops");
        alert.setHeaderText("Введен неверный пароль.");
        alert.setContentText("Будьте внимательны!");
        alert.showAndWait();
    }

    //Вывод окна информирующего, что пользователь заблокирован
    public void block_pas() throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ooops");
        alert.setHeaderText("Пользователь заблокирован.");
        alert.setContentText("Обратитесь к администратору!");
        alert.showAndWait();
    }

    //Вывод окна информирующего, что такого пользователя не существует
    public void not_users() throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ooops");
        alert.setHeaderText("Такого пользователя не существует.");
        alert.setContentText("Обратитесь к администратору!");
        alert.showAndWait();
    }

    //Вывод окна информирующего, что пользователей с таким логином нексколько
    public void many_users() throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ooops");
        alert.setHeaderText("Таких пользователей много.");
        alert.setContentText("Обратитесь к администратору!");
        alert.showAndWait();
    }

    //Вывод окна информирующего, что пользователь заблокирован по причине подбора пароля
    public void password_selection() throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Ooops");
        alert.setHeaderText("Пользователь заблокирован по причине многократных попыток подбора пароля.");
        alert.setContentText("Обратитесь к администратору!");
        alert.showAndWait();
    }

    //Нажатие на кнопку "Вход", проверка логина и пароля
    public void button_entrance_action(ActionEvent actionEvent) throws IOException, SQLException {
        int fin = 0;// 0 - неверный логин или пароль, 1 - пользователь заблокирован, 2 - вход подтвержден
        String login = text_login.getText(), password = text_password.getText(), password_db = null, login_db = null;
        int id_user = 0, block_flg = 0, attempt = 0, count_user = 0;
        String query = "select count(*) as count_user from v_users where login ='"+login+"'";
        ProductList MC = new ProductList();

        //MS.SQLOpenConnect();
        ResultSet rs = MS.SQLQuery(query);

        while (rs.next()) {
            count_user = rs.getInt("count_user");
        }

        switch (count_user){
            case 0:
                not_users();
                break;
            case 2:
                many_users();
                break;
            case 1:
                query = "select id_user, flg_block, attempt, password, login from USERS where login = '"+login+"'";
                rs = MS.SQLQuery(query);
                while (rs.next()) {
                    id_user = rs.getInt("id_user");
                    block_flg = rs.getInt("flg_block");
                    attempt = rs.getInt("attempt");
                    password_db = rs.getString("password");
                    login_db = rs.getString("login");
                }
                if (login.compareTo(login_db) == 0 & password.compareTo(password_db) == 0 & block_flg == 0) {
                    // открываем главную форму программы
                    MC.show_main();
                    Stage stage = (Stage) button_exit.getScene().getWindow();
                    stage.close();
                    // сбрасываем в 0 количество неуспешных входов в базе данных
                    query = "UPDATE mrdrednout_msale.USERS SET attempt = 0 WHERE id_user = " + id_user;
                    MS.SQLUpdate(query);
                } else if (block_flg == 1) {
                    block_pas();
                } else if (login.compareTo(login_db) != 0 | password.compareTo(password_db) != 0) {
                    wrong_pas();
                    query = "UPDATE mrdrednout_msale.USERS SET attempt =" + ++attempt + " WHERE id_user = " + id_user;
                    MS.SQLUpdate(query);
                    if (attempt == 3) {
                        query = "UPDATE mrdrednout_msale.USERS SET flg_block = 1 WHERE id_user = " + id_user;
                        MS.SQLUpdate(query);
                        password_selection();
                    }
                }
                break;
        }
    }

    // Нажатие на кнопку "Выход"
    public void button_exit_action(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) button_exit.getScene().getWindow();
        stage.close();
    }


}
