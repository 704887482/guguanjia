package cn.nyse.service.impl;

import cn.nyse.entity.Demand;
import cn.nyse.service.DemandService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author hhy
 * @Date 2019/10/10 15:15
 */
@Service
@Transactional
public class DemandImpl extends ServiceImpl<Demand> implements DemandService {
}
