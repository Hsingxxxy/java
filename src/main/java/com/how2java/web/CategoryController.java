package com.how2java.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.mapper.CateMapper;
import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class CategoryController {
    @Autowired
	CategoryMapper categoryMapper;

	@Autowired
	CateMapper cateMapper;

	@RequestMapping("/listCate")
	public String listCate(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
		PageHelper.startPage(start,size,"id desc");
		List<Category> cs=cateMapper.findAlls();
		PageInfo<Category> page = new PageInfo<>(cs);
		m.addAttribute("page", page);
		return "listCate";
	}
	@RequestMapping("/addCate")
	public String listCate(Category c) throws Exception {
		cateMapper.saves(c);
		return "redirect:listCate";
	}
	@RequestMapping("/deleteCate")
	public String deleteCate(Category c) throws Exception {
		cateMapper.deletes(c.getId());
		return "redirect:listCate";
	}
	@RequestMapping("/updateCate")
	public String updateCate(Category c) throws Exception {
		cateMapper.updates(c);
		return "redirect:listCate";
	}
	@RequestMapping("/isDeleCate")
	public String isDeleCate(int id) throws Exception {
		Category c= cateMapper.gets(id);
		cateMapper.isdeles(c.getId());
		return "redirect:listCate";
	}
	@RequestMapping("/editCate")
	public String listCate(int id,Model m) throws Exception {
		Category c= cateMapper.gets(id);
		m.addAttribute("c", c);
		return "editCate";
	}

















	@RequestMapping("/listCategory")
	public String listCategory(Model m,@RequestParam(value = "start", defaultValue = "0") int start,@RequestParam(value = "size", defaultValue = "10") int size) throws Exception {
		PageHelper.startPage(start,size,"id desc");
		List<Category> cs=categoryMapper.findAll();
		PageInfo<Category> page = new PageInfo<>(cs);
		m.addAttribute("page", page);
		return "listCategory";
	}

    @RequestMapping("/addCategory")
    public String listCategory(Category c) throws Exception {
    	categoryMapper.save(c);
    	return "redirect:listCategory";
    }
    @RequestMapping("/deleteCategory")
    public String deleteCategory(Category c) throws Exception {
    	categoryMapper.delete(c.getId());
    	return "redirect:listCategory";
    }
    @RequestMapping("/updateCategory")
    public String updateCategory(Category c) throws Exception {
    	categoryMapper.update(c);
    	return "redirect:listCategory";
    }
    @RequestMapping("/isDeleCategory")
    public String isDeleCategory(int id) throws Exception {
		Category c= categoryMapper.get(id);
    	categoryMapper.isdele(c.getId());
    	return "redirect:listCategory";
    }
    @RequestMapping("/editCategory")
    public String listCategory(int id,Model m) throws Exception {
    	Category c= categoryMapper.get(id);
    	m.addAttribute("c", c);
    	return "editCategory";
    }
    

     
}