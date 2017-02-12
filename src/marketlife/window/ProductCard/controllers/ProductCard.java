package marketlife.window.ProductCard.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import marketlife.window.ProductCard.interfaces.impls.CollectionWorkGoodsShort;
import marketlife.window.ProductsList.objects.Goods;
import marketlife.window.ProductCard.objects.GoodsShort;
import marketlife.codesoftware.MySQLConnect;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Viktor on 06.01.2017.
 */


public class ProductCard {

    private CollectionWorkGoodsShort workGoodsShortImpl = new CollectionWorkGoodsShort();
    
    @FXML
    private Label show_id_doogs;

    @FXML
    private TableView table_GoodsShort;

    @FXML
    private TableColumn<GoodsShort, Integer> column_id_goods;

    @FXML
    private TableColumn<GoodsShort, String> column_color_goods;

    @FXML
    private TableColumn<GoodsShort, String> column_size_goods;

    @FXML
    private TableColumn<GoodsShort, String> column_print;

    @FXML
    private TableColumn<GoodsShort, String> column_material;

    @FXML
    private TableColumn<GoodsShort, Integer> column_in_arhive;

    @FXML
    private void initialize() throws SQLException {
        column_id_goods.setCellValueFactory(new PropertyValueFactory<GoodsShort, Integer>("id_goods"));
        column_color_goods.setCellValueFactory(new PropertyValueFactory<GoodsShort, String>("color"));
        column_size_goods.setCellValueFactory(new PropertyValueFactory<GoodsShort, String>("size_goods"));
        column_print.setCellValueFactory(new PropertyValueFactory<GoodsShort, String>("print"));
        column_material.setCellValueFactory(new PropertyValueFactory<GoodsShort, String>("material"));
        column_in_arhive.setCellValueFactory(new PropertyValueFactory<GoodsShort, Integer>("in_arhive"));

    }

    private Goods goods;


    public void setGoods(Goods goods) throws SQLException {
        this.goods = goods;
        System.out.println(goods.getId_goods());
        System.out.println(goods.getType_goods()+goods.getName_goods());
        MySQLConnect MS = new MySQLConnect();
        ResultSet rs = MS.SQLQuery("select * from v_goods_card where typename = '" + goods.getType_goods()+goods.getName_goods()+"'");
        workGoodsShortImpl.fillingGoodsShort(rs);
        table_GoodsShort.setItems(workGoodsShortImpl.getGoodsShort());
    }


    public void actionClose(javafx.event.ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

}
