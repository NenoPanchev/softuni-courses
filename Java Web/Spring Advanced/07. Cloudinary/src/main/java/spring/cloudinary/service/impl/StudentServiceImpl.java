package spring.cloudinary.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import spring.cloudinary.model.entity.StudentEntity;
import spring.cloudinary.model.service.StudentServiceModel;
import spring.cloudinary.model.view.StudentViewModel;
import spring.cloudinary.repository.StudentRepository;
import spring.cloudinary.service.CloudinaryService;
import spring.cloudinary.service.StudentService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

  private final StudentRepository studentRepository;
  private final ModelMapper modelMapper;
  private final CloudinaryService cloudinaryService;

  public StudentServiceImpl(CloudinaryService cloudinaryService,
      StudentRepository studentRepository,
      ModelMapper modelMapper) {
    this.cloudinaryService = cloudinaryService;
    this.studentRepository = studentRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public void addStudent(StudentServiceModel studentServiceModel) throws IOException {
    MultipartFile img = studentServiceModel.getImg();
    String imageUrl = cloudinaryService.uploadImage(img);

    StudentEntity studentEntity = new StudentEntity().
        setName(studentServiceModel.getName()).
        setImgUrl(imageUrl);

    studentRepository.save(studentEntity);
  }

  @Override
  public List<StudentViewModel> findAll() {
    return studentRepository.
        findAll().
        stream().
        map(se -> modelMapper.map(se, StudentViewModel.class)).
        collect(Collectors.toList());
  }
}
