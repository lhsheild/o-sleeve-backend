package io.github.talelin.latticy.service;

import io.github.talelin.latticy.model.SpuDO;
import com.baomidou.mybatisplus.extension.service.IService;
import io.github.talelin.latticy.model.SpuDetailDO;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-11-03
 */
public interface SpuService extends IService<SpuDO> {
    SpuDetailDO getDetail(Long id);
}
