package a90ms.easy.default_architecture.data.model

import a90ms.easy.default_architecture.domain.dto.MainDto
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MainVo(
    val id: Long,
    val name: String,
) : Parcelable {

    companion object {
        fun dtoToVo(userDto: MainDto): MainVo = MainVo(
            id = userDto.id,
            name = userDto.name
        )
    }
}
