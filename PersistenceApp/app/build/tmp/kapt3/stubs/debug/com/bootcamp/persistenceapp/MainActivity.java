package com.bootcamp.persistenceapp;

import java.lang.System;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010#\u001a\u00020 2\b\u0010$\u001a\u0004\u0018\u00010%H\u0014J\b\u0010&\u001a\u00020 H\u0002J\b\u0010\'\u001a\u00020 H\u0002J\b\u0010(\u001a\u00020 H\u0002J\b\u0010)\u001a\u00020 H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006+"}, d2 = {"Lcom/bootcamp/persistenceapp/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "nameEditText", "Landroid/widget/EditText;", "getNameEditText", "()Landroid/widget/EditText;", "setNameEditText", "(Landroid/widget/EditText;)V", "preferences", "Landroid/content/SharedPreferences;", "getPreferences", "()Landroid/content/SharedPreferences;", "setPreferences", "(Landroid/content/SharedPreferences;)V", "preferences2", "getPreferences2", "setPreferences2", "recycler", "Landroidx/recyclerview/widget/RecyclerView;", "getRecycler", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecycler", "(Landroidx/recyclerview/widget/RecyclerView;)V", "viewModel", "Lcom/bootcamp/persistenceapp/TodoViewModel;", "getViewModel", "()Lcom/bootcamp/persistenceapp/TodoViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onClick", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveButton", "saveInDB", "saveInDBWithRepository", "showName", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    public static final com.bootcamp.persistenceapp.MainActivity.Companion Companion = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String NAME_KEY = "myname";
    public android.widget.EditText nameEditText;
    public android.content.SharedPreferences preferences;
    public android.content.SharedPreferences preferences2;
    public androidx.recyclerview.widget.RecyclerView recycler;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public MainActivity() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.widget.EditText getNameEditText() {
        return null;
    }
    
    public final void setNameEditText(@org.jetbrains.annotations.NotNull()
    android.widget.EditText p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPreferences() {
        return null;
    }
    
    public final void setPreferences(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.SharedPreferences getPreferences2() {
        return null;
    }
    
    public final void setPreferences2(@org.jetbrains.annotations.NotNull()
    android.content.SharedPreferences p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.recyclerview.widget.RecyclerView getRecycler() {
        return null;
    }
    
    public final void setRecycler(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.bootcamp.persistenceapp.TodoViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.Nullable()
    android.view.View v) {
    }
    
    private final void saveInDB() {
    }
    
    private final void saveInDBWithRepository() {
    }
    
    private final void showName() {
    }
    
    private final void saveButton() {
    }
    
    @kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/bootcamp/persistenceapp/MainActivity$Companion;", "", "()V", "NAME_KEY", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}