package io.github.talelin.latticy.service;

import io.github.talelin.latticy.model.CategoryDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-11-09
 */
public interface CategoryService extends IService<CategoryDO> {
    CategoryDO getCategory(Integer id);
}
