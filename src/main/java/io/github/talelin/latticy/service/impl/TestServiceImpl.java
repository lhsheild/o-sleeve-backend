package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.mapper.BannerMapper;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author a7818
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<BannerDO> getBanners() {
        return this.bannerMapper.getAllBanners();
    }

    @Override
    public List<BannerDO> getBanners2() {
        return this.bannerMapper.getAllBanners2();
    }

    @Override
    public Long insertBanner() {
        BannerDO bannerDO = new BannerDO();
        bannerDO.setName("newbanner");
        bannerDO.setTitle("newbannertitle");
        bannerMapper.insertBanner(bannerDO);
        return bannerDO.getId();
    }
}
