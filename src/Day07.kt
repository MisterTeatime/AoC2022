fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 1)
    check(part2(testInput) == 1)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}

fun dirDemo() {
    
    val directory = FileObject("/")
    println(directory.getSize())

    val a = directory.addContent("a")
    directory.addContent("b.txt", 14848514)
    directory.addContent("c.dat", 8504156)

    val d = directory.addContent("d")

    val e = a.addContent("e")
    a.addContent("f", 29116)
    a.addContent("g", 2557)
    a.addContent("h.lst", 62596)

    e.addContent("i", 584)

    d.addContent("j", 4060174)
    d.addContent("d.log", 8033020)
    d.addContent("d.ext", 5626152)
    d.addContent("k", 7214296)

    println(directory.getSize())
}

data class FileObject(val name: String, val content: MutableList<FileObject> = mutableListOf()) {
    private var size: Int = 0

    constructor(name: String, size: Int, content: MutableList<FileObject> = mutableListOf()) : this(name, content) {
        this.size = size
    }

    fun getSize(): Int = when {
        content.isEmpty() -> size
        else -> content.sumOf { it.getSize() }
    }

    fun addContent(item: FileObject) = content.add(item)

    fun addContent(name: String, size: Int) = addContent(FileObject(name, size))

    fun addContent(name: String): FileObject {
        val item = FileObject(name)
        addContent(item)
        return item
    }
}