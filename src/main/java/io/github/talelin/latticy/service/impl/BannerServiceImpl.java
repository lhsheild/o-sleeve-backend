package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.autoconfigure.exception.NotFoundException;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.mapper.BannerItemMapper;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import io.github.talelin.latticy.service.BannerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerDO> implements BannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Autowired
    private BannerItemMapper bannerItemMapper;

    public void update(BannerDTO bannerDTO, Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException("banner未找到", 20000);
        }
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        this.updateById(bannerDO);
    }

    public void delete(Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException("banner未找到", 20000);
        }
        this.getBaseMapper().deleteById(id);
    }

    public BannerWithItemsBO getWithItems(Long id) {
        BannerDO bannerDO = this.getById(id);
        if (bannerDO == null) {
            throw new NotFoundException(20000);
        }
        Long bannerId = bannerDO.getId();
        QueryWrapper<BannerItemDO> wrapper = new QueryWrapper<>();
//        wrapper.eq("banner_id", bannerId);
        wrapper.lambda().eq(BannerItemDO::getBannerId, id);
        List<BannerItemDO> bannerItemDOList = this.bannerItemMapper.selectList(wrapper);
        BannerWithItemsBO bannerWithItemsBO = new BannerWithItemsBO(bannerDO, bannerItemDOList);
        return bannerWithItemsBO;
    }
}
