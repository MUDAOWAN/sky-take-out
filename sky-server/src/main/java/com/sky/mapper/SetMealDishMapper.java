package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SetMealDishMapper {
    /**
     * 根据菜品id查询对应的菜品id
     * @param dishIds
     * @return
     */
    List<Long> getSetMealDishByDishIds(List<Long> dishIds);
}
