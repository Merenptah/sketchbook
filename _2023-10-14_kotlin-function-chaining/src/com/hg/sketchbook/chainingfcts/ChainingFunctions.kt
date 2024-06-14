package com.hg.sketchbook.chainingfcts

typealias FUN<A, B> = (A) -> B

infix fun <A, B, C> FUN<A, B>.andThen(other: FUN<B, C>): FUN<A, C> = {
    x -> other(this(x))
}

data class RequestBody(val content: String)
data class ResponseBody(val content: String)

data class Request(val id: String, val data: RequestBody)
data class Response(val code: String, val data: ResponseBody)

fun getBody(request: Request) = request.data
fun getContent(requestBody: RequestBody) = requestBody.content
fun transform(content: String) = "Responded to: $content"
fun toResponseBody(content: String) = ResponseBody(content)
fun toResponse(body: ResponseBody) = Response("200", body)

val processFct = ::getBody andThen
        ::getContent andThen
        ::transform andThen
        ::toResponseBody andThen
        ::toResponse

fun main() {
    print(processFct(Request("id", RequestBody("Test"))))
}