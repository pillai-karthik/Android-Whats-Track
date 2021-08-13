package com.kbrosapp.whatstrack;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Target.class}, version = 1)//////////////////////////
public abstract  class WhatsDatabase extends RoomDatabase {

    private static WhatsDatabase instance;

    public abstract TargetsDao targetsDao();

    public static synchronized WhatsDatabase getInstance(Context context){
        if(instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    WhatsDatabase.class,"WhatsDatabase")
                    //.fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    //.addMigrations(MIGRATION_1_2,MIGRATION_2_3)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private TargetsDao targetsDao;

        public PopulateDbAsyncTask(WhatsDatabase db){
            targetsDao=db.targetsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            targetsDao.insert(new Target("Karthik","919029192655"));
            targetsDao.insert(new Target("Amma","918655803448"));
            return null;
        }
    }
}
