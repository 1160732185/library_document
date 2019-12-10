package com.document.ecust.service;

import com.document.ecust.model.Type;

public interface TypeService {
    Type[] getAllType();
    Type[] getTypeJQ(String para,String content);
}
