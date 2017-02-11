package marketlife.window.ProductCard.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import marketlife.codesoftware.MySQLConnect;
import marketlife.window.ProductCard.interfaces.WorkGoodsShort;
import marketlife.window.ProductCard.objects.GoodsShort;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Observable;

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

    public void fillingGoodsShort() throws SQLException {

        MySQLConnect MS = new MySQLConnect();
        ResultSet rs = MS.SQLQuery("select * from v_goods");

        goodsShortList.clear();

        while (rs.next()) {
            goodsShortList.add(new GoodsShort(rs.getInt("id_goods")));
        }
    }
}
