package ru.mavrinvladislav.jetpack.common

sealed class Either<out S, out F> {

    data class Success<out S>(val value: S) : Either<S, Nothing>()

    data class Fail<out F>(val value: F) : Either<Nothing, F>()

    fun isSuccess() = this is Success
    fun isFail() = this is Fail

    fun <T> fold(onSuccess: (S) -> T, onFail: (F) -> T) {
        when (this) {
            is Success -> {
                onSuccess(value)
            }

            is Fail -> {
                onFail(value)
            }
        }
    }
}