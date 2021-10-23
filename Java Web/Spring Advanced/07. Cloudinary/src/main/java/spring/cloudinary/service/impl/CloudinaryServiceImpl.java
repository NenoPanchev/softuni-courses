package spring.cloudinary.service.impl;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.cloudinary.service.CloudinaryService;

import java.io.File;
import java.io.IOException;
import java.util.Collections;

@Service
public class CloudinaryServiceImpl implements CloudinaryService {

  private static final String TEMP_FILE = "temp-file";
  private static final String URL = "url";

  private final Cloudinary cloudinary;

  public CloudinaryServiceImpl(Cloudinary cloudinary) {
    this.cloudinary = cloudinary;
  }

  @Override
  public String uploadImage(MultipartFile multipartFile) throws IOException {
    File file = File.createTempFile(TEMP_FILE, multipartFile.getOriginalFilename());
    multipartFile.transferTo(file);

    System.out.println("Original file name: " + multipartFile.getOriginalFilename());
    System.out.println("Name: " + multipartFile.getName());
    System.out.println("ContentType: " + multipartFile.getContentType());

    return this.cloudinary
        .uploader()
        .upload(file, Collections.emptyMap())
        .get(URL)
        .toString();
  }
}
