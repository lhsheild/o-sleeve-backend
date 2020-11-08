package io.github.talelin.latticy.service;

import io.github.talelin.latticy.model.SpecKeyDO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-11-08
 */
public interface SpecKeyService extends IService<SpecKeyDO> {
    List<SpecKeyDO> getBySpuId(Long spuId);
}
