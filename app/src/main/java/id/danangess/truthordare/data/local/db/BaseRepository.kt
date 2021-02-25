package id.danangess.truthordare.data.local.db

import io.reactivex.Observable
import io.reactivex.Single

interface BaseRepository<TEntity> {
    fun add(entity: TEntity): Single<Boolean>
    fun edit(entity: TEntity): Single<Boolean>
    fun remove(tKey: Long): Single<Boolean>
    fun random(count: Int): Observable<List<TEntity>>
    fun random(): Single<TEntity>
}