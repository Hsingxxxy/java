package com.how2java.mapper;

import com.how2java.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CateMapper {

    List<Category> findAlls();
    int saves(Category category);
    void deletes(int id);
    Category gets(int id);
    int updates(Category category);
    int isdeles(int id);

}