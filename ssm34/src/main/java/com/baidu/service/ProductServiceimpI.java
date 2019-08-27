package com.baidu.service;

import com.baidu.entity.Product;
import com.baidu.mapper.IProductMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceimpI implements IProductService{
    @Autowired
    private IProductMapper mapper;
    /**
     * 列表分页
     */
    @Override
    public PageInfo selectList(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        //调用mapper层的列表方法
        List<Product> productList = mapper.selectList();
        //创建分页插件对象将列表对象传入
        PageInfo<Product> pageInfo = new PageInfo<>(productList);
        return pageInfo;
    }
    /**
     * 批量删除
     */
    @Override
    public void plsc(String[] split) {
        for (String ids:split) {
            mapper.plsc(ids);
        }
    }
    /**
     * 获取颜色单选按钮
     */
    @Override
    public List<Product> selectcolor() {
        return mapper.selectcolor();
    }
}
