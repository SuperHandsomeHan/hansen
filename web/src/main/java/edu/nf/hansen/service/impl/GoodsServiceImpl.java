package edu.nf.hansen.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.dao.GoodsDao;
import edu.nf.hansen.entity.Goods;
import edu.nf.hansen.service.GoodsService;
import edu.nf.hansen.service.exception.GoodsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/22
 */
@Service("goodsService")
public class GoodsServiceImpl implements GoodsService {
    @Autowired
    private GoodsDao dao;

    @Override
    public PageInfo<List<Goods>> listGoods(Integer pageNum, Integer pageSize) {
        try{
            return new PageInfo(dao.listGoods(pageNum, pageSize));
        }catch (Exception e){
            throw new GoodsException("服务器异常");
        }
    }

    @Override
    public List<Goods> listGoods() {
        try{
            return dao.listGoods();
        }catch (Exception e){
            throw new GoodsException("服务器异常");
        }
    }

    @Override
    public Goods getGoodsById(String gid) {
        try{
            return dao.getGoodsById(gid);
        }catch (Exception e){
            throw new GoodsException("服务器异常");
        }
    }

    @Override
    public Goods getGoodsByName(String gname) {
        try{
            return dao.getGoodsByName(gname);
        }catch (Exception e){
            throw new GoodsException("服务器异常");
        }
    }

    @Override
    public void addGoods(Goods goods) {
        try{
            Goods g = dao.getGoodsById(goods.getGname());
            if(g != null){
                throw new GoodsException("该供应商已经存在");
            }
            dao.addGoods(goods);
        }catch (Exception e){
            throw new GoodsException("服务器异常");
        }
    }

    @Override
    public void updateGoods(Goods goods) {
        try{
            dao.updateGoods(goods);
        }catch (Exception e){
            throw new GoodsException("服务器异常");
        }
    }

    @Override
    public void deleteGoods(String... gid) {
        try{
            for (String id : gid){
                Goods g = dao.getGoodsById(id);
                if(g == null){
                    throw new GoodsException("该供应商不存在");
                }
            }
            dao.deleteGoods(gid);
        }catch (Exception e){
            throw new GoodsException("服务器异常");
        }
    }
}
