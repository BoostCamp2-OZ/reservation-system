package connect.oz.reservation.product.domain;

public class Image {
    private long id;
    private long productId;
    private long fileId;
    private long type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public long getType() {
        return type;
    }

    public void setType(long type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", productId=" + productId +
                ", fileId=" + fileId +
                ", type=" + type +
                '}';
    }
}
