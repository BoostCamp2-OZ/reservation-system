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
}
