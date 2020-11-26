package com.epam.array.report;

import com.epam.array.entity.JaggedArray;
import com.epam.array.entity.SingleArray;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayReport {
    private static final Logger logger = LogManager.getLogger();

    public void reportArray(SingleArray array, String message) {
        logger.info(message + array.toString());
    }

    public void reportArray(JaggedArray jaggedArray, String message) {
        logger.info(message + jaggedArray.toString());
    }

    public void reportBinarySearchResult(SingleArray array, int key, boolean condition) {
        logger.info(key + (condition ? " - was found" : " - wasn't found") + " in the array (" + array.toString() +
                ")");
    }

    public void reportElement(SingleArray array, int element, String message) {
        logger.info(message + element + " (" + array.toString() + ")");
    }
}