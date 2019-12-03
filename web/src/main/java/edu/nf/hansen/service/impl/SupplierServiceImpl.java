package edu.nf.hansen.service.impl;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.dao.SupplierDao;
import edu.nf.hansen.entity.Supplier;
import edu.nf.hansen.service.SupplierService;
import edu.nf.hansen.service.exception.SupplierException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/21
 */
@Service("supplierService")
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierDao dao;

    @Override
    public PageInfo<List<Supplier>> listSupplier(Integer pageNum, Integer pageSize) {
        try{
            return new PageInfo(dao.listSupplier(pageNum, pageSize));
        }catch (Exception e){
            throw new SupplierException("服务器异常");
        }
    }

    @Override
    public List<Supplier> listSupplier() {
        try{
            return dao.listSupplier();
        }catch (Exception e){
            throw new SupplierException("服务器异常");
        }
    }

    @Override
    public Supplier getSupplierById(String sid) {
        try{
            return dao.getSupplierById(sid);
        }catch (Exception e){
            throw new SupplierException("服务器异常");
        }
    }

    @Override
    public Supplier getSupplierByName(String sname) {
        try{
            return dao.getSupplierByName(sname);
        }catch (Exception e){
            throw new SupplierException("服务器异常");
        }
    }

    @Override
    public void addSupplier(Supplier supplier) {
        Supplier s = dao.getSupplierByName(supplier.getSname());
        if(s != null){
            throw new SupplierException("该供应商已经存在");
        }
        try{
            dao.addSupplier(supplier);
        }catch (Exception e){
            throw new SupplierException("服务器异常");
        }
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        try{
            dao.updateSupplier(supplier);
        }catch (Exception e){
            throw new SupplierException("服务器异常");
        }
    }

    @Override
    public void deleteSupplier(String ... sid) {
        for (String id : sid){
            Supplier s = dao.getSupplierById(id);
            if(s == null){
                throw new SupplierException("该供应商不存在");
            }
        }
        try{
            dao.deleteSupplier(sid);
        }catch (Exception e){
            throw new SupplierException("服务器异常");
        }
    }
}
