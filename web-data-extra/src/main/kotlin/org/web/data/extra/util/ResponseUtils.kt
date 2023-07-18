package org.web.data.extra.util

import org.web.data.extra.data.StatusResponse

class ResponseUtils<T> {


    companion object {
        fun <T> OK(data: T): StatusResponse<T> {
            return StatusResponse("200", "OK", data)
        }

        fun <T> ERROR(data: T): StatusResponse<T> {
            return StatusResponse("500", "ERROR", data)
        }
    }

}

/**
 * JSON返回结果。
 *
 */
//@JsonInclude(JsonInclude.Include.NON_NULL)
/*

class RestOut<T>(
    */
/**
 * 状态
 *//*

    @field:JsonProperty("respCode") @param:JsonProperty(
        "respCode"
    ) private var respCode: Int,
    */
/**
 * 消息
 *//*

    @field:JsonProperty("respMsg") @param:JsonProperty(
        "respMsg"
    ) private var respMsg: String,
    */
/**
 * 实际的数据
 *//*

    @field:JsonProperty("datas") @param:JsonProperty(
        "datas"
    ) private val datas: T,
) {
    init {
        datas = datas
    }

    fun setRespMsg(respMsg: String): RestOut<T> {
        this.respMsg = respMsg
        return this
    }

    fun setRespCode(respCode: Int): RestOut<T> {
        this.respCode = respCode
        return this
    }

    override fun toString(): String {
        return "RestOut{" +
                "datas=" + datas +
                ", respCode=" + respCode +
                ", respMsg='" + respMsg +
                '}'
    }

    val isSuccess: Boolean
        get() = respCode == STATUS_SUCCESS

    companion object {
        */
/**
 * 成功
 *//*

        const val STATUS_SUCCESS = 0

        */
/**
 * 失败
 *//*

        const val STATUS_ERROR = -1

        */
/**
 * 重载的  构造者 方法
 *//*

        fun <T> build(status: Int, msg: String, data: T): RestOut<T> {
            return RestOut(status, msg, data)
        }

        */
/**
 * 封装成功的返回数据
 *
 * @return 封装结果
 *//*

        fun <T> success(data: T): RestOut<T> {
            return build(STATUS_SUCCESS, "请求成功", data)
        }

        fun <T> success(data: T, message: String): RestOut<T> {
            return build(STATUS_SUCCESS, message, data)
        }

        */
/**
 * 返回错误消息
 *
 * @return 封装结果
 *//*

        fun <T> error(message: String): RestOut<T?> {
            return build(STATUS_ERROR, message, null)
        }

        fun <T> error(status: Int, message: String): RestOut<T?> {
            return build(status, message, null)
        }

        fun <T> failed(errMsg: String): RestOut<T?> {
            return build(STATUS_ERROR, errMsg, null)
        }

        fun <T> succeed(message: String): RestOut<T?> {
            return build(STATUS_SUCCESS, message, null)
        }
    }
}*/
