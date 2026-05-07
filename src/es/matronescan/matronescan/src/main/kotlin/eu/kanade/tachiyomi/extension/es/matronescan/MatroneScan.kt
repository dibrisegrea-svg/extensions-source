package eu.kanade.tachiyomi.extension.es.matronescan

import eu.kanade.tachiyomi.multisrc.madara.Madara
import eu.kanade.tachiyomi.network.interceptor.rateLimit
import okhttp3.OkHttpClient
import java.text.SimpleDateFormat
import java.util.Locale

class MatroneScan : Madara(
    "Matrone Scan",
    "https://matrone-scan.xyz",
    "es",
    dateFormat = SimpleDateFormat("MMMM dd, yyyy", Locale("es")),
) {
    override val client: OkHttpClient = super.client.newBuilder()
        .rateLimit(1, 2)
        .build()

    override val useNewChapterEndpoint: Boolean = true
}
