import cfg.gologan.ca.WebCFG


fun main() {
    val webCFG : WebCFG = WebCFG();

    webCFG.globalHashMap["hello_world"] = "Hello World";
    webCFG.globalHashMap["other_test"] = "This doesn't work well in kotlin TBH"

    println(webCFG.returnWebReplace("html/test.html"));
}