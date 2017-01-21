package marketlife.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import marketlife.interfaces.WorkGoods;
import marketlife.objects.Goods;
import marketlife.start.MySQLConnect;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Viktor on 06.01.2017.
 */
// Класс реализует интерфейс с помощью коллекции
public class CollectionWorkGoods implements WorkGoods {

    private ObservableList<Goods> goodsList = FXCollections.observableArrayList();

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

    public void fillTestData() throws SQLException {

        MySQLConnect MS = new MySQLConnect();
        ResultSet rs = MS.SQLQuery("select * from v_goods");

        goodsList.clear();

        while (rs.next()) {
            goodsList.add(new Goods(rs.getInt("id_goods"),
                                    rs.getString("name_goods"),
                                    rs.getString("color"),
                                    rs.getString("size"),
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
