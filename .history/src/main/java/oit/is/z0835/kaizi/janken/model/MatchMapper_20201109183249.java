package oit.is.z0835.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchMapper {

  @Select("SELECT * from matches")
  ArrayList<Match> selectAllMatch();

  @Insert("INSERT INTO matches (user_1,user_2,user_1_hand,user_2_hand,is_active) VALUES (2,1,'Gu',#{hand},true);")
  void insertMatch(String hand);

}