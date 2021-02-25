package id.danangess.truthordare.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import id.danangess.truthordare.data.model.db.Dare

@Dao
interface DareDao : BaseDao<Dare> {
    @Query("SELECT * FROM dare WHERE id = :id")
    override fun get(id: Long): Dare

    @Query("SELECT * FROM dare WHERE id IN (SELECT id FROM dare ORDER BY RANDOM() LIMIT :count)")
    override fun random(count: Int): List<Dare>

    @Query("SELECT * FROM dare WHERE id IN (SELECT id FROM dare ORDER BY RANDOM() LIMIT 1)")
    override fun random(): Dare

//    @Query("SELECT * FROM dare")
//    override fun loadAll(): List<Dare>
//    @Query("DELETE FROM dare")
//    override fun truncate()
}