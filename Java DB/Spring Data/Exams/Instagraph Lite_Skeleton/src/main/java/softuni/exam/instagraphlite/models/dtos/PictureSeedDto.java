package softuni.exam.instagraphlite.models.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;

public class PictureSeedDto {
    @Expose
    private String path;
    @Expose
    private Double size;

    public PictureSeedDto() {
    }

    @NotNull
    @NotBlank
    public String getPath() {
        return path;
    }

    public PictureSeedDto setPath(String path) {
        this.path = path;
        return this;
    }

    @NotNull
    @Min(500)
    @Max(60000)
    public Double getSize() {
        return size;
    }

    public PictureSeedDto setSize(Double size) {
        this.size = size;
        return this;
    }
}
