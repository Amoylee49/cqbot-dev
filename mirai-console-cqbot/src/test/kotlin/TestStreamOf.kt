//import data.CharacterHolder
//import data5555.DynamicLookupSerializer
//import kotlinx.serialization.*
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.json.JsonArray
//import kotlinx.serialization.json.JsonObject
//import util.JsonUtils
//import java.util.LinkedList
//import java.util.function.Supplier
//import java.util.stream.Collectors
//import java.util.stream.Stream
//
//object TestStreamOf {
//    @Serializable(with = DynamicLookupSerializer::class)
//    val data2: Any? = null
//}
//
///**
// * List<Object>转化为List<Cart>，其中List<Object>中的Object为Cart的json对象
// *
// * //查询购物车数据(将List<Object>变成List<Cart>)
// * return carts.stream().map(o -> JsonUtils.parse(o.toString(),Cart.class)).collect(Collectors.toList());
// */
//
//fun testStreamOf(): List<String?> {
//    @Serializable
//    data class Data(
//        val nickname: List<Int>,
//        val character: JsonObject? //can be any JSON object, e.g.: {"test_key":"test value","test_key_object":{"test_key":"test value"}}
//    )
//    @Serializable
//    data class Food(
//        val id: Int,
//        @SerialName("nicknames") val nickname: List<String>,
////        val character: Charactersss,
//    )
//
//
//    val listJson = JsonUtils.readStream()
////    val string = Json.decodeFromString(listJson.toString())
////
////    println(listJson)
//
////        {nickNames=[光明剑士里昂, 剑主, 黄毛, Leon], character={
//    //        {nickNames=[光明剑士里昂, 剑主, 黄毛, Leon], character={
//    //        {nickNames=[光明剑士里昂, 剑主, 黄毛, Leon], character={
//    //        {nickNames=[光明剑士里昂, 剑主, 黄毛, Leon], character={
//
//    val message = "黄毛"
//    if (listJson != null) {
//        for (holder in listJson) {
//            for (nickName in holder.nickNames){
//                if (nickName.startsWith(message)||nickName.endsWith(message)){
//                    val character = holder.character
//                    return listOf(character?.name,character?.imageUrl,character?.content
//                        ,character?.pageUrl)
//                }
//            }
//        }
//
//    }
//    return listOf()
////    val findFirst = Stream.of<List<CharacterHolder?>>(listJson).map { obj: List<CharacterHolder?>? ->
////
////    }.collect(
////        Collectors.toCollection(
////            Supplier { ArrayList() })
////    ).stream().findFirst()
////    println(findFirst.get())
//}
//
//fun main() {
//println(testStreamOf())
//
//}