package com.bootcamp.persistenceapp.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\bH\'J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000b"}, d2 = {"Lcom/bootcamp/persistenceapp/dao/TodoDao;", "", "addTodo", "", "todo", "Lcom/bootcamp/persistenceapp/entities/Todo;", "(Lcom/bootcamp/persistenceapp/entities/Todo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTodosList", "Landroidx/lifecycle/LiveData;", "", "removeTodo", "app_debug"})
public abstract interface TodoDao {
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM Todo")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.bootcamp.persistenceapp.entities.Todo>> getTodosList();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract java.lang.Object addTodo(@org.jetbrains.annotations.NotNull()
    com.bootcamp.persistenceapp.entities.Todo todo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    @androidx.room.Delete()
    public abstract void removeTodo(@org.jetbrains.annotations.NotNull()
    com.bootcamp.persistenceapp.entities.Todo todo);
}