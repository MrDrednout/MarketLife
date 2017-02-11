package marketlife.window.ProductCard.objects;

import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by Viktor on 28.01.2017.
 */
public class GoodsShort {
    private SimpleIntegerProperty id_goods = new SimpleIntegerProperty();

    public GoodsShort() {

    }

    public GoodsShort(int id_goods) {
        this.id_goods = new SimpleIntegerProperty(id_goods);
    }

    public int getId_goods() {
        return id_goods.get();
    }

    public SimpleIntegerProperty id_goodsProperty() {
        return id_goods;
    }

    public void setId_goods(int id_goods) {
        this.id_goods.set(id_goods);
    }
}
