package connect.oz.reservation.product.dao;

public class ProductSqls {
    final static String SELECT_PRODUCTS =
            "SELECT P.id, P.category_id, P.name, P.description, DI.place_name, F.id AS file_id"
                    + " FROM product AS P"
                    + " JOIN display_info AS DI"
                    + " ON DI.product_id = P.id"
                    + " JOIN product_image AS PI"
                    + " ON P.id = PI.product_id"
                    + " JOIN file AS F"
                    + " ON F.id = PI.file_id"
                    + " WHERE PI.type=1"
                    + " ORDER BY P.id DESC"
                    + " LIMIT :offset, :limit";

    final static String SELECT_PRODUCTS_BY_CATEGORY_ID =
            "SELECT P.id, P.category_id, P.name, P.description, DI.place_name, F.id AS file_id"
                    + " FROM product AS P"
                    + " JOIN display_info AS DI"
                    + " ON DI.id = P.id"
                    + " JOIN product_image AS PI"
                    + " ON P.id = PI.product_id"
                    + " JOIN file AS F"
                    + " ON F.id = PI.file_id"
                    + " WHERE P.category_id = :categoryId"
                    + " AND PI.type=1"
                    + " ORDER BY P.id DESC"
                    + " LIMIT :offset, :limit";

    final static String SELECT_PRODUCTS_COUNT_BY_CATEGORY_ID =
            "SELECT count(*)"
                    + " FROM product"
                    + " WHERE category_id= :categoryId";

    final static String SELECT_PRODUCTS_COUNT =
            "SELECT count(*)"
                    + " FROM product";

    final static String SELECT_PRODUCT_BY_ID =
            "SELECT "
                    + " P.id, P.name, P.description, P.event,"
                    + " P.sales_start, P.sales_end, P.sales_flag,"
                    + " DI.observation_time, DI.place_name, DI.place_lot, DI.place_street,"
                    + " DI.tel, DI.homepage, DI.email, PD.content"
                    + " FROM product AS P"
                    + " JOIN product_detail AS PD ON P.id = PD.product_id"
                    + " JOIN display_info AS DI ON P.id = DI.product_id"
                    + " WHERE P.id = :productId";

    final static String SELECT_PRODUCT_IMGAE_LIST =
            "SELECT F.id AS fileId"
                    + " FROM product AS P"
                    + " JOIN product_image AS PI ON P.id = PI.product_id"
                    + " JOIN file AS F ON PI.file_id = F.id"
                    + " WHERE F.delete_flag = 0"
                    + " AND F.file_length > 0"
                    + " AND P.id = :productId"
                    + " ORDER BY PI.type ASC";
}
