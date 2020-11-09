package io.github.talelin.latticy.service.impl;

import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.model.CategoryDO;
import io.github.talelin.latticy.mapper.CategoryMapper;
import io.github.talelin.latticy.service.CategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-11-09
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, CategoryDO> implements CategoryService {
    public CategoryDO getCategory(Integer id){
        CategoryDO categoryDO = this.getById(id);
        if (categoryDO == null){
            throw new NotFoundException(40000);
        }
        return categoryDO;
    }
}
