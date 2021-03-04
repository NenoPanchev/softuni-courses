package coursespringdata.jsonprocessingex1.models.dtos;

import com.google.gson.annotations.Expose;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class CategorySeedDto {
    @Expose
    @NotNull
    private String name;

    public CategorySeedDto() {
    }

    @NotNull(message = "Category name is required.")
    @Length(min = 3, max = 15, message = "Name length should be between 3 and 15 characters.")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
