package io.github.talelin.latticy.controller.v1;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.github.talelin.core.annotation.*;
import io.github.talelin.latticy.bo.BannerWithItemsBO;
import io.github.talelin.latticy.common.mybatis.Page;
import io.github.talelin.latticy.dto.BannerDTO;
import io.github.talelin.latticy.model.BannerDO;
import io.github.talelin.latticy.service.impl.BannerServiceImpl;
import io.github.talelin.latticy.vo.CreatedVO;
import io.github.talelin.latticy.vo.DeletedVO;
import io.github.talelin.latticy.vo.PageResponseVO;
import io.github.talelin.latticy.vo.UpdatedVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/v1/banner")
@Validated
@PermissionModule(value = "Banner")
public class BannerController {
    @Autowired
    private BannerServiceImpl bannerService;

    @DeleteMapping("/{id}")
    @PermissionMeta(value = "删除Banner")
    @GroupRequired
    public DeletedVO delete(
            @PathVariable @Positive Long id
    ) {
        bannerService.delete(id);
        return new DeletedVO();
    }

    @PutMapping("/{id}")
    @PermissionMeta(value = "更新Banner")
    @GroupRequired
    public UpdatedVO update(
            @PathVariable @Positive Long id,
            @RequestBody @Validated BannerDTO bannerDTO
    ) {
        bannerService.update(bannerDTO, id);
        return new UpdatedVO();
    }

    @PostMapping
    @PermissionMeta(value = "创建Banner")
    @GroupRequired
    public CreatedVO create(
            @RequestBody @Validated BannerDTO bannerDTO
    ) {
        BannerDO bannerDO = new BannerDO();
        BeanUtils.copyProperties(bannerDTO, bannerDO);
        this.bannerService.save(bannerDO);
        return new CreatedVO();
    }

    @GetMapping("/page")
    @LoginRequired
    public PageResponseVO<BannerDO> getBanners(
            @RequestParam(defaultValue = "0", required = false) @Min(value = 0, message = "{page.number.min}") Integer page,
            @RequestParam(defaultValue = "0", required = false) @Min(value = 1, message = "{page.count.min}") @Max(value = 30, message = "{page.count.max}") Integer count
    ) {
        Page<BannerDO> pager = new Page<>(page, count);
        IPage<BannerDO> paging = bannerService.getBaseMapper().selectPage(pager, null);
        return new PageResponseVO<BannerDO>(paging.getTotal(), paging.getRecords(), paging.getCurrent(), paging.getSize());
    }

    @GetMapping("/{id}")
    @LoginRequired
    @PermissionMeta(value = "查询Banner")
    @Logger(template = "{user.username}查询了Banner数据")
    public BannerWithItemsBO getWithItems(
            @PathVariable @Positive Long id
    ) {
        return this.bannerService.getWithItems(id);
    }
}
