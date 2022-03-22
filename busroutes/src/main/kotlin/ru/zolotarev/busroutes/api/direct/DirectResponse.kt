package ru.zolotarev.busroutes.api.direct


data class DirectResponse(
    val from: Int,
    val to: Int,
    val direct: Boolean
) {

    fun toJson(): String = "{\"from\": $from, \"to\": $to, \"direct\": $direct}"

}