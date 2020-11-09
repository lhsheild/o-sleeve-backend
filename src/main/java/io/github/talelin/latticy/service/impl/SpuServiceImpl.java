package io.github.talelin.latticy.service.impl;

import io.github.talelin.latticy.dto.SpuDTO;
import io.github.talelin.latticy.model.*;
import io.github.talelin.latticy.mapper.SpuMapper;
import io.github.talelin.latticy.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author generator@TaleLin
 * @since 2020-11-03
 */
@Service
public class SpuServiceImpl extends ServiceImpl<SpuMapper, SpuDO> implements SpuService {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SpuImgService spuImgService;

    @Autowired
    private SpuDetailImgService spuDetailImgService;

    @Autowired
    private SpuKeyService spuKeyService;

    @Override
    public SpuDetailDO getDetail(Long id) {
        return this.getBaseMapper().getDetail(id);
    }

    @Transactional
    public void create(SpuDTO spuDTO) {
        SpuDO spuDO = new SpuDO();
        BeanUtils.copyProperties(spuDTO, spuDO);

        CategoryDO categoryDO = categoryService.getCategory(spuDTO.getCategoryId());
        spuDO.setRootCategoryId(categoryDO.getParentId());

        List<String> spuImgList = new ArrayList<>();
        if (spuDTO.getSpuImgList() == null) {
            spuImgList.add(spuDTO.getImg());
        } else {
            spuImgList = spuDTO.getSpuImgList();
        }
        this.insertSpuImgList(spuImgList, spuDO.getId());

        if (spuDTO.getSpuDetailImgList() != null) {
            this.insertSpuDetailImgList(spuDTO.getSpuDetailImgList(), spuDO.getId());
        }

        if (spuDTO.getSpecKeyIdList() != null) {
            this.insertSpuKeyList(spuDTO.getSpecKeyIdList(), spuDO.getId());
        }

        this.save(spuDO);
    }

    private void insertSpuImgList(List<String> spuImgList, Long spuId) {
        List<SpuImgDO> spuImgDOList = spuImgList.stream().map(s -> {
            SpuImgDO spuImgDO = new SpuImgDO();
            spuImgDO.setImg(s);
            spuImgDO.setSpuId(spuId.intValue());
            return spuImgDO;
        }).collect(Collectors.toList());

        this.spuImgService.saveBatch(spuImgDOList);
    }

    private void insertSpuDetailImgList(List<String> spuDetailImgList, Long spuId) {
        AtomicReference<Integer> index = new AtomicReference<>(0);
        List<SpuDetailImgDO> spuDetailImgDOList = spuDetailImgList.stream().map(s -> {
            SpuDetailImgDO spuDetailImgDO = new SpuDetailImgDO();
            spuDetailImgDO.setImg(s);
            spuDetailImgDO.setSpuId(spuId.intValue());
            spuDetailImgDO.setIndex(index.get());
            index.updateAndGet(v -> v + 1);
            return spuDetailImgDO;
        }).collect(Collectors.toList());

        this.spuDetailImgService.saveBatch(spuDetailImgDOList);
    }

    private void insertSpuKeyList(List<Integer> spuKeyIdList, Long spuId) {
        List<SpuKeyDO> spuKeyDOList = spuKeyIdList.stream().map(sk -> {
            SpuKeyDO spuKeyDO = new SpuKeyDO();
            spuKeyDO.setSpuId(spuId.intValue());
            spuKeyDO.setSpecKeyId(sk);
            return spuKeyDO;
        }).collect(Collectors.toList());
        this.spuKeyService.saveBatch(spuKeyDOList);
    }
}
