package edu.nf.hansen.controller;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.controller.vo.ResponseVO;
import edu.nf.hansen.entity.Supplier;
import edu.nf.hansen.service.SupplierService;
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
public class SupplierController extends BaseController {
    @Autowired
    @Qualifier("supplierService")
    private SupplierService service;

    @GetMapping("/list_supplier")
    public ResponseVO<PageInfo<List<Supplier>>> listSupplier(Integer pageNum, Integer pageSize){
        return success(service.listSupplier(pageNum, pageSize));
    }

    @GetMapping("/get_supplier")
    public ResponseVO getSupplierById(String sid){
        return success(service.getSupplierById(sid));
    }

    @PostMapping("/update_supplier")
    public ResponseVO updateSupplier(Supplier supplier){
        service.updateSupplier(supplier);
        return success("修改成功！");
    }

    @PostMapping("/add_supplier")
    public ResponseVO addSupplier(Supplier supplier){
        service.addSupplier(supplier);
        return success("添加成功！");
    }

    @PostMapping("/delete_supplier")
    public ResponseVO deleteSupplier(String ... sid){
        service.deleteSupplier(sid);
        return success("删除成功！");
    }

}
