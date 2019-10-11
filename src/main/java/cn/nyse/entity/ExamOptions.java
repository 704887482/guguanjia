package cn.nyse.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "options")
public class ExamOptions {
    @Id
    private Long id;

    @Column(name = "examination_standard_id")
    private Long examinationStandardId;

    private String content;

    /**
     * eg:            A B C
     */
    private Integer code;

    private Float score;

    /**
     * 0：基础选项    1：本题否决项（选中本题为0）   2：全局否决项（选中总分为0）
     */
    @Column(name = "veto_item")
    private Integer vetoItem;

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
     * @return examination_standard_id
     */
    public Long getExaminationStandardId() {
        return examinationStandardId;
    }

    /**
     * @param examinationStandardId
     */
    public void setExaminationStandardId(Long examinationStandardId) {
        this.examinationStandardId = examinationStandardId;
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
     * 获取eg:            A B C
     *
     * @return code - eg:            A B C
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 设置eg:            A B C
     *
     * @param code eg:            A B C
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return score
     */
    public Float getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Float score) {
        this.score = score;
    }

    /**
     * 获取0：基础选项    1：本题否决项（选中本题为0）   2：全局否决项（选中总分为0）
     *
     * @return veto_item - 0：基础选项    1：本题否决项（选中本题为0）   2：全局否决项（选中总分为0）
     */
    public Integer getVetoItem() {
        return vetoItem;
    }

    /**
     * 设置0：基础选项    1：本题否决项（选中本题为0）   2：全局否决项（选中总分为0）
     *
     * @param vetoItem 0：基础选项    1：本题否决项（选中本题为0）   2：全局否决项（选中总分为0）
     */
    public void setVetoItem(Integer vetoItem) {
        this.vetoItem = vetoItem;
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