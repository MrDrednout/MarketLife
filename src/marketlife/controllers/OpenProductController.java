package marketlife.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.stage.Stage;
import marketlife.objects.Goods;
import marketlife.start.MySQLConnect;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        ResultSet rs = MS.SQLQuery("select * from v_goods_card where concat(type_goods, name_goods) = '" + goods.getType_goods()+goods.getName_goods()+"'");
    }


    public void actionClose(javafx.event.ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

}
