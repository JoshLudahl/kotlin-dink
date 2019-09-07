class FancyInfoProvider : BasicInfoProvider() {
    override val providerInfo: String
        get() = "Totes Fancy info Provider"

    override fun printInfo(person: Person) {
    super.printInfo(person)
        println("Fancy Information")
    }

    override val sessionIdPrefix: String
        get() = "Session Token: asdfklw54351321sd3f3sdaf3sad21f32132a1sdf321a3sdfwwwdfasdfd"
}