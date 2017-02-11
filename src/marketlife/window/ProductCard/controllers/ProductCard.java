package marketlife.window.ProductCard.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import marketlife.window.ProductsList.objects.Goods;
import marketlife.window.ProductCard.objects.GoodsShort;
import marketlife.codesoftware.MySQLConnect;

import javax.swing.text.TabableView;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Viktor on 06.01.2017.
 */


public class ProductCard {

    @FXML
    private Label show_id_doogs;

    @FXML
    private TabableView table_mini_goods;

    @FXML
    private TableColumn<GoodsShort, Integer> column_id_goods;

    @FXML
    private void initialize() {
        column_id_goods.setCellValueFactory(new PropertyValueFactory<GoodsShort, Integer>("id_goods"));
    }

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
