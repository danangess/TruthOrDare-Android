package id.danangess.truthordare.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import id.danangess.truthordare.data.model.db.Truth

@Dao
interface TruthDao : BaseDao<Truth> {
    @Query("SELECT * FROM truth WHERE id = :id")
    override fun get(id: Long): Truth

    @Query("SELECT * FROM truth WHERE id IN (SELECT id FROM truth ORDER BY RANDOM() LIMIT :count)")
    override fun random(count: Int): List<Truth>

    @Query("SELECT * FROM truth WHERE id IN (SELECT id FROM truth ORDER BY RANDOM() LIMIT 1)")
    override fun random(): Truth

//    @Query("SELECT * FROM truth")
//    override fun loadAll(): List<Truth>
//    @Query("DELETE FROM truth")
//    override fun truncate()
}