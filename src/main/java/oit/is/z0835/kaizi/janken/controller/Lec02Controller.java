package oit.is.z0835.kaizi.janken.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0835.kaizi.janken.model.Janken;
import oit.is.z0835.kaizi.janken.model.Entry;
@Controller
public class Lec02Controller {

  @Autowired
  private Entry room;


  @GetMapping("lec02")
  public String lec02(ModelMap model, Principal prin) {
    String loginUser = prin.getName(); // ログインユーザ情報
    this.room.addUser(loginUser);
    model.addAttribute("room", this.room);
    return "lec02.html";
  }


  @PostMapping("/lec02")
  public String lec02(@RequestParam String name, ModelMap model) {
    String username = name;
    model.addAttribute("username", "Hi "+ username);
    return "lec02.html";
  }
  @GetMapping("/gu")
    public String gu(ModelMap model){
      String hand ="グー";
      Janken janken = new Janken(hand);

      model.addAttribute("yourhand", hand);
      model.addAttribute("result", janken.result);
      return "lec02.html";
    }
  @GetMapping("/choki")
    public String choki(ModelMap model){
      String hand ="チョキ";
      Janken janken = new Janken(hand);

      model.addAttribute("yourhand", hand);
      model.addAttribute("result", janken.result);
      return "lec02.html";
    }
  @GetMapping("/pa")
    public String pa(ModelMap model){
      String hand ="パー";
      Janken janken = new Janken(hand);

      model.addAttribute("yourhand", hand);
      model.addAttribute("result", janken.result);
      return "lec02.html";
    }
}
