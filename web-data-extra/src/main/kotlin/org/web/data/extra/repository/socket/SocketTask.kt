//package org.web.data.extra.repository.socket
//
//import io.vertx.core.Context
//import io.vertx.core.Promise
//import io.vertx.core.Verticle
//import io.vertx.core.Vertx
//import io.vertx.core.buffer.Buffer
//import org.web.data.extra.repository.CharacterRepository
//
////@Component
//class SocketTask(repository: CharacterRepository) : Verticle {
////    constructor()
//    /**
//     * 如果有bean需要注入则使用【lateinit var】来实现bean的注入
//     */
////    @Autowired
//    lateinit var repository: CharacterRepository
//
//    init {
//        this.repository = repository
//
//        init(vertx, null)
//        start(Promise.promise())
//    }
//
////    final var repository: CharacterRepository
//
//    private var sendMessage: String? = null
//
//    override fun getVertx(): Vertx {
//        return Vertx.vertx()
//    }
//
//    //初始化发送数据
//    override fun init(vertx: Vertx, context: Context?) {
//        sendMessage = repository.getAll().toString()
////        print("init SendMessage$sendMessage")
//    }
//
//    override fun start(startPromise: Promise<Void>?) {
//        println("start Send Message?$sendMessage")
//        val send = Buffer.buffer(sendMessage.toString(), "UTF-8")
//        this.vertx.createDatagramSocket()
//            .send(send, 8888, "localhost")
////        sendMessage = repository.readCharacterAsStream()
//    }
//
//    override fun stop(stopPromise: Promise<Void>?) {
//    }
//}
//
//
////class TaskConstratorTest(apple: Apple) {
////    private val apple: Apple
////
////    init {
////        this.apple = apple
////    }
////}
//
////fun main() {
////
////    val scanner = Scanner(System.`in`)
////    val socketTask = SocketTask()
////    while (scanner.hasNext()){
////        socketTask.init(socketTask.vertx,null)
////        socketTask.start(Promise.promise())
////        print(scanner.nextLine())
////    }
////}