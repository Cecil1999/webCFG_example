package cfg.gologan.ca

import java.io.File

//
val valPattern = Regex("\\[%\\s*VAL\\s*-(\\w+)\\s*%]")

class WebCFG {
    var globalHashMap : HashMap<String, Any> = HashMap<String, Any>();

    fun returnWebReplace (form : String): String {
        var replacedString: String = "";

        // "\n" troubleshooting reasons when returning HTML don't need it.
        try {
            File(form).forEachLine { line: String ->
                val matches = valPattern.findAll(line);
                if (matches.count() > 0) {
                    for (match in matches) {
                        val replacedLine = line.replace(match.groupValues[0], globalHashMap.getValue(match.groupValues[1]).toString())
                        replacedString += replacedLine + "\n";
                    }
                } else {
                    replacedString += line + "\n";
                }
            }

            return replacedString;
        } catch (e : Exception) {
            println(e);
        }
        return "";
    }

}