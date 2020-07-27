package com.example.roomlivedata;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    MyRepsitory repsitory;
    LiveData<List<Student>> getAllData;
    public MyViewModel(@NonNull Application application) {
        super(application);
        repsitory = new MyRepsitory(application);
        getAllData = repsitory.readALLData();
    }

    //This is for Insert Method
    public void insert(Student student){
        repsitory.insert(student);
    }
    //This is for Update Method
    public void update(Student student){
        repsitory.update(student);
    }
    //This is for Delete Method
    public void delete(Student student){
        repsitory.delete(student);
    }
    //This is for read Data method
    public LiveData<List<Student>> readData(){
        return getAllData;
    }

}
