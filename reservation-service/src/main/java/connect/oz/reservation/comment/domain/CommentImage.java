package connect.oz.reservation.comment.domain;

public class CommentImage {
    private Long id;
    private Long reservationUserCommentId;
    private Long fileId;
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getReservationUserCommentId() {
        return reservationUserCommentId;
    }

    public void setReservationUserCommentId(Long reservationUserCommentId) {
        this.reservationUserCommentId = reservationUserCommentId;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

}
