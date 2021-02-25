package id.danangess.truthordare.data.local.prefs

import android.content.Context
import android.content.SharedPreferences
import id.danangess.truthordare.data.model.UserDto
import id.danangess.truthordare.di.PreferenceInfo
import javax.inject.Inject

class AppPreferencesHelper
@Inject
constructor(private val mContext: Context, @PreferenceInfo prefFileName: String) :
    PreferencesHelper {
    companion object {
        private const val PREF_KEY_USER_SCORE = "PREF_KEY_USER_SCORE"
    }

    private val mPrefs: SharedPreferences =
        mContext.getSharedPreferences(prefFileName, Context.MODE_PRIVATE)

    override val users: List<UserDto>
        get() {
            return mPrefs.all.map { entry -> UserDto(entry.key, entry.value as Int) }
        }
//        set(value) {
//            val prefEditor = mPrefs.edit()
//            prefEditor.clear()
//            value.forEach { userDto: UserDto ->
//                prefEditor.putInt(userDto.name, userDto.score)
//            }
//            prefEditor.apply()
//        }

    override fun addOrUpdateScore(name: String) {
        val userScore = mPrefs.getInt(name, -1)
        mPrefs.edit().putInt(name, userScore + 1).apply()
    }

    override fun removeUser(name: String) {
        mPrefs.edit().remove(name).apply()
    }
}