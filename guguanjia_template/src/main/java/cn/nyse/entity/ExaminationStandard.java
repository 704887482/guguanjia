package cn.nyse.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "examination_standard")
public class ExaminationStandard {
    @Id
    private Long id;

    private String title;

    private Integer code;

    private String content;

    @Column(name = "based_on")
    private String basedOn;

    /**
     * 1、我是产废方            2、我是处置方
     */
    private Integer type;

    /**
     * 1、单选  2、多选
     */
    @Column(name = "examination_type")
    private Integer examinationType;

    /**
     *  达标说明
     */
    private String description;

    /**
     * 数据创建时间,在数据新增时设置
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 数据修改时间,在数据新增时和修改时设置
     */
    @Column(name = "update_date")
    private Date updateDate;

    /**
     * 删除标记（0：正常；1：删除；2：审核；）
     */
    @Column(name = "del_flag")
    private String delFlag;

    @Column(name = "create_by")
    private String createBy;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * @return code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * @return based_on
     */
    public String getBasedOn() {
        return basedOn;
    }

    /**
     * @param basedOn
     */
    public void setBasedOn(String basedOn) {
        this.basedOn = basedOn == null ? null : basedOn.trim();
    }

    /**
     * 获取1、我是产废方            2、我是处置方
     *
     * @return type - 1、我是产废方            2、我是处置方
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置1、我是产废方            2、我是处置方
     *
     * @param type 1、我是产废方            2、我是处置方
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取1、单选  2、多选
     *
     * @return examination_type - 1、单选  2、多选
     */
    public Integer getExaminationType() {
        return examinationType;
    }

    /**
     * 设置1、单选  2、多选
     *
     * @param examinationType 1、单选  2、多选
     */
    public void setExaminationType(Integer examinationType) {
        this.examinationType = examinationType;
    }

    /**
     * 获取 达标说明
     *
     * @return description -  达标说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置 达标说明
     *
     * @param description  达标说明
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取数据创建时间,在数据新增时设置
     *
     * @return create_date - 数据创建时间,在数据新增时设置
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置数据创建时间,在数据新增时设置
     *
     * @param createDate 数据创建时间,在数据新增时设置
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取数据修改时间,在数据新增时和修改时设置
     *
     * @return update_date - 数据修改时间,在数据新增时和修改时设置
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 设置数据修改时间,在数据新增时和修改时设置
     *
     * @param updateDate 数据修改时间,在数据新增时和修改时设置
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 获取删除标记（0：正常；1：删除；2：审核；）
     *
     * @return del_flag - 删除标记（0：正常；1：删除；2：审核；）
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记（0：正常；1：删除；2：审核；）
     *
     * @param delFlag 删除标记（0：正常；1：删除；2：审核；）
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }

    /**
     * @return create_by
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * @param createBy
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }
}