package id.danangess.truthordare.data.local.db

import id.danangess.truthordare.data.local.db.dao.BaseDao
import io.reactivex.Observable
import io.reactivex.Single

class AppBaseRepository<TEntity>
constructor(private val baseDao: BaseDao<TEntity>) : BaseRepository<TEntity> {

    override fun add(entity: TEntity): Single<Boolean> {
        return Single.fromCallable {
            baseDao.insert(entity)
            true
        }
    }

    override fun edit(entity: TEntity): Single<Boolean> {
        return Single.fromCallable {
            baseDao.update(entity)
            true
        }
    }

    override fun remove(tKey: Long): Single<Boolean> {
        return Single.fromCallable {
//            val entity = baseDao.get(tKey)
//            baseDao.delete(entity)
            true
        }
    }

    override fun random(count: Int): Observable<List<TEntity>> {
        return Observable.fromCallable {
            baseDao.random(count)
        }
    }

    override fun random(): Single<TEntity> {
        return Single.fromCallable {
            baseDao.random()
        }
    }
}