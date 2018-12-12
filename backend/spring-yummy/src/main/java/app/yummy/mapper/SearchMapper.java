package app.yummy.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import app.yummy.vo.FoodVO;

@Mapper
public interface SearchMapper {
	
	List<FoodVO> searchFood(@Param("foodname") String foodname);
	
}
