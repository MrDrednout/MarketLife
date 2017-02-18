package marketlife.window.ProductCard.sql;

/**
 * Created by Viktor on 18.02.2017.
 */
public class ProductCardSQL {

    public String queryProdectCard(String tm) {
        String s =
                "select\n" +
                        "    g.id_goods       as id_goods,\n" +
                        "    g.name_goods     as name_goods,\n" +
                        "    dc.termin        as color,\n" +
                        "    ds.termin        as sizee,\n" +
                        "    dcs.termin       as color_string,\n" +
                        "    dp.termin        as provider,\n" +
                        "    g.purchase_price as purchase_price,\n" +
                        "    g.cost_of        as cost_of,\n" +
                        "    s.sum_goods      as sum_goods,\n" +
                        "    g.in_arhive      as in_arhive,\n" +
                        "    g.print          as print,\n" +
                        "    mt.termin        as material,\n" +
                        "    tp.termin        as type_goods\n" +
                        "from ML.goods g \n" +
                        "left join ML.dict dc on g.id_color = dc.code and dc.id_dict = 1 \n" +
                        "left join ML.dict ds on g.id_size = ds.code and ds.id_dict = 3 \n" +
                        "left join ML.dict dp on g.id_provider = dp.code and dp.id_dict = 2 \n" +
                        "left join ML.dict dcs on g.color_string = dcs.code and dcs.id_dict = 4 \n" +
                        "left join (\n" +
                        "    select \n" +
                        "        id_goods,\n" +
                        "        sum(count_goods) as sum_goods \n" +
                        "    from ML.DEPOT\n" +
                        "    group by id_goods\n" +
                        ") s on s.id_goods = g.id_goods \n" +
                        "left join ML.dict tp on tp.code = g.type_goods and tp.id_dict = 7 \n" +
                        "left join ML.dict mt on mt.code = g.material and mt.id_dict = 6\n" +
                        "where tp.termin||g.name_goods = '" + tm + "'";
        return s;
    }
}
