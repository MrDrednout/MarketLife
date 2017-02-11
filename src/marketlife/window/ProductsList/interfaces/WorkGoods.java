package marketlife.window.ProductsList.interfaces;

import marketlife.window.ProductsList.objects.Goods;

/**
 * Created by Viktor on 06.01.2017.
 */
public interface WorkGoods {

    // добавить запись
    void add(Goods goods);

    // удалить запись
    void delete(Goods goods);

    //обновить запись (подтвердить обновление)
    void update(Goods goods);
}
