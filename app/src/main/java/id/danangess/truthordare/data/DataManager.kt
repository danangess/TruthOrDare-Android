package id.danangess.truthordare.data

import id.danangess.truthordare.data.model.DareDto
import id.danangess.truthordare.data.model.TruthDto
import io.reactivex.Single

interface DataManager {
    fun addTruth(truthDto: TruthDto): Single<Boolean>
    fun getTruth(id: String): Single<TruthDto>
    fun randomTruth(): Single<TruthDto>

    fun addDare(dareDto: DareDto): Single<Boolean>
    fun getDare(id: String): Single<DareDto>
    fun randomDare(): Single<DareDto>

    fun addUser(name: String): Single<Boolean>
    fun removeUser(name: String): Single<Boolean>
}