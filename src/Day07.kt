fun main() {
    val totalSpace = 70_000_000
    val updateSpace = 30_000_000

    fun part1(input: List<String>): Int {

        val nodes = mutableSetOf<TreeNode>()

        val root = TreeNode("/")
        var currentNode = root
        nodes.add(root)

        //Verzeichnisbaum erstellen
        input.drop(2).map { it.split(" ") }
            .forEach {item ->
                when {
                    item[0].matches("""\d+""".toRegex()) -> currentNode.addChild(item[1], item[0].toInt())
                    item[0] == "dir" -> nodes.add(currentNode.addChild(item[1]))
                    item[0] == "$" && item[1] == "cd" -> currentNode = when (item[2]) {
                        ".." -> currentNode.parent!!
                        else -> currentNode.getContent(item[2])
                    }
                }
            }

        //Ergebnis suchen
        return nodes.map { it.getSize() }.filter { it <= 100_000 }.sum()
    }

    fun part2(input: List<String>): Int {

        val nodes = mutableSetOf<TreeNode>()

        val root = TreeNode("/")
        var currentNode = root
        nodes.add(root)

        //Verzeichnisbaum erstellen
        input.drop(2).map { it.split(" ") }
            .forEach {item ->
                when {
                    item[0].matches("""\d+""".toRegex()) -> currentNode.addChild(item[1], item[0].toInt())
                    item[0] == "dir" -> nodes.add(currentNode.addChild(item[1]))
                    item[0] == "$" && item[1] == "cd" -> currentNode = when (item[2]) {
                        ".." -> currentNode.parent!!
                        else -> currentNode.getContent(item[2])
                    }
                }
            }

        //Ergebnis suchen
        val spaceToFreeUp = updateSpace - (totalSpace - root.getSize())

        if (spaceToFreeUp <= 0) return 0

        return nodes
            .map { it.getSize() }
            .filter { it >= spaceToFreeUp }
            .minOf { it }
    }
    
    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day07_test")
    check(part1(testInput) == 95437)
    check(part2(testInput) == 24933642)

    val input = readInput("Day07")
    println(part1(input))
    println(part2(input))
}

data class TreeNode(val name: String, val content: MutableList<TreeNode> = mutableListOf()) {
    private var size: Int = 0
    var parent: TreeNode? = null

    constructor(name: String, size: Int, content: MutableList<TreeNode> = mutableListOf()) : this(name, content) {
        this.size = size
    }

    fun getSize(): Int = when {
        content.isEmpty() -> size
        else -> content.sumOf { it.getSize() }
    }

    private fun addChild(item: TreeNode) {
        content.add(item)
        item.parent = this
    }

    fun addChild(name: String, size: Int) = addChild(TreeNode(name, size))

    fun addChild(name: String): TreeNode {
        val item = TreeNode(name)
        addChild(item)
        return item
    }

    fun getContent(name: String) = this.content.first { it.name == name }
}