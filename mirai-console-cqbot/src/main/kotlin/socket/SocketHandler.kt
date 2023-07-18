//package socket
//
//import com.fasterxml.jackson.core.type.TypeReference
//import io.vertx.core.*
//import io.vertx.core.buffer.Buffer
//import io.vertx.core.datagram.DatagramPacket
//import org.cqbot.dev.data.CharacterHolder
//import org.cqbot.dev.util.JsonUtils
//
//object SocketHandler : Verticle {
////    constructor() {
////        init(vertx, null)
////        start(Promise.promise())
////    }
//
//    private var allCharacter: List<CharacterHolder>? = null
//    override fun getVertx(): Vertx {
//        return Vertx.vertx()
//    }
//
//    fun getAllCharacters(): List<CharacterHolder>? {
//        return allCharacter
//    }
//
//    override fun init(vertx: Vertx?, context: Context?) {
//
//    }
//
//    override fun start(startPromise: Promise<Void>?) {
//        print("++++++start socketHandler ++++++")
//        vertx.createDatagramSocket()
//            .handler { data ->
//                dataHandle(data, vertx)
//            }
//            .handler { }
//            .listen(8888, "localhost")
//
//    }
//
//    override fun stop(stopPromise: Promise<Void>?) {
//        TODO("Not yet implemented")
//    }
//
//    private fun dataHandle(pack: DatagramPacket, vertx: Vertx): Handler<Buffer> {
//        val eventBus = vertx.eventBus()
//        print("pack.data()===" + pack.data())
//
//        //已经从json文件 序列化成对象发过来了，不用再序列化一次
//        var data = JsonUtils.toObj(pack.data().toString(), object : TypeReference<List<CharacterHolder>?>() {})
//        allCharacter = pack.data() as List<CharacterHolder>?
////            val sendMessage
//        print(allCharacter)
////            println(sendMessage)
//        return TODO()
//    }
//
//}