package id.danangess.truthordare.data.model.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "truth")
class Truth {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    @ColumnInfo(name = "text")
    lateinit var text: String

    @ColumnInfo(name = "category")
    var category: String? = null
}