package io.github.talelin.latticy.mapper;

import io.github.talelin.latticy.model.BannerDO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author a7818
 */
@Repository
public interface BannerMapper {
    List<BannerDO> getAllBanners();
}
