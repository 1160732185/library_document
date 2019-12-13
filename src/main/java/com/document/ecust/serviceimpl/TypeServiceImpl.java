package com.document.ecust.serviceimpl;

import com.document.ecust.mapper.TypeMapper;
import com.document.ecust.model.Book;
import com.document.ecust.model.Information;
import com.document.ecust.model.Type;
import com.document.ecust.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;

public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeMapper typeMapper;
    @Override
    public Type[] getAllType() {
        return typeMapper.getAllType();
    }
    @Override
    public Information getTypeJQ(String para,String content)
    {
        Type[] typeshuzu = new Type[100];
        Information result = new Information();
        ArrayList<Type> types = new ArrayList<>();
        ArrayList<Integer> ano = new ArrayList<>();
        Book[] books = new Book[100];
        HashMap<String,Integer> cata = new HashMap<>();
        HashMap<String,Integer> catl = new HashMap<>();
        HashMap<String,Integer> catd = new HashMap<>();
        HashMap<String,Integer> catt = new HashMap<>();
        result.setTypes(types);
        result.setCata(cata);result.setCatd(catd);result.setCatl(catl);result.setCatt(catt);result.setAno(ano);
        if(para.equals("name")||para.equals("title")){
            if(typeMapper.getHotSearchByWord(content)==null) {typeMapper.insertHotSearchByWord(content);}else typeMapper.updateHotSearchByWord(content);
        }
        switch (para){
        case "name":
            typeshuzu = typeMapper.getTypeJQN(content); break;
        case "author":
            typeshuzu = typeMapper.getTypeJQA(content);break;
        case "publish":
            typeshuzu = typeMapper.getTypeJQP(content);break;
        case "callNo":
            typeshuzu = typeMapper.getTypeJQC(content);break;
        case "isbn":
            typeshuzu = typeMapper.getTypeJQI(content);break;
    }
    for (Type t:typeshuzu){
        books = typeMapper.getBooksbyIsbn(t.getISBN());
        result.setBooks(books);
        types.add(t);
        ano.add(typeMapper.getAnobyIsbn(t.getISBN()));
        String au = t.getAuthor();
        au = au.replace("等著","");
        au = au.replace("编著","");
        au = au.replace("主编","");
        au = au.replace("编选","");
        au = au.replace("译注","");
        au = au.replace("绘","");
        au = au.replace("著","");
        au = au.replace("编","");
        t.setAuthor(au);
        if(!cata.containsKey(t.getAuthor())){
            cata.put(t.getAuthor(),1);
        }else {
            cata.put(t.getAuthor(),cata.get(t.getAuthor())+1);
        }
        if(!catd.containsKey(t.getPublishtime())){
            catd.put(t.getPublishtime(),1);
        }else {
            catd.put(t.getPublishtime(),catd.get(t.getPublishtime())+1);
        }
        if(!catt.containsKey(t.getBooktype())){
            catt.put(t.getBooktype(),1);
        }else {
            catt.put(t.getBooktype(),catt.get(t.getBooktype())+1);
        }
        if(!catl.containsKey(t.getLang())){
            catl.put(t.getLang(),1);
        }else {
            catl.put(t.getLang(),catl.get(t.getLang())+1);
        }
    }
    return result;
    }

    @Override
    public Information getTypeAD(String name, String author, String publisher, String isbn, String callno) {
        Type[] alltypes = typeMapper.getAllType();
        Information result = new Information();
        ArrayList<Type> types = new ArrayList<>();
        ArrayList<Integer> ano = new ArrayList<>();
        HashMap<String,Integer> cata = new HashMap<>();
        HashMap<String,Integer> catl = new HashMap<>();
        HashMap<String,Integer> catd = new HashMap<>();
        HashMap<String,Integer> catt = new HashMap<>();
        result.setTypes(types);
        result.setCata(cata);result.setCatd(catd);result.setCatl(catl);result.setCatt(catt);result.setAno(ano);
        for (Type t:alltypes){
            if(!name.equals("undefined")&& !t.getName().contains(name))continue;
            if(!author.equals("undefined")&& !t.getAuthor().contains(author))continue;
            if(!publisher.equals("undefined")&& !t.getPublisher().contains(publisher))continue;
            if(!isbn.equals("undefined")&& !t.getISBN().contains(isbn))continue;
            if(!callno.equals("undefined")&& !t.getCallno().contains(callno))continue;
            types.add(t);
            ano.add(typeMapper.getAnobyIsbn(t.getISBN()));
            String au = t.getAuthor();
            au = au.replace("等著","");
            au = au.replace("编著","");
            au = au.replace("主编","");
            au = au.replace("编选","");
            au = au.replace("译注","");
            au = au.replace("绘","");
            au = au.replace("著","");
            au = au.replace("编","");
            t.setAuthor(au);
            if(!cata.containsKey(t.getAuthor())){
                cata.put(t.getAuthor(),1);
            }else {
                cata.put(t.getAuthor(),cata.get(t.getAuthor())+1);
            }
            if(!catd.containsKey(t.getPublishtime())){
                catd.put(t.getPublishtime(),1);
            }else {
                catd.put(t.getPublishtime(),catd.get(t.getPublishtime())+1);
            }
            if(!catt.containsKey(t.getBooktype())){
                catt.put(t.getBooktype(),1);
            }else {
                catt.put(t.getBooktype(),catt.get(t.getBooktype())+1);
            }
            if(!catl.containsKey(t.getLang())){
                catl.put(t.getLang(),1);
            }else {
                catl.put(t.getLang(),catl.get(t.getLang())+1);
            }

        }
        return result;
    }

    @Override
    public Information getTypeFM(String name, String author, String publisher, String isbn, String callno, String a, String d, String l, String t) {
        ArrayList<Type> types = this.getTypeAD(name,author,publisher,isbn,callno).getTypes();
        for (int i = 0;i<types.size();i++){
            if(!a.equals("undefined")&&!types.get(i).getAuthor().equals(a)) {types.remove(i);i--;continue;}
            if(!d.equals("undefined")&&!types.get(i).getPublishtime().equals(d)) {types.remove(i);i--;continue;}
            if(!l.equals("undefined")&&!types.get(i).getLang().equals(l)) {types.remove(i);i--;continue;}
            if(!t.equals("undefined")&&!types.get(i).getBooktype().equals(t)) {types.remove(i);i--;continue;}
        }
        Information result = new Information();
        HashMap<String,Integer> cata = new HashMap<>();
        HashMap<String,Integer> catl = new HashMap<>();
        HashMap<String,Integer> catd = new HashMap<>();
        HashMap<String,Integer> catt = new HashMap<>();
        ArrayList<Integer> ano = new ArrayList<>();
        result.setTypes(types);
        result.setCata(cata);result.setCatd(catd);result.setCatl(catl);result.setCatt(catt);result.setAno(ano);
        for (Type ty:types){
            ano.add(typeMapper.getAnobyIsbn(ty.getISBN()));
            if(!cata.containsKey(ty.getAuthor())){
                cata.put(ty.getAuthor(),1);
            }else {
                cata.put(ty.getAuthor(),cata.get(ty.getAuthor())+1);
            }
            if(!catd.containsKey(ty.getPublishtime())){
                catd.put(ty.getPublishtime(),1);
            }else {
                catd.put(ty.getPublishtime(),catd.get(ty.getPublishtime())+1);
            }
            if(!catt.containsKey(ty.getBooktype())){
                catt.put(ty.getBooktype(),1);
            }else {
                catt.put(ty.getBooktype(),catt.get(ty.getBooktype())+1);
            }
            if(!catl.containsKey(ty.getLang())){
                catl.put(ty.getLang(),1);
            }else {
                catl.put(ty.getLang(),catl.get(ty.getLang())+1);
            }
        }
        return result;
    }

    @Override
    public String[] getHot() {
        String[] r =  typeMapper.getHotSearchByWord5();
        return r;
    }

    @Override
    public String addComment(String comment,String isbn) {
        typeMapper.insertComment(comment,isbn);
        return null;
    }

    @Override
    public String[] getComment(String isbn) {
        return typeMapper.getComment(isbn);
    }

    @Override
    public String getConn(String isbn) {
        return typeMapper.getConn(isbn);
    }
}
