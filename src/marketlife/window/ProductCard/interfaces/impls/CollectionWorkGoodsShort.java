package marketlife.window.ProductCard.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import marketlife.window.ProductCard.interfaces.WorkGoodsShort;
import marketlife.window.ProductCard.objects.GoodsShort;
import marketlife.window.ControlForm.controllers.ProductList;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by coole on 11.02.2017.
 */
public class CollectionWorkGoodsShort implements WorkGoodsShort {

    private ObservableList<GoodsShort> goodsShortList = FXCollections.observableArrayList();

    @Override
    public void add(GoodsShort goodsShort) {

    }

    @Override
    public void delete(GoodsShort goodsShort) {

    }

    @Override
    public void update(GoodsShort goodsShort) {

    }

    public ObservableList<GoodsShort> getGoodsShort() {
        return goodsShortList;
    }

    public void fillingGoodsShort(ResultSet rs) throws SQLException {
        ProductList ps = new ProductList();
        goodsShortList.clear();
        while (rs.next()) {
            goodsShortList.add(new GoodsShort(
                    rs.getInt("id_goods"),
                    rs.getString("type_goods"),
                    rs.getString("name_goods"),
                    rs.getString("color"),
                    rs.getString("sizee"),
                    rs.getString("color_string"),
                    rs.getString("provider"),
                    rs.getFloat("purchase_price"),
                    rs.getFloat("cost_of"),
                    rs.getInt("sum_goods"),
                    rs.getInt("in_arhive"),
                    rs.getString("print"),
                    rs.getString("material")));
        }
    }
}
