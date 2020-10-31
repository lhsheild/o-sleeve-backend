package io.github.talelin.latticy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.github.talelin.latticy.model.BannerDO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author a7818
 */
@Repository
public interface BannerMapper extends BaseMapper<BannerDO> {
    List<BannerDO> getAllBanners();

    int insertBanner(BannerDO bannerDO);

    @Select(value = "select * from banner")
    List<BannerDO> getAllBanners2();
}
