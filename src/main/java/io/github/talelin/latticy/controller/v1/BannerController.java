package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.impl.BannerServiceImpl;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/banner")
@Validated
public class BannerController {
    @Autowired
    private BannerServiceImpl bannerService;

    @DeleteMapping("/{id}")
    public DeletedVO delete(
            @PathVariable @Positive Long id
    ) {
        bannerService.delete(id);
        return new DeletedVO();
    }

    @PutMapping("/{id}")
    public UpdatedVO update(
            @PathVariable @Positive Long id,
            @RequestBody @Validated BannerDTO bannerDTO
    ) {
        bannerService.update(bannerDTO, id);
        return new UpdatedVO();
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

    @GetMapping("/{id}")
    public BannerWithItemsBO getWithItems(
            @PathVariable @Positive Long id
    ) {
        return this.bannerService.getWithItems(id);
    }
}
