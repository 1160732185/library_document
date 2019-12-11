package com.document.ecust.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Information {
    ArrayList<Type> types;
    ArrayList<Integer> ano;
    HashMap<String,Integer> cata;
    HashMap<String,Integer> catd;
    HashMap<String,Integer> catl;
    HashMap<String,Integer> catt;
    Book[] books;
    public ArrayList<Type> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<Type> types) {
        this.types = types;
    }

    public ArrayList<Integer> getAno() {
        return ano;
    }

    public void setAno(ArrayList<Integer> ano) {
        this.ano = ano;
    }

    public HashMap<String, Integer> getCata() {
        return cata;
    }

    public void setCata(HashMap<String, Integer> cata) {
        this.cata = cata;
    }

    public HashMap<String, Integer> getCatd() {
        return catd;
    }

    public void setCatd(HashMap<String, Integer> catd) {
        this.catd = catd;
    }

    public HashMap<String, Integer> getCatl() {
        return catl;
    }

    public void setCatl(HashMap<String, Integer> catl) {
        this.catl = catl;
    }

    public HashMap<String, Integer> getCatt() {
        return catt;
    }

    public void setCatt(HashMap<String, Integer> catt) {
        this.catt = catt;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
