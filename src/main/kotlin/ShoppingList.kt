import com.google.gson.Gson
import java.net.URL
import com.google.gson.reflect.TypeToken
import java.io.DataOutputStream
import java.lang.StringBuilder
import java.net.HttpURLConnection



data class Items(
    val _id: String,
    val item: String,
    val date: String
)

fun urlListBuilder(url: String, item: String) = StringBuilder(url).apply {
    append(item.toUpperCase().replace(" ", "%20"))
}.toString()



fun main() {

    /*
    *   URL for directions on how to send data
    *   https://www.mkyong.com/java/how-to-send-http-request-getpost-in-java/
    */

    val listUrl = "https://bulga.io/list/"
    var gson = Gson()
    var json = URL("https://bulga.io/list").readText()
    val snap = URL(urlListBuilder(listUrl, "Test"))

    //  Create a connection with snap as the url
    val con = snap.openConnection() as HttpURLConnection
    //  Define the method for the request
    con.requestMethod = "POST"
    //  Optional parameters
    val urlParams = "daa"

    // Send post request
    con.doOutput = true
    val wr = DataOutputStream(con.outputStream)
    wr.writeBytes(urlParams)

    wr.flush()
    wr.close()

    val responseCode = con.responseCode

    println("\nSending 'POST' request to URL : $snap")
    println("Response Code : $responseCode : ${con.responseMessage}")

    println(json)

    val shoppingList: Collection<Items> = gson.fromJson(json)
    shoppingList.forEach { element -> println(element.item) }
}
