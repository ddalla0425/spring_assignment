package spring.assignment.model.dto;

public class CategoryDTO {
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
    private String refCategoryName;

    public CategoryDTO() {
    }

    public CategoryDTO(int categoryCode, String categoryName, Integer refCategoryCode, String refCategoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
        this.refCategoryCode = refCategoryCode;
        this.refCategoryName = refCategoryName;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getRefCategoryCode() {
        return refCategoryCode;
    }

    public void setRefCategoryCode(Integer refCategoryCode) {
        this.refCategoryCode = refCategoryCode;
    }

    public String getRefCategoryName() {
        return refCategoryName;
    }

    public void setRefCategoryName(String refCategoryName) {
        this.refCategoryName = refCategoryName;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryCode=" + categoryCode +
                ", categoryName='" + categoryName + '\'' +
                ", refCategoryCode=" + refCategoryCode +
                ", refCategoryName='" + refCategoryName + '\'' +
                '}';
    }
}
