package cn.nyse.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "waste")
public class Waste {
    @Id
    private Long id;

    /**
     * 大类ID
     */
    @Column(name = "parent_id")
    private Long parentId;

    private String name;

    private String code;

    @Column(name = "hazardous_characteristics")
    private String hazardousCharacteristics;

    @Column(name = "industry_from_id")
    private Long industryFromId;

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
     * 获取大类ID
     *
     * @return parent_id - 大类ID
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * 设置大类ID
     *
     * @param parentId 大类ID
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return hazardous_characteristics
     */
    public String getHazardousCharacteristics() {
        return hazardousCharacteristics;
    }

    /**
     * @param hazardousCharacteristics
     */
    public void setHazardousCharacteristics(String hazardousCharacteristics) {
        this.hazardousCharacteristics = hazardousCharacteristics == null ? null : hazardousCharacteristics.trim();
    }

    /**
     * @return industry_from_id
     */
    public Long getIndustryFromId() {
        return industryFromId;
    }

    /**
     * @param industryFromId
     */
    public void setIndustryFromId(Long industryFromId) {
        this.industryFromId = industryFromId;
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