package com.luxondata.transferscaffold.service.impl;

import com.luxondata.transferscaffold.pojo.RecordLog;
import com.luxondata.transferscaffold.pojo.ResponseContent;
import com.luxondata.transferscaffold.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * TransferServiceImpl
 *
 * @author dusk
 * @since 15/11/2019
 */
@Service
public class TransferServiceImpl implements TransferService {
    @Autowired
    @Qualifier(value = "omlJdbcTemplate")
    JdbcTemplate omlJdbcTemplate;

    @Autowired
    @Qualifier(value = "sgbJdbcTemplate")
    JdbcTemplate sgbJdbcTemplate;

    @Autowired
    @Qualifier(value = "mySqlJdbcTemplate")
    JdbcTemplate mySqlJdbcTemplate;

    @Override
    public ResponseContent selectRecodeByCreateTime(String name) {
        try {
            JdbcTemplate jdbcTemplate;
            switch (name) {
                case "oml":
                    jdbcTemplate = omlJdbcTemplate;
                    break;
                case "sgb":
                    jdbcTemplate = sgbJdbcTemplate;
                    break;
                case "mysql":
                    jdbcTemplate = mySqlJdbcTemplate;
                    break;
                default:
                    return ResponseContent.failde();
            }
            RecordLog recordLog = getRecord(name, jdbcTemplate);
            return ResponseContent.success(recordLog);
        } catch (Exception e) {
            return ResponseContent.failde();
        }
    }

    private RecordLog getRecord(String name, JdbcTemplate jdbcTemplate) {
        return jdbcTemplate.queryForObject("select * from RecordLog where ItemName = ? and CreateTime >= ?", new Object[]{name, LocalDate.now().toString()}, new BeanPropertyRowMapper<>(RecordLog.class));
    }

}
