package marketlite.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.stage.Modality;
import javafx.stage.Stage;
import marketlite.objects.Goods;
import marketlite.start.MySQLConnect;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Node;

/**
 * Created by Viktor on 06.01.2017.
 */


public class OpenProductController {

    @FXML
    private Label show_id_doogs;


    private Goods goods;



    public void setGoods(Goods goods) throws SQLException {
        this.goods = goods;
        System.out.println(goods.getId_goods());
        System.out.println(goods.getType_goods()+goods.getName_goods());
        MySQLConnect MS = new MySQLConnect();
        ResultSet rs = MS.SQLConnect("select * from v_goods_card where concat(type_goods, name_goods) = '" + goods.getType_goods()+goods.getName_goods()+"'");
    }


    public void actionClose(javafx.event.ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

/*
    public void actionSave(javafx.event.ActionEvent actionEvent) {
        person.setPhone(txtPhone.getText());
        person.setFio(txtFIO.getText());
        actionClose(actionEvent);
    }
*/
}
