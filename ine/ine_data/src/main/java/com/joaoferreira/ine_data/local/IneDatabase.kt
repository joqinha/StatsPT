package com.joaoferreira.ine_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.joaoferreira.ine_data.local.entity.IneEntity

@Database(
    entities = [IneEntity::class],
    version = 1
)
abstract class IneDatabase: RoomDatabase() {

    abstract val dao: IneDao
}