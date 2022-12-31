package plugins


if (tasks.findByName("installGitHooks") == null) {
    tasks.register<Copy>("installGitHooks") {
        val file = File(rootProject.rootDir, "/buildSrc/src/main/kotlin/plugins/pre-commit.sh")
        val target = File(rootProject.rootDir, ".git/hooks/pre-commit")
        target.writeText(file.readText())
        target.setExecutable(true)
    }
}
tasks.findByName("build")!!.dependsOn(tasks.findByName("installGitHooks")!!)