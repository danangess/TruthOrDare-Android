package id.danangess.truthordare.data.local.db.dao

import androidx.room.*

interface BaseDao<TEntity> {

    fun get(id: Long): TEntity
    fun random(count: Int): List<TEntity>
    fun random(): TEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tEntity: TEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tEntities: List<TEntity>)

    @Update
    fun update(tEntity: TEntity)

    @Update
    fun update(tEntities: List<TEntity>)

    @Delete
    fun delete(tEntity: TEntity)

    @Delete
    fun delete(tEntities: List<TEntity>)

//    @Query("SELECT * FROM dare")
//    override fun loadAll(): List<Dare>
//    @Query("DELETE FROM dare")
//    override fun truncate()
}