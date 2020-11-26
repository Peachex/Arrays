package com.epam.array.creator;

import com.epam.array.entity.SingleArray;
import com.epam.array.reader.SingleArrayReader;
import com.epam.array.service.NumberService;

public class SingleArrayCreator {
    public SingleArray createSingleArray(int size) {
        SingleArrayReader reader = new SingleArrayReader();
        return new SingleArray(reader.readArrayFromConsole(size));
    }

    public SingleArray createSingleArray(int size, int maxValue) {
        NumberService service = new NumberService();
        return new SingleArray(service.findRandomNumbersArray(size, maxValue));
    }

    public SingleArray createSingleArray(String path) {
        SingleArrayReader reader = new SingleArrayReader();
        return new SingleArray(reader.readArrayFromFile(path));
    }
}