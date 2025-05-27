package ru.mavrinvladislav.jetpack.data.repository

import ru.mavrinvladislav.jetpack.common.Either
import ru.mavrinvladislav.jetpack.common.RemoteConstants
import ru.mavrinvladislav.jetpack.data.remote.ApiService
import ru.mavrinvladislav.jetpack.data.toEntity
import ru.mavrinvladislav.jetpack.domain.entity.Bar
import ru.mavrinvladislav.jetpack.domain.entity.TimeFrame
import ru.mavrinvladislav.jetpack.domain.repository.BarRepository
import javax.inject.Inject

class BarRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : BarRepository {
    override suspend fun loadBars(timeFrame: TimeFrame): Either<List<Bar>, String> {
        try {
            val result = apiService.loadBars(timeFrame.value)
            if (!result.isSuccessful) {
                return Either.Fail(result.message())
            }
            val body = result.body()!!
            val barList = body.barList.map { it.toEntity() }
            return Either.Success(barList)
        } catch (e: Exception) {
            return Either.Fail(e.localizedMessage ?: RemoteConstants.UNKNOWN_ERROR)
        }
    }
}