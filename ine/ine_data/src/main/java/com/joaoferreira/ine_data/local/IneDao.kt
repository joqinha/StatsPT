package com.joaoferreira.ine_data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.joaoferreira.ine_data.local.entity.IneEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface IneDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(ineEntity: IneEntity)

    @Delete
    suspend fun deleteTrackedFood(ineEntity: IneEntity)

    @Query(
        """
            SELECT *
            FROM ineentity
            WHERE dayOfMonth = :day AND month = :month AND year = :year
        """
    )
    fun getFoodsForDate(day: Int, month: Int, year: Int): Flow<List<IneEntity>>
}