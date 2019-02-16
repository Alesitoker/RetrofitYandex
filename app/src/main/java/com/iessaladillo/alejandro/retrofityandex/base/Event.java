package com.iessaladillo.alejandro.retrofityandex.base;

@SuppressWarnings({"unused", "WeakerAccess"})
public class Event<T> {

    private final T content;
    private boolean hasBeenHandled = false;

    public Event(T content) {
        this.content = content;
    }

    public T getContentIfNotHandled() {
        if (hasBeenHandled) return null;
        hasBeenHandled = true;
        return content;
    }

}