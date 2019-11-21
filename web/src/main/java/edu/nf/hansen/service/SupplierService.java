package edu.nf.hansen.service;

import com.github.pagehelper.PageInfo;
import edu.nf.hansen.entity.Supplier;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Achine
 * @date 2019/11/21
 */
public interface SupplierService {
    PageInfo<List<Supplier>> listSupplier(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize);

    Supplier getSupplierById(String sid);

    Supplier getSupplierByName(String sname);

    void addSupplier(Supplier supplier);

    void updateSupplier(Supplier supplier);

    void deleteSupplier(String sid);
}