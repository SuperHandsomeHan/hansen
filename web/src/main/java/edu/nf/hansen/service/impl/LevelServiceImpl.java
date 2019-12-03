package edu.nf.hansen.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.dao.LevelDao;
import edu.nf.hansen.entity.Level;
import edu.nf.hansen.service.LevelService;
import edu.nf.hansen.service.exception.LevelException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/21
 */
@Service("levelService")
public class LevelServiceImpl implements LevelService {
    @Autowired
    private LevelDao dao;

    @Override
    public PageInfo<List<Level>> listLevel(Integer pageNum, Integer pageSize) {
        try {
            return new PageInfo(dao.listLevel(pageNum, pageSize));
        } catch (Exception e){
            throw new LevelException("服务器异常");
        }
    }

    @Override
    public Level getLevelById(String levelId) {
        try {
            return dao.getLevelById(levelId);
        } catch (Exception e){
            throw new LevelException("服务器异常");
        }
    }

    @Override
    public Level getLevelByName(String levelName) {
        try {
            return dao.getLevelById(levelName);
        } catch (Exception e){
            throw new LevelException("服务器异常");
        }
    }

    @Override
    public void addLevel(Level level) {
        Level l = dao.getLevelByName(level.getLevelName());
        if(l != null){
            throw new LevelException("该职位已经存在");
        }
        try {
            dao.addLevel(level);
        } catch (Exception e){
            throw new LevelException("服务器异常");
        }
    }

    @Override
    public void updateLevel(Level level) {
        try {
            dao.updateLevel(level);
        } catch (Exception e){
            throw new LevelException("服务器异常");
        }
    }

    @Override
    public void deleteLevel(String levelId) {
        Level l = dao.getLevelById(levelId);
        if(l == null){
            throw new LevelException("该职位不存在");
        }
        try {
            dao.deleteLevel(levelId);
        } catch (Exception e){
            throw new LevelException("服务器异常");
        }
    }
}
