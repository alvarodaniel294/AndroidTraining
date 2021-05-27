package com.bootcamp.persistenceapp.todoRepository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0087@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/bootcamp/persistenceapp/todoRepository/TodoRepository;", "", "dao", "Lcom/bootcamp/persistenceapp/dao/TodoDao;", "(Lcom/bootcamp/persistenceapp/dao/TodoDao;)V", "todoList", "Landroidx/lifecycle/LiveData;", "", "Lcom/bootcamp/persistenceapp/entities/Todo;", "getTodoList", "()Landroidx/lifecycle/LiveData;", "addTodo", "", "todo", "(Lcom/bootcamp/persistenceapp/entities/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateTodo", "app_debug"})
public final class TodoRepository {
    private final com.bootcamp.persistenceapp.dao.TodoDao dao = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.bootcamp.persistenceapp.entities.Todo>> todoList = null;
    
    public TodoRepository(@org.jetbrains.annotations.NotNull()
    com.bootcamp.persistenceapp.dao.TodoDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.bootcamp.persistenceapp.entities.Todo>> getTodoList() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.annotation.WorkerThread()
    public final java.lang.Object addTodo(@org.jetbrains.annotations.NotNull()
    com.bootcamp.persistenceapp.entities.Todo todo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public final void updateTodo(@org.jetbrains.annotations.NotNull()
    com.bootcamp.persistenceapp.entities.Todo todo) {
    }
}