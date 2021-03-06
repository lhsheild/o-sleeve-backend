package io.github.talelin.latticy.bo;

import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.model.BannerItemDO;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.Banner;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Data
@NoArgsConstructor
public class BannerWithItemsBO {
    private Long id;
    private String name;
    private String title;
    private String img;
    private String description;

    List<BannerItemDO> items;

    public BannerWithItemsBO(BannerDO bannerDO, List<BannerItemDO> items) {
        BeanUtils.copyProperties(bannerDO, this);
        this.setItems(items);
    }
}
