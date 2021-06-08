package spring.softunimusicdb.service.impl;

import org.springframework.stereotype.Component;
import spring.softunimusicdb.service.ImageShuffler;

import java.util.Collections;
import java.util.List;

@Component
public class ImageShufflerImpl implements ImageShuffler {
    @Override
    public void shuffle(List<String> images) {
        Collections.shuffle(images);
    }
}
