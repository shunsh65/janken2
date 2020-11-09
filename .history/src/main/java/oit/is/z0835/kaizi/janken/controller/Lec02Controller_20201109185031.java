package oit.is.z0835.kaizi.janken.controller;

import java.security.Principal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import oit.is.z0835.kaizi.janken.model.Janken;

import oit.is.z0835.kaizi.janken.model.Entry;

import oit.is.z0835.kaizi.janken.model.User;
import oit.is.z0835.kaizi.janken.model.UserMapper;
import oit.is.z0835.kaizi.janken.model.Match;
import oit.is.z0835.kaizi.janken.model.MatchMapper;


@Controller
public class Lec02Controller {

  //@GetMapping("/lec02")
  //public String lec021(){
    //return "lec02.html";
  //}



  //@GetMapping("/lec02")
  //public String lec02(@RequestParam String name,ModelMap model){

  //  model.addAttribute("name",name);
  //  return "lec02.html";
  //}


  //@param model

  @GetMapping("/matchjanken")
  @Transactional
  public String lec02Janken(@RequestParam String hand, ModelMap model) {
    String result;
    if(hand.equals("Gu")){
      result = "Draw";
    }else if(hand.equals("Tyo")){
      result = "You Lose!!";
    }else{
      result = "You Win!";
    }
    //Janken result = new Janken(hand);

    model.addAttribute("myhand", hand);
    model.addAttribute("result", result);
    MatchMapper.insertMatch(hand);
    return "match.html";
  }

  //@PostMapping("/lec02janken/judge")
  //public String lec02JankenResult(@RequestParam String hand, ModelMap model) {
  //  Janken result = new Janken(hand);

  //  model.addAttribute("result", result);
  //  return "lec02.html";
  //}

  @Autowired
  private Entry entry;

  //@param model
  //@param prin
  //@return

  //@GetMapping("/lec02")
  //public String sample32(ModelMap model, Principal prin) {
    //String loginUser = prin.getName();
    //model.addAttribute("login_user", loginUser);
    //return "lec02.html";
  //}

  @GetMapping("/lec02/entry")
  public String lec02Entry(Principal prin, ModelMap model) {
    String loginUser = prin.getName();
    this.entry.addUser(loginUser);
    model.addAttribute("entry", this.entry);

    return "lec02.html";
  }

  //@GetMapping("/lec02")
  //public String sample39(Principal prin, ModelMap model) {
    //String loginUser = prin.getName();
    //Entry newRoom = new Entry();
    //newRoom.addUser(loginUser);
    //model.addAttribute("new_room", newRoom);

    //return "lec02.html";
  //}


  //staticでないメソッドなんたらのエラーが出たらAutowiredのつけ忘れ
  @Autowired
  UserMapper UserMapper;

  @Autowired
  MatchMapper MatchMapper;

  /*@Autowired
  MatchInfoMapper MatchInfoMapper;*/


  @GetMapping("/lec02")
  public String lec02IdName(ModelMap model) {
    ArrayList<User> User1 = UserMapper.selectName();
    User User2 = UserMapper.selectMyName();
    ArrayList<Match> Match1 = MatchMapper.selectAllMatch();
    model.addAttribute("User1", User1);
    model.addAttribute("User2", User2);
    model.addAttribute("Match1", Match1);

    return "lec02.html";
  }

  //@GetMapping("lec02")
  //public String lec02IdMatch(ModelMap model) {
    //ArrayList<Match> Match1 = MatchMapper.selectMatchById();
    //model.addAttribute("Match1", Match1);

    //return "lec02.html";
  //}

  @GetMapping("/match")
  public String matchPage(@RequestParam Integer id, ModelMap model){
    User User3 = UserMapper.selectNamebyId(id+1);
    User User4 = UserMapper.selectNamebyId(id);
    //MatchInfoMapper.insertMatchInfo();
    model.addAttribute("User3", User3);
    model.addAttribute("User4", User4);
    return "match.html";
  }

}