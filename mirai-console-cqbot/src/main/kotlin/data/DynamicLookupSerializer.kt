package data

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

@OptIn(ExperimentalSerializationApi::class)
internal object DynamicLookupSerializer : KSerializer<Any> {
    override val descriptor: SerialDescriptor =
        ContextualSerializer(Any::class, null, emptyArray()).descriptor

    @Suppress("UNCHECKED_CAST")
    @OptIn(InternalSerializationApi::class)
    override fun serialize(encoder: Encoder, value: Any) {
        val actualSerializer = encoder.serializersModule.getContextual(value::class)
            ?: value::class.serializer()
        if (value is String) {
//            val jsonUnquotedLiteral =
//                JsonUnquotedLiteral(value.takeIf { it != "null" && it.isNotBlank() })
//            encoder.encodeSerializableValue(JsonPrimitive.serializer(), actualSerializer)
        } else {
            encoder.encodeSerializableValue(actualSerializer as KSerializer<Any>, value)
        }
    }

    override fun deserialize(decoder: Decoder): Any {
        error("Unsupported")
    }
}