package cn.nyse.service.impl;

import cn.nyse.entity.WorkOrder;
import cn.nyse.service.WorkService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author hhy
 * @Date 2019/10/10 18:11
 */
@Service
@Transactional
public class WorkServieImpl extends ServiceImpl<WorkOrder> implements WorkService {
}
