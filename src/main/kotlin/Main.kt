// number in list: 10
// algorithms var: 3 - merge sort
// structures var: 11 - binary tree

fun merge(leftList: MutableList<UInt>, rightList: MutableList<UInt>): MutableList<UInt> {
	val mergedList: MutableList<UInt> = mutableListOf()
	var indexLeft = 0
	var indexRight = 0

	while (indexRight < rightList.size && indexLeft < leftList.size) {
		if (leftList[indexLeft] <= rightList[indexRight]) {
			mergedList.add(leftList[indexLeft])
			indexLeft++
		} else {
			mergedList.add(rightList[indexRight])
			indexRight++
		}
	}

	for (i in indexLeft until leftList.size) {
		mergedList.add(leftList[i])
	}

	for (i in indexRight until rightList.size) {
		mergedList.add(rightList[i])
	}

	return mergedList
}

fun sort(list: MutableList<UInt>): MutableList<UInt> {
	if (list.size < 2) return list

	val leftHalf = list.subList(0, list.size / 2)
	val rightHalf = list.subList(list.size / 2, list.size)

	return merge(sort(leftHalf), sort(rightHalf))
}

fun main() {
	println("Enter positive number sequence to merge-sorting it and building 2 binary trees: from sorted and unsorted number sequences")
	val nodeList: MutableList<UInt> = mutableListOf()
	var inputNumber: UInt = 1u
	while (inputNumber != 0u) {
		try {
			inputNumber = readln().toUInt()
			if (inputNumber != 0u) nodeList.add(inputNumber)
		} catch (e: NumberFormatException) {
			println("Input line isn't positive number")
		}
	}

	val resultList = sort(nodeList)

	println("Unsorted list:\n$nodeList")
	println("Sorted list:\n$resultList")

	val unsortedTree = TreeNode(nodeList[0])
	for (i in 1 until nodeList.size) {
		unsortedTree.add(nodeList[i])
	}
	println("Unsorted tree:")
	unsortedTree.printTree()

	val sortedTree = TreeNode(resultList[0])
	for (i in 1 until resultList.size) {
		sortedTree.add(resultList[i])
	}
	println("Sorted tree (kinda number ladder):")
	sortedTree.printTree()
}