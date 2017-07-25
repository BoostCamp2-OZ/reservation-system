package kr.or.connect.dto;

public class ProductDisplayDto {

	private Long id;
	private Long categoryId;
	private String name;
	private String description;
	private String placeName;
	private Long fileId;

	public ProductDisplayDto() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public Long getFileId() {
		return fileId;
	}

	public void setFileId(Long fileId) {
		this.fileId = fileId;
	}

	@Override
	public String toString() {
		return "ProductDisplayDto [id=" + id + ", categoryId=" + categoryId + ", name=" + name + ", description="
				+ description + ", placeName=" + placeName + ", fileId=" + fileId + "]";
	}

}
