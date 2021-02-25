package id.danangess.truthordare.data

import android.content.Context
import id.danangess.truthordare.data.local.db.BaseRepository
import id.danangess.truthordare.data.local.prefs.PreferencesHelper
import id.danangess.truthordare.data.model.DareDto
import id.danangess.truthordare.data.model.TruthDto
import id.danangess.truthordare.data.model.db.Dare
import id.danangess.truthordare.data.model.db.Truth
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppDataManager
@Inject
constructor(
    private val mContext: Context,
    private val dareRepository: BaseRepository<Dare>,
    private val truthRepository: BaseRepository<Truth>,
    private val prefHelper: PreferencesHelper
) : DataManager {
    override fun addTruth(truthDto: TruthDto): Single<Boolean> {
        val truth = Truth()
        truth.id = truthDto.id
        truth.category = truthDto.category
        truth.text = truthDto.text
        return truthRepository.add(truth)
    }

    override fun getTruth(id: String): Single<TruthDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun randomTruth(): Single<TruthDto> {
        return truthRepository.random().map { t: Truth -> TruthDto(t.id, t.text, t.category) }
    }

    override fun addDare(dareDto: DareDto): Single<Boolean> {
        val dare = Dare()
        dare.id = dareDto.id
        dare.category = dareDto.category
        dare.text = dareDto.text
        return dareRepository.add(dare)
    }

    override fun getDare(id: String): Single<DareDto> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun randomDare(): Single<DareDto> {
        return dareRepository.random().map { t: Dare -> DareDto(t.id, t.text, t.category) }
    }

    override fun addUser(name: String): Single<Boolean> {
        return Single.fromCallable {
            prefHelper.addOrUpdateScore(name)
            true
        }
    }

    override fun removeUser(name: String): Single<Boolean> {
        return Single.fromCallable {
            prefHelper.removeUser(name)
            true
        }
    }
}