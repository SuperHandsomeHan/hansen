package edu.nf.hansen.controller;

import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Achine
 * @date 2019/12/3
 */
@RestController
public class PersonalController extends BaseController {
    @Autowired
    @Qualifier("personalService")
    private PersonalService service;

    @GetMapping("/get_personal")
    public ResponseVO getPersonal(String uid){
        return success(service.getPersonal(uid));
    }
}
