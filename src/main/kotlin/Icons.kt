class Icons {
    fun icon(iconCode: String): String {
        //  Try to find icon resource, then assign and return the resource
        //  Then...
        return if(iconCode != null) "${iconCode}.png" else "default.png"
    }
}