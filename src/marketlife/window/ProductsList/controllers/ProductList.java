package marketlife.window.ProductsList.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import marketlife.window.ProcessingDictionaries.controllers.ProcessingDictionaries;
import marketlife.window.ProcessingMutable.controllers.ProcessingMutable;
import marketlife.window.ProductCreate.controllers.ProductCreate;
import marketlife.window.ProductsList.interfaces.impls.CollectionWorkGoods;
import marketlife.window.ProductCard.controllers.ProductCard;
import marketlife.window.ProductsList.objects.Goods;

import java.io.IOException;
import java.sql.SQLException;

public class ProductList {

    public String ss;

    private CollectionWorkGoods workGoodsImpl = new CollectionWorkGoods();

    @FXML
    private Button button_show;

    @FXML
    private Button button_create;

    @FXML
    private Button button_card_product;

    @FXML
    private TableView table_goods;

    @FXML
    private TableColumn<Goods, Integer> column_id_goods;

    @FXML
    private TableColumn<Goods, String> column_name_goods;

    @FXML
    private TableColumn<Goods, Integer> column_sum_goods;

    @FXML
    private TableColumn<Goods, String> column_color_goods;

    @FXML
    private TableColumn<Goods, String> column_size_goods;

    @FXML
    private TableColumn<Goods, Float> column_purchase_price;

    @FXML
    private TableColumn<Goods, Float> column_cost_of;

    @FXML
    private TableColumn<Goods, String> column_provider;

    @FXML
    private TableColumn<Goods, String> column_color_string;

    @FXML
    private TableColumn<Goods, String> column_type_goods;

    @FXML
    private TableColumn<Goods, Integer> column_in_arhive;

    @FXML
    private TableColumn<Goods, String> column_print;

    @FXML
    private TableColumn<Goods, String> column_material;

    @FXML
    private Parent fxmlEdit;
    private Stage card_product;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private ProductCard openProductController;

    ProcessingDictionaries processingDictionaries = new ProcessingDictionaries();
    ProcessingMutable processingMutable = new ProcessingMutable();
    ProductCreate productCreate = new ProductCreate();

    @FXML
    private void initialize(){
        column_id_goods.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("id_goods"));
        column_name_goods.setCellValueFactory(new PropertyValueFactory<Goods, String>("name_goods"));
        column_sum_goods.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("sum_goods"));
        column_color_goods.setCellValueFactory(new PropertyValueFactory<Goods, String>("color"));
        column_size_goods.setCellValueFactory(new PropertyValueFactory<Goods, String>("size"));
        column_purchase_price.setCellValueFactory(new PropertyValueFactory<Goods, Float>("purchase_price"));
        column_cost_of.setCellValueFactory(new PropertyValueFactory<Goods, Float>("cost_of"));
        column_provider.setCellValueFactory(new PropertyValueFactory<Goods, String>("provider"));
        column_color_string.setCellValueFactory(new PropertyValueFactory<Goods, String>("color_string"));
        column_type_goods.setCellValueFactory(new PropertyValueFactory<Goods, String>("type_goods"));
        column_in_arhive.setCellValueFactory(new PropertyValueFactory<Goods, Integer>("in_arhive"));
        column_print.setCellValueFactory(new PropertyValueFactory<Goods, String>("print"));
        column_material.setCellValueFactory(new PropertyValueFactory<Goods, String>("material"));

        try {
            fxmlLoader.setLocation(getClass().getResource("/marketlife/window/ProductCard/fxml/ProductCard.fxml"));
            fxmlEdit = fxmlLoader.load();
            openProductController = fxmlLoader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void button_action_show(ActionEvent actionEvent) throws SQLException {
        workGoodsImpl.fillingGoods();
        table_goods.setItems(workGoodsImpl.getGoodsList());
    }

    public void button_card_product_action(ActionEvent actionEvent) throws IOException, SQLException {
        Goods selectedGoods = (Goods) table_goods.getSelectionModel().getSelectedItem();
        Window parentWindow = ((Node) actionEvent.getSource()).getScene().getWindow();
        openProductController.setGoods(selectedGoods);
        show_card_product(parentWindow);
    }

    public void show_main() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/marketlife/window/ProductsList/fxml/ProductList.fxml"));
        stage.setTitle("Market Life 0.04b");
        stage.setMinWidth(730);
        stage.setMinHeight(500);
        stage.setWidth(1200);
        stage.setHeight(700);
        stage.setScene(new Scene(root));
        stage.show();
    }

    public void show_card_product(Window parentWinwdow) {
        if (card_product == null) {
            card_product = new Stage();
            card_product.setTitle("Карточка продукта");
            card_product.setWidth(1000);
            card_product.setHeight(600);
            card_product.setResizable(false);
            card_product.setScene(new Scene(fxmlEdit));
            card_product.initModality(Modality.WINDOW_MODAL);
            card_product.initOwner(parentWinwdow);
        }
        card_product.show();
    }

    public void button_action_create(ActionEvent actionEvent) throws IOException {
        productCreate.openProductCreate();
    }

    public void action_menu_setting_dict(ActionEvent actionEvent) throws IOException {
        processingDictionaries.openProcessingDictionaries();
    }

    public void action_menu_setting_mutable(ActionEvent actionEvent) throws IOException {
        processingMutable.openProcessingMutable();
    }
}
