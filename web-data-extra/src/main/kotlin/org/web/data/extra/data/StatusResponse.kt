package org.web.data.extra.data

class StatusResponse<T> (
    val code: String?,
    val status: String?,
    val body: T
){
    override fun toString(): String {
        return super.toString()
    }
}