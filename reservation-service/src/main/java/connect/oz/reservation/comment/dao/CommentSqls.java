package connect.oz.reservation.comment.dao;

public class CommentSqls {

    final static String SELECT_COMMENT_IMAGES =
            "SELECT RUCI.file_id"
                    + " FROM reservation_user_comment_image AS RUCI"
                    + " WHERE RUCI.reservation_user_comment_id = :commentId"
                    + " ORDER BY RUCI.file_id DESC";

    final static String SELECT_COMMENTS =
            "SELECT RUC.id, RUC.score, RUC.comment, RUC.create_date," +
                    " MAX(RUCI.file_id) AS file_id, COUNT(RUCI.reservation_user_comment_id) AS image_count," +
                    " U.username" +
                    " FROM reservation_user_comment AS RUC" +
                    " JOIN users AS U ON U.id = RUC.user_id" +
                    " LEFT JOIN reservation_user_comment_image AS RUCI ON RUC.id = RUCI.reservation_user_comment_id" +
                    " WHERE product_id = :productId" +
                    " GROUP BY RUC.id" +
                    " ORDER BY RUC.id DESC LIMIT :offset, :limit";

    final static String SELECT_COMMENTS_SUMMARY =
            "SELECT P.id AS productId, P.name AS productName,"
                    + " ROUND(AVG(RUC.score), 1) AS average, COUNT(*) AS totalCount"
                    + " FROM product AS P"
                    + " JOIN reservation_user_comment AS RUC"
                    + " ON P.id = RUC.product_id"
                    + " WHERE RUC.product_id = :productId";

}
