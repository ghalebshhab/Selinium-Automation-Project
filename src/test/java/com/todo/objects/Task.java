package com.todo.objects;

public class Task {
    private String item;
    private boolean isCompleted;
    public Task(String item,boolean isCompleted){
        this.item=item;
        this.isCompleted=isCompleted;
    }

    public String getitem() {
        return item;
    }

    public boolean getisCompleted() {
        return isCompleted;
    }
}
