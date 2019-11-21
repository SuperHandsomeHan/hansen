package edu.nf.hansen.service;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.entity.Level;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/21
 */
public interface LevelService {
    PageInfo<List<Level>> listLevel(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Level getLevelById(String levelId);

    Level getLevelByName(String levelName);

    void addLevel(Level level);

    void updateLevel(Level level);

    void deleteLevel(String levelId);
}