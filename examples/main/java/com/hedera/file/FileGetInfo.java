package com.hedera.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hedera.sdk.common.HederaPrecheckResult;
import com.hedera.sdk.file.HederaFile;

public final class FileGetInfo {
	public static boolean getInfo(HederaFile file) throws Exception {
		final Logger logger = LoggerFactory.getLogger(FileGetInfo.class);
		
		logger.info("");
		logger.info("FILE GET INFO");
		logger.info("");

		// get info for the file
		if (file.getInfo()) {
			logger.info("===>Got info");
			return true;
		} else if (file.getPrecheckResult() == HederaPrecheckResult.BUSY) {
			logger.info("system busy, try again later");
			return false;
		} else {
			logger.info("===>Getting info - precheck ERROR " + file.getPrecheckResult());
			return false;
		}
		
	}
}
