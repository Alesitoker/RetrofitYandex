package com.iessaladillo.alejandro.retrofityandex.data.entity;

import java.util.List;

public class TranslateText {

    private List<String> text;

    public TranslateText(List<String> text) {
        this.text = text;
    }

    public List<String> getText() {
        return text;
    }
}
