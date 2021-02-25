package id.danangess.truthordare.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import id.danangess.truthordare.data.local.db.dao.DareDao
import id.danangess.truthordare.data.local.db.dao.TruthDao
import id.danangess.truthordare.data.model.db.Dare
import id.danangess.truthordare.data.model.db.Truth

@Database(
    entities = [
        Truth::class,
        Dare::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract val truthDao: TruthDao
    abstract val dareDao: DareDao
}