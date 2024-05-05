package com.bezkoder.spring.files.excel.service.ExcelService;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bezkoder.spring.files.excel.helper.ExcelHelper;
import com.bezkoder.spring.files.excel.model.User;
import com.bezkoder.spring.files.excel.repository.UserRepository;

@Service
public class ExcelService {
  @Autowired
  UserRepository repository;

  public void save(MultipartFile file) {
    try {
      List<User> users = ExcelHelper.excelToUsers(file.getInputStream());
      repository.saveAll(users);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public ByteArrayInputStream load() {
    List<User> users = repository.findAll();

    ByteArrayInputStream in = ExcelHelper.usersToExcel(users);
    return in;
  }

  public List<User> getAllUsers() {
    return repository.findAll();
  }
}
