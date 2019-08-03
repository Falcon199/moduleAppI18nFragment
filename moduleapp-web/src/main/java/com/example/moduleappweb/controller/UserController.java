package com.example.moduleappweb.controller;

import com.example.moduleappcommon.model.User;
import com.example.moduleappcommon.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/")
  public String main(ModelMap map,
                     @RequestParam("page") Optional<Integer> page,
                     @RequestParam("size") Optional<Integer> size,
                     Locale locale) {
    int currentPage = page.orElse(1);
    int pageSize = size.orElse(5);
    Page<User> all = userRepository.findAll(PageRequest.of(currentPage - 1, pageSize));
    map.addAttribute("userPage", all);
    int totalPages = all.getTotalPages();
    if (totalPages > 0) {
      List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
        .boxed()
        .collect(Collectors.toList());
      map.addAttribute("pageNumbers", pageNumbers);
    }
    return "index";
  }
}
