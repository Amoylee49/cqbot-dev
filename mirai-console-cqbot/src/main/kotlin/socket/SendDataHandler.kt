package socket

import data.CharacterHolder
import io.vertx.core.Handler

class SendDataHandler : Handler<List<CharacterHolder>> {
    override fun handle(event: List<CharacterHolder>?) {
        TODO("Not yet implemented")
    }
}