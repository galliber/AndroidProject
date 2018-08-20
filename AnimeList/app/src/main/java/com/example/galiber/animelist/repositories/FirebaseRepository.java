package com.example.galiber.animelist.repositories;

import com.example.galiber.animelist.models.Anime;
import com.example.galiber.animelist.repositories.base.Repository;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;
import java.util.function.Consumer;

public class FirebaseRepository<T> implements Repository {

    private final FirebaseFirestore mFirebase;
    private final Class<T> mKlass;
    private final String mCollectionName;

    public FirebaseRepository(Class<T> klass){
        mFirebase= FirebaseFirestore.getInstance();
        mKlass=klass;
        mCollectionName=klass.getSimpleName().toLowerCase()+"s";
    }
    public FirebaseRepository(String collectionName, Class<T> klasss){
        mKlass= klasss;
        mCollectionName=collectionName;
        mFirebase=FirebaseFirestore.getInstance();
    }


    @Override
    public void getAll(Consumer action) {
        mFirebase.collection(mCollectionName).get().addOnCompleteListener(task->{
            List<T> items=task.getResult().toObjects(mKlass);
            action.accept(items);
        });
    }

    @Override
    public void add(Object item) {

    }
}
