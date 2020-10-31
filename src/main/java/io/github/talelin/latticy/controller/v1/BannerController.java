package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.impl.BannerServiceImpl;
import io.github.talelin.latticy.vo.PageResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {
    @Autowired
    private BannerServiceImpl bannerService;

    @PutMapping("/{id}")
    public void update(
            @PathVariable Long id,
            @RequestBody @Validated BannerDTO bannerDTO
            )
    {

    }

    @GetMapping("/page")
    public PageResponseVO<BannerDO> getBanners(
            @RequestParam(defaultValue = "0", required = false) @Min(value = 0, message = "{page.number.min}") Integer page,
            @RequestParam(defaultValue = "0", required = false) @Min(value = 1, message = "{page.count.min}") @Max(value = 30, message = "{page.count.max}") Integer count
    ) {
        Page<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.getBaseMapper().selectPage(pager, null);
        return new PageResponseVO<BannerDO>(paging.getTotal(), paging.getRecords(), paging.getCurrent(), paging.getSize());
    }
}
