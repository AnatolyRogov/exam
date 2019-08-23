package ru.sib.exam.framework.utils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CollectionUtils {

    public ArrayList<String> getListOfString(String str) {
        if(str != null) {
            ArrayList<String> list = new ArrayList<String>();
            str.split(",");
            for (String a : str.split(",")) {
                list.add(a);
            }
            return list;
        }
        return null;
    }
}
