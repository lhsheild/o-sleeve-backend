package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.model.SpecKeyDO;
import io.github.talelin.latticy.mapper.SpecKeyMapper;
import io.github.talelin.latticy.service.SpecKeyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-11-08
 */
@Service
public class SpecKeyServiceImpl extends ServiceImpl<SpecKeyMapper, SpecKeyDO> implements SpecKeyService {

    public List<SpecKeyDO> getBySpuId(Long spuId){
        return this.getBaseMapper().getBySpuId(spuId);
    }
}
