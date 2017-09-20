package com.deep.service.catalog.impl;

import com.deep.repository.catalog.dto.ContentCatalogDto;
import com.deep.repository.catalog.mapper.ContentCatalogMapper;
import com.deep.service.catalog.ICatalogService;
import com.deep.service.catalog.vo.CatalogVo;
import com.deep.service.common.utils.DBUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by yangliuhua on 2017-6-22.
 */
@Service
public class CatalogServiceImpl implements ICatalogService {

    private static final Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Resource
    private DataSource dataSource;

    @Resource
    private ContentCatalogMapper contentCatalogMapper;

    @Override
    public Map<String, Object> getPrimaryCatalogByProfessionId(Integer professionId) {
        Map<String, Object> result = Maps.newHashMap();
        List<ContentCatalogDto> dtoList = contentCatalogMapper.selectPrimaryCatalogByProfessionId(professionId);
        List<ContentCatalogDto> shareCatalog = dtoList.stream().filter(c -> c.getType() == 1).collect(Collectors.toList());
        List<ContentCatalogDto> publicCatalog = dtoList.stream().filter(c -> c.getType() == 0).collect(Collectors.toList());
        result.put("shareCatalog", shareCatalog);
        result.put("publicCatalog", publicCatalog);
        return result;
    }

    @Override
    public List<ContentCatalogDto> getChildrenCatalogByParentId(Integer parentId) {
        return contentCatalogMapper.selectChildrenCatalogByParentId(parentId);
    }

    @Override
    public int addCatalog(List<CatalogVo> catalogVoList) {
        List<String> sqlList = Lists.newArrayList();
        StringBuilder sql = new StringBuilder();
        for (CatalogVo catalogVo : catalogVoList) {
            sql.append("");//todo 新增
            sqlList.add(sql.toString());
            sql.delete(0, sql.length());
        }
        updateDataBase(sqlList);
        return 0;
    }

    @Override
    public int updateCatalog(List<CatalogVo> catalogVoList) {
        List<String> sqlList = Lists.newArrayList();
        StringBuilder sql = new StringBuilder();
        for (CatalogVo catalogVo : catalogVoList) {
            if (catalogVo.getId() == null) {
                sql.append("");//todo 新增
            } else {
                sql.append("");//todo 更新
            }
            sqlList.add(sql.toString());
            sql.delete(0, sql.length());
        }
        updateDataBase(sqlList);
        return 0;
    }

    protected void updateDataBase(List<String> sqlList){
        if(sqlList.size() == 0) return;
        Connection connection = null;
        Statement statement = null;
        boolean autoCommit = false;
        try {
            connection = dataSource.getConnection();
            autoCommit = DBUtils.setAutoCommit(connection, false);
            statement = connection.createStatement();
            int i = 0;
            for(String sql : sqlList) {
                i++;
                logger.debug(sql);
                statement.addBatch(sql);
                if(i % 2000 == 0) statement.executeBatch();
            }
            statement.executeBatch();
            DBUtils.commit(connection);
        } catch (SQLException e) {
            if(e instanceof BatchUpdateException){
                BatchUpdateException batchUpdateException = (BatchUpdateException)e;
                int [] updateCounts = batchUpdateException.getUpdateCounts();
                for(int i = 0 ; i < updateCounts.length;i++) {
                    if(updateCounts[i] == Statement.EXECUTE_FAILED) logger.error(sqlList.get(i));
                }
                DBUtils.commit(connection);
            } else {
                logger.error(getClass().getName() + " updateDataBase SQLException !" + e);
            }
        } finally {
            DBUtils.setAutoCommit(connection,autoCommit);
            DBUtils.close(statement);
            DBUtils.close(connection);
        }
    }
}
