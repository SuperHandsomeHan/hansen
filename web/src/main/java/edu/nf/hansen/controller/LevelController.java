package edu.nf.hansen.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Level;
import edu.nf.hansen.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/21
 */
@RestController
public class LevelController extends BaseController {
    @Autowired
    @Qualifier("levelService")
    private LevelService service;

    @GetMapping("/list_level")
    public ResponseVO<PageInfo<List<Level>>> listLevel(Integer pageNum, Integer pageSize){
        return success(service.listLevel(pageNum, pageSize));
    }

    @GetMapping("/get_level")
    public ResponseVO getLevelById(String levelId){
        return success(service.getLevelById(levelId));
    }

    @PostMapping("/update_level")
    public ResponseVO updateLevel(Level level){
        service.updateLevel(level);
        return success("修改成功！");
    }

    @PostMapping("/add_level")
    public ResponseVO addLevel(Level level){
        service.addLevel(level);
        return success("添加成功！");
    }

    @PostMapping("/delete_level")
    public ResponseVO deleteLevel(String levelId){
        service.deleteLevel(levelId);
        return success("删除成功！");
    }

}
