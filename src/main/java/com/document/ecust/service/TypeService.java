package com.document.ecust.service;

import com.document.ecust.model.Information;
import com.document.ecust.model.Type;

import java.util.ArrayList;

public interface TypeService {
    Type[] getAllType();
    Information getTypeJQ(String para,String content);
    Information getTypeAD(String name, String author, String publisher, String isbn, String callno);
    Information getTypeFM(String name, String author, String publisher, String isbn, String callno, String a, String d, String l, String t);
    String[] getHot();

    String addComment(String comment,String isbn);
    String[] getComment(String isbn);

    String getConn(String isbn);
}
