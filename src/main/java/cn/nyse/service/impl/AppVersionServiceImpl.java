package cn.nyse.service.impl;

import cn.nyse.entity.AppVersion;
import cn.nyse.service.AppVersionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AppVersionServiceImpl extends ServiceImpl<AppVersion> implements AppVersionService {

   /* @Autowired
    AppVersionMapper mapper;

    @Override
    public List<AppVersion> selectAll() {
        return mapper.selectAll();
    }*/
}
