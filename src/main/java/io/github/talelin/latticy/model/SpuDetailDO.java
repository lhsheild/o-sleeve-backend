package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author generator@TaleLin
 * @since 2020-11-03
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("spu")
public class SpuDetailDO extends SpuDO {
    private String categoryName;
    private String sketchSpecKeyName;
    private String defaultSkuTitle;
    private List<String> spuImgList;
    private List<String> spuDetailImgList;
}
