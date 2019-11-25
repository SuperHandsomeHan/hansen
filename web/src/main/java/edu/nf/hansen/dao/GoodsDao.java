package edu.nf.hansen.dao;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.entity.Goods;
import edu.nf.hansen.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/22
 */
public interface GoodsDao {
    List<Goods> listGoods(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    List<Goods> listGoods();

    Goods getGoodsById(String gid);

    Goods getGoodsByName(String gname);

    void addGoods(Goods goods);

    void updateGoods(Goods goods);

    void deleteGoods(String ... sid);
}