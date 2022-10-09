class TreeNode(
	var key: UInt
) {
	var leftNode: TreeNode? = null
	var rightNode: TreeNode? = null

	fun find(key: UInt): TreeNode? = when {
		this.key == key -> this
		this.key > key -> this.leftNode?.find(key)
		this.key < key -> this.rightNode?.find(key)
		else -> null
	}

	private fun hasLeft(): Boolean = leftNode != null
	private fun hasRight(): Boolean = rightNode != null

	fun getLeft(): TreeNode? = this.leftNode
	fun getRight(): TreeNode? = this.rightNode

	fun add(value: UInt): Boolean {
		val node = TreeNode(value)
		if (this.find(node.key) != null)
			return false
		if (this.key > node.key) {
			if (this.hasLeft())
				return this.leftNode!!.add(node.key)
			this.leftNode = node
		}
		if (this.key < node.key) {
			if (this.hasRight()) {
				return this.rightNode!!.add(node.key)
			}
			this.rightNode = node
		}

		return true
	}

	override fun toString(): String {
		return "TreeNode(key=$key, leftNode=[$leftNode], rightNode=[$rightNode])"
	}

	fun printTree() {
		println("-------------------------------")
		this.print()
		println("-------------------------------\n")
	}

	private fun print(offset: Int = 0) {
		this.rightNode?.print(offset + 1)
		println("\t".repeat(offset) + this.key)
		this.leftNode?.print(offset + 1)
	}
}