package oit.is.z0835.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT id,name from users where id = 2")
  User selectMyName();

  @Select("SELECT id,name from users")
  ArrayList<User> selectName();

  @Select("SELECT id,name from users where id = #{id}")
  User selectNamebyId(int id);

}