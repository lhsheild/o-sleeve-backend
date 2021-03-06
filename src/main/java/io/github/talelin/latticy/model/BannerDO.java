package io.github.talelin.latticy.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@TableName("banner")
public class BannerDO extends BaseModel {
    //    @TableId(value = "id", type = IdType.AUTO)
//    private Long id;
    private String name;
    private String description;
    private String title;
    private String img;
//    @JsonIgnore
//    private Date createTime;
//    @JsonIgnore
//    private Date updateTime;
//    @JsonIgnore
//    @TableLogic
//    private Date deleteTime;
}
