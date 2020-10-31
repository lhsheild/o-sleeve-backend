package io.github.talelin.latticy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, BannerDO> {
    @Autowired
    private BannerMapper bannerMapper;

    public void getBanners(){
//        bannerMapper.selectPage();
    }
}
