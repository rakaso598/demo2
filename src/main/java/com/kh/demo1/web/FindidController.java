package com.kh.demo1.web;

import com.kh.demo1.domain.dao.FindidDAO;
import com.kh.demo1.domain.dao.entity.FindidEntity;
import com.kh.demo1.web.api.IdResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping
public class FindidController {

  private final FindidDAO findidDAO;

  @GetMapping("/user")                      // GET http://localhost:9090/user
  public String init(){
    return "user/init";
  }

  @ResponseBody
  @PostMapping("/findid")               // POST http://localhost:9090/findid
  public IdResponse findid(@RequestBody FindidEntity findidEntity){
    String email = findidDAO.findid(findidEntity);
    return new IdResponse(email);
  }

}
