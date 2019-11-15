package com.luxondata.transferscaffold.controller;

import com.luxondata.transferscaffold.config.TransferProperties;
import com.luxondata.transferscaffold.pojo.RecordLog;
import com.luxondata.transferscaffold.pojo.ResponseContent;
import com.luxondata.transferscaffold.service.TransferService;
import com.luxondata.transferscaffold.utils.ProcessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * transferController
 *
 * @author dusk
 * @since 15/11/2019
 */
@RestController
@RequestMapping(value = "/api")
public class TransferController {

    @Autowired
    TransferProperties transferProperties;

    @Autowired
    TransferService transferService;

    @PostMapping("/{name}/startBatch")
    public Object startBatch(@PathVariable("name") String name) {
        ProcessUtils.cmdStart(transferProperties.getPathMap().get(name));
        return ResponseContent.success();
    }

    @GetMapping("/{name}/check")
    public Object check(@PathVariable("name") String name) {
        RecordLog recordLog = transferService.selectRecodeByCreateTime(name);
        return ResponseContent.success(recordLog);
    }
}
