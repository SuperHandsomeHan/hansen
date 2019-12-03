package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.service.BossService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Achine
 * @date 2019/12/3
 */
@RestController
public class BossController extends BaseController {
    @Autowired
    @Qualifier("BossService")
    private BossService service;

    @GetMapping("/get_boss")
    public ResponseVO getBoss(){
        return success(service.getBoss());
    }
}
