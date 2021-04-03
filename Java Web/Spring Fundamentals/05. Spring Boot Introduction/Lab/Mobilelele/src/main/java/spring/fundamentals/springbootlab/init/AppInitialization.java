package spring.fundamentals.springbootlab.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.fundamentals.springbootlab.entities.BaseEntity;
import spring.fundamentals.springbootlab.entities.BrandEntity;
import spring.fundamentals.springbootlab.entities.ModelEntity;
import spring.fundamentals.springbootlab.entities.enums.CategoryEnum;
import spring.fundamentals.springbootlab.repositories.BrandRepository;
import spring.fundamentals.springbootlab.repositories.ModelRepository;
import spring.fundamentals.springbootlab.services.BrandService;
import spring.fundamentals.springbootlab.services.ModelService;

import java.time.Instant;
import java.util.List;

@Component
public class AppInitialization implements CommandLineRunner {
    private final BrandService brandService;
    private final ModelService modelService;
    private final BrandRepository brandRepository;
    private final ModelRepository modelRepository;

    @Autowired
    public AppInitialization(BrandService brandService, ModelService modelService, BrandRepository brandRepository, ModelRepository modelRepository) {
        this.brandService = brandService;
        this.modelService = modelService;
        this.brandRepository = brandRepository;
        this.modelRepository = modelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (this.brandRepository.count() == 0) {
            BrandEntity ford = new BrandEntity("Ford");
            setTime(ford);
            BrandEntity bmw = new BrandEntity("BMW");
            setTime(bmw);
            this.brandRepository.saveAll(List.of(ford, bmw));
        }

        if (this.modelRepository.count() == 0) {
            ModelEntity escort = new ModelEntity("Escort");
            setTime(escort);
            escort.setCategory(CategoryEnum.CAR);
            escort.setBrandEntity(this.brandRepository.getByName("Ford"));
            escort.setStartYear(1960);
            escort.setImageUrl("https://www.carscoops.com/wp-content/uploads/2021/01/MST-MK2-Escort-01.jpg");

            ModelEntity fiesta = new ModelEntity("Fiesta");
            setTime(fiesta);
            fiesta.setCategory(CategoryEnum.CAR);
            fiesta.setBrandEntity(this.brandRepository.getByName("Ford"));
            fiesta.setStartYear(1960);
            fiesta.setEndYear(2010);
            fiesta.setImageUrl("https://www.topgear.com/sites/default/files/styles/16x9_1280w/public/images/news-article/2020/10/88bc5aca51b761d020b821b05c7bb149/fiesta_st_edition_029.jpg?itok=L8UUpHAs");

            ModelEntity x5 = new ModelEntity("X5");
            setTime(x5);
            x5.setCategory(CategoryEnum.CAR);
            x5.setBrandEntity(this.brandRepository.getByName("BMW"));
            x5.setStartYear(1970);
            x5.setEndYear(2015);
            x5.setImageUrl("https://www.bmw-m.com/content/dam/bmw/marketBMW_M/common/topics/magazine-article-pool/2018/g05-m-performance/bmw-x5-m-performance-social-image.jpg");

            this.modelRepository.saveAll(List.of(escort, fiesta, x5));
        }
    }

    private static void setTime(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now());
        baseEntity.setModified(Instant.now());
    }
}
