package oit.is.z0835.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MatchInfoMapper{
  @Insert("INSERT INTO match_info (user_1,user_2,is_active) VALUES (2,1,true)")
  void insertMatchInfo();

}