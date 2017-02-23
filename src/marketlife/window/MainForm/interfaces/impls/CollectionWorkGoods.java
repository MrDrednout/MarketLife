package marketlife.window.MainForm.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import marketlife.window.MainForm.interfaces.WorkGoods;
import marketlife.window.MainForm.objects.Goods;
import marketlife.codesoftware.sql.SQLConnect;
import marketlife.window.MainForm.sql.ProductListSQL;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Viktor on 06.01.2017.
 */
// Класс реализует интерфейс с помощью коллекции
public class CollectionWorkGoods implements WorkGoods {

    private ObservableList<Goods> goodsList = FXCollections.observableArrayList();

    ProductListSQL sql = new ProductListSQL();

    @Override
    public void add(Goods goods) {
        goodsList.add(goods);
    }

    @Override
    public void delete(Goods goods) {
        goodsList.remove(goods);
    }

    @Override
    public void update(Goods goods) {

    }

    public ObservableList<Goods> getGoodsList() {
        return goodsList;
    }

    public void fillingGoods() throws SQLException {

        SQLConnect MS = new SQLConnect();
        ResultSet rs = MS.SQLQuery(sql.querySelectGoods());

        goodsList.clear();

        while (rs.next()) {
            goodsList.add(new Goods(rs.getInt("id_goods"),
                                    rs.getString("name_goods"),
                                    rs.getString("color"),
                                    rs.getString("sizee"),
                                    rs.getString("color_string"),
                                    rs.getString("provider"),
                                    rs.getFloat("purchase_price"),
                                    rs.getFloat("cost_of"),
                                    rs.getInt("sum_goods"),
                                    rs.getInt("in_arhive"),
                                    rs.getString("type_goods"),
                                    rs.getString("print"),
                                    rs.getString("material")));
        }
    }
}
