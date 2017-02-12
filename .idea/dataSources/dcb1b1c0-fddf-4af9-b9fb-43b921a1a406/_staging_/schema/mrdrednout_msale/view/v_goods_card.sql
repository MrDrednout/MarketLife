CREATE OR REPLACE VIEW `v_goods_card` AS
  SELECT
  `v_goods`.`id_goods`       AS `id_goods`,
  `v_goods`.`type_goods`     AS `type_goods`,
  `v_goods`.`name_goods`     AS `name_goods`,
  `v_goods`.`color`          AS `color`,
  `v_goods`.`size`           AS `size`,
  `v_goods`.`color_string`   AS `color_string`,
  `v_goods`.`provider`       AS `provider`,
  `v_goods`.`purchase_price` AS `purchase_price`,
  `v_goods`.`cost_of`        AS `cost_of`,
  `v_goods`.`sum_goods`      AS `sum_goods`,
  `v_goods`.`in_arhive`      AS `in_arhive`,
  `v_goods`.`print`          AS `print`,
  `v_goods`.`material`       AS `material`,
  concat(`v_goods`.`type_goods`,`v_goods`.`name_goods`) as `typename`
FROM `mrdrednout_msale`.`v_goods`