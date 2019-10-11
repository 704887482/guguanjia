package cn.nyse.service;

import cn.nyse.entity.Statute;

import java.util.List;

public interface StatuteService extends IService<Statute> {

    List<Statute> selectByExample(String type);
}
