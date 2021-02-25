package id.danangess.truthordare.data.local.prefs

import id.danangess.truthordare.data.model.UserDto

interface PreferencesHelper {
    val users: List<UserDto>
    fun addOrUpdateScore(name: String)
    fun removeUser(name: String)
}