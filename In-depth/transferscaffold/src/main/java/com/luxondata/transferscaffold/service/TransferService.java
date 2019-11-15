package com.luxondata.transferscaffold.service;

import com.luxondata.transferscaffold.pojo.RecordLog;

/**
 * TransferService
 *
 * @author dusk
 * @since 15/11/2019
 */

public interface TransferService {
    RecordLog selectRecodeByCreateTime(String name);
}
