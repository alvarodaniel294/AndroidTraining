package com.bootcamp.persistenceapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/bootcamp/persistenceapp/TodoViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lcom/bootcamp/persistenceapp/todoRepository/TodoRepository;", "(Lcom/bootcamp/persistenceapp/todoRepository/TodoRepository;)V", "todoList", "Landroidx/lifecycle/LiveData;", "", "Lcom/bootcamp/persistenceapp/entities/Todo;", "getTodoList", "()Landroidx/lifecycle/LiveData;", "getListFromDB", "application", "Landroid/app/Application;", "saveData", "", "string", "", "saveDataWithRepository", "todo", "app_debug"})
public final class TodoViewModel extends androidx.lifecycle.ViewModel {
    private final com.bootcamp.persistenceapp.todoRepository.TodoRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.bootcamp.persistenceapp.entities.Todo>> todoList = null;
    
    public TodoViewModel(@org.jetbrains.annotations.NotNull()
    com.bootcamp.persistenceapp.todoRepository.TodoRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bootcamp.persistenceapp.entities.Todo>> getTodoList() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bootcamp.persistenceapp.entities.Todo>> getListFromDB(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
    
    public final void saveData(@org.jetbrains.annotations.NotNull()
    java.lang.String string, @org.jetbrains.annotations.NotNull()
    android.app.Application application) {
    }
    
    public final void saveDataWithRepository(@org.jetbrains.annotations.NotNull()
    com.bootcamp.persistenceapp.entities.Todo todo) {
    }
}