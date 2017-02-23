package marketlife.window.ControlForm.objects;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Viktor on 06.01.2017.
 */
public class Goods {
    private SimpleIntegerProperty id_goods = new SimpleIntegerProperty();
    private SimpleStringProperty name_goods = new SimpleStringProperty("");
    private SimpleStringProperty color = new SimpleStringProperty("");
    private SimpleStringProperty size = new SimpleStringProperty("");
    private SimpleStringProperty color_string = new SimpleStringProperty("");
    private SimpleStringProperty provider = new SimpleStringProperty("");
    private SimpleFloatProperty purchase_price = new SimpleFloatProperty();
    private SimpleFloatProperty cost_of = new SimpleFloatProperty();
    private SimpleIntegerProperty sum_goods = new SimpleIntegerProperty();
    private SimpleIntegerProperty in_arhive = new SimpleIntegerProperty();
    private SimpleStringProperty type_goods = new SimpleStringProperty("");
    private SimpleStringProperty print = new SimpleStringProperty("");
    private SimpleStringProperty material = new SimpleStringProperty("");

    public Goods() {

    }

    public Goods(int id_goods, String name_goods, String color, String size, String color_string, String provider,
                 float purchase_price, float cost_of, int sum_goods, int in_arhive, String type_goods, String print, String material) {
        this.id_goods = new SimpleIntegerProperty(id_goods);
        this.name_goods = new SimpleStringProperty(name_goods);
        this.color = new SimpleStringProperty(color);
        this.size = new SimpleStringProperty(size);
        this.color_string = new SimpleStringProperty(color_string);
        this.provider = new SimpleStringProperty(provider);
        this.purchase_price = new SimpleFloatProperty(purchase_price);
        this.cost_of = new SimpleFloatProperty(cost_of);
        this.sum_goods = new SimpleIntegerProperty(sum_goods);
        this.in_arhive = new SimpleIntegerProperty(in_arhive);
        this.type_goods = new SimpleStringProperty(type_goods);
        this.print = new SimpleStringProperty(print);
        this.material = new SimpleStringProperty(material);
    }


    @Override
    public String toString() {
        return "Goods{" +
                "id_goods=" + id_goods +
                ", name_goods='" + name_goods + '\'' +
                ", color='" + color + '\'' +
                ", size='" + size + '\'' +
                ", color_string='" + color_string + '\'' +
                ", provider='" + provider + '\'' +
                ", purchase_price=" + purchase_price +
                ", cost_of=" + cost_of +
                ", sum_goods=" + sum_goods +
                '}';
    }

    public int getId_goods() {
        return id_goods.get();
    }

    public void setId_goods(int id_goods) {
        this.id_goods.set(id_goods);
    }

    public String getName_goods() {
        return name_goods.get();
    }

    public void setName_goods(String name_goods) {
        this.name_goods.set(name_goods);
    }

    public String getColor() {
        return color.get();
    }

    public void setColor(String color) {
        this.color.set(color);
    }

    public String getSize() {
        return size.get();
    }

    public void setSize(String size) {
        this.size.set(size);
    }

    public String getColor_string() {
        return color_string.get();
    }

    public void setColor_string(String color_string) {
        this.color_string.set(color_string);
    }

    public String getProvider() {
        return provider.get();
    }

    public void setProvider(String provider) {
        this.provider.set(provider);
    }

    public float getPurchase_price() {
        return purchase_price.get();
    }

    public void setPurchase_price(float purchase_price) {
        this.purchase_price.set(purchase_price);
    }

    public float getCost_of() {
        return cost_of.get();
    }

    public void setCost_of(float cost_of) {
        this.cost_of.set(cost_of);
    }

    public int getSum_goods() {
        return sum_goods.get();
    }

    public void setSum_goods(int sum_goods) {
        this.sum_goods.set(sum_goods);
    }

    public SimpleIntegerProperty id_goodsProperty() {
        return id_goods;
    }

    public SimpleStringProperty name_goodsProperty() {
        return name_goods;
    }

    public SimpleStringProperty colorProperty() {
        return color;
    }

    public SimpleStringProperty sizeProperty() {
        return size;
    }

    public SimpleStringProperty color_stringProperty() {
        return color_string;
    }

    public SimpleStringProperty providerProperty() {
        return provider;
    }

    public SimpleFloatProperty purchase_priceProperty() {
        return purchase_price;
    }

    public SimpleFloatProperty cost_ofProperty() {
        return cost_of;
    }

    public SimpleIntegerProperty sum_goodsProperty() {
        return sum_goods;
    }

    public int getIn_arhive() {
        return in_arhive.get();
    }

    public SimpleIntegerProperty in_arhiveProperty() {
        return in_arhive;
    }

    public void setIn_arhive(int in_arhive) {
        this.in_arhive.set(in_arhive);
    }

    public String getType_goods() {
        return type_goods.get();
    }

    public SimpleStringProperty type_goodsProperty() {
        return type_goods;
    }

    public void setType_goods(String type_goods) {
        this.type_goods.set(type_goods);
    }

    public String getPrint() {
        return print.get();
    }

    public SimpleStringProperty printProperty() {
        return print;
    }

    public void setPrint(String print) {
        this.print.set(print);
    }

    public String getMaterial() {
        return material.get();
    }

    public SimpleStringProperty materialProperty() {
        return material;
    }

    public void setMaterial(String material) {
        this.material.set(material);
    }
}





